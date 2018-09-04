package com.tts.xiaoliji.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author yangshiyin
 * @version
 * @since 2017年3月7日
 */
public class LoanRandomUtil {

    private static final String[] BASE_STRING =
            { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
              "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
              "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    private static final String[] BASE_ALPHA = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                                                 "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                                                 "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    private static final String[] BASE_NUMBER = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

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
        }
        else if ("2".equals(scope)) {
            seedString = BASE_ALPHA;
        }
        else if ("3".equals(scope)) {
            seedString = BASE_NUMBER;
        }
        int length = seedString.length;
        String randomString = "";
        for (int i = 0; i < length; i++) {
            randomString = randomString + seedString[random.nextInt(length)];
        }
        random = new Random(System.currentTimeMillis());
        String resultStr = "";
        for (int i = 0; i < len; i++) {
            resultStr = resultStr + randomString.charAt(random.nextInt(randomString.length() - 1));
        }
        return resultStr;
    }

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            String str = LoanRandomUtil.getRandomString(6, "3");
            if (map.get(str) != null) {
                count++;
            }
            map.put(str, "1");

        }
        System.out.println(count);
    }
}
