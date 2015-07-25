package me.yumin.java.common.util;

import java.util.Collection;

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
            for (Collection string : args) {
                if (null != string && 0 < string.size()) {
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
