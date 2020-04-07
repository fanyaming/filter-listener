package com.fym.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by lenovo on 2020/4/7.
 */
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter1...after...");
    }

    @Override
    public void destroy() {

    }
}
