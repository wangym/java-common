package me.yumin.common.helper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-04
 */
public final class Log4jHelper {
    private final Logger LOG;

    /**
     * @param name The name of the logger to retrieve.
     */
    public Log4jHelper(String name) {
        LOG = LogManager.getLogger(name);
    }

    /**
     * @param message the message object to log.
     */
    public void error(String message) {
        error(message, null);
    }

    /**
     * @param t the exception to log, including its stack trace.
     */
    public void error(Throwable t) {
        error(null, t);
    }

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    public void error(String message, Throwable t) {
        LOG.error(message, t);
    }

    /**
     * @param message the message object to log.
     */
    public void warn(String message) {
        warn(message, null);
    }

    /**
     * @param t the exception to log, including its stack trace.
     */
    public void warn(Throwable t) {
        warn(null, t);
    }

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    public void warn(String message, Throwable t) {
        LOG.warn(message, t);
    }

    /**
     * @param message the message object to log.
     */
    public void info(String message) {
        info(message, null);
    }

    /**
     * @param t the exception to log, including its stack trace.
     */
    public void info(Throwable t) {
        info(null, t);
    }

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    public void info(String message, Throwable t) {
        LOG.info(message, t);
    }

    /**
     * @param message the message object to log.
     */
    public void debug(String message) {
        debug(message, null);
    }

    /**
     * @param t the exception to log, including its stack trace.
     */
    public void debug(Throwable t) {
        debug(null, t);
    }

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    public void debug(String message, Throwable t) {
        LOG.debug(message, t);
    }
}
