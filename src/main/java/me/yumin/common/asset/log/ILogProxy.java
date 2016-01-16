package me.yumin.common.asset.log;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-16
 */
public interface ILogProxy {
    /**
     * @param message the message object to log.
     */
    void error(final String message);

    /**
     * @param t the exception to log, including its stack trace.
     */
    void error(final Throwable t);

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    void error(final String message, final Throwable t);

    /**
     * @param message the message object to log.
     */
    void warn(final String message);

    /**
     * @param t the exception to log, including its stack trace.
     */
    void warn(final Throwable t);

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    void warn(final String message, final Throwable t);

    /**
     * @param message the message object to log.
     */
    void info(final String message);

    /**
     * @param t the exception to log, including its stack trace.
     */
    void info(final Throwable t);

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    void info(final String message, final Throwable t);

    /**
     * @param message the message object to log.
     */
    void debug(final String message);

    /**
     * @param t the exception to log, including its stack trace.
     */
    void debug(final Throwable t);

    /**
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     */
    void debug(final String message, final Throwable t);
}
