/**
 *
 */
package me.yumin.java.common.util;

import org.apache.commons.logging.Log;

/**
 * @author yumin
 */
public class LogUtil {

    /**
     * @param log
     * @param message
     * @param t
     */
    public static void error(Log log, Object message, Throwable t) {
        log.error(message, t);
    }
}
