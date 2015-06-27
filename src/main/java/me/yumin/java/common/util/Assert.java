package me.yumin.java.common.util;

/**
 * @author xuanyin
 * @since 2015-06-16
 */
public abstract class Assert {
    protected Assert() {
    }

    /**
     * @param object
     */
    public static void notNull(Object object) {
        assertTrue(null != object);
    }

    /**
     * @param condition
     */
    public static void assertTrue(boolean condition) {
        if (!condition) {
            exception(null);
        }
    }

    /**
     * @param message
     */
    public static void exception(String message) {
        throw new IllegalArgumentException(message);
    }
}
