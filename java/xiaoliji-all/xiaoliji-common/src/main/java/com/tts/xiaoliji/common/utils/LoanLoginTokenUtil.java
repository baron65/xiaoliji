package com.tts.xiaoliji.common.utils;

import java.util.UUID;

/**
 *
 * @author yangshiyin
 * @version
 * @since 2017年3月7日
 */
public class LoanLoginTokenUtil {

    public static String generateToken() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String token = uuid + LoanRandomUtil.getRandomString(8);
        return token;
    }

    public static void main(String[] args) {
        // long st = System.currentTimeMillis();
        // for (int i = 0; i < 100; i++) {
        // System.out.println(LoginTokenUtil.generateToken());
        // }
        // System.out.println(System.currentTimeMillis() - st);

    }
}
