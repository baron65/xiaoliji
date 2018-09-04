package com.tts.xiaoliji.intf.base.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.tts.xiaoliji.intf.base.exception.InvalidInputException;

public class DeviceIdCheckCodeUtil {
	static int[] Wi = { 16, 4, 8, 9, 3, 11, 13, 6, 7, 2 };
	static char[] allowChar = { '-', '\n', '\\', 'n' };

	public static String getDeviceIdCheckCode(String deviceId) {
		if (StringUtils.isEmpty(deviceId)) {
			throw new InvalidInputException("deviceId.input.null");
		}
		deviceId = deviceId.trim();
		int totalSum = 0;
		for (int i = 0; i < deviceId.length(); i++) {
			char a = deviceId.charAt(i);
			int temp = -1;
			if (((a >= '0') && (a <= '9')) || ((a >= 'a') && (a <= 'f')) || ((a >= 'A') && (a <= 'F'))) {
				temp = Integer.parseInt(String.valueOf(a), 16);
			} else {
				if (checkAllow(a)) {
					continue;
				}
				temp = Character.getNumericValue(a) + 8;
			}
			totalSum += (temp + i) * Wi[(i % 10)];
		}
		if (totalSum == 0) {
			throw new InvalidInputException("deviceId.input.illegal");
		}
		String checkCode = String.format("%02d", new Object[] { Integer.valueOf(totalSum % 100) });
		return checkCode;
	}

	public static boolean checkAllow(char a) {
		for (char temp : allowChar) {
			if (a == temp) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void test11() {
		String temp = "17654A-22B8-45D3-B0A3-3DC029D409B9";
		System.out.println(getDeviceIdCheckCode(temp));
	}

	public static void main(String[] args) {
		File file = new File("C:/Users/jianjian/Desktop/bb.csv");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String aa = br.readLine();
			while (StringUtils.isNotEmpty(aa)) {
				System.out.println(getDeviceIdCheckCode(aa));
				aa = br.readLine();
			}
			return;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
