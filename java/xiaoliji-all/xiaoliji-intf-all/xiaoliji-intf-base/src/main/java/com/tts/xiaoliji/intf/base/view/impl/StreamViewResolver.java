package com.tts.xiaoliji.intf.base.view.impl;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.view.ViewResolver;

import cn.openlo.service.ServiceResponse;

@Component("streamResolver")
// public class StreamViewResolver extends AbstractViewResolver {
// public void render(ServiceResponse serviceResponse, HttpServletRequest request, HttpServletResponse response)
// throws Exception {
// preventCaching(response);
// Map result = (Map) serviceResponse.getModel();
// Object content = result.get(this.contentField);
// response.setContentType(calcContentType(result));
// writeByteStream(content, response, this.encoding);
// }

/**
 * 2017-06-20 17:12:15.900 ERROR [{}][JettyThread-1080][564] [com.jsh.wss.intf.base.view.impl.StreamViewResolver] - render
 * org.eclipse.jetty.io.EofException
 * at org.eclipse.jetty.io.ChannelEndPoint.flush(ChannelEndPoint.java:192)
 * at org.eclipse.jetty.io.WriteFlusher.flush(WriteFlusher.java:408)
 * at org.eclipse.jetty.io.WriteFlusher.completeWrite(WriteFlusher.java:364)
 * at org.eclipse.jetty.io.SelectChannelEndPoint.onSelected(SelectChannelEndPoint.java:111)
 * at org.eclipse.jetty.io.SelectorManager$ManagedSelector.processKey(SelectorManager.java:641)
 * at org.eclipse.jetty.io.SelectorManager$ManagedSelector.select(SelectorManager.java:612)
 * at org.eclipse.jetty.io.SelectorManager$ManagedSelector.run(SelectorManager.java:550)
 * at org.eclipse.jetty.util.thread.NonBlockingThread.run(NonBlockingThread.java:52)
 * at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:635)
 * at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:555)
 * at java.lang.Thread.run(Thread.java:744)
 * Caused by: java.io.IOException: Connection reset by peer
 * at sun.nio.ch.FileDispatcherImpl.write0(Native Method)
 * at sun.nio.ch.SocketDispatcher.write(SocketDispatcher.java:47)
 * at sun.nio.ch.IOUtil.writeFromNativeBuffer(IOUtil.java:93)
 * at sun.nio.ch.IOUtil.write(IOUtil.java:65)
 * at sun.nio.ch.SocketChannelImpl.write(SocketChannelImpl.java:487)
 * at org.eclipse.jetty.io.ChannelEndPoint.flush(ChannelEndPoint.java:170)
 * ... 10 more
 */

// 以下代码从wss-inner-base中copy过来，解决一下上面的异常
public class StreamViewResolver implements ViewResolver {
    protected static final String HEADER_PRAGMA = "Pragma";
    protected static final String HEADER_EXPIRES = "Expires";
    protected static final String HEADER_CACHE_CONTROL = "Cache-Control";
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private boolean nocacheFlag = true;
    private String contentType;
    private String encoding;
    private String contentField = "_content_";
    private String filenameField = "_filename_";
    private String contentTypeField = "_content_type_";
    private String contentDisposition = "_content-_disposition";

    public void render(ServiceResponse serviceResponse, HttpServletRequest request, HttpServletResponse response) throws Exception {
        preventCaching(response);
        response.setContentType(getContentType());
        Map result = (Map) serviceResponse.getModel();
        Object content = result.get(this.contentField);
        String fileName = (String) result.get(this.filenameField);
        String contentType = (String) result.get(this.contentTypeField);
        generateFileName(request, response, fileName, null, null);
        response.setContentType(contentType);

        Object contentDispositionObj = result.get(this.contentDisposition);

        if (null != contentDispositionObj) {
            String contentDispositionS = (String) contentDispositionObj;
            if (StringUtils.hasText(contentDispositionS)) {
                // response.setHeader("content-disposition", "inline; filename=\"YourFileName.pdf\"");
                response.setHeader("content-disposition", contentDispositionS);
            }
        }

        writeByteStream(content, response, this.encoding);
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
                this.logger.info("Response content Length : {}", Integer.valueOf(((byte[]) content).length));
                out.write((byte[]) content);
                out.flush();
            }
            else {
                content = content.toString();
                OutputStream out = response.getOutputStream();
                byte[] bytes;
                if (encoding == null) {
                    bytes = ((String) content).getBytes();
                }
                else {
                    bytes = ((String) content).getBytes(encoding);
                }
                response.setContentLength(bytes.length);
                out.write(bytes);
                out.flush();
            }
        }
        catch (Exception e) {
            this.logger.error("render error:" + e.getMessage(), e);
        }
    }

    protected void generateFileName(HttpServletRequest request, HttpServletResponse response, String filename, String fileNameEncoding,
            String fileNameToEncoding) {
        StringBuffer sb = new StringBuffer();
        String inline = request.getParameter("inline");
        if (inline == null) {
            inline = String.valueOf(request.getAttribute("inline"));
        }
        if ((inline != null) && (inline.trim().equalsIgnoreCase("true"))) {
            sb.append("inline; filename=");
        }
        else {
            sb.append("attachment; filename=");
        }
        if (fileNameEncoding != null) {
            try {
                sb.append(new String(filename.getBytes(fileNameEncoding), fileNameToEncoding));
            }
            catch (Exception e) {
                this.logger.warn(e.getMessage(), e);
                sb.append(filename);
            }
        }
        else {
            try {

                sb.append(URLEncoder.encode(filename, "UTF-8"));

            }
            catch (UnsupportedEncodingException e) {
                this.logger.warn(e.getMessage(), e);
                sb.append(filename);
            }

        }
        response.setHeader("Content-Disposition", sb.toString());
    }

    public void setNocacheFlag(boolean nocacheFlag) {
        this.nocacheFlag = nocacheFlag;
    }

    public String getContentField() {
        return this.contentField;
    }

    public void setContentField(String cf) {
        this.contentField = cf;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
