package me.yumin.common.spec;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-31
 */
public interface IPropertyConverter<T> {
    /**
     * @return T
     */
    T convert();
}
