package me.yumin.java.common.util;

import org.apache.commons.logging.Log;

/**
 * 日志工具类
 * 对日志输出进行优化
 *
 * @author yumin
 * @since 2014-05-05
 */
public class LogUtil {

    private LogUtil() {
    }

    /**
     * @param log
     * @param message
     * @param t
     */
    public static void error(Log log, Object message, Throwable t) {
        log.error(message, t);
    }
}
