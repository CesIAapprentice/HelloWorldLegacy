<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Register Form</title>
</head>
<body>
<form:form name="registerForm" method="POST"  >
<div align="center">
<table>
<tr>
<td><label >Username</label></td>
<td><input type="text" name="username" /></td>
</tr>
<tr>
<td><label >Password</label></td>
<td><input type="password" name="password" /></td>
</tr>
<tr>
<td><label >Email</label></td>
<td><input type="text" name="email" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit" /></td>
</tr>
</table>
<c:if test="${userAlreadyInDatabase != null}"> 
	<div style="color: blue">${IDAlreadyInDatabase}. You may <a href="login">login</a> instead</div>
</c:if>
<c:if test="${registerSuccess != null}"> 
	<div style="color: red">${registerSuccess} successfully added. You may <a href="login">login</a> now</div>
</c:if>
</div>
</form:form>
</body>
</html>