<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>

	<h3>Products Page</h3>
	<table cellpadding="2" cellspacing="2" border="0">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="product" items="${products }">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td><img src="${pageContext.request.contextPath }/displayproducts/barcode/${product.id }" width="200" height="50"></td>
				<%-- <td><img width="100" src="${pageContext.request.contextPath }${product.imagesnames}"/></td> --%>
				<td><img width="100" src="<c:url value="/images/"/>${product.imagesnames}"/></td>				
				<td align="center">
					<a href="${pageContext.request.contextPath }/cart/add/${product.id}">Add to Cart</a>
				</td>
				
			</tr>
		</c:forEach>
	</table>
<br>
</body>
</html>