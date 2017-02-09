<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" src="resource/js/jquery-1.8.2.min.js"></script>
<!-- 日期控件使用 -->
<script type="text/javascript" src="resource/js/DatePicker/WdatePicker.js"></script> 
<script language="javascript">
	function validate(){
		//判断用户名
		//输入成功返回true;
		//输入失败返回false;
		
		return true;
    }
</script>
</head>
<body>
<div><%@ include file="left.jsp" %></div>
人员信息
<form action="search" method="post">

	姓名:<input type="text" id="name" name="name" value="<%=request.getAttribute("name") == null ? "":request.getAttribute("name") %>" />
	开始时间: <input type="text" id="startDate" name="startDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" value="<%= request.getAttribute("startDate") == null ?"":request.getAttribute("startDate")%>"/>
	结束时间: <input type="text" id="endDate" name="endDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" value="<%= request.getAttribute("endDate") ==null?"":request.getAttribute("endDate")%>"/>
	<input type="submit" value="查询" onclick="return validate();" />
</form>

<table  border="2" width="300" bordercolorlight="#FF9600" bordercolordark="#FF00EE" cellpadding="0" cellspacing="0">
					<tr>						
							<td>姓名</td>
							<td>密码</td>
							<td>查看</td>
							<td>删除</td>
					</tr>
					<c:forEach var="map" items="${userInfo}">
						<tr>
							<td>${map["name"]}</td>
							<td>${map["password"]}</td>
							<td><a href='look?id=${map["id"]}'>详细信息</a></td>
							<td><a href='delete?id=${map["id"]}'>删除</a></td>
						</tr>
					</c:forEach>
	</table>

</body>
</html>