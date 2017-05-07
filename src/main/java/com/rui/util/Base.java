package com.rui.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by Administrator on 2017/3/2.
 */
public class Base {
    public static String encryptBASE(byte[] key) throws Exception {
        System.out.println("Base加密前:"+key);
        String value = (new BASE64Encoder()).encodeBuffer(key).replaceAll("[\\s*\t\n\r]", "");
        System.out.println("Base加密后:"+value);
        return value;
    }

    public static byte[] decryptBASE(String key) throws Exception {
        System.out.println("Base解密前:"+key);
        byte[] value = (new BASE64Decoder()).decodeBuffer(key);
        System.out.println("Base解密后:"+value);
        return value;
    }
}
