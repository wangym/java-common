package me.yumin.common.util.algorithm;

import me.yumin.common.util.algorithm.exception.StackEmptyException;
import me.yumin.common.util.algorithm.exception.StackFullException;
import me.yumin.common.util.algorithm.impl.DefaultStack;

/**
 * @author java-fries.com, #redactor yumin
 * @since 2015-02-28 16:17
 */
public class DefaultStackMain {
    /**
     * @param args Args
     */
    public static void main(String[] args) {
        DefaultStack<Integer> stack = new DefaultStack<Integer>(4);
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
    private static void popElements(DefaultStack<Integer> stack) {
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    /**
     * @param stack Stack
     */
    private static void pushOnStackUntillStackIsFull(DefaultStack<Integer> stack) {
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(9);
        stack.push(2);
    }

    /**
     * @param stack Stack
     */
    private static void checkStackEmpty(DefaultStack<Integer> stack) {
        System.out.println("Is stack empty : " + stack.isEmpty());
    }
}
