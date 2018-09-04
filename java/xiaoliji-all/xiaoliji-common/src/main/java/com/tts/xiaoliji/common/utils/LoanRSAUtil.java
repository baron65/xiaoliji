package com.tts.xiaoliji.common.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class LoanRSAUtil {
    private static String privateKey =
            "MIIEowIBAAKCAQEA57U0CC3ZqD5uufBtAZ/QgWhAn20npjUnMrLw7SVnpPPPezgb\nHgFyhD1G2aIrbqmf+BxPRXElfns86gvliKUcHqj3gcAZySNpnvRTZcG1pAgajIbk\nl5UJdfzdfHYkjqUlyvYBtY8r5IKLX0CVF+iel21hrkC4RjxmOqDJao0lhC2D8fKl\nYc+jzPI/Kh0oSUGJ0Co3mdyEdmmi0pyFo0jI8CURA3GqRUxboJVX+x81rx1CVJiR\nyfI4ncphhCZQTGNmwrh0li1u2r85HGb8SbhtzcK5bjUKkJUharn7biv8UrZpujAG\nqG8q8rroQQ3TnY0cLlnFyGi3Emr7BedF3CbvTQIDAQABAoIBACiYTKdqMQoS9h9J\nii+Qql0hwMCtxRaPlXCCfUdvGDuEI8O4zrdxFXkpqzISAX3/5fD4NMM70Y/ZU5DF\nyM8p7kVI4SQwXdQpiiW5NKtNRt+YM96O+5m7GM89ICjgIgOD1505gI8oqE3+uSBV\nFkn8DV0GYui+mgpkJpz68o7ib8I6Sd5SziJGhx3NPxvDwHe8m8xsQIy5PyLmxosX\nC+nty6UV7G0kQy+ElgpFQvIoNSiEt4aHNHkYWQrThcGr9OzOEuvU6t6PASk6Nuvt\nOmeYdTDVh4WvzwJm2XyKxjt48qZ2kKshXZnsZKHllEuJMr8DgqX0caPsLUTdwMc0\n4YvfKYECgYEA8+yPHbw/G0aRZXRvh5mUNljayUNcONaxtEGT32h42rkjGamvptnw\nTn4gyRRo2eUWfP7EhFfN1o2e5XxSom7TVvCwK31570zLFFQAe71dWj/bESIZhhH7\ngf1j10Zwz3BZel48y/bHIXhY2bxlIIuukChJcAqDg4EB75ddDFHbRX0CgYEA8y3R\ne35mAaw6ez4FHHBsGVcdMwJn85jPCu4EKvT9BaZ/AwKFfs8drXd2W/2bTod/qFKw\nzYodM2Ts/67IskNXyxtjl+bC7uT3N5joNia2Yd9yX6zXaSe9Kio4bQ6OIpjCiKvy\nUjWlwB5XZSJ6zvq4eSxjX5adP6x0YPtHRq2NOhECgYEAtxqg5EVnaeYzRuF8x2G2\nLIXO1r5GADTJ+PIxOseF0Uqg2qbSQIHhLkrn+Ynkm4yosPPeOSpgTerJmKMWtPBU\nnTLYTA1I9yXCXGQiaMDhztmYbOgYGNhu4EmCJRuvm0hPItiS8tkw6iMZL3mIwEGa\nrIRRfFWoG5NADManBpR78VECgYADO12oXYKvjQFt9+ILgbb+EzlRHzwQcbx2sbke\ndQkT1SWk/ZiWmdwUHR1WlaVFwulAbHDrGmXO9A1uTH1gWSLGkUOeljOLB0H93Cth\n5NvRqy2S9fIa9Ks/7zW2xVXAQfV76YUb8JiWWBDjSDUHoS9odN2RPKg0W29khpJo\n7w+McQKBgBEeQczJNHD5VMagKLJndzDNOvU6DE9wVCTpiOQHgf4xZMPfhJZuto5l\nKS+2IG6UXEH/+FzYYumhZjecpXtX/RDkaWbwq0mqOpFa3KGvjOZdKSy86TxaEhXF\n3TmosTHVEQP3/cvJcsj2dBYNIqLxA7nnLkxOAznrzZoFUO+M5mbN\n";
    private static String publicKey =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA57U0CC3ZqD5uufBtAZ/Q\ngWhAn20npjUnMrLw7SVnpPPPezgbHgFyhD1G2aIrbqmf+BxPRXElfns86gvliKUc\nHqj3gcAZySNpnvRTZcG1pAgajIbkl5UJdfzdfHYkjqUlyvYBtY8r5IKLX0CVF+ie\nl21hrkC4RjxmOqDJao0lhC2D8fKlYc+jzPI/Kh0oSUGJ0Co3mdyEdmmi0pyFo0jI\n8CURA3GqRUxboJVX+x81rx1CVJiRyfI4ncphhCZQTGNmwrh0li1u2r85HGb8Sbht\nzcK5bjUKkJUharn7biv8UrZpujAGqG8q8rroQQ3TnY0cLlnFyGi3Emr7BedF3Cbv\nTQIDAQAB\n\n";
    private static Cipher cipher;

    static {
        try {
            Security.addProvider(new BouncyCastleProvider());
            try {
                cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            }
            catch (NoSuchProviderException e) {
                e.printStackTrace();
            }
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public static String getKey(String filename) throws IOException {
        String strKeyPEM = "";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            strKeyPEM = strKeyPEM + line + "\n";
        }
        br.close();
        return strKeyPEM;
    }

    public static PrivateKey generatePrivateKey(String content) throws IOException, GeneralSecurityException {
        String privateKeyPEM = content;
        return getPrivateKeyFromString(privateKeyPEM);
    }

    public static PrivateKey getPrivateKeyFromString(String key) throws IOException, GeneralSecurityException {
        String privateKeyPEM = key;
        byte[] encoded = Base64.decodeBase64(privateKeyPEM);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static PublicKey generatePublicKey(String content) throws IOException, GeneralSecurityException {
        String publicKeyPEM = content;
        return getPublicKeyFromString(publicKeyPEM);
    }

    public static PublicKey getPublicKeyFromString(String key) throws IOException, GeneralSecurityException {
        String publicKeyPEM = key;
        byte[] encoded = Base64.decodeBase64(publicKeyPEM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    public static String sign(PrivateKey privateKey, String message)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        Signature sign = Signature.getInstance("SHA1withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes("UTF-8"));
        return new String(Base64.encodeBase64(sign.sign()), "UTF-8");
    }

    public static boolean verify(PublicKey publicKey, String message, String signature)
            throws SignatureException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Signature sign = Signature.getInstance("SHA1withRSA");
        sign.initVerify(publicKey);
        sign.update(message.getBytes("UTF-8"));
        return sign.verify(Base64.decodeBase64(signature.getBytes("UTF-8")));
    }

    public static String encrypt(String rawText, PublicKey publicKey) throws IOException, GeneralSecurityException {
        cipher.init(1, publicKey);
        return Base64.encodeBase64String(cipher.doFinal(rawText.getBytes("UTF-8")));
    }

    public static String decrypt(String cipherText, PrivateKey privateKey) throws IOException, GeneralSecurityException {
        cipher.init(2, privateKey);
        return new String(cipher.doFinal(Base64.decodeBase64(cipherText)), "UTF-8");
    }

    public static String encrypt(String rawText) throws IOException, GeneralSecurityException {
        return encrypt(rawText, generatePublicKey(publicKey));
    }

    public static String decrypt(String cipherText) throws IOException, GeneralSecurityException {
        return decrypt(cipherText, generatePrivateKey(privateKey));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(publicKey);
        // System.out.println("===============publicKey");
        // System.out.println(publicKey.replace("\n", ""));
        // System.out.println("===============encrypt helloworld");
        // long st = System.currentTimeMillis();
        // PublicKey pk = generatePublicKey(publicKey);
        // System.out.println("===============cost time:" + (System.currentTimeMillis() - st));
        // st = System.currentTimeMillis();
        // String encrypt = encrypt("helloworld", pk);
        // System.out.println("===============cost time2:" + (System.currentTimeMillis() - st));
        // System.out.println(encrypt);
        // System.out.println("===============decrypt helloworld");
        // String descrypt = decrypt(encrypt, generatePrivateKey(privateKey));
        // System.out.println(descrypt);
        // System.out.println("===============AES KEY");
        // String aesAfterRSA =
        // "sLpH1jP4kvbGiFRbphjbxpIeLiPSKdT+NKexFUtjO97mMhlb7PrR6/qLkVRelGMRhnAj+D3FZ4zOuEbQy3zZgBBsFtHF1g6ylpryh1w/R3tpuOoSEg/FUVx2ZGEM7DrTbjkhJIsrxV0658WFH5tRFu7koFeQCdcjI2Tmh8ahHx4KB8p6+lM7+ebIL5L5RUIhI1+r7utnpZXvBuw99Zib+Zr9+Xf2fDlZ5hyBLemkW9ETOeE1ILk/8ooiFcfXYgeb7jKEGcQUZLi1VBlFFle/x+lezm7ur9kmLDp3UH/EdYFArecpSqHzPrcaNlSHV5hqsAWE0wuOV74hu7ez/pfkFg==";
        //
        // String plainText = decrypt(aesAfterRSA);
        // System.out.println("aesKey is :" + plainText);

        String encryptStr =
                "1xjRSuj4am0gINtioSNuj90NFAz1RGYiSVdy8hfGZyRrej7NmUQ2xgLo+FPD5ypgTMe8LuLn9bE6OMqU1M0PwjUMqasRwTRyTDAx/AkqCqenLeCMTPNkWyOdjWPHTeKr2C8kffylvy3Ia6MtmHTlC9nIFjehpxPUTvWTIoyJ2nj/cdK5bYwzDTdf+PS9t+Y0L7bkz8G9PYPx3Z4fpfSWgnwHkhlD8BxSxfF/bKQroIecR5ZGqtl4iTvH5D9vxl+qlIwJgBZBaFjIO+mCV/w0Cujy6rfP+dQBQv/vhlf3eVqj5b+aVsWYk/BHXthCvkaakfpVpL7qCkprkW6gRIlpvQ==";
        String descrypt = decrypt(encryptStr, generatePrivateKey(privateKey));
        System.out.println(descrypt);

        String encryptPsw = LoanSHA1Util.encrypt("S000000" + "JSH@123456");
        System.out.println(encryptPsw);
    }
}
