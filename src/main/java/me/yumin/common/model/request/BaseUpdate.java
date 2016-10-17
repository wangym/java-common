package me.yumin.common.model.request;

import lombok.Getter;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-31
 */
public abstract class BaseUpdate extends BaseReq {
    private static final long serialVersionUID = -4201534234580885641L;

    @Getter
    private Integer rowVersion; // 行版本号

    /**
     * @param rowVersion 行版本号
     */
    public void setRowVersion(Integer rowVersion) {
        if (null == rowVersion || 0 >= rowVersion) {
            throw new IllegalArgumentException("Parameters `rowVersion` is required");
        }

        this.rowVersion = rowVersion;
    }
}
