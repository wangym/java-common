package me.yumin.common.util;

/**
 * @author chinawym@gmail.com
 * @since 2015-06-16
 */
public final class Assert {
    private Assert() {
    }

    /**
     * @param condition
     */
    public static void assertTrue(final boolean condition) {
        assertTrue(condition, null);
    }

    /**
     * @param condition
     * @param message
     */
    public static void assertTrue(final boolean condition, final String message) {
        if (!condition) {
            exception(message);
        }
    }

    /**
     * @param objects
     */
    public static void notNull(final Object... objects) {
        for (Object object : objects) {
            notNull(object, null);
        }
    }

    /**
     * @param object
     * @param message
     */
    public static void notNull(final Object object, final String message) {
        assertTrue(null != object, message);
    }

    /**
     * @param message
     */
    private static void exception(final String message) {
        throw new IllegalArgumentException(message);
    }
}
