package com.tts.xiaoliji.intf.base.sao;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.exception.IntfRuntimeException;
import com.tts.xiaoliji.intf.base.exception.InvalidServiceResponseException;

import cn.openlo.common.beanutils.BeanToMap;
import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.service.FacadeServiceClient;
import cn.openlo.service.LOServiceClient;
import cn.openlo.service.ServiceResponse;

public abstract class IntfBaseSAO {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	protected static final String NO_REQUEST_DTL_LOG_KEY = "_no_dtl_log_";
	protected static final Pattern validatorFail = Pattern.compile("^20[0-9]{4}$");
	protected static final Set<String> knownValidateCodeSet = new HashSet<String>();

	static {
		knownValidateCodeSet.add("200000");
		knownValidateCodeSet.add("200001");
		knownValidateCodeSet.add("200002");
		knownValidateCodeSet.add("200003");
		knownValidateCodeSet.add("200004");
		knownValidateCodeSet.add("200005");
		knownValidateCodeSet.add("200006");
		knownValidateCodeSet.add("200010");
	}

	protected Map<String, Object> sendRequest(LOServiceClient client, Map<String, Object> params) {
		boolean recDtlLog = true;
		if (params != null) {
			recDtlLog = params.remove("_no_dtl_log_") == null;
		}
		logSendDtl(client, params, recDtlLog);
		ServiceResponse response = client.sendRequest(params);
		logResponseDtl(client, response, recDtlLog);
		Map<String, Object> result = extractRealResponse(response);
		return result;
	}

	@SuppressWarnings("unchecked")
	protected Map<String, Object> extractRealResponse(ServiceResponse response) {
		if (response == null) {
			throw new InvalidServiceResponseException("service.res.isnull");
		}
		String responseCode = response.getResponseCode();
		if (!"000000".equals(responseCode)) {
			this.logger.warn("Request send to {} failed, response code is {}, responseMsg is {}",
					new Object[] { getSysPre(), response.getResponseCode(), response.getResponseMsg() });

			IntfRuntimeException exception = contructException(response);
			throw exception;
		}
		Object model = response.getModel();
		Map<String, Object> result = null;
		try {
			result = (Map<String, Object>) BeanToMap.toMap(model);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			this.logger.error("Failed to transfer model to map, the model is {}", LOJsonUtil.objectToJsonString(model));
			throw new IntfRuntimeException(getSysPre() + "|" + "err.response");
		}
		return result;
	}

	protected void logSendDtl(LOServiceClient client, Map<String, Object> params, boolean recDtlLog) {
		if ((this.logger.isInfoEnabled()) && (recDtlLog)) {
			if ((client instanceof FacadeServiceClient)) {
				FacadeServiceClient clientImpl = (FacadeServiceClient) client;
				String calleeName = clientImpl.getCalleeName();
				this.logger.info("Invoke service: {} to {} start, the request is {}",
						new Object[] { calleeName, getSysPre(), LOJsonUtil.objectToJsonString(params) });
			} else {
				this.logger.info("Invoke sao to {}, the params is {}", getSysPre(),
						LOJsonUtil.objectToJsonString(params));
			}
		}
	}

	protected void logResponseDtl(LOServiceClient client, ServiceResponse response, boolean recDtlLog) {
		if ((this.logger.isInfoEnabled()) && (recDtlLog)) {
			if ((client instanceof FacadeServiceClient)) {
				FacadeServiceClient clientImpl = (FacadeServiceClient) client;
				String calleeName = clientImpl.getCalleeName();
				this.logger.info("Invoke service: {} to {} end, the result is {}",
						new Object[] { calleeName, getSysPre(), LOJsonUtil.objectToJsonString(response) });
			} else {
				this.logger.info("Invoke sao to {} end, the result is {}", getSysPre(),
						LOJsonUtil.objectToJsonString(response));
			}
		}
	}

	private IntfRuntimeException contructException(ServiceResponse response) {
		String responseCode = response.getResponseCode();

		InvalidServiceResponseException exception = null;
		if ("999999".equals(responseCode)) {
			exception = new InvalidServiceResponseException("888888");
		} else {
			exception = new InvalidServiceResponseException(getSysPre() + "|" + responseCode,
					response.getResponseMsg());
		}
		if (StringUtils.hasText(responseCode)) {
			if(StringUtils.hasText(response.getResponseMsg())){
				throw new InvalidServiceResponseException(responseCode, response.getResponseMsg());
			}
			if (validatorFail.matcher(responseCode).matches()) {
				if (knownValidateCodeSet.contains(responseCode)) {
					exception = new InvalidServiceResponseException(responseCode, "系统内部错误，请稍后重试");
				} else {
					exception = new InvalidServiceResponseException("validator.fail", "系统内部错误，请稍后重试");
				}
			}
		}
		return exception;
	}

	public static void main(String[] args) {
		System.out.println(validatorFail.matcher(" 20000").matches());
		System.out.println(validatorFail.matcher(" 200001").matches());
		System.out.println(validatorFail.matcher("20x001").matches());
	}

	protected abstract String getSysPre();
}
