package me.yumin.common.util;

import java.util.*;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-25
 */
public final class CollectionUtil {
    private CollectionUtil() {
    }

    /**
     * 整型字符串转整型列表集
     *
     * @param strings example:1,2,3
     * @return list
     */
    public static List<Integer> fromIntegerString(final String strings) {
        List<Integer> result = new ArrayList<Integer>();

        if (StringUtil.isNotEmpty(strings)) {
            List<String> list = Arrays.asList(strings.split(","));
            if (isNotEmpty(list)) {
                for (String string : list) {
                    Integer integer = NumberUtil.parseInt(string);
                    if (null != integer) {
                        result.add(integer);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 整型字符串转长整型列表集
     *
     * @param strings 1,2,3
     * @return list
     */
    public static List<Long> fromLongString(String strings) {
        List<Long> result = new ArrayList<Long>();

        if (StringUtil.isNotEmpty(strings)) {
            List<String> list = Arrays.asList(strings.split(","));
            if (isNotEmpty(list)) {
                for (String string : list) {
                    Long value = NumberUtil.parseLong(string);
                    if (null != value) {
                        result.add(value);
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param args
     * @return
     */
    public static boolean isEmpty(final Collection... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Collection collection : args) {
                if (null == collection || 0 == collection.size()) {
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
    public static boolean isEmpty(final Map... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Map map : args) {
                if (null == map || 0 == map.size()) {
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
    public static boolean isNotEmpty(final Collection... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Collection collection : args) {
                if (null != collection && 0 < collection.size()) {
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
    public static boolean isNotEmpty(final Map... args) {
        boolean result = false;

        if (null != args && 0 < args.length) {
            int counter = 0;
            for (Map map : args) {
                if (null != map && 0 < map.size()) {
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
}
