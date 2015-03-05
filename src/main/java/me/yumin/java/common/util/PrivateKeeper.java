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
    public static Object getFieldValue(Object object, String fieldName) {
        Object fieldValue = null;

        if (null != object) {
            try {
                Field field = getDeclaredField(object, fieldName);
                fieldValue = field.get(object);
            } catch (NoSuchFieldException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ey) {
                ey.printStackTrace();
            }
        }

        return fieldValue;
    }

    /**
     * @param object     Java object
     * @param fieldName  类私有属性名
     * @param fieldValue 属性值
     * @return boolean true|false
     */
    public static boolean setFieldValue(Object object, String fieldName, Object fieldValue) {
        boolean result = false;

        if (null != object) {
            try {
                Field field = getDeclaredField(object, fieldName);
                field.set(fieldName, fieldValue);
                result = true;
            } catch (NoSuchFieldException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ey) {
                ey.printStackTrace();
            }
        }

        return result;
    }

    /**
     * @param object    Java object
     * @param fieldName 类私有属性名
     * @return Field object
     * @throws NoSuchFieldException
     */
    private static Field getDeclaredField(Object object, String fieldName) throws NoSuchFieldException {
        Field field = null;

        if (null != object) {
            field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
        }

        return field;
    }
}
