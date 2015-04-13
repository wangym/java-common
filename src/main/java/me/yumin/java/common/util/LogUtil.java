package me.yumin.java.common.util;

import org.apache.commons.logging.Log;
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
    private static final Log LOG = LogFactory.getLog(LogUtil.class);

    private LogUtil() {
    }

    /**
     * @param t throwable
     */
    public static void error(Throwable t) {
        LOG.error(t);
    }

    /**
     * @param message make any content
     * @param t       throwable
     */
    public static void error(Object message, Throwable t) {
        LOG.error(message, t);
    }
}
