package me.yumin.java.common.util;

import java.util.Date;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-02
 */
public final class DateUtil {
    private DateUtil() {
    }

    /**
     * @return
     */
    public static long getTimestamp() {
        long timestamp = new Date().getTime() / 1000;

        return timestamp;
    }
}
