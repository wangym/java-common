package me.yumin.common.util.algorithm.exception;

/**
 * @author java-fries.com, #redactor chinawym@gmail.com
 * @since 2015-02-28 16:00
 */
public final class StackFullException extends RuntimeException {
    /**
     *
     */
    public StackFullException() {
        super("[StackFullException]Stack is full.");
    }

    /**
     * @param message Exception message
     */
    public StackFullException(final String message) {
        super(message);
    }
}
