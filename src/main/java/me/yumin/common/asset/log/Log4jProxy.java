package me.yumin.common.asset.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-04
 */
public final class Log4jProxy implements ILogProxy {
    private final Logger log;

    /**
     * @param name The logger name. If null the name of the calling class will be used.
     */
    public Log4jProxy(final String name) {
        log = LogManager.getLogger(name);
    }

    @Override
    public void error(final String message) {
        error(message, null);
    }

    @Override
    public void error(final Throwable t) {
        error(null, t);
    }

    @Override
    public void error(final String message, final Throwable t) {
        log.error(message, t);
    }

    @Override
    public void warn(final String message) {
        warn(message, null);
    }

    @Override
    public void warn(final Throwable t) {
        warn(null, t);
    }

    @Override
    public void warn(final String message, final Throwable t) {
        log.warn(message, t);
    }

    @Override
    public void info(final String message) {
        info(message, null);
    }

    @Override
    public void info(final Throwable t) {
        info(null, t);
    }

    @Override
    public void info(final String message, final Throwable t) {
        log.info(message, t);
    }

    @Override
    public void debug(final String message) {
        debug(message, null);
    }

    @Override
    public void debug(final Throwable t) {
        debug(null, t);
    }

    @Override
    public void debug(final String message, final Throwable t) {
        log.debug(message, t);
    }
}
