package me.yumin.java.common.util;

import java.security.MessageDigest;

/**
 * @author xuanyin
 * @since 2015-07-09
 */
public class MD5 {
    private MD5() {
    }

    /**
     * @param data
     * @param charset
     * @return
     */
    public static String encode(String data, String charset) {
        String result = null;

        if (StringUtil.isNotEmpty(data, charset)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                if (null != messageDigest) {
                    result = byte2hex(messageDigest.digest(data.getBytes(charset)));
                }
            } catch (Exception e) {
                Log.error(e);
            }
        }

        return result;
    }

    /**
     * @param bytes
     * @return
     */
    private static String byte2hex(byte[] bytes) {
        String result = null;

        if (null != bytes && 0 < bytes.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(bytes[i] & 0xFF);
                if (null != hex && 1 == hex.length()) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(hex.toUpperCase());
            }
            result = stringBuilder.toString();
        }

        return result;
    }
}
