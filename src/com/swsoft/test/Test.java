package com.swsoft.test;

import java.util.HashMap;
import java.util.Map;

import com.swsoft.dao.UserMapper;

public class Test {
	
	public static void main(String[] args){
		Map<String, Object> map = new HashMap<String, Object>();
		UserMapper um = new UserMapper();
		//删除
		map.put("id", 1);
		um.delete(map);
		
		//更新
		/*map.put("newpassword", "cc");
		map.put("name", "aa");
		map.put("oldpassword", "bb");
		um.update(map);*/
		
	}


	
}
