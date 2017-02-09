<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table  border="2" width="300" bordercolorlight="#FF9600" bordercolordark="#FF00EE" cellpadding="0" cellspacing="0">
					<tr>
							<td>ID</td>
							<td>姓名</td>
							<td>密码</td>
					</tr>
					<c:forEach var="map" items="${userInfo}">
						<tr>
							<td>${map["id"] }</td>
							<td>${map["name"]}</td>
							<td>${map["password"]}</td>
						</tr>
					</c:forEach>
	</table>
</body>
</html>