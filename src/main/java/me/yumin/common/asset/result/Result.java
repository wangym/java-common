package me.yumin.common.asset.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.yumin.common.util.StringUtil;

import java.io.Serializable;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-05
 */
@ToString
public final class Result<T> implements IResult, Serializable {
    private static final long serialVersionUID = 4484904915776383226L;

    @Setter
    @Getter
    protected boolean success = false;

    @Getter
    protected boolean retry = false;

    @Getter
    protected int code = 0;

    @Getter
    protected String msg = null;

    @Getter
    protected T data = null;

    @Getter
    protected Object extend = null;

    /**
     *
     */
    public Result() {
    }

    /**
     * @param data T
     */
    public Result(final T data) {
        setData(data);
    }

    /**
     * @param fromResult result
     * @param <?>        f
     * @param <T>        t
     * @return see {@link Result}
     */
    public static <T> Result<T> createResult(Result<?> fromResult) {
        Result result = new Result();

        result.success = fromResult.success;
        result.retry = fromResult.retry;
        result.code = fromResult.code;
        result.msg = fromResult.msg;
        result.extend = fromResult.extend;

        return result;
    }

    /**
     * 是否失败
     *
     * @return true=失败 || false=成功
     */
    public boolean isFail() {
        return !isSuccess();
    }

    /**
     * @param msg 结果说明
     * @return this
     */
    public Result<T> setMsgAppend(final String msg) {
        if (StringUtil.isNotEmpty(msg)) {
            this.msg += msg;
        }

        return this;
    }

    /**
     * @param data T
     * @return this
     */
    public Result<T> setData(final T data) {
        if (null != data) {
            this.data = data;
        }

        return this;
    }

    /**
     * @param e Exception
     * @return this
     */
    public Result<T> setException(final Exception e) {
        if (null != e) {
            String msg = e.getMessage();
            if (e instanceof IllegalArgumentException) {
                setTips(Tips.FAIL_BIZ_BAD_REQUEST).setMsg(msg);
            } else {
                setTips(Tips.FAIL_BIZ_INTERNAL_SERVER_ERROR).setMsg(msg);
            }
        }

        return this;
    }

    /**
     * @param extend Object
     * @return this
     */
    public Result<T> setExtend(Object extend) {
        if (null != extend) {
            this.extend = extend;
        }

        return this;
    }

    /**
     * @param msg 结果说明
     * @return this
     */
    public Result<T> setMsg(final String msg) {
        if (StringUtil.isNotEmpty(msg)) {
            this.msg = msg;
        }

        return this;
    }

    /**
     * @param tips 提示对象
     * @param <R>  结果实例
     * @return this
     */
    public <R extends IResult> Result<T> setTips(final R tips) {
        if (null != tips) {
            this.success = tips.isSuccess();
            this.retry = tips.isRetry();
            this.code = tips.getCode();
            this.msg = tips.getMsg();
        }

        return this;
    }
}