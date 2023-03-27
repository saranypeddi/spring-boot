<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<form:form method="post" action="/save" modelAttribute="contactForm">
	<table border="1" style="border-collapse: collapse;">
	<tr>
	
		<th style="background-color:yellow;">Table Name</th>
		<th style="background-color:yellow">Column Name</th>
		<th style="background-color:#50D050">Distinct Value</th>
		<th style="background-color:orange">User Input</th>
	</tr>
	<c:forEach items="${tableItems.items}" var="item" varStatus="status">
		<tr  style="border-collapse: collapse;">
			
			<td><input readonly name="items[${status.index}].tableName" value="${item.tableName}"/></td>
			<td><input readonly name="items[${status.index}].colName" value="${item.colName}"/></td>
			<td><input readonly name="items[${status.index}].colValue" value="${item.colValue}"/></td>
			<td><input name="items[${status.index}].updateValue" value="${item.updateValue}"/></td>
		</tr>
	</c:forEach>
</table>	
<br/>
<input type="submit" value="Update" />
	
</form:form> </div>

<a href="/"> Home</a>
</body>
</html>