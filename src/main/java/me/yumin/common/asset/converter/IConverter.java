package me.yumin.common.asset.converter;

/**
 * Type Conversion
 *
 * @author chinawym@gmail.com
 * @since 2016-01-16
 */
public interface IConverter<S, T> {
    /**
     * 类型转换
     *
     * @param source 源始类型
     * @return 目标类型
     */
    T convert(final S source);
}
