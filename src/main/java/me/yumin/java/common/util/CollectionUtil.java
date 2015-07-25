package me.yumin.java.common.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-25
 */
public class CollectionUtil {
    private CollectionUtil() {
    }

    /**
     * @param args
     * @return
     */
    public static boolean isEmpty(Collection... args) {
        return (!isNotEmpty(args));
    }

    /**
     * @param args
     * @return
     */
    public static boolean isNotEmpty(Collection... args) {
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
    public static boolean isEmpty(Map... args) {
        return (!isNotEmpty(args));
    }

    /**
     * @param args
     * @return
     */
    public static boolean isNotEmpty(Map... args) {
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
