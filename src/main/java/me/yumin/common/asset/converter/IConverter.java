package me.yumin.common.asset.converter;

import java.util.List;

/**
 * Type Conversion
 *
 * @author chinawym@gmail.com
 * @since 2016-01-16
 */
public interface IConverter<S, T> {
    /**
     * 类型转换(单个)
     *
     * @param source 源始类型
     * @return 目标类型
     */
    T convert(final S source);

    /**
     * 类型转换(批量)
     *
     * @param sources 源始类型
     * @return 目标类型
     */
    List<T> convert(final List<S> sources);
}
