package com.fym.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CheckLoginFilter implements Filter{
	private List<String> list ;
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String unCheckURI = arg0.getInitParameter("UnCheckURI");
		list =  Arrays.asList(unCheckURI.split(","));
	}

	@Override
	public void doFilter(ServletRequest requset, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//servletRequest里没有获取请求资源的方法(该方法存在于它的子类中,所以需要进行强转)
		HttpServletRequest req = (HttpServletRequest) requset;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 获取当前客户的发出请求的资源
		String requestURI = req.getRequestURI();
		//判断是否有和不需要过滤的资源相等的资源(取反,就是需要进行检查登录的资源)
		if (!list.contains(requestURI)) {
			// 登录检查过滤器(先获取session对象,再获取session中的数据)
			Object obj = req.getSession().getAttribute("USER_IN_SESSION");
			if (obj == null) {
				resp.sendRedirect("/login.jsp");
				return;
			}
		}
		// 放行(这一步是是必须要做的,但是往往会忽略这个,需要牢记)
		chain.doFilter(req, resp);
	}
	@Override
	public void destroy() {
	}
}
