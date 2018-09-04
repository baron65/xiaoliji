package com.tts.xiaoliji.common.utils;

import java.util.UUID;

public class MyNumberGen {

    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24, 36);
        return s;
    }
}