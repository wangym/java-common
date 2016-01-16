package me.yumin.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-11
 */
public final class JsonUtil {
    /**
     * 判断能否互转
     *
     * @param object
     * @param clazz
     * @return
     */
    public static boolean isMutualConversion(final Object object, final Class clazz) {
        boolean result = false;

        if (null != object && null != clazz) {
            String json = toJSONString(object);
            if (StringUtil.isNotEmpty(json)) {
                if (null != JSON.parseObject(json, clazz)) {
                    result = true;
                }
            }
        }

        return result;
    }

    /**
     * @param json
     * @return
     */
    public static final JSONObject parseObject(final String json) {
        return JSON.parseObject(json);
    }

    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static final <T> T parseObject(final String json, final Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * @param object
     * @return
     */
    public static final String toJSONString(final Object object) {
        return JSON.toJSONString(object);
    }
}
