package com.example.yyzx_demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 描述：MD5加密.
 */
public class Md5Utils {

    /**
     * 描述：MD5加密.
     *
     * @param str 要加密的字符串
     * @return String 加密的字符串
     */
    public static String MD5(String str) {
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        byte[] strTemp = str.getBytes();
        MessageDigest mdTemp;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        mdTemp.update(strTemp);
        byte tmp[] = mdTemp.digest(); // MD5 的计算结果是一个 128 位的长整数，
        char outputChars[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
        int k = 0;
        for (int i = 0; i < 16; i++) {
            byte byte0 = tmp[i];
            outputChars[k++] = hexDigits[byte0 >>> 4 & 0xf];
            outputChars[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(outputChars).toUpperCase();
    }
}
