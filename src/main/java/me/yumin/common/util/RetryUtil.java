package me.yumin.common.util;

/**
 * @author chinawym@gmail.com
 * @since 2016-10-13
 */
public final class RetryUtil {
    private RetryUtil() {
    }

    /**
     * @param retry
     * @param times
     * @return
     */
    public static boolean execute(final IRetry retry, final int times) {
        int i = getTimes(times);

        do {
            try {
                if (retry.execute(i)) {
                    return true;
                }
            } catch (Exception e) {
                if (1 == i) { // 首次就有异常没必要再重试
                    throw new RuntimeException(e);
                }
            }
        } while (0 < --i);

        return false;
    }

    /**
     * @param times
     * @return
     */
    private static int getTimes(final int times) {
        return times;
    }

    /**
     *
     */
    public interface IRetry {
        boolean execute(final int times);
    }
}
