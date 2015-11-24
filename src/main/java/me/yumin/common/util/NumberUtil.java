package me.yumin.common.util;

import me.yumin.common.constant.R;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-26
 */
public final class NumberUtil {
    private NumberUtil() {
    }

    /**
     * @param args
     * @return
     */
    public static boolean isEmpty(Number... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Number number : args) {
                if (null == number) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == args.length) {
                result = true;
            }
        }

        return result;
    }

    /**
     * @param args
     * @return
     */
    public static boolean isNotEmpty(Number... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Number number : args) {
                if (null != number) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == args.length) {
                result = true;
            }
        }

        return result;
    }

    /**
     * @param value
     * @param args
     * @return
     */
    public static boolean isGreaterEqual(int value, Number... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Number arg : args) {
                if (null != arg && value <= arg.longValue()) { // 支持int和long
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == args.length) {
                result = true;
            }
        }

        return result;
    }

    /**
     * String转Double
     *
     * @param string 字符串型数值
     * @return Double
     */
    public static Double parseDouble(String string) {
        Double result = null;

        try {
            if (StringUtil.isNotEmpty(string)) {
                result = Double.parseDouble(string);
            }
        } catch (NumberFormatException e) {
            R.LOG.error(e);
        }

        return result;
    }

    /**
     * String转Long
     *
     * @param string 字符串型数值
     * @return Long
     */
    public static Long parseLong(String string) {
        Long result = null;

        try {
            if (StringUtil.isNotEmpty(string)) {
                result = Long.parseLong(string);
            }
        } catch (NumberFormatException e) {
            R.LOG.error(e);
        }

        return result;
    }

    /**
     * 保留小数点后位(原生不舍不入)
     *
     * @param number
     * @param scale
     * @return
     */
    public static String scale(Number number, int scale) {
        String result = null;

        if (null != number && 0 < scale) {
            result = String.valueOf(number);
            if (StringUtil.isNotEmpty(result)) {
                int index = result.indexOf(".");
                int length = result.length();
                int endIndex = index + scale + 1;
                if (0 <= index && length >= endIndex) {
                    result = result.substring(0, endIndex);
                }
            }
        }

        return result;
    }
}
