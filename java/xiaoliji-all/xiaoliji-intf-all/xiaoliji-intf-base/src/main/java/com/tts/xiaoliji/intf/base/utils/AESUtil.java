package com.tts.xiaoliji.intf.base.utils;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AESUtil {
	private static final String KEY_ALGORITHM = "AES";

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
		return secretKey;
	}

	public static String encrypt(String originStr, String encKey) throws Exception {
		Key k = toKey(encKey.getBytes());
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);

		cipher.init(1, k);

		byte[] encrypt = cipher.doFinal(originStr.getBytes());
		return Base64.encodeBase64String(encrypt);
	}

	public static String decrypt(String encStr, String encKey) throws Exception {
		Key k = toKey(encKey.getBytes("UTF-8"));
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);

		cipher.init(2, k);

		byte[] decrypt = cipher.doFinal(Base64.decodeBase64(encStr));
		return StringUtils.newStringUtf8(decrypt);
	}

	public static void main(String[] args) throws Exception {
		String key = TokenUtil.getRandomString(16);
		System.out.println(key);
		String plainText = "{\"phoneNo\":\"18610773012\", \"测试\":\"中文测试\"}";
		String encData = encrypt(plainText, key);
		System.out.println(encData);
		String decData = decrypt(encData, key);
		System.out.println(decData);
	}
}
