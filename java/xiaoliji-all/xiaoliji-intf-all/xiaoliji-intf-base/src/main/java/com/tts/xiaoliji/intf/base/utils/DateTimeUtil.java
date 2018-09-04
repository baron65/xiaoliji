package com.tts.xiaoliji.intf.base.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.openlo.common.util.DateUtil;

public class DateTimeUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);
	public static final String DEFAULT_DATE_PATTERN = "yyyyMMdd";
	public static final String DEFAULT_DATE_PATTERN2 = "yyyy-MM-dd";
	public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss SSSS";
	public static final String DEFAULT_DATE_TIME_PATTERN2 = "yyyy-MM-dd HH:mm:ss";

	public static String formatDate(Date date, String pattern) {
		return new DateTime(date).toString(pattern);
	}

	public static String formatNow() {
		return formatDate(DateTime.now().toDate(), "yyyy-MM-dd HH:mm:ss SSSS");
	}

	public static Date parseDefaultTime(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss SSSS");
	}

	public static Date now() {
		Calendar cal = Calendar.getInstance();
		synchronized (cal) {
			cal.setTimeInMillis(System.currentTimeMillis());
			return cal.getTime();
		}
	}

	public static Date parseDate(String dateStr, String pattern) {
		DateTimeZone dateTimeZone = DateTimeZone.forID("Etc/GMT-8");
		DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern).withZone(dateTimeZone);
		return DateTime.parse(dateStr, formatter).toDate();
	}

	public static String formatDate(Date inputDate) {
		String result = "";
		try {
			result = DateUtil.printDateTime(inputDate);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	public static String transformBirthday(String birthday) {
		String result = "";
		try {
			result = DateUtil.printCompactDate(DateUtil.parseDate(birthday));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	public static String getString(Date value, String pattern)
	{
		if (value == null) {
			return "";
		}
		SimpleDateFormat vFormat = new SimpleDateFormat(pattern);
		return vFormat.format(value);
	}

}
