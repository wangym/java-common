package me.yumin.common.util.algorithm.exception;

/**
 * @author java-fries.com, #redactor chinawym@gmail.com
 * @since 2015-02-28 16:00
 */
public final class StackEmptyException extends RuntimeException {
    /**
     *
     */
    public StackEmptyException() {
        super("[StackEmptyException]Stack is Empty.");
    }

    /**
     * @param message Exception message
     */
    public StackEmptyException(String message) {
        super(message);
    }
}
