package com.swsoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapper {
	private String url = "jdbc:mysql://localhost:3306/test";
	private String user = "root";
	private String password = "Oracle123";
	
	public List<Map<String,Object>> selectByTime(Map<String,Object> map){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		
		try{
			//加载
			Class.forName("com.mysql.jdbc.Driver");
			//连接
			conn = DriverManager.getConnection(url,user, password);
			if(conn != null){
				//sql语句
				String s =  map.get("startDate").toString();
				String e =  map.get("endDate").toString();
				String n =  map.get("name").toString();
				String sql = "select * from user where 1=1 ";
				int flag = 0;
				if(s.trim().length()>0){
					sql += " and submitDate >= ? ";
				}
				if(e.trim().length()>0){
					sql += " and submitDate <=? ";
				}
				if(n.trim().length()>0){
					sql += " and name like ? ";
				}
				//String sql = "select * from user where submitDate>=? and submitDate<=? and name like ?";
				ps = conn.prepareStatement(sql);
				if(s.trim().length()>0){
					flag++;
					ps.setString(flag, s);
				}
				if(e.trim().length()>0){
					flag++;
					ps.setString(flag, e);
				}
				if(n.trim().length()>0){
					flag++;
					ps.setString(flag, "%"+n+"%"); //会自动添加单引号: http://www.bubuko.com/infodetail-692506.html
				}
			    //执行查询
				rs = ps.executeQuery();
			
				while(rs.next()){
				    Map<String, Object> tmpMap = new HashMap<String, Object>();
				    tmpMap.put("id", rs.getString("id"));
				    tmpMap.put("name", rs.getString("name"));
				    tmpMap.put("password", rs.getString("password"));
					listMap.add(tmpMap);
				}
			}
		}catch(Exception ex){
		
		}finally{
			try {
				//对象必须不为null,才可以调用任何的函数，不然就会报错
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listMap;
	}
	
	
	public List<Map<String,Object>> selectById(String id){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		
		try{
			//加载
			Class.forName("com.mysql.jdbc.Driver");
			//连接
			conn = DriverManager.getConnection(url,user, password);
			if(conn != null){
				//sql语句
				String sql = "select * from user where id=?";
				ps = conn.prepareStatement(sql);		
				ps.setInt(1, Integer.parseInt(id));
			    //执行查询
				rs = ps.executeQuery();
			
				while(rs.next()){
				    Map<String, Object> tmpMap = new HashMap<String, Object>();
				    tmpMap.put("id", rs.getString("id"));
				    tmpMap.put("name", rs.getString("name"));
				    tmpMap.put("password", rs.getString("password"));
					listMap.add(tmpMap);
				}
			}
		}catch(Exception ex){
		
		}finally{
			try {
				//对象必须不为null,才可以调用任何的函数，不然就会报错
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listMap;
	}
	
	public List<Map<String,Object>> selectAll(){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		
		try{
			//加载
			Class.forName("com.mysql.jdbc.Driver");
			//连接
			conn = DriverManager.getConnection(url,user, password);
			if(conn != null){
				//sql语句
				String sql = "select * from user";
				ps = conn.prepareStatement(sql);				
			    //执行查询
				rs = ps.executeQuery();
			
				while(rs.next()){
				    Map<String, Object> tmpMap = new HashMap<String, Object>();
				    tmpMap.put("id", rs.getString("id"));
				    tmpMap.put("name", rs.getString("name"));
				    tmpMap.put("password", rs.getString("password"));
					listMap.add(tmpMap);
				}
			}
		}catch(Exception ex){
		
		}finally{
			try {
				//对象必须不为null,才可以调用任何的函数，不然就会报错
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listMap;
	}
	//函数: 查看是否有该用户
	public int select(Map<String, Object> map){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		int ret = 1;
		System.out.println("select name:"+map.get("name").toString());
		try{
			//加载
			Class.forName("com.mysql.jdbc.Driver");
			//连接
			conn = DriverManager.getConnection(url,user, password);
			if(conn != null){
				//sql语句
				String sql = "select count(1) as num from user where name=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, map.get("name").toString());
			    //执行查询
				rs = ps.executeQuery();
				System.out.println("select run===========");
				while(rs.next()){
					System.out.println("resultset "+rs.getString("num"));
					ret = Integer.parseInt(rs.getString("num"));
				}
			}
		}catch(Exception ex){
			ret = 1;
		}finally{
			try {
				//对象必须不为null,才可以调用任何的函数，不然就会报错
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("result: "+ret);
		return ret;
	}
	
	public int delete(Map<String, Object> map){
		int ret = 0;
		try{
			//加载
			Class.forName("com.mysql.jdbc.Driver");
			//连接
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn != null){
				//sql
				String sql = "delete from user where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(map.get("id").toString()));
				
		    	//执行
			   ret = ps.executeUpdate();
			   
			   //释放资源
			   ps.close();
			   conn.close();
			}
		}catch(Exception ex){
			ret = 0;
		}
		return ret;
	}
	
	
	
	public int update(Map<String, Object> map){
		int ret = 0;
		
		try{
			//加载
			Class.forName("com.mysql.jdbc.Driver");
			//连接
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn != null){
				//sql语句
				String sql = "update user set password=? where name=? and password=?";
				
				//sql语句赋值
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, map.get("newpassword").toString());
				ps.setString(2, map.get("name").toString());
				ps.setString(3, map.get("oldpassword").toString());
				
				//执行
				ret = ps.executeUpdate();
				ps.close();
				conn.close();
			}
			
		}catch(Exception ex){
			
		}
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int insert(Map<String, Object> map){
		System.out.println("dao");
		int ret = 0 ;
		try{
			//1,加载
			Class.forName("com.mysql.jdbc.Driver");
			//2,连接
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn != null){
				//3,拼接sql;
				String sql = "insert into user(name,password,submitDate) values(?,?,now())";
				
				//4,给sql语句变量赋值
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, map.get("name").toString());
				ps.setString(2, map.get("password").toString());
				
				//5,执行
				ret = ps.executeUpdate();
				System.out.println("dao run ok");
			}
		}catch(Exception ex){
			//异常,ret返回0，表示数据插入到数据库不成功
			ret = 0;
			System.out.println("dao exception");
		}
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int insert(String name, int age) {
		int ret = 0;
		try{
			//初始化參數
			String url = "jdbc:mysql://localhost:3306/test";
			//String oracleUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			String username = "root";
			String password = "Oracle123";
			
			//加載Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//連接數據庫
			Connection conn = DriverManager.getConnection(url, username, password);
			if (conn != null) {
				//sql語句
				String sql = "insert into user(name,age,submitDate) value(?,?,now())";
				//對sql語句進行預處理,檢查他的安全性
				PreparedStatement ps = conn.prepareStatement(sql);
				//ps.setInt(1, getUserCount()+1);
				ps.setString(1, name);
				ps.setInt(2, age);
				
				//執行，sql語句發送到數據庫那邊執行，然後返回結果
				ret = ps.executeUpdate();
				
				//釋放資源
				ps.close();
				conn.close();
				
			} else {
			}
		}catch(Exception ex){
			
		}
		
		return ret;
	}
}
