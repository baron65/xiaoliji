package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.tts.xiaoliji.common.bean.LoginUser;
import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;

import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("userAccessCheckFilter")
public class UserAccessCheckFilter extends AbstractIntfInboudFilter {
    public boolean matches(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) {
        return true;
    }

    public int getOrder() {
        return 3;
    }

    public String getName() {
        return "userAccessFilter";
    }

    public void preFilter(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) throws LOSException {
        LoginUser user = IntfSession.getSession().getUser();
        if (user == null) {
            Map<String, String> losProperties = paramServiceContext.getLosProperties();
            String tempUserOk = (String) losProperties.get("_temp_user");
            if ("Y".equals(tempUserOk)) {
                user = (LoginUser) IntfSession.getSession().getAttribute("temp_session_user_key", LoginUser.class);
            }
            String livePcUserOk = (String) losProperties.get("_pc_live_user");
            if ("Y".equals(livePcUserOk)) {
                user = (LoginUser) IntfSession.getSession().getAttribute("_live_auto_login_user", LoginUser.class);
            }
        }
        if (user == null) {
            throw new InvalidConditionException("user.invalid");
        }
    }

}
