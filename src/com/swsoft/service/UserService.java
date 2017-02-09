package com.swsoft.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	public int insert(Map<String, Object> map);
	//判断用户是否存在
	public int select(Map<String, Object> map);
    public List<Map<String, Object>> selectAll();
    public List<Map<String,Object>> selectById(String id);
    public List<Map<String,Object>> selectByTime(Map<String,Object> map);
}
