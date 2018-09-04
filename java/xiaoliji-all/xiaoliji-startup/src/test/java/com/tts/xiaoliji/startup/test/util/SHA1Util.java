package com.tts.xiaoliji.startup.test.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class SHA1Util {
    public static String encrypt(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte bytes[] = digest.digest();
            return Base64.encodeBase64String(bytes);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
 
    public static String encryptHex(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte bytes[] = digest.digest();
            return bytesToHexString(bytes);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
 
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
 
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
 
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
 
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            String res = SHA1Util.encryptHex(RandomUtil.getRandomString(16, "2"));
//            System.out.println(res.toUpperCase());
        }
        String uid = "20170413174545000000222";
        String psw = "123456";
        String res = SHA1Util.encryptHex(uid + psw);
        System.out.println(res.toUpperCase());
    }
}
