package me.yumin.java.common.util;

/**
 * 有关<code>Object</code>处理的工具类。
 * <p/>
 * <p>
 * 这个类中的每个方法都可以“安全”地处理<code>null</code>，而不会抛出<code>NullPointerException</code>。
 * </p>
 *
 * @author Michael Zhou, #redactor chinawym@gmail.com
 * @version $Id: ObjectUtil.java 509 2004-02-16 05:42:07Z baobao $
 */
public final class ObjectUtil {
    private ObjectUtil() {
    }

    /**
     * 如果对象为<code>null</code>，则返回指定默认对象，否则返回对象本身。
     * <pre>
     * ObjectUtil.defaultIfNull(null, null)      = null
     * ObjectUtil.defaultIfNull(null, "")        = ""
     * ObjectUtil.defaultIfNull(null, "zz")      = "zz"
     * ObjectUtil.defaultIfNull("abc", *)        = "abc"
     * ObjectUtil.defaultIfNull(Boolean.TRUE, *) = Boolean.TRUE
     * </pre>
     *
     * @param object       要测试的对象
     * @param defaultValue 默认值
     * @return 对象本身或默认对象
     */
    public static Object defaultIfNull(Object object, Object defaultValue) {
        return (object != null) ? object : defaultValue;
    }
}
