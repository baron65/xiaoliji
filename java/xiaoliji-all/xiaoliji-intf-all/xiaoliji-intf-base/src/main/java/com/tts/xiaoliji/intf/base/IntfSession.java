package com.tts.xiaoliji.intf.base;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.common.bean.LoginUser;
import com.tts.xiaoliji.intf.base.sao.NotifySAO;
import com.tts.xiaoliji.intf.base.service.GlobalAttrService;
import com.tts.xiaoliji.intf.base.utils.DateTimeUtil;
import com.tts.xiaoliji.intf.base.utils.TicketUtil;

import cn.openlo.nosql.redis.RedisDao;
import cn.openlo.nosql.redis.support.RedisLock;
import cn.openlo.nosql.redis.support.RedisMap;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("intfSession")
@Scope("prototype")
public class IntfSession {
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private GlobalAttrService globalAttrService;
    public static final String PREFIX_SESSION = "SESSION.";
    public static final String PREFIX_USER = "USER.";
    private static final String PREFIX_SESSION_LOCK = "LOCK.";
    private static final Logger logger = LoggerFactory.getLogger(IntfSession.class);
    private static ThreadLocal<IntfSession> intfSessionThreadLocal = new ThreadLocal<IntfSession>();
    private String sessionId;
    private String staffNo;
    // private int expiredTime = 600;
    private int expiredTime = 60 * 60 * 24 * 7;// 为了测试，临时修改这个有效期
    private int userExpiredTime = 2 * this.expiredTime;
    private String losName;
    private long createdTime;
    private boolean isNewSession = false;
    private RedisMap<String, Object> sessionRedisMap;
    private RedisMap<String, Object> userRedisMap;
    private Map<String, RedisLock> holdLocks = new ConcurrentHashMap<String, RedisLock>();
    @Autowired
    private NotifySAO notifySAO;
    private static Set<String> constantSessionKey = new HashSet<String>();

    static {
        constantSessionKey.add("_channel_id");
        constantSessionKey.add("SESSION_CLIENT_VERSION");
        constantSessionKey.add("SESSION_MEDIA_CHANNEL");
        constantSessionKey.add("createTime");
        constantSessionKey.add("lastAccessTime");
    }

    public void init(String sid) {
        init(sid, null);
    }

    public void init(String sid, String uid) {
        if (StringUtils.hasText(sid)) {
            this.sessionId = sid;
            this.sessionRedisMap = this.redisDao.getMap("SESSION." + this.sessionId);
        }
        else {
            this.sessionId = TicketUtil.generateTicket();
        }
        if (this.sessionRedisMap == null) {
            this.isNewSession = true;
            this.sessionRedisMap = this.redisDao.createMap("SESSION." + this.sessionId);
        }
        String createTime = (String) this.sessionRedisMap.get("createTime");
        if (StringUtils.isEmpty(createTime)) {
            this.isNewSession = true;
            this.sessionRedisMap.put("createTime", DateTimeUtil.formatNow());
        }
        this.sessionRedisMap.put("lastAccessTime", DateTimeUtil.formatNow());
        this.sessionRedisMap.expire(this.expiredTime, TimeUnit.SECONDS);

        this.staffNo = ((String) this.sessionRedisMap.get("userId"));
        if (uid != null) {
            this.staffNo = uid;
        }
        if (StringUtils.hasText(this.staffNo)) {
            this.userRedisMap = this.redisDao.createMap("USER." + this.staffNo);
            this.userRedisMap.put("lastUpdateTime", DateTimeUtil.formatNow());
            this.userRedisMap.expire(this.userExpiredTime, TimeUnit.SECONDS);
        }
        intfSessionThreadLocal.set(this);
    }

    public void init(ServiceRequest request) {
        String sid = (String) request.getParameters().get("UFO-SESSION-ID");
        logger.debug("===========================request UFO-SESSION-ID is :" + sid);

        this.losName = request.getServiceName();
        this.createdTime = System.currentTimeMillis();

        init(sid, null);
    }

    public void login(LoginUser user) {
        login(user, null);
    }

    @SuppressWarnings("unchecked")
    public void login(LoginUser user, String sessionKey, boolean channelUserSession) {
        Map<String, Object> mediaMap = (Map<String, Object>) getAttribute("SESSION_MEDIA_CHANNEL");
        String channelId = (String) getAttribute("_channel_id");
        String versionNo = (String) getAttribute("SESSION_CLIENT_VERSION");

        this.staffNo = user.getCustNo();
        if (channelUserSession) {
            this.userRedisMap = this.redisDao.getMap("USER." + channelId + this.staffNo);
        }
        else {
            this.userRedisMap = this.redisDao.getMap("USER." + this.staffNo);
        }
        if (this.userRedisMap != null) {
            String oldSessionId = (String) this.userRedisMap.get("sessionId");
            if ((!StringUtils.isEmpty(oldSessionId)) && (!oldSessionId.equals(this.sessionId))) {
                logger.debug("session kick bug oldSessionId: " + oldSessionId + " userId: " + this.staffNo + "  cmd.exists(mapId):");
                destroySession(oldSessionId);
                notifyClient(oldSessionId);
            }
        }
        else {
            this.userRedisMap = this.redisDao.createMap("USER." + this.staffNo);
        }
        destroySession();
        if (user.getLoginToken() != null && user.getLoginToken().trim().length() > 0) {
            // 这个token由wss-system生成，并保存在mysql数据库中。
            this.sessionId = user.getLoginToken();
        }
        else {
            this.sessionId = TicketUtil.generateTicket();
        }
        this.isNewSession = true;

        this.sessionRedisMap = this.redisDao.createMap("SESSION." + this.sessionId);
        this.sessionRedisMap.put("createTime", DateTimeUtil.formatNow());
        this.sessionRedisMap.put("userId", this.staffNo);
        if (!StringUtils.isEmpty(sessionKey)) {
            this.sessionRedisMap.put(sessionKey, user);
        }
        else {
            this.sessionRedisMap.put("USER", user);
        }
        this.sessionRedisMap.expire(this.expiredTime, TimeUnit.SECONDS);

        this.userRedisMap.put("sessionId", this.sessionId);
        this.userRedisMap.put("lastUpdateTime", DateTimeUtil.formatNow());

        this.userRedisMap.expire(this.userExpiredTime, TimeUnit.SECONDS);
        if (StringUtils.hasText(channelId)) {
            setAttribute("_channel_id", channelId);
        }
        if (!CollectionUtils.isEmpty(mediaMap)) {
            setAttribute("SESSION_MEDIA_CHANNEL", mediaMap);
        }
        if (StringUtils.hasText(versionNo)) {
            setAttribute("SESSION_CLIENT_VERSION", versionNo);
        }
    }

    public void login(LoginUser user, String sessionKey) {
        login(user, sessionKey, false);
    }

    @SuppressWarnings("unchecked")
    public void dispose(ServiceResponse response) {
        destroyUselessSession();
        intfSessionThreadLocal.remove();
        if (response == null) {
            return;
        }
        Object model = response.getModel();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (model == null) {
            logger.debug("responseModel is empty, just put an empty map into it");
        }
        else if ((model instanceof Map)) {
            modelMap.putAll((Map<String, Object>) model);
        }
        else {
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(model.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor property : propertyDescriptors) {
                    String key = property.getName();
                    if (!"class".equals(key)) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(model, new Object[0]);
                        modelMap.put(key, value);
                    }
                }
            }
            catch (Exception e) {
                logger.debug("transMap2Bean Error " + e);
            }
        }
        response.setModel(modelMap);
        modelMap.put("UFO-SESSION-ID", this.sessionId);
    }

    private void destroyUselessSession() {
        boolean needDestroy = false;
        if (!isLogin()) {
            Set<String> keys = this.sessionRedisMap.keySet();
            if ((keys == null) || (keys.size() == 0)) {
                needDestroy = true;
            }
            if (!needDestroy) {
                keys.removeAll(constantSessionKey);
                if (keys.size() == 0) {
                    needDestroy = true;
                    logger.debug("the session is no need to save to redis, need to destroy.");
                }
                else {
                    logger.debug("The keySize is {}", Integer.valueOf(keys.size()));
                    logger.debug("the detail is ");
                    for (String key : keys) {
                        logger.debug("key: {}", key);
                    }
                }
            }
        }
        else {
            logger.debug("User is login, cann't destory session.");
        }
        if (needDestroy) {
            destroySession();
            this.sessionId = null;
        }
    }

    public boolean lock(String lockName) {
        String sessionLock = PREFIX_SESSION_LOCK + this.sessionId + "." + lockName;
        RedisLock lock = this.redisDao.createLock(sessionLock);
        if (lock.tryLock()) {
            String value = "{time=" + DateTimeUtil.formatNow() + "}";
            logger.info("Locked<" + lockName + "> by " + value + "  success.");
            this.holdLocks.put(lockName, lock);
            return true;
        }
        logger.debug("Try to Lock<" + lockName + ">  fail.");
        return false;
    }

    public void unlock(String lockName) {
        RedisLock lock = null;
        if ((!CollectionUtils.isEmpty(this.holdLocks)) && ((lock = (RedisLock) this.holdLocks.remove(lockName)) != null)) {
            lock.unlock();
        }
    }

    public void logout() {
        this.redisDao.deleteMap("SESSION." + this.sessionId);
        this.redisDao.deleteMap("SESSION." + this.staffNo);
        this.staffNo = null;
    }

    public void destroySession(String sid) {
        this.redisDao.deleteMap("SESSION." + sid);
    }

    public void destroySession() {
        this.redisDao.deleteMap("SESSION." + this.sessionId);
    }

    public static IntfSession getSession() {
        return (IntfSession) intfSessionThreadLocal.get();
    }

    public String getId() {
        return this.sessionId;
    }

    public Object getAttribute(String key) {
        Object result = this.sessionRedisMap.get(key);
        return result;
    }

    public <T> T getAttribute(String key, Class<T> type) {
        T result = this.sessionRedisMap.get(key, type);
        return result;
    }

    public void setAttribute(String key, Object value) {
        if (value == null) {
            value = "";
        }
        this.sessionRedisMap.put(key, value);
    }

    public void setAttribute(String key, long value) {
        this.sessionRedisMap.put(key, Long.valueOf(value));
    }

    public Object removeAttribute(String key) {
        return this.sessionRedisMap.remove(key);
    }

    public boolean isNew() {
        return this.isNewSession;
    }

    public boolean isLogin() {
        return this.staffNo != null;
    }

    public String getUserId() {
        return this.staffNo;
    }

    public LoginUser getUser() {
        return (LoginUser) getAttribute("USER", LoginUser.class);
    }

    public Object getGlobalAttribute(String globalId, String key) {
        Object result = null;
        if (this.globalAttrService != null) {
            result = this.globalAttrService.getGlobalAttribute(globalId, key);
        }
        return result;
    }

    public <T> T getGlobalAttribute(String globalId, String key, Class<T> type) {
        T result = null;
        if (this.globalAttrService != null) {
            result = this.globalAttrService.getGlobalAttribute(globalId, key, type);
        }
        return result;
    }

    public void setGlobalAttribute(String globalId, String key, Object value) {
        if (this.globalAttrService != null) {
            this.globalAttrService.setGlobalAttribute(globalId, key, value);
        }
    }

    public void removeGlobalAttribute(String globalId, String key) {
        if (this.globalAttrService != null) {
            this.globalAttrService.removeGlobalAttribute(globalId, key);
        }
    }

    public String getLosName() {
        return this.losName;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    private void notifyClient(String oldSessionId) {
        // TODO 暂时没有异常通知websocket，只能注销会话，不发送消息
        // try {
        // String serverInfo = (String)
        // this.userRedisMap.get("websocket_dubbo_url", String.class);
        // if (StringUtils.isEmpty(serverInfo)) {
        // logger.info("No websocket info, just no need to notify.");
        // } else {
        // List<Map<String, Object>> noticeContentList = new
        // ArrayList<Map<String, Object>>();
        // Map<String, Object> noticeContentMap = new HashMap<String, Object>();
        // Map<String, Object> wsCont = new HashMap<String, Object>();
        // noticeContentList.add(noticeContentMap);
        // noticeContentMap.put("tempId", "kickOff");
        // noticeContentMap.put("noticeType", "socket");
        // noticeContentMap.put("tempCont", wsCont);
        // wsCont.put("sessionId", oldSessionId);
        // wsCont.put("serverURL", serverInfo);
        // wsCont.put("content", "您账户已在其它设备登录");
        // this.notifySAO.notify(noticeContentList, "socket", this.userId, "");
        //
        // this.userRedisMap.remove("websocket_dubbo_url");
        // }
        // } catch (Exception e) {
        // logger.error(e.getMessage(), e);
        // }
    }
}
