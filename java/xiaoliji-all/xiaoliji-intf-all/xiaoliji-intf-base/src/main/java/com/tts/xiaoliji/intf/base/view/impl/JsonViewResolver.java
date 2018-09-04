package com.tts.xiaoliji.intf.base.view.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.utils.DigestUtil;
import com.tts.xiaoliji.intf.base.utils.IntfJsonUtil;
import com.tts.xiaoliji.intf.base.view.ViewResolver;

import cn.openlo.protocol.http.JettyRelatedUtil;
import cn.openlo.service.ServiceResponse;

@Component("jsonResolver")
public class JsonViewResolver implements ViewResolver {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void render(ServiceResponse serviceResponse, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String charset = getCharset(request, response);
		byte[] jsonDatas = getResponseJsonBytes(serviceResponse, charset);

		String digest = DigestUtil.generateMd5Digest(jsonDatas);
		response.setHeader("shths", digest);

		outputHttpResponse(jsonDatas, response);
	}

	protected String getCharset(HttpServletRequest request, HttpServletResponse response) {
		String charset = JettyRelatedUtil.getCharset(request, "UTF-8");
		response.setCharacterEncoding(charset);
		return charset;
	}

	protected byte[] getResponseJsonBytes(ServiceResponse servicesResponse, String charset) throws IOException {
		Map result = (Map) servicesResponse.getModel();
		if (result == null) {
			return null;
		}
		if (result.containsKey("_enData_")) {
			servicesResponse.setModel(result.get("_enData_"));
		}
		if (servicesResponse.getFailCause() != null) {
			this.logger.warn(
					"exception is not null, the detail is {}, remove it from serviceResponse. The exception detail is as follows");
			this.logger.warn(servicesResponse.getFailCause().getMessage(), servicesResponse.getFailCause());
			servicesResponse.setFailCause(null);
		}
		String respString = IntfJsonUtil.objectToJsonString(servicesResponse);
		if (this.logger.isDebugEnabled()) {
			this.logger.debug("ResponseJSON=" + respString);
		}
		return respString.getBytes(charset);
	}

	protected void outputHttpResponse(byte[] jsonDatas, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=" + response.getCharacterEncoding());
		response.setContentLength(jsonDatas == null ? 0 : jsonDatas.length);
		if (jsonDatas != null) {
			OutputStream out = response.getOutputStream();
			out.write(jsonDatas);
			out.flush();
		} else {
			this.logger.warn("Response model is null.");
		}
	}
}
