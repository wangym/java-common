package me.yumin.common.asset.result;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-09
 */
public final class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 2710973307675225562L;

    @Getter
    private long totalRows = 0; // 总行数

    @Getter
    private int pageNum = 0; // 当前页

    @Getter
    private int pageRows = 0; // 每页数

    @Getter
    private long totalPage = 0; // 总页数

    @Getter
    private boolean hasNext = true; // 下页否

    @Getter
    @Setter
    protected T data = null;

    /**
     *
     */
    private PageResult() {
    }

    /**
     * @param totalRows 总行数
     * @param pageRows  每页数
     * @param pageNum   当前页
     */
    public PageResult(final long totalRows, final int pageNum, final int pageRows) {
        this.totalRows = totalRows;
        this.pageNum = pageNum;
        this.pageRows = pageRows;

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
