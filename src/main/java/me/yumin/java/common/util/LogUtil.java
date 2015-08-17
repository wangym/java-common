package me.yumin.java.common.util;

import org.apache.commons.logging.LogFactory;

/**
 * 日志工具类
 * 对日志输出进行优化
 *
 * @author chinawym@gmail.com
 * @since 2014-05-05
 */
public class LogUtil {
    // log for class
    private static final org.apache.commons.logging.Log LOG = LogFactory.getLog(LogUtil.class);

    private LogUtil() {
    }

    /**
     * @param message
     */
    public static void error(String message) {
        error(message, null);
    }

    /**
     * @param t
     */
    public static void error(Throwable t) {
        error(null, t);
    }

    /**
     * @param message
     * @param t
     */
    public static void error(String message, Throwable t) {
        LOG.error(message, t);
    }

    /**
     * @param message
     */
    public static void warn(String message) {
        warn(message, null);
    }

    /**
     * @param t
     */
    public static void warn(Throwable t) {
        warn(null, t);
    }

    /**
     * @param message
     * @param t
     */
    public static void warn(String message, Throwable t) {
        LOG.warn(message, t);
    }

    /**
     * @param message
     */
    public static void info(String message) {
        info(message, null);
    }

    /**
     * @param t
     */
    public static void info(Throwable t) {
        info(null, t);
    }

    /**
     * @param message
     * @param t
     */
    public static void info(String message, Throwable t) {
        LOG.info(message, t);
    }

    /**
     * @param message
     */
    public static void debug(String message) {
        debug(message, null);
    }

    /**
     * @param t
     */
    public static void debug(Throwable t) {
        debug(null, t);
    }

    /**
     * @param message
     * @param t
     */
    public static void debug(String message, Throwable t) {
        LOG.debug(message, t);
    }
}
