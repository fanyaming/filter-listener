package com.fym.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/encoding")
public class encodingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");设置请求的编码格式
		String username = req.getParameter("username");
		System.out.println(username);//èäºæ(这里打印出来的就是乱码,因为这里没有设置请求的编码格式)
	}

}
