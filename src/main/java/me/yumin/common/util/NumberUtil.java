package me.yumin.common.util;

import me.yumin.common.R;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-26
 */
public final class NumberUtil {
    private NumberUtil() {
    }

    /**
     * 若value为null则返回defaultValue
     *
     * @param value        校验值
     * @param defaultValue 默认值
     * @return 最终值
     */
    public static Integer defaultIfNull(Integer value, Integer defaultValue) {
        Integer result = value;

        if (NumberUtil.isNull(value)) {
            result = defaultValue;
        }

        return result;
    }

    /**
     * @param args
     * @return
     */
    public static boolean isEmpty(final Number... args) {
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
     * 等于
     *
     * @param value long 待比较值
     * @param args  Number 被比较值
     * @return true=全部等于 || false=至少一项不等于
     */
    public static boolean isEqual(final long value, final Number... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Number arg : args) {
                if (null != arg && value == arg.longValue()) { // 支持int和long
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
     * 等于
     *
     * @param hello Number 待比较值
     * @param world Number 被比较值
     * @return true=等于 || false=不等于(类型不匹配也返回false)
     */
    public static boolean isEqualNumber(final Number hello, final Number world) {
        boolean result = false;

        if (null != hello && null != world) {
            if (hello.equals(world)) {
                result = true;
            }
        }

        return result;
    }

    /**
     * 大于
     *
     * @param value long 待比较值
     * @param args  Number 被比较值
     * @return true=全部大于 || false=至少一项不大于
     */
    public static boolean isGreater(final long value, final Number... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Number arg : args) {
                if (null != arg && value < arg.longValue()) { // 支持int和long
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
    public static boolean isGreaterEqual(final long value, final Number... args) {
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
     * @param value
     * @param args
     * @return
     */
    public static boolean isLessEqual(final long value, final Number... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Number arg : args) {
                if (null != arg && value >= arg.longValue()) { // 支持int和long
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
    public static boolean isNotEmpty(final Number... args) {
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
     * 是否不为空
     *
     * @param args Number 被判断值
     * @return true=是不为空 || false=否
     */
    public static boolean isNotNull(final Number... args) {
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
     * 是否为空
     *
     * @param args Number 被判断值
     * @return true=是为空 || false=否
     */
    public static boolean isNull(final Number... args) {
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
     * long型转int(若转失败则使用int默认值)
     *
     * @param value      long值
     * @param defaultInt int默认值
     * @return 转换结果
     */
    public static int longToInt(final Long value, final int defaultInt) {
        int result = defaultInt;

        if (null != value) {
            result = value.intValue();
        }

        return result;
    }

    /**
     * 若arg等于value则返回null反之返回实际数值
     *
     * @param value 待比较值
     * @param arg   被比较值
     * @return null或arg
     */
    public static Long nullIfEqual(final long value, final Long arg) {
        Long result = arg;

        if (isEqual(value, arg)) {
            result = null;
        }

        return result;
    }

    /**
     * String转Double
     *
     * @param string 字符串型数值
     * @return Double
     */
    public static Double parseDouble(final String string) {
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
     * String转Int
     *
     * @param string 字符串型数值
     * @return Long
     */
    public static Integer parseInt(final String string) {
        Integer result = null;

        try {
            if (StringUtil.isNotEmpty(string)) {
                result = Integer.parseInt(string);
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
    public static Long parseLong(final String string) {
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
    public static String scale(final Number number, final int scale) {
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
