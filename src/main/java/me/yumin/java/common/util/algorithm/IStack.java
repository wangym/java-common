package me.yumin.java.common.util.algorithm;

import me.yumin.java.common.util.algorithm.exception.StackEmptyException;

/**
 * @author java-fries.com, #redactor yumin
 * @since 2015-02-28 15:50
 */
public interface IStack<T> {

    /**
     * @param item Push item
     */
    public void push(T item);

    /**
     * @return T
     * @throws StackEmptyException
     */
    public T pop() throws StackEmptyException;

    /**
     * @return T
     * @throws StackEmptyException
     */
    public T top() throws StackEmptyException;

    /**
     * @return int
     */
    public int size();

    /**
     * @return boolean
     */
    public boolean isEmpty();

    /**
     *
     */
    public void dump();
}
