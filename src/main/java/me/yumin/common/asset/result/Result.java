package me.yumin.common.asset.result;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-05
 */
public final class Result<T> implements Serializable {
    private static final long serialVersionUID = 4484904915776383226L;

    @Getter
    protected boolean success = false;
    @Getter
    protected boolean retry = false;
    @Getter
    protected int code = 0;
    @Getter
    protected String msg = null;
    @Getter
    @Setter
    protected T data = null;

    /**
     * @param resultEnum
     * @param <R>
     * @return
     */
    public <R extends IResultEnum> Result<T> setResult(final R resultEnum) {
        if (null != resultEnum) {
            this.success = resultEnum.isSuccess();
            this.retry = resultEnum.isRetry();
            this.code = resultEnum.getCode();
            this.msg = resultEnum.getMsg();
        }

        return this;
    }
}
