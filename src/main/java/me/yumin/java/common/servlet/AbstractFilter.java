/**
 * 
 */
package me.yumin.java.common.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import me.yumin.java.common.util.StringUtil;

/**
 * 所有filter的基类。
 *
 * @author Michael Zhou
 * @version $Id: AbstractFilter.java 1038 2004-06-04 07:02:54Z baobao $
 */
public abstract class AbstractFilter implements Filter {
    protected final Log log          = LogFactory.getLog(getClass());
    private FilterConfig   filterConfig;
    private boolean        eatException;

    /**
     * 初始化filter。
     *
     * @param filterConfig filter的配置信息
     *
     * @throws ServletException 如果初始化失败
     */
    public final void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig     = filterConfig;

        this.eatException = Boolean.valueOf(findInitParameter("eatException", "true")).booleanValue();

        if (eatException) {
            log.info("Set eating ServletException to " + eatException);
        }

        init();
    }

    /**
     * 初始化filter。
     *
     * @throws ServletException 如果初始化失败
     */
    public void init() throws ServletException {
    }

    /**
     * 清除filter.
     */
    public void destroy() {
        filterConfig = null;
    }

    /**
     * 取得filter的配置信息。
     *
     * @return <code>FilterConfig</code>对象
     */
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    /**
     * 取得servlet容器的上下文信息。
     *
     * @return <code>ServletContext</code>对象
     */
    public ServletContext getServletContext() {
        return getFilterConfig().getServletContext();
    }

    /**
     * 查找指定的filter初始化参数，按如下顺序：
     * 
     * <ol>
     * <li>
     * 查找filter自身的<code>init-param</code>
     * </li>
     * <li>
     * 查找web应用全局的<code>init-param</code>
     * </li>
     * <li>
     * 使用指定默认值。
     * </li>
     * </ol>
     * 
     *
     * @param paramName 初始化参数名
     * @param defaultValue 默认值
     *
     * @return 指定名称所对应的初始化参数值，如果未定义或参数值为空，则返回<code>null</code>。
     */
    public String findInitParameter(String paramName, String defaultValue) {
        // 取filter参数
        String value = trimToNull(getFilterConfig().getInitParameter(paramName));

        // 如果未取到，则取全局参数
        if (value == null) {
            value = trimToNull(getServletContext().getInitParameter(paramName));
        }

        // 如果未取到，则取默认值
        if (value == null) {
            value = defaultValue;
        }

        return value;
    }

    /**
     * 执行filter.
     *
     * @param request HTTP请求
     * @param response HTTP响应
     * @param chain filter链
     *
     * @throws IOException 处理filter链时发生输入输出错误
     * @throws ServletException 处理filter链时发生的一般错误
     */
    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 对于重入的filter，不消化exception。
        // 在weblogic中，servlet forward到jsp时，jsp仍会调用此filter，而jsp抛出的异常就会被该filter捕获。
        if (!(request instanceof HttpServletRequest && response instanceof HttpServletResponse)
                    || (request.getAttribute(getClass().getName()) != null)) {
            chain.doFilter(request, response);

            return;
        }

        // 防止重入.
        request.setAttribute(getClass().getName(), Boolean.TRUE);

        try {
            // 执行子类的doFilter
            HttpServletRequest  req = (HttpServletRequest) request;

            HttpServletResponse res = (HttpServletResponse) response;

            doFilter(req, res, chain);
        } catch (ServletException e) {
            if (eatException) {
                log.error("Failed to execute the filter chain", e);
            } else {
                throw e;
            }
        }
    }

    /**
     * 执行filter.
     *
     * @param request HTTP请求
     * @param response HTTP响应
     * @param chain filter链
     *
     * @throws IOException 处理filter链时发生输入输出错误
     * @throws ServletException 处理filter链时发生的一般错误
     */
    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain) throws IOException, ServletException;

    /**
     * 将字符串trim，如果字符串为空白，则返回<code>null</code>。
     *
     * @param str 输入字符串
     *
     * @return 输出字符串，如果输入字符串为空白，则返回<code>null</code>
     */
    protected String trimToNull(String str) {
        if (str != null) {
            str = str.trim();

            if (str.length() == 0) {
                str = null;
            }
        }

        return str;
    }

    /**
     * 取得request的内容(HTTP方法, URI)
     *
     * @param request HTTP请求
     *
     * @return 字符串
     */
    protected String dumpRequest(HttpServletRequest request) {
        StringBuffer buffer = new StringBuffer(request.getMethod());

        buffer.append(" ").append(request.getRequestURI());

        String queryString = StringUtil.trimToNull(request.getQueryString());

        if (queryString != null) {
            buffer.append("?").append(queryString);
        }

        return buffer.toString();
    }
}
