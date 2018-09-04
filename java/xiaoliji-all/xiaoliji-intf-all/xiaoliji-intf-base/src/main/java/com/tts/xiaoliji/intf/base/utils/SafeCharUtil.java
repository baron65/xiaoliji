package com.tts.xiaoliji.intf.base.utils;

public class SafeCharUtil {
	public static final String safety = "$#@!$safe$#@!$:";

	public static boolean isSafetyString(String s) {
		if (s == null) {
			return false;
		}
		return s.startsWith("$#@!$safe$#@!$:");
	}

	public static String pureString(String s) {
		if (isSafetyString(s)) {
			return s.substring("$#@!$safe$#@!$:".length(), s.length());
		}
		return s;
	}

	public static String safeString(String s) {
		return "$#@!$safe$#@!$:" + pureString(s);
	}

	public static void main(String[] args) {
		System.out.println(isSafetyString(" $#@!$safe$#@!$:fdafdsa"));

		System.out.println(pureString("$#@!$safe$#@!$:fdafdsa"));
	}
}
