package com.tts.xiaoliji.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

public class LoanStringUtils extends StringUtils {

    public static boolean isNotEmpty(String s) {
        if (null != s && s.trim().length() > 0) {
            return true;
        }

        return false;
    }

    public static boolean equals(String s1, String s2) {
        s1 = trim(s1);
        s2 = trim(s2);

        return s1.equals(s2);
    }

    public static String notempty(String s, String def) {
        s = trim(s);
        if (null == s || "".equals(s)) {
            s = def;
        }
        return s;
    }

    public static String trim(String s, String def) {
        s = trim(s);
        if (null == s) {
            s = def;
        }
        return s;
    }

    public static String trim(String s) {
        if (null == s) {
            return "";
        }
        return s.trim();
    }

    public static String fixedLengthWith0(String s, int length) {
        return fixedLength(s, length, '0');
    }

    public static String fixedLength(String s, int length, char c) {
        s = trim(s, "");

        if (s.length() > length) {
            return s.substring(0, 8);
        }

        if (s.length() == length) {
            return s;
        }

        String format = "%" + length + "s";

        s = String.format(format, s);

        s = s.replaceAll(" ", String.valueOf(c));

        return s;
    }

    public static List<String> splitByComma(String value) {
        List<String> list = new ArrayList<String>();

        if (StringUtils.isEmpty(value)) {
            return list;
        }

        String[] arrs = value.split(",");

        list = Arrays.asList(arrs);

        return list;
    }

    public static String toStringByComma(List<String> strList) {
        if (CollectionUtils.isEmpty(strList)) {
            return "";
        }
        StringBuilder strBuilder = new StringBuilder();
        for (String str : strList) {
            if (null == str) {
                continue;
            }
            strBuilder.append(str.trim()).append(",");
        }
        strBuilder = strBuilder.deleteCharAt(strBuilder.length() - 1);
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        {
            list.add("a");
            list.add("a");
        }

        String s = toStringByComma(list);
        System.out.println(s);
        System.out.println(splitByComma(s));
        System.out.println("|" + fixedLengthWith0("P01", 4) + "|");
    }
}
