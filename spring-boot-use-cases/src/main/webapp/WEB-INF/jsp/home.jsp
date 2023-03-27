<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<form method="POST" action="/list">
  <input type="text" id="tableName" name="tableName" placeholder="Table Name"><br>
  <input type="text" id="UniqueCol" name="UniqueCol" placeholder="Unique Column"><br>
  <input type="text" id="ColName" name="ColName" placeholder="Column Name"><br><br>
  <input type="submit" value="Manual Update">
</form> 
</div>


</body>

</html>