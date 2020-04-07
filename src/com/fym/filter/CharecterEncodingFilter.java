package com.fym.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharecterEncodingFilter implements Filter{
	private String encoding;
	private boolean force;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 encoding = filterConfig.getInitParameter("encoding");//获取初始化参数的值
		 force = Boolean.valueOf(filterConfig.getInitParameter("force"));//注意格式的转换
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
			String characterEncoding = req.getCharacterEncoding();
			//当我们设置了编码的时候,要判断要不要使用我们设置的编码(根据force的值)
			//当之前没有设置编码的时候,就会使用我们设置的编码
			/*if( (hasLengh(encoding)&&force) 
					||hasLengh(encoding)&&characterEncoding==null){
			//设置请求的编码格式
			req.setCharacterEncoding(encoding);//设置为初始化参数
			}*/
			if(hasLengh(encoding)&&(force||characterEncoding==null)){
				req.setCharacterEncoding(encoding);
			}
			//放行操作
			chain.doFilter(req, resp);
	}
	@Override
	public void destroy() {	
	}
	//定义一个方法,判断一个字符串是否为空
	public  boolean hasLengh(String value){
		return value != null && !"".equals(value.trim());
	}
}
