package me.yumin.common.util;

import me.yumin.java.common.constant.R;
import java.net.InetAddress;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-28
 */
public final class NetUtil {
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
            R.LOG.error(e);
        }

        return result;
    }
}
