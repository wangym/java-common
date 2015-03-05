package me.yumin.java.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yumin
 * @since 2015-03-02 14:52
 */
public class PrivateKeeper {

    private PrivateKeeper() {
    }

    /**
     * Getting field values
     *
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
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return fieldValue;
    }

    /**
     * Setting field values
     *
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
                field.set(object, fieldValue);
                result = true;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Invoking methods
     *
     * @param object         Java object
     * @param methodName     方法名称
     * @param parameterTypes 入参类型
     * @param args           入参对象
     * @return Object 执行结果
     */
    public static Object invokeMethod(Object object, String methodName, Class[] parameterTypes, Object[] args) {
        Object result = null;

        if (null != object) {
            try {
                Method method = getDeclaredMethod(object, methodName, parameterTypes);
                result = method.invoke(object, args);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        return result;
    }

    /**
     * Getting field object
     *
     * @param object    Java object
     * @param fieldName 类私有属性名
     * @return Field object
     * @throws NoSuchFieldException
     */
    public static Field getDeclaredField(Object object, String fieldName) throws NoSuchFieldException {
        Field field = null;

        if (null != object) {
            field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
        }

        return field;
    }

    /**
     * Getting method object
     *
     * @param object         Java object
     * @param methodName     方法名称
     * @param parameterTypes 入参类型
     * @return Method object
     * @throws NoSuchMethodException
     */
    public static Method getDeclaredMethod(Object object, String methodName, Class[] parameterTypes) throws NoSuchMethodException {
        Method method = null;

        if (null != object) {
            method = object.getClass().getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
        }

        return method;
    }
}
