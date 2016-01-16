package me.yumin.common.util;

import me.yumin.common.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author chinawym@gmail.com
 * @since 2015-03-02
 */
public final class ReflectUtil {
    private ReflectUtil() {
    }

    /**
     * Getting field value
     *
     * @param object    Java object
     * @param fieldName 类私有属性名
     * @return 属性值
     */
    @Deprecated
    public static Object getFieldValue(final Object object, final String fieldName) {
        Object fieldValue = null;

        try {
            Field field = getDeclaredField(object, fieldName);
            fieldValue = field.get(object);
        } catch (NoSuchFieldException e) {
            R.LOG.error(e);
        } catch (IllegalAccessException e) {
            R.LOG.error(e);
        }

        return fieldValue;
    }

    /**
     * Setting field value
     *
     * @param object     Java object
     * @param fieldName  类私有属性名
     * @param fieldValue 属性值
     * @return true|false
     */
    public static boolean setFieldValue(final Object object, final String fieldName, final Object fieldValue) {
        boolean result = false;

        try {
            Field field = getDeclaredField(object, fieldName);
            field.set(object, fieldValue);
            result = true;
        } catch (NoSuchFieldException e) {
            R.LOG.error(e);
        } catch (IllegalAccessException e) {
            R.LOG.error(e);
        }

        return result;
    }

    /**
     * Invoking method
     *
     * @param object         Java object
     * @param methodName     方法名称
     * @param parameterTypes 入参类型
     * @param args           入参对象
     * @return 执行结果对象
     */
    public static Object invokeMethod(final Object object, final String methodName, final Class[] parameterTypes, final Object[] args) {
        Object result = null;

        try {
            Method method = getDeclaredMethod(object, methodName, parameterTypes);
            result = method.invoke(object, args);
        } catch (NoSuchMethodException e) {
            R.LOG.error(e);
        } catch (IllegalAccessException e) {
            R.LOG.error(e);
        } catch (InvocationTargetException e) {
            R.LOG.error(e);
        }

        return result;
    }

    /**
     * Invoking method plus
     *
     * @param object     Java object
     * @param methodName 方法名称
     * @param args       入参对象
     * @return 执行结果对象
     */
    public static Object invokeMethodPlus(final Object object, final String methodName, final Object... args) {
        Object result = null;

        if (null != args) {
            int length = args.length;
            Class[] types = new Class[length];
            Object[] values = new Object[length];
            for (int i = 0; i < length; i++) {
                types[i] = args[i].getClass();
                values[i] = args[i];
                // 原始类型修补
                Field[] fields = types[i].getFields();
                for (Field field : fields) {
                    if ("TYPE".equalsIgnoreCase(field.getName())) {
                        try {
                            types[i] = (Class) field.get(null);
                        } catch (IllegalAccessException e) {
                            R.LOG.error(e);
                        }
                    }
                }

            }
            result = invokeMethod(object, methodName, types, values);
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
    private static Field getDeclaredField(final Object object, final String fieldName) throws NoSuchFieldException {
        Field field = null;

        if (null != object && (null != fieldName && 0 < fieldName.length())) {
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
    private static Method getDeclaredMethod(final Object object, final String methodName, final Class[] parameterTypes) throws NoSuchMethodException {
        Method method = null;

        if (null != object && (null != methodName && 0 < methodName.length())) {
            method = object.getClass().getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
        }

        return method;
    }
}
