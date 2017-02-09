package com.swsoft.controller;

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

@WebServlet("/selectall")
public class UserSelectController  extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    UserService us = new UserServiceImp();
	    List<Map<String, Object>> listMap = us.selectAll();
		request.setAttribute("userInfo", listMap);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/user/userselect.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}