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

	<%
	// Set refresh, autoload time as 5 seconds
	response.setIntHeader("Refresh", 120);
	%>
	<div align="center">

		<form action="/addSite" method="POST">
			<label for="name">Add site to check status</label><br> <input
				type="text" name="site" /><br> <br> <input type="submit"
				value="Add">
		</form>

		<br> <br>

		<table border="1" style="border-collapse: collapse;">
			<tr>

				<th>Site</th>
				<th>Status</th>

			</tr>
			<c:forEach items="${websites.sites}" var="item" varStatus="status">
				<tr style="border-collapse: collapse;">

					<td>${item.site}</td>


					<td><c:choose>
							<c:when test="${item.status.equals('up')}">
        <button style="background-color: #4CAF50;"> up</button> 
        <br />
							</c:when>
							<c:otherwise>
         <button style="background-color: #f44336;"> up</button> 
        <br />
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<br />


	</div>

</body>
</html>