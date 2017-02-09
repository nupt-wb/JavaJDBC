package com.swsoft.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swsoft.service.UserService;
import com.swsoft.service.imp.UserServiceImp;

@WebServlet("/userregister")
public class UserInsertController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
	
		String password = request.getParameter("password");
		
		request.setAttribute("isUserExist", 0);
		
		//对参数name, password进行验证 ...
		System.out.println(name);
		System.out.println(password);
		//对参数进行组合
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("password", password);
		
		UserService us = new UserServiceImp();
		//用户是否存在?
		if(us.select(map)>0){
			try{
				request.setAttribute("isUserExist", "1");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/user/login.jsp");
				rd.forward(request, response);
			}catch(Exception ex){
				
			}
		}else{
			//传参数，注册用户
			
			
			//如果有插入的用户在数据库中已经存在，这个时候直接返回，让用户取其他名字? 
			
			int ret = us.insert(map);
			System.out.println("controller ret" +ret);
			//对是否注册成功进行处理
			try{
				if(ret>0){
					//注册成功
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/user/center.jsp");
					rd.forward(request, response);
				}else{
					//注册不成功
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/user/login.jsp");
					rd.forward(request, response);
				}
			}catch(Exception ex){
				
			}
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
		doGet(request, response);
	}
}
