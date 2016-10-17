package me.yumin.common.model.request;

import lombok.Getter;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-20
 */
public abstract class BaseQuery extends BaseReq {
    private static final long serialVersionUID = -4201534234580885641L;

    public static final int PAGE_SIZE_UPPER_LIMIT = 200;

    @Getter
    private int pageNum = 1; // 当前页

    @Getter
    private int pageRows = 1; // 每页数

    /**
     * @param pageNum 当前页
     */
    public void setPageNum(int pageNum) {
        if (0 >= pageNum) {
            pageNum = 1;
        }

        this.pageNum = pageNum;
    }

    /**
     * @param pageRows 每页数
     */
    public void setPageRows(int pageRows) {
        if (0 >= pageRows) {
            pageRows = 1;
        }
        if (pageRows > PAGE_SIZE_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format("Parameter `pageRows` is over the limit, it must <= %s !", PAGE_SIZE_UPPER_LIMIT));
        }

        this.pageRows = pageRows;
    }
}
