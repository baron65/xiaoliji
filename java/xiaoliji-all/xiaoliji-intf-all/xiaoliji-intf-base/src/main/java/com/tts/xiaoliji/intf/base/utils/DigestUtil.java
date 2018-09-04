package com.tts.xiaoliji.intf.base.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtil {
	public static String generateMd5Digest(String message) {
		String result = DigestUtils.md5Hex(message);
		return result;
	}

	public static String generateMd5Digest(byte[] bytes) {
		String result = DigestUtils.md5Hex(bytes);
		return result;
	}

	public static String generateUpMd5Digest(String message) {
		byte[] digests = DigestUtils.md5(StringUtils.getBytesUtf8(message));
		return new String(Hex.encodeHex(digests, false));
	}

	public static void main(String[] args) {
		System.out.println(generateMd5Digest("{}"));
	}
}
