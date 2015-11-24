package me.yumin.common.util.algorithm;

import me.yumin.common.util.algorithm.exception.StackEmptyException;

/**
 * @author java-fries.com, #redactor yumin
 * @since 2015-02-28 15:50
 */
public interface IStack<T> {
    /**
     * @param item Push item
     */
    void push(T item);

    /**
     * @return T
     * @throws StackEmptyException
     */
    T pop() throws StackEmptyException;

    /**
     * @return T
     * @throws StackEmptyException
     */
    T top() throws StackEmptyException;

    /**
     * @return int
     */
    int size();

    /**
     * @return boolean
     */
    boolean isEmpty();

    /**
     *
     */
    void dump();
}
