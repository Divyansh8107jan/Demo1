<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<c:forEach var="reg" items="${registration}">
			<tr>
				<th>${reg.firstName}</th>
				<th>${reg.lastName}</th>
				<th>${reg.email}</th>
				<th>${reg.mobile}</th>
				<th><a href="delete?id=${reg.id}">delete</a></th>
				<th><a href="updateReg?id=${reg.id}">update</a></th>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>