package me.yumin.java.common.util;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-26
 */
public class NumberUtil {
    private NumberUtil() {
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
     * @param string
     * @return
     */
    public static Long parseLong(String string) {
        Long result = null;

        try {
            if (StringUtil.isNotEmpty(string)) {
                result = Long.parseLong(string);
            }
        } catch (NumberFormatException e) {
            Log.error(e);
        }

        return result;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(isGreaterEqual(0, Long.MAX_VALUE, Integer.MAX_VALUE));
    }
}
