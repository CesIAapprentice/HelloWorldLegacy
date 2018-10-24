<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Products Form</title>
</head>
<body>
<div align="center"> Welcome Storehouse. You may now enter products</div>
<br>
<form:form name="enterProductsForm" method="POST"  >
<div align="center">
<table>
<tr>
<td><label >ID</label></td>
<td><input type="text" name="id" /></td>
</tr>
<tr>
<td><label >Name</label></td>
<td><input type="text" name="name" /></td>
</tr>
<tr>
<td><label >Price</label></td>
<td><input type="text" name="price" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit" /></td>
</tr>
</table>
<c:if test="${IDSuccessfullyAdded != null}"> 
	<div style="color: red">${IDSuccessfullyAdded}</div>
</c:if>
<c:if test="${IDAlreadyInDatabase != null}"> 
	<div style="color: red">${IDAlreadyInDatabase}</div>
</c:if>
</div>
</form:form>
</body>
</html>