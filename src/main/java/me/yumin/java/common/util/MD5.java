package me.yumin.java.common.util;

import me.yumin.java.common.constant.R;
import java.security.MessageDigest;

/**
 * @author chinawym@gmail.com
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
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                if (null != md5) {
                    result = byte2hex(md5.digest(data.getBytes(charset)));
                }
            } catch (Exception e) {
                R.LOG.error(e);
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
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(bytes[i] & 0xFF);
                if (null != hex && 1 == hex.length()) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hex.toUpperCase());
            }
            result = stringBuffer.toString();
        }

        return result;
    }
}
