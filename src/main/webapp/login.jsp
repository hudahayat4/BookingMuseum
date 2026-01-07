<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
.error-message{
color:red;
font-size:14px;
margin-bottom:10px;
}
</style>
</head>
<body>
<h1>Login</h1>
<form action="LoginController" method="post">
<!-- Display error message if exists -->
<c:if test="${not empty errorMessage }">
<div class="error-message">${errorMessage }</div>
</c:if>
Email:<br>
<input type="email" name="email" required><br>
Password:<br>
<input type="password" name="password" required><br><br>
<input type="submit" value="Login">
<input type="reset">
</form>
</body>
</html>