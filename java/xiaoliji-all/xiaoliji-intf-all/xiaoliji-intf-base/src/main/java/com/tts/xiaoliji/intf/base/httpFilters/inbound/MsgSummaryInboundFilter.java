package com.tts.xiaoliji.intf.base.httpFilters.inbound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.utils.DigestUtil;

import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.exception.LOSException;
import cn.openlo.service.HttpInboundServiceFilter;
import cn.openlo.service.ServiceContext;

@Component("httpMsgSummaryInFilter")
public class MsgSummaryInboundFilter implements HttpInboundServiceFilter {
	Logger logger = LoggerFactory.getLogger(getClass());

	public int getOrder() {
		return 40;
	}

	public void doFilter(HttpServletRequest request, ServiceContext context) throws LOSException {
		String msgSummary = request.getHeader("summary");
		if (StringUtils.isEmpty(msgSummary)) {
			throw new LOSException("failed");
		}
		StringWriter writer = readRequestBody(request);
		String content = writer.toString();
		String calcDigest = DigestUtil.generateMd5Digest(content);
		if (!msgSummary.equals(calcDigest)) {
		    this.logger.debug("digest not equal, the content is {}", content);
			this.logger.debug("digest not equal, the upload is {}, the calc is {}", msgSummary, calcDigest);
			throw new LOSException("failed");
		}
		context.putAllData(parseStringAsJSON(content));
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> parseStringAsJSON(String requestBody) throws LOSException {
		Map<String, Object> params = null;
		this.logger.debug("RequestParamaters(JSON)=" + requestBody);
		if (StringUtils.hasText(requestBody)) {
			try {
				params = (Map<String, Object>) LOJsonUtil.jsonStringToMap(requestBody);
			} catch (Exception ex) {
				this.logger.error("RequestParamaters(JSON)[" + requestBody + "] format error:" + ex.getMessage());
				throw new LOSException("fail");
			}
		}
		return params;
	}

	private StringWriter readRequestBody(HttpServletRequest request) throws LOSException {
		try {
			BufferedReader in = request.getReader();
			StringWriter out = null;
			char[] buffer = new char['?'];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != -1) {
				if (out == null) {
					out = new StringWriter(512);
				}
				out.write(buffer, 0, bytesRead);
			}
			return out;
		} catch (IOException e) {
			throw new LOSException("Read request body error:" + e.getMessage(), e);
		}
	}
}
