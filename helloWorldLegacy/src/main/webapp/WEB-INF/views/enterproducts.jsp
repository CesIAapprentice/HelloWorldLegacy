<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Enter Products Form</title>
    <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    .empty
    {
        color: #00ff00;
        font-weight: bold;
    }
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2><spring:message code="lbl.page" text="Welcome Storehouse. You may now enter products" /></h2>
<br/>
<form:form commandName="product" action="enterproducts" method="post" enctype="multipart/form-data">
<%-- <form:errors path="*" cssClass="error" /> --%>
<div align="center">
<table>
            <tr>
                <td><spring:message code="lbl.id" text="id" /></td>
                <td><form:input path="id" /></td>
                <td><form:errors path="id" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.name" text="name" /></td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.price" text="price" /></td>
                <td><form:input path="price" /></td>
                <td><form:errors path="price" cssClass="error" /></td>
            </tr>
            <tr>
                 <td><label for="image">Product Images: </label></td>
                 <td><input type="file" name="images" multiple="multiple"/></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Add Products"/></td>
            </tr>
        </table>

<c:if test="${IDSuccessfullyAdded != null}"> 
	<div style="color: red">${IDSuccessfullyAdded}</div>
</c:if>
</div>
</form:form>
</body>
</html>