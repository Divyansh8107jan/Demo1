<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update registration here</h1>
		<form action="/updateRegistrationDetails" method="post">
			<pre>
				<input type="hidden" name="id" value="${reg.id}"/>
				First Name<input type="text" name="firstName" value="${reg.firstName}"/>
				Last Name<input type="text" name="lastName"value="${reg.lastName}"/>
				Email<input type="text" name="email" value="${reg.email}"/>
				Mobile<input type="text" name="mobile" value="${reg.mobile}"/>
				<input type="submit" value="update"/>
			</pre>
		</form>
</body>
</html>