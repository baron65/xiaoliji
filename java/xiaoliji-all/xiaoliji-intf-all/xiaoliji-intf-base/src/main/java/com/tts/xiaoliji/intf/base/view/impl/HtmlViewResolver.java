package com.tts.xiaoliji.intf.base.view.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import cn.openlo.service.ServiceResponse;

@Component("htmlResolver")
public class HtmlViewResolver extends AbstractViewResolver {
	private String encoding;
	private String contentField = "_content_";

	public String getContentType() {
		return "text/html";
	}

	public void render(ServiceResponse serviceResponse, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map result = (Map) serviceResponse.getModel();
		Object content = result.get(this.contentField);
		response.setContentType(calcContentType(result));
		writeByteStream(content, response, this.encoding);
	}
}
