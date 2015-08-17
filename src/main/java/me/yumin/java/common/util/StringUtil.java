package me.yumin.java.common.util;

/**
 * 有关字符串处理的工具类。
 * <p/>
 * <p>
 * 这个类中的每个方法都可以“安全”地处理<code>null</code>，而不会抛出<code>NullPointerException</code>。
 * </p>
 *
 * @author Michael Zhou, #redactor chinawym@gmail.com
 * @version $Id: StringUtil.java 1149 2004-08-10 02:01:41Z baobao $
 */
public class StringUtil {
    private StringUtil() {
    }

    /**
     * @param args
     * @return
     */
    public static boolean isEmpty(String... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (String string : args) {
                if (null == string || 0 == string.length()) {
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
    public static boolean isNotEmpty(String... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (String string : args) {
                if (null != string && 0 < string.length()) {
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
     * @param json
     * @return
     */
    public static boolean isJSONArray(String json) {
        return isJSON(json, "[", "]");
    }

    /**
     * @param json
     * @return
     */
    public static boolean isJSONObject(String json) {
        return isJSON(json, "{", "}");
    }

    /**
     * @param json
     * @param startsWith
     * @param endsWith
     * @return
     */
    private static boolean isJSON(String json, String startsWith, String endsWith) {
        boolean result = false;

        if (isNotEmpty(json)) {
            if (json.startsWith(startsWith) && json.endsWith(endsWith)) {
                result = true;
            }
        }

        return result;
    }
}
