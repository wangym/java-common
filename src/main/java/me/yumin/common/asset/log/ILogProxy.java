package me.yumin.common.asset.log;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-16
 */
public interface ILogProxy {
    /**
     * @param message the message object to log.
     */
    void error(String message);

    /**
     * @param t the exception to log, including its stack trace.
     */
    void error(Throwable t);

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    void error(String message, Throwable t);

    /**
     * @param message the message object to log.
     */
    void warn(String message);

    /**
     * @param t the exception to log, including its stack trace.
     */
    void warn(Throwable t);

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    void warn(String message, Throwable t);

    /**
     * @param message the message object to log.
     */
    void info(String message);

    /**
     * @param t the exception to log, including its stack trace.
     */
    void info(Throwable t);

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    void info(String message, Throwable t);

    /**
     * @param message the message object to log.
     */
    void debug(String message);

    /**
     * @param t the exception to log, including its stack trace.
     */
    void debug(Throwable t);

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    void debug(String message, Throwable t);
}
