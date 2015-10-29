package me.yumin.java.common.util;

/**
 * @author chinawym@gmail.com
 * @since 2015-06-16
 */
public final class Assert {
    private Assert() {
    }

    /**
     * @param objects
     */
    public static void notNull(Object... objects) {
        for (Object object : objects) {
            notNull(object, null);
        }
    }

    /**
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        assertTrue(null != object, message);
    }

    /**
     * @param condition
     */
    public static void assertTrue(boolean condition) {
        assertTrue(condition, null);
    }

    /**
     * @param condition
     * @param message
     */
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            exception(message);
        }
    }

    /**
     * @param message
     */
    private static void exception(String message) {
        throw new IllegalArgumentException(message);
    }
}
