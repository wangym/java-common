package me.yumin.common.domain.domainobject;

import lombok.Getter;
import java.io.Serializable;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-09
 */
public final class PageDO implements Serializable {
    private static final long serialVersionUID = 2710973307675225562L;

    @Getter
    private long totalRows; // 总的行数
    @Getter
    private int pageRows; // 每页行数
    @Getter
    private int pageNum; // 每页行数
    @Getter
    private long totalPage = 0L; // 总的页数
    @Getter
    private boolean hasNext = true; // 有无下页

    /**
     *
     */
    private PageDO() {
    }

    /**
     * @param totalRows
     * @param pageRows
     * @param pageNum
     */
    public PageDO(long totalRows, int pageRows, int pageNum) {
        this.totalRows = totalRows;
        this.pageRows = pageRows;
        this.pageNum = pageNum;

        // 动态值计算
        setTotalPage();
        setHasNext();
    }

    /**
     * 总的页数
     *
     * @return
     */
    private void setTotalPage() {
        if (0 < totalRows && 0 < pageRows) {
            this.totalPage = (totalRows + pageRows - 1) / pageRows;
        }
    }

    /**
     * 有无下页
     *
     * @return
     */
    private void setHasNext() {
        if (pageNum >= totalPage) {
            this.hasNext = false;
        }
    }
}
