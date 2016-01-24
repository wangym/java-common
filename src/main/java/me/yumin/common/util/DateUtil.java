package me.yumin.common.util;

import java.util.Date;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-02
 */
public final class DateUtil {
    private DateUtil() {
    }

    /**
     * @return 秒级时间戳
     */
    public static long getTimestamp() {
        return new Date().getTime() / 1000;
    }
}
