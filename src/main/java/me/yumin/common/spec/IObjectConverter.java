package me.yumin.common.spec;

import java.util.List;

/**
 * Type Conversion
 *
 * @author chinawym@gmail.com
 * @since 2016-01-16
 */
public interface IObjectConverter<S, T> {
    /**
     * 类型转换(单个)
     *
     * @param source 源始类型
     * @return 目标类型
     */
    T convertForward(S source);

    /**
     * 类型转换(批量)
     *
     * @param sources 源始类型
     * @return 目标类型
     */
    List<T> convertForward(List<S> sources);

    /**
     * 类型转换(单个)
     *
     * @param source 源始类型
     * @return 目标类型
     */
    S convertReverse(T source);

    /**
     * 类型转换(批量)
     *
     * @param sources 源始类型
     * @return 目标类型
     */
    List<S> convertReverse(List<T> sources);
}
