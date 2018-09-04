package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.utils.SafeCharUtil;

import cn.openlo.exception.IllegalParamException;
import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("serviceIllegalCharFilter")
public class IllegalCharacterCheckFilter extends AbstractIntfInboudFilter {
	private String ILLEGAL_CHARACTER_STRING = "'|\"|%|<|>|\\[|\\]|\\{|\\}|&|\\(|\\)";
	private String ILLEGAL_CHARACTER_PATTERN_STRING = ".*(" + this.ILLEGAL_CHARACTER_STRING + ").*";
	private Pattern ILLEGAL_CHARACTER_PATTERN1 = Pattern.compile(this.ILLEGAL_CHARACTER_PATTERN_STRING);
	private Pattern ILLEGAL_CHARACTER_PATTERN2 = Pattern.compile(this.ILLEGAL_CHARACTER_STRING);
	private Log log = LogFactory.getLog(getClass());

	public boolean matches(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) {
		return true;
	}

	public int getOrder() {
		return 15;
	}

	public void preFilter(ServiceRequest paramServiceRequest, ServiceContext serviceContext) throws LOSException {
		try {
			match(paramServiceRequest.getParameters());
		} catch (IllegalParamException e) {
			throw new LOSException(e);
		}
	}

	public String getName() {
		return "serviceIllegalCharFilter";
	}

	private void match(Object value) throws IllegalParamException {
		if (value == null) {
			return;
		}
		if ((value instanceof String)) {
			String paramValue = (String) value;
			if (paramValue.length() == 0) {
				return;
			}
			if (this.ILLEGAL_CHARACTER_PATTERN1.matcher(paramValue).matches()) {
				throw new IllegalParamException("inputParam.include.illegalChar");
			}
		}
		if ((value instanceof Collection)) {
			Collection paramValue = (Collection) value;
			for (Object tmp : paramValue) {
				match(tmp);
			}
		}
		if (value.getClass().isArray()) {
			Object[] paramValue = (Object[]) value;
			for (Object tmp : paramValue) {
				match(tmp);
			}
		}
		if ((value instanceof Map)) {
			Map paramValue = (Map) value;
			for (Object tmp : paramValue.values()) {
				match(tmp);
			}
		}
	}

	private void replace(Object value) {
		if (value == null) {
			return;
		}
		if ((value instanceof Collection)) {
			Collection paramValue = (Collection) value;
			for (Object tmp : paramValue.toArray()) {
				if ((tmp instanceof String)) {
					String paramValue2 = (String) tmp;
					if (SafeCharUtil.isSafetyString(paramValue2)) {
						String safeString = SafeCharUtil.pureString(paramValue2);
						this.log.warn("ignore illegal character output paramenter filter [" + safeString + "] ");
						paramValue.remove(tmp);
						paramValue.add(safeString);
					} else {
						if (paramValue2.length() == 0) {
							continue;
						}
						String filteredString = this.ILLEGAL_CHARACTER_PATTERN2.matcher(paramValue2).replaceAll("");
						if (filteredString.length() != paramValue2.length()) {
							this.log.warn("illegal character output paramenter filter [" + paramValue2 + "] -> ["
									+ filteredString + "]");
							paramValue.remove(tmp);
							paramValue.add(filteredString);
						}
					}
				} else {
					replace(tmp);
				}
			}
			return;
		}
		if (value.getClass().isArray()) {
			if (value.getClass().getComponentType().isPrimitive()) {
				return;
			}
			Object[] paramValue = (Object[]) value;
			int i = 0;
			for (Object tmp : paramValue) {
				if ((tmp instanceof String)) {
					String paramValue2 = (String) tmp;
					if (SafeCharUtil.isSafetyString(paramValue2)) {
						String safeString = SafeCharUtil.pureString(paramValue2);
						this.log.warn("ignore illegal character output paramenter filter [" + safeString + "] ");
						paramValue[i] = safeString;
					} else {
						if (paramValue2.length() == 0) {
							continue;
						}
						String filteredString = this.ILLEGAL_CHARACTER_PATTERN2.matcher(paramValue2).replaceAll("");
						if (filteredString.length() != paramValue2.length()) {
							this.log.warn("illegal character output paramenter filter [" + paramValue2 + "] -> ["
									+ filteredString + "]");
							paramValue[i] = filteredString;
						}
					}
				} else {
					replace(tmp);
				}
				i++;
			}
			return;
		}
		if ((value instanceof Map)) {
			Map paramValue = (Map) value;
			for (Object key : paramValue.keySet()) {
				Object tmp = paramValue.get(key);
				if ((tmp instanceof String)) {
					String paramValue2 = (String) tmp;
					if (SafeCharUtil.isSafetyString(paramValue2)) {
						String safeString = SafeCharUtil.pureString(paramValue2);
						this.log.warn("ignore illegal character output paramenter filter [" + safeString + "] ");
						paramValue.put(key, safeString);
					} else {
						if (paramValue2.length() == 0) {
							continue;
						}
						String filteredString = this.ILLEGAL_CHARACTER_PATTERN2.matcher(paramValue2).replaceAll("");
						if (filteredString.length() != paramValue2.length()) {
							this.log.warn("illegal character output paramenter filter [" + paramValue2 + "] -> ["
									+ filteredString + "]");
							paramValue.put(key, filteredString);
						}
					}
				} else {
					replace(tmp);
				}
			}
			return;
		}
		try {
			this.log.debug("ignore illegal character output paramenter filter , not recognition class : "
					+ value.getClass() + " value :" + value.toString());
		} catch (Exception localException) {
		}
	}
}
