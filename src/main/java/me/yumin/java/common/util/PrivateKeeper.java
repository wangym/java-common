package me.yumin.java.common.util;

import java.lang.reflect.Field;

/**
 * @author yumin
 * @since 2015-03-02 14:52
 */
public class PrivateKeeper {

    private PrivateKeeper() {
    }

    /**
     * @param object    Java object
     * @param fieldName 类私有属性名
     * @return 属性值
     */
    private static Object getDeclaredField(Object object, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Object value = null;

        if (null != object) {
            Class cls = object.getClass();
            Field field = cls.getDeclaredField(fieldName);
            field.setAccessible(true);
            value = field.get(object);
        }

        return value;
    }

    /**
     * @param object    Java object
     * @param fieldName 类私有属性名
     * @return 属性值
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Object getFieldValue(Object object, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        return getDeclaredField(object, fieldName);
    }
}
