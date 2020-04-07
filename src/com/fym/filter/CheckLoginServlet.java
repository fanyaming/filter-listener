package com.fym.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class CheckLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取请求参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//这里是直接写死的,实际应用中应该是与数据库中的数据作比较
		if("admin".equals(username)&&"123".equals(password)){
			//将用户信息添加到session中
			req.getSession().setAttribute("USER_IN_SESSION", username);
		}
		//跳转到welcome.jsp页面中
		req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
		
	}
}
