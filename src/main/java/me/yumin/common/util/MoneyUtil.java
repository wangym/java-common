package me.yumin.common.util;

import java.math.BigDecimal;

/**
 * @author chinawym@gmail.com
 * @since 2016-03-13
 */
public final class MoneyUtil {
    private MoneyUtil() {
    }

    /**
     * 将分转元
     *
     * @param cent 分
     * @return 元
     */
    public static BigDecimal toYuan(final Long cent) {
        BigDecimal result = null;

        if (null != cent) {
            result = new BigDecimal(cent).movePointLeft(2);
        }

        return result;
    }
}
