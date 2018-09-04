package com.tts.xiaoliji.intf.base.utils;

import java.util.Random;

public class TokenUtil {
	private static final int DEFAULT_LENGTH = 6;
	private static final String[] BASE_STRING = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
			"z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };
	private static final String[] BASE_ALPHA = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private static final String[] BASE_NUMBER = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private static final String[] BASE_NUMBER_AND_LOW_ALPHA = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a",
			"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z" };

	public static final String getRandomString() {
		return getRandomString(6, "1");
	}

	public static final String getRandomString(int len) {
		return getRandomString(len, "1");
	}

	public static final String getRandomString(int len, String scope) {
		Random random = new Random();
		String[] seedString = new String[0];
		if ("1".equals(scope)) {
			seedString = BASE_STRING;
		} else if ("2".equals(scope)) {
			seedString = BASE_ALPHA;
		} else if ("3".equals(scope)) {
			seedString = BASE_NUMBER;
		} else if ("4".equals(scope)) {
			seedString = BASE_NUMBER_AND_LOW_ALPHA;
		}
		random = new Random(System.currentTimeMillis());
		String resultStr = "";
		for (int i = 0; i < len; i++) {
			resultStr = resultStr + seedString[random.nextInt(seedString.length - 1)];
		}
		return resultStr;
	}
}
