package com.tts.xiaoliji.gw.wx.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

public class HttpUtils {

	// 连接超时时间，默认10秒
	private static int socketTimeout = 10000;

	// 传输超时时间，默认30秒
	private static int connectTimeout = 30000;

	public static String post(String url, String json) throws Exception {

		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json");
		StringEntity postEntity = new StringEntity(json, "UTF-8");
		httpPost.setEntity(postEntity);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectTimeout).build();
		httpPost.setConfig(requestConfig);

		String result = null;
		try {
			CloseableHttpClient httpClient = HttpClients.custom().build();
			HttpResponse response = httpClient.execute(httpPost);
			result = handlerResponse(response, "UTF-8");
		} finally {
			httpPost.abort();
		}

		return result;
	}

	// TODO 实现超时重试机制
	public static String get(String url, Map<String, Object> paramMap) throws Exception {
		if (StringUtils.isEmpty(url)) {
			throw new RuntimeException("url参数错误");
		}

		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse resp = null;
		try {
			String encodedUrl = encodeGetUrl(url, paramMap);
			HttpGet httpGet = new HttpGet(encodedUrl);
			RequestConfig reqConf = RequestConfig.custom().setSocketTimeout(socketTimeout)
					.setConnectTimeout(connectTimeout).build();
			httpGet.setConfig(reqConf);
			System.out.println(httpGet.getURI());
			// 发起请求 并返回请求的响应
			resp = httpClient.execute(httpGet);
			// 返回响应结果
			return handlerResponse(resp, "UTF-8");
		} catch (Throwable e) {
			throw new RuntimeException("url: " + url, e);
		} finally {
			try {
				httpClient.close();
				if (resp != null) {
					resp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 生成满足Get请求方式的URI规范路径, 如果参数paramMap不为空, 则转换编码后和url进行拼接, 如下格式URL都可以自动处理:
	 * <ul>
	 * <li>http://www.zjcs.com</li>
	 * <li>http://www.zjcs.com?key1=value1</li>
	 * <li>http://www.zjcs.com?key1=value1&</li>
	 * </ul>
	 */
	private static String encodeGetUrl(String url, Map<String, Object> paramMap) throws URISyntaxException {
		URIBuilder uriBuilder = new URIBuilder(url);
		if (MapUtils.isNotEmpty(paramMap)) {
			for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
				Object value = entry.getValue();
				if (null == value) {
					continue;
				}
				uriBuilder.addParameter(entry.getKey(), value.toString());
			}
		}
		return uriBuilder.toString();
	}

	// 处理返回结果
	private static String handlerResponse(HttpResponse resp, String encode) throws Exception {
		StatusLine statusLine = resp.getStatusLine();
		if (statusLine.getStatusCode() >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}

		// 获取响应对象
		HttpEntity resEntity = resp.getEntity();
		if (resEntity == null) {
			throw new ClientProtocolException("response contains no content");
		}
		String resContent = EntityUtils.toString(resEntity, Charset.forName(encode));
		resContent = resContent == null ? "" : resContent;
		EntityUtils.consume(resEntity); // 销毁

		return resContent;
	}
}