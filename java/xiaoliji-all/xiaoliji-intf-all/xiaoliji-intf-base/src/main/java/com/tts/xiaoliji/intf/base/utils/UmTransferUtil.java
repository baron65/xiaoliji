package com.tts.xiaoliji.intf.base.utils;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tts.xiaoliji.intf.base.user.RMInfo;

import cn.openlo.common.util.DateUtil;

public class UmTransferUtil {
	private static final Logger logger = LoggerFactory.getLogger("UmTransferUtil");

	public static RMInfo transferMapToDetail(Map<String, Object> rmMap) {
		RMInfo rmInfo = new RMInfo();
		rmInfo.setChineseName((String) rmMap.get("name"));
		rmInfo.setCity((String) rmMap.get("workCity"));
		if (rmMap.get("financialYears") != null) {
			rmInfo.setDuration(((Integer) rmMap.get("financialYears")).intValue());
		}
		Date entryDate = (Date) rmMap.get("dateJoinStartdate");
		try {
			rmInfo.setEntryDate(DateUtil.printDate(entryDate));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		rmInfo.setHoners((String) rmMap.get("selfhonor"));
		rmInfo.setRmId((String) rmMap.get("rmId"));
		rmInfo.setSelfRecomd((String) rmMap.get("selfcommend"));
		rmInfo.setSex((String) rmMap.get("sex"));
		rmInfo.setTitle((String) rmMap.get("jobLevelDesc"));
		rmInfo.setPhone((String) rmMap.get("phone"));
		rmInfo.setMajorEng((String) rmMap.get("selfIntroduction"));
		rmInfo.setImageUrl1((String) rmMap.get("imageUrl1"));
		rmInfo.setImageUrl2((String) rmMap.get("imageUrl2"));
		rmInfo.setImageUrl3((String) rmMap.get("imageUrl3"));
		return rmInfo;
	}
}
