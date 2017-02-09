<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" src="resource/js/jquery-1.8.2.min.js"></script>
<script language="javascript">
	function validate(){
		//判断用户名和密码是否按规定输入
		//输入成功返回true;
		//输入失败返回false;
		
		return true;
    }
</script>
</head>
<body>
login



<% 
    Object obj = request.getAttribute("isUserExist");
	
	 if(obj != null){
		 if(obj.toString().equals("1")){
	%>
	<div style="color:red">此用户存在，亲，请换个名字</div>
<% } } %>

<form action="userregister" method="post">
	用户名:<input type="text" name="name" id="name" />
	密码: <input type="password" name="password" id="password" />
	<input type="submit" onclick="return validate();" value="注册" />
</form>
</body>
</html>