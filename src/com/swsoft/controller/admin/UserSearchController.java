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

@WebServlet("/search")
public class UserSearchController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    String name = request.getParameter("name");
	    String startDate = request.getParameter("startDate");
	    String endDate = request.getParameter("endDate");
	    
	    
	    //到数据库查询数据 select * from user where submitDate>=? and submitDate<=? name like ?"
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("name", name);
	    map.put("startDate", startDate);
	    map.put("endDate", endDate);
	    
	    UserService us = new UserServiceImp();
	    List<Map<String, Object>>  listMap = us.selectByTime(map);
	    request.setAttribute("userInfo", listMap);
	    request.setAttribute("name", name);
	    request.setAttribute("startDate", startDate);
	    request.setAttribute("endDate", endDate);
	    
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/admin/usersearch.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
