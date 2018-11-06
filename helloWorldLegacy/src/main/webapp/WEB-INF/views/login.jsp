<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
<div align="center">You may now Log in</div>
<br>
<form:form name="submitForm" method="POST"  >
<div align="center">
<table>
<tr>
<td><label ><strong><spring:message	code="label.firstName" /></strong></label></td>
<td><input type="text" name="username" /></td>
</tr>
<tr>
<td><label ><strong><spring:message	code="label.lastName" /></strong></label></td>
<td><input type="password" name="password" /></td>
</tr>
<tr>
<td></td>
<spring:message code="label.submit" var="labelSubmit"></spring:message>
<td><input type="submit" value="${labelSubmit}" /></td>
</tr>
</table>
<div style="color: red">${loginError}</div>
<c:if test="${userNotFound != null}"> 
	<div style="color: red">${userNotFound} You may want to <a href="register">register</a> first</div>
</c:if>
</div>
</form:form>
</body>
</html>