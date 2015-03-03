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
     *
     * @param object
     * @param name
     * @return
     * @throws NoSuchFieldException
     */
    public static Object getField(Object object, String name) throws NoSuchFieldException {
        if (object == null) {
            throw new IllegalArgumentException("Invalid null object argument");
        } else {
            Class cls = object.getClass();

            while (cls != null) {
                try {
                    Field field = cls.getDeclaredField(name);
                    field.setAccessible(true);
                    return field.get(object);
                } catch (Exception e) {
                    cls = cls.getSuperclass();
                }
            }

            throw new NoSuchFieldException("Could get value for field " + object.getClass().getName() + "." + name);
        }
    }

    /**
     *
     * @param cls
     * @param name
     * @return
     * @throws NoSuchFieldException
     */
    public static Object getField(Class cls, String name) throws NoSuchFieldException {
        if (cls == null) {
            throw new IllegalArgumentException("Invalid null cls argument");
        } else {
            Class base = cls;

            while (base != null) {
                try {
                    Field field = base.getDeclaredField(name);
                    field.setAccessible(true);
                    return field.get(base);
                } catch (Exception e) {
                    base = base.getSuperclass();
                }
            }

            throw new NoSuchFieldException("Could get value for static field " + cls.getName() + "." + name);
        }
    }

    /**
     * 
     * @param object
     * @param name
     * @param value
     * @throws NoSuchFieldException
     */
    public static void setField(Object object, String name, Object value) throws NoSuchFieldException {
        if (object == null) {
            throw new IllegalArgumentException("Invalid null object argument");
        } else {
            Class cls = object.getClass();

            while (cls != null) {
                try {
                    Field ex = cls.getDeclaredField(name);
                    ex.setAccessible(true);
                    ex.set(object, value);
                    return;
                } catch (Exception e) {
                    cls = cls.getSuperclass();
                }
            }

            throw new NoSuchFieldException("Could set value for field " + object.getClass().getName() + "." + name);
        }
    }

    public static void setField(Class cls, String name, Object value) throws NoSuchFieldException {
        if (cls == null) {
            throw new IllegalArgumentException("Invalid null cls argument");
        } else {
            Class base = cls;

            while (base != null) {
                try {
                    Field ex = base.getDeclaredField(name);
                    ex.setAccessible(true);
                    ex.set(base, value);
                    return;
                } catch (Exception var5) {
                    base = base.getSuperclass();
                }
            }

            throw new NoSuchFieldException("Could set value for static field " + cls.getName() + "." + name);
        }
    }

    public static Object invoke(Object object, String name, Class[] parameterTypes, Object[] args) throws Throwable {
        if (object == null) {
            throw new IllegalArgumentException("Invalid null object argument");
        } else {
            Class cls = object.getClass();

            while (cls != null) {
                try {
                    Method e = cls.getDeclaredMethod(name, parameterTypes);
                    e.setAccessible(true);
                    return e.invoke(object, args);
                } catch (InvocationTargetException var7) {
                    throw var7.getTargetException();
                } catch (Exception var8) {
                    cls = cls.getSuperclass();
                }
            }

            throw new NoSuchMethodException("Failed method invocation: " + object.getClass().getName() + "." + name + "()");
        }
    }

    public static Object invoke(Class cls, String name, Class[] parameterTypes, Object[] args) throws Throwable {
        if (cls == null) {
            throw new IllegalArgumentException("Invalid null cls argument");
        } else {
            Class base = cls;

            while (base != null) {
                try {
                    Method e = base.getDeclaredMethod(name, parameterTypes);
                    e.setAccessible(true);
                    return e.invoke(base, args);
                } catch (InvocationTargetException var7) {
                    throw (Exception) var7.getTargetException();
                } catch (Exception var8) {
                    base = base.getSuperclass();
                }
            }

            throw new NoSuchMethodException("Failed static method invocation: " + cls.getName() + "." + name + "()");
        }
    }
}
