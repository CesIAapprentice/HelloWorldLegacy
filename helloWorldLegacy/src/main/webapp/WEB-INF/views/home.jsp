<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
<div align="center">
<h1>
	Hello user!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div style="color: blue">${msg}</div>

<P>  You may <a href="login">Login</a> or <a href="register">Register</a></P>

</div>
</body>
</html>