package com.tts.xiaoliji.intf.base.service;

import java.io.File;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;
import com.tts.xiaoliji.intf.base.exception.InvalidServiceResponseException;

import cn.openlo.common.util.DateUtil;
import cn.openlo.exception.DateFormatException;
import cn.openlo.exception.LOException;
import cn.openlo.fss.client.FSSClient;
import cn.openlo.fss.client.exception.FSSClientException;
import cn.openlo.fss.client.model.customer.GetFileBytesByReadKeyReq;
import cn.openlo.fss.client.model.customer.GetFileBytesByReadKeyRes;
import cn.openlo.fss.client.model.customer.UploadReq;
import cn.openlo.fss.client.model.customer.UploadRes;
import cn.openlo.gear.jnl.JnlNoHelper;

public class BaseFssInvokeService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private JnlNoHelper jnlNoHelper;
	@Autowired
	FSSClient fssClient;

	public String upload(File file, String fileKey) {
		UploadReq req = new UploadReq();
		req.setFile(file);
		req.setFileKey(fileKey);
		UploadRes res = null;
		try {
			req.setChannel((String) IntfSession.getSession().getAttribute("_channel_id"));
			req.setChannelDate(DateUtil.getDateString(new Date(), "yyyyMMdd"));
			req.setChannelJnlNo(this.jnlNoHelper.generate().getStringValue());
			req.setSourceSystemId("1001");
			res = this.fssClient.upload(req);
			return res.getReadKey();
		} catch (FSSClientException e) {
			this.logger.error("upload file #{}# fail: #{}#.", new Object[] { req.getFileKey(), e.getMessage(), e });
			throw new InvalidConditionException("file.upload.error");
		} catch (DateFormatException e) {
			this.logger.error(e.getMessage(), e);
		} catch (LOException e) {
			this.logger.error(e.getMessage(), e);
			throw new InvalidConditionException("file.upload.error");
		}
		return null;
	}

	public byte[] download(String fileReadId) {
		GetFileBytesByReadKeyReq req = new GetFileBytesByReadKeyReq();
		req.setReadKey(fileReadId);
		GetFileBytesByReadKeyRes res = null;
		try {
			req.setChannel((String) IntfSession.getSession().getAttribute("_channel_id"));
			req.setChannelDate(DateUtil.getDateString(new Date(), "yyyyMMdd"));
			req.setChannelJnlNo(this.jnlNoHelper.generate().getStringValue());
			req.setSourceSystemId("1001");
			res = this.fssClient.getFileBytesByReadKey(req);
			return res.getContent();
		} catch (DateFormatException e) {
			this.logger.error(e.getMessage(), e);
		} catch (LOException e) {
			this.logger.error(e.getMessage(), e);
		} catch (FSSClientException e) {
			this.logger.error(e.getMessage(), e);
			throw new InvalidServiceResponseException(e.getResponseCode(), e.getResponseMsg());
		}
		return null;
	}
}
