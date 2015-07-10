package me.yumin.java.common.util;

import java.util.Date;

/**
 * @author xuanyin
 * @since 2015-07-02
 */
public class DateUtil {
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
