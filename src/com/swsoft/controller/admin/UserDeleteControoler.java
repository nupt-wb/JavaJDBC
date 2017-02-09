package com.swsoft.controller.admin;

import java.io.IOException;
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

@WebServlet("/delete")
public class UserDeleteControoler  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    String id = request.getParameter("id");
	    
	    //到数据库查询数据 delete from user where id=?"
	    
	    //获取数据 select * from user

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/admin/center.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
