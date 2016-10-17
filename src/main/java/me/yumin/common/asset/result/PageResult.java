package me.yumin.common.asset.result;

import lombok.Getter;
import me.yumin.common.util.StringUtil;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-09
 */
public final class PageResult<T extends Collection> implements Serializable {
    private static final long serialVersionUID = 2710973307675225562L;

    @Getter
    private int pageNum = 0; // 当前页码

    @Getter
    private int pageRows = 0; // 每页数量

    @Getter
    private int totalPage = 0; // 总的页数

    @Getter
    private int totalRows = 0; // 总的行数

    private boolean hasNext = false; // 有否下页

    @Getter
    private boolean success = true;

    @Getter
    private int code = 200;

    @Getter
    private String msg = "OK"; // 提示信息

    @Getter
    protected T data = null; // 结果集合

    /**
     *
     */
    public PageResult() {
    }

    /**
     * @param pageNum   当前页
     * @param pageRows  每页数
     * @param totalRows 总行数
     */
    public PageResult(final int pageNum, final int pageRows, final int totalRows) {
        this.pageNum = pageNum;
        this.pageRows = pageRows;
        this.totalRows = totalRows;

        // 动态值计算
        init();
    }

    /**
     * 是否有数据
     *
     * @return true=有 || false=无
     */
    public boolean hasData() {
        boolean result = false;

        if (0 < totalRows) {
            if (null != data && 0 < data.size()) {
                result = true;
            }
        }

        return result;
    }

    /**
     * 是否有下页
     *
     * @return true=有 || false=无
     */
    public boolean hasNext() {
        return hasNext;
    }

    /**
     * @param code code
     * @return this
     */
    public PageResult<T> setCode(final int code) {
        this.code = code;
        this.success = (200 == code);

        return this;
    }

    /**
     * @param data T
     * @return this
     */
    public PageResult<T> setData(final T data) {
        if (null != data) {
            this.data = data;
        }

        return this;
    }

    /**
     * @param e Exception
     * @return this
     */
    public PageResult<T> setException(final Exception e) {
        if (null != e) {
            setCode(500).setMsg(e.getMessage());
        }

        return this;
    }

    /**
     * @param msg msg
     * @return this
     */
    public PageResult<T> setMsg(final String msg) {
        if (StringUtil.isNotEmpty(msg)) {
            this.msg = msg;
        }

        return this;
    }

    /**
     * ========================================
     * private methods
     * ========================================
     */

    /**
     *
     */
    private void init() {
        if (0 < totalRows && 0 < pageRows) {
            this.totalPage = (totalRows + pageRows - 1) / pageRows;
        }

        this.hasNext = pageNum < totalPage;
    }

    public static void main(String[] args) {
        PageResult pageResult = new PageResult(100, 1, 10);
        System.out.println(pageResult.toString());
    }
}
