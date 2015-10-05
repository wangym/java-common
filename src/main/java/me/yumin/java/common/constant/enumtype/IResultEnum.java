package me.yumin.java.common.constant.enumtype;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-05
 */
public interface IResultEnum {
    /**
     * @return
     */
    boolean isSuccess();

    /**
     * @return
     */
    boolean isRetry();

    /**
     * @return
     */
    int getCode();

    /**
     * @return
     */
    String getMsg();
}
