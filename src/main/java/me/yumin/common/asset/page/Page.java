package me.yumin.common.asset.page;

import lombok.Getter;
import java.io.Serializable;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-09
 */
public final class Page implements Serializable {
    private static final long serialVersionUID = 2710973307675225562L;

    @Getter
    private long totalRows; // 总行数
    @Getter
    private int pageRows; // 每页数
    @Getter
    private int pageNum; // 当前页
    @Getter
    private long totalPage; // 总页数
    @Getter
    private boolean hasNext = true; // 下页否

    /**
     *
     */
    private Page() {
    }

    /**
     * @param totalRows 总行数
     * @param pageRows  每页数
     * @param pageNum   当前页
     */
    public Page(final long totalRows, final int pageRows, final int pageNum) {
        this.totalRows = totalRows;
        this.pageRows = pageRows;
        this.pageNum = pageNum;

        // 动态值计算
        setTotalPage();
        setHasNext();
    }

    /**
     *
     */
    private void setTotalPage() {
        if (0 < totalRows && 0 < pageRows) {
            this.totalPage = (totalRows + pageRows - 1) / pageRows;
        }
    }

    /**
     *
     */
    private void setHasNext() {
        if (pageNum >= totalPage) {
            this.hasNext = false;
        }
    }
}
