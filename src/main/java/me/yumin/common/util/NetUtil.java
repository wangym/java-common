package me.yumin.common.util;

import me.yumin.common.R;

import java.net.InetAddress;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-28
 */
public final class NetUtil {
    private NetUtil() {
    }

    /**
     * @return hostAddress
     */
    public static String getHostAddress() {
        String result = null;

        try {
            InetAddress addr = InetAddress.getLocalHost();
            result = addr.getHostAddress();
        } catch (Exception e) {
            R.LOG.error(e);
        }

        return result;
    }

    /**
     * @return localHost
     */
    public static String getLocalHost() {
        String result = null;

        try {
            InetAddress addr = InetAddress.getLocalHost();
            result = addr.getHostName();
        } catch (Exception e) {
            R.LOG.error(e);
        }

        return result;
    }
}
