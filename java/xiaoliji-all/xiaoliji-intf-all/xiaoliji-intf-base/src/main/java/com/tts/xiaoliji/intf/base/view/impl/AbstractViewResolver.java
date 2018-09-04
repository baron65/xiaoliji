package com.tts.xiaoliji.intf.base.view.impl;

import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.view.ViewResolver;

import cn.openlo.protocol.http.JettyRelatedUtil;

public abstract class AbstractViewResolver implements ViewResolver {
	protected static final String HEADER_PRAGMA = "Pragma";
	protected static final String HEADER_EXPIRES = "Expires";
	protected static final String HEADER_CACHE_CONTROL = "Cache-Control";
	private final Logger logger = LoggerFactory.getLogger(getClass());
	protected boolean nocacheFlag = true;
	protected String contentType;
	protected String encoding;
	protected String contentField = "_content_";

	protected String getCharset(HttpServletRequest request, HttpServletResponse response) {
		String charset = JettyRelatedUtil.getCharset(request, "UTF-8");
		response.setCharacterEncoding(charset);
		return charset;
	}

	protected String calcContentType(Map result) {
		String contentType = getContentType();
		try {
			String assignType = (String) result.get("_content_type_");
			if (StringUtils.hasText(assignType)) {
				contentType = assignType;
			}
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}
		return contentType;
	}

	protected final void preventCaching(HttpServletResponse response) {
		if (this.nocacheFlag) {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
		}
	}

	protected void writeByteStream(Object content, HttpServletResponse response, String encoding) {
		if (content == null) {
			return;
		}
		if (this.logger.isDebugEnabled()) {
			this.logger.debug("content is not null, try to send to request");
		}
		try {
			if ((content instanceof byte[])) {
				OutputStream out = response.getOutputStream();
				response.setContentLength(((byte[]) content).length);
				out.write((byte[]) content);
				out.flush();
			} else {
				content = content.toString();
				OutputStream out = response.getOutputStream();
				byte[] bytes;
				if (encoding == null) {
					bytes = ((String) content).getBytes();
				} else {
					bytes = ((String) content).getBytes(encoding);
				}
				response.setContentLength(bytes.length);
				out.write(bytes);
				out.flush();
			}
		} catch (Exception e) {
			this.logger.error("render", e);
		}
	}

	protected void generateFileName(HttpServletRequest request, HttpServletResponse response, String filename,
			String fileNameEncoding, String fileNameToEncoding) {
		StringBuffer sb = new StringBuffer();
		String inline = request.getParameter("inline");
		if (inline == null) {
			inline = String.valueOf(request.getAttribute("inline"));
		}
		if ((inline != null) && (inline.trim().equalsIgnoreCase("true"))) {
			sb.append("inline; filename=");
		} else {
			sb.append("attachment; filename=");
		}
		if (fileNameEncoding != null) {
			try {
				sb.append(new String(filename.getBytes(fileNameEncoding), fileNameToEncoding));
			} catch (Exception e) {
				this.logger.warn(e.getMessage(), e);
				sb.append(filename);
			}
		} else {
			sb.append(filename);
		}
		response.setHeader("Content-Disposition", sb.toString());
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getEncoding() {
		return this.encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getContentField() {
		return this.contentField;
	}

	public void setContentField(String contentField) {
		this.contentField = contentField;
	}

	public Logger getLogger() {
		return this.logger;
	}
}
