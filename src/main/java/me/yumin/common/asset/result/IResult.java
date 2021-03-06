package me.yumin.common.asset.result;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-05
 */
public interface IResult {
    /**
     * @return 是否成功
     */
    boolean isSuccess();

    /**
     * @return 需要重试
     */
    boolean isRetry();

    /**
     * @return 返回代码
     */
    int getCode();

    /**
     * @return 返回提示
     */
    String getMsg();
}
