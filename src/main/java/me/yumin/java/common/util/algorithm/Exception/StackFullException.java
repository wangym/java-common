package me.yumin.java.common.util.algorithm.exception;

/**
 * @author java-fries.com, #redactor yumin
 * @since 2015-02-28 16:00
 */
public class StackFullException extends RuntimeException {

    /**
     *
     */
    public StackFullException() {
        super("[StackFullException]Stack is full.");
    }

    /**
     * @param message Exception message
     */
    public StackFullException(String message) {
        super(message);
    }
}
