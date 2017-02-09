package com.swsoft.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swsoft.service.UserService;
import com.swsoft.service.imp.UserServiceImp;


@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//后台管理员登录
		//1,验证
		//2, 通过用户名和密码到数据库里面查找
		/*SELECT 
		COUNT(1) 
		FROM USER AS u 
		JOIN userauth AS ua ON u.id=ua.userid
		JOIN authority AS r ON ua.authid = r.id 
		WHERE r.auth ='superadmin' AND u.name=? AND PASSWORD=?*/
		
		 UserService us = new UserServiceImp();
		 List<Map<String, Object>> listMap = us.selectAll();
		 request.setAttribute("userInfo", listMap);
			
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/admin/center.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
