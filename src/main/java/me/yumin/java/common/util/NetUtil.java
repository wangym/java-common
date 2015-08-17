package me.yumin.java.common.util;

import java.net.InetAddress;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-28
 */
public class NetUtil {
    private NetUtil() {
    }

    /**
     * @return
     */
    public static String getHostName() {
        String result = null;

        try {
            InetAddress addr = InetAddress.getLocalHost();
            result = addr.getHostName();
        } catch (Exception e) {
            LogUtil.error(e);
        }

        return result;
    }
}
