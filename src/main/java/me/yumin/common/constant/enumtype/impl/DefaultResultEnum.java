package me.yumin.common.constant.enumtype.impl;

import lombok.Getter;
import me.yumin.common.constant.enumtype.IResultEnum;

/**
 * @author chinawym@gmail.com
 * @since 2015-10-05
 */
public enum DefaultResultEnum implements IResultEnum {
    SUCCESS(true, false, 200, "请求成功"),
    FAIL_BIZ_BAD_REQUEST(false, false, 400, "请求错误,请检查入参"),
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
     * @param success
     * @param retry
     * @param code
     * @param msg
     */
    DefaultResultEnum(boolean success, boolean retry, int code, String msg) {
        this.success = success;
        this.retry = retry;
        this.code = code;
        this.msg = msg;
    }

    /**
     * @param code
     * @return
     */
    public static DefaultResultEnum getEnum(int code) {
        DefaultResultEnum result = null;

        for (DefaultResultEnum defaultResultEnum : DefaultResultEnum.values()) {
            if (defaultResultEnum.getCode() == code) {
                result = defaultResultEnum;
                break;
            }
        }

        return result;
    }
}
