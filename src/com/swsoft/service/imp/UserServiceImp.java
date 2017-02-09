package com.swsoft.service.imp;

import java.util.List;
import java.util.Map;

import com.swsoft.dao.UserMapper;
import com.swsoft.service.UserService;

public class UserServiceImp implements UserService{
		public int insert(Map<String, Object> map){
			System.out.println("service");
			UserMapper dbmanage = new UserMapper();
			return dbmanage.insert(map);
		}
		
		//查询用户是否存在
		public int select(Map<String, Object> map){
			UserMapper dbmanage = new UserMapper();
			return dbmanage.select(map);
		}
		
		public List<Map<String, Object>> selectAll(){
			UserMapper dbmanage = new UserMapper();
			return dbmanage.selectAll();
		}
		
		public List<Map<String,Object>> selectById(String id){
			UserMapper dbmanage = new UserMapper();
			return dbmanage.selectById(id);
		}
		
		public List<Map<String,Object>> selectByTime(Map<String,Object> map){
			UserMapper dbmanage = new UserMapper();
			return dbmanage.selectByTime(map);
		}
}
