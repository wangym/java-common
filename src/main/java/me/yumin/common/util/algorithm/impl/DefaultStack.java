package me.yumin.common.util.algorithm.impl;

import me.yumin.common.util.algorithm.exception.StackEmptyException;
import me.yumin.common.util.algorithm.exception.StackFullException;
import me.yumin.common.util.algorithm.IStack;

/**
 * @author java-fries.com, #redactor chinawym@gmail.com
 * @since 2015-02-28 15:55
 */
public final class DefaultStack<T> implements IStack<T> {
    private Object[] elements;
    private final static int DEFAULT_CAPACITY = 16;
    private int capacity;
    private int top = -1;

    /**
     * @param capacity Stack capacity
     */
    public DefaultStack(final int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    /**
     *
     */
    public DefaultStack() {
        this.capacity = DEFAULT_CAPACITY;
    }

    @Override
    public void push(final T item) {
        if (capacity == size()) {
            throw new StackFullException();
        }
        elements[++top] = item;
    }

    @Override
    public T pop() throws StackEmptyException {
        if (-1 == top) {
            throw new StackEmptyException();
        }
        T element = (T) elements[top];
        elements[top--] = null;

        return element;
    }

    @Override
    public T top() throws StackEmptyException {
        if (-1 == top) {
            throw new StackEmptyException();
        }

        return (T) elements[top];
    }

    @Override
    public int size() {
        return 1 + top;
    }

    @Override
    public boolean isEmpty() {
        return -1 == top;
    }

    @Override
    public void dump() {
        for (int i = 0; i < size(); i++) {
            System.out.println(elements[i]);
        }
    }
}
