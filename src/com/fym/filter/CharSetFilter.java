package com.fym.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by lenovo on 2020/4/7.
 */
@WebFilter(filterName = "CharSetFilter", urlPatterns = "/*",//通配符（*）表示对所有的web资源进行拦截
        initParams = {
                @WebInitParam(name = "charset", value = "utf-8")//这里可以放一些初始化的参数,例如设置编码
        })
public class CharSetFilter implements Filter {
    private String filterName;
    private String charset;

    // 销毁时调用
    public void destroy() {
        System.out.println(filterName + "销毁");
    }

    //过滤方法(真正做事的方法) 主要是对request和response进行一些处理，然后交给下一个过滤器或Servlet处理
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(filterName + "doFilter()");
        //doFilter()之前是,对请求的过滤
        req.setCharacterEncoding(charset);
        chain.doFilter(req, resp);//放行操作,交给下一个过滤器或者是servlet处理
        //doFilter()之后是,对响应的过滤
        resp.setCharacterEncoding(charset);
    }

    //初始化方法  接收一个FilterConfig类型的参数 该参数是对Filter的一些配置
    public void init(FilterConfig config) throws ServletException {
        filterName = config.getFilterName();
        charset = config.getInitParameter("charset");
        System.out.println("过滤器名称：" + filterName);
        System.out.println("字符集编码：" + charset);
    }
}
