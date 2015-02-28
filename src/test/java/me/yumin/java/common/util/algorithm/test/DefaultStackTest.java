package me.yumin.java.common.util.algorithm.test;

import me.yumin.java.common.util.algorithm.exception.StackEmptyException;
import me.yumin.java.common.util.algorithm.exception.StackFullException;
import me.yumin.java.common.util.algorithm.impl.DefaultIStack;

/**
 * @author java-fries.com, #redactor yumin
 * @since 2015-02-28 16:17
 */
public class DefaultStackTest {

    /**
     * @param args Args
     */
    public static void main(String[] args) {
        DefaultIStack<Integer> stack = new DefaultIStack<Integer>(4);
        checkStackEmpty(stack);
        try {
            pushOnStackUntillStackIsFull(stack);
        } catch (StackFullException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Stack content: ");
        stack.dump();
        System.out.println("Popping out: ");
        try {
            popElements(stack);
        } catch (StackEmptyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param stack Stack
     */
    private static void popElements(DefaultIStack<Integer> stack) {
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    /**
     * @param stack Stack
     */
    private static void pushOnStackUntillStackIsFull(DefaultIStack<Integer> stack) {
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(9);
        stack.push(2);
    }

    /**
     * @param stack Stack
     */
    private static void checkStackEmpty(DefaultIStack<Integer> stack) {
        System.out.println("Is stack empty : " + stack.isEmpty());
    }
}
