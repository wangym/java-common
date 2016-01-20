package me.yumin.common.model.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-20
 */
public abstract class BaseQuery extends BaseReq {
    private static final long serialVersionUID = -4201534234580885641L;

    @Setter
    @Getter
    private int pageRows = 1; // 每页数

    @Setter
    @Getter
    private int pageNum = 1; // 当前页
}
