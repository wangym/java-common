package me.yumin.common.asset.result;

import lombok.Getter;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-05
 */
public enum ResultEnum implements IResultEnum {
    SUCCESS(true, false, 200, "请求成功"),
    FAIL_BIZ(false, false, -1, "请求失败,逻辑已运行完整"),
    FAIL_BIZ_BAD_REQUEST(false, false, 400, "请求失败,请检查相关参数"),
    FAIL_BIZ_NOT_FOUND(false, false, 404, "请求失败,未找到依赖资源"),
    FAIL_BIZ_INTERNAL_SERVER_ERROR(false, true, 500, "内部服务器错误,请重试或联系管理员");

    @Getter
    private boolean success = false;
    @Getter
    private boolean retry = false;
    @Getter
    private int code = 0;
    @Getter
    private String msg = null;

    /**
     * @param success 是否成功
     * @param retry   是否重试
     * @param code    结果编号
     * @param msg     提示信息
     */
    ResultEnum(final boolean success, final boolean retry, final int code, final String msg) {
        this.success = success;
        this.retry = retry;
        this.code = code;
        this.msg = msg;
    }
}
