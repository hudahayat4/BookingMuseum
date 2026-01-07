<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Malacca Heritage Museum</title>
</head>
<body>
	<a href="list.jsp">List</a> | <a href="LogoutController">Logout</a><br><br>
	<%
	//Prevent browser caching
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expires",0);
	
	if(session.getAttribute("email")==null){
		response.sendRedirect("login.jsp");
	}
	%>
	<h1>Malacca Heritage Museum</h1>
	<h6>Get Your e-Tickets Here</h6>
	<form action="BookingController" method="post">
	<b>User Id:</b><br>
	<input type="text" name="userId"><br>
	<b>Select Visit Date:</b><br>
	<input type="date" name="date"><br>
	<b>Select session:</b><br>
	<input type="radio" name="session" value="10.00am">10:00 AM
	<input type="radio" name="session" value="12.30pm">12:30 PM
	<input type="radio" name="session" value="15.00pm">15:00 PM
	<input type="radio" name="session" value="17.30pm">17:30 PM<br>
	<b>Guided Tour:</b><br>
	<input type="radio" name="guide" value="Yes">Yes
	<input type="radio" name="guide" value="No">No<br>
	<b>Ticket:</b><br>
	<table>
	<tr>
	<td>General Admission (RM25.00)</td>
	<td>Student Admission (RM15.00)</td>
	<td>Senior Admission (RM10.00)</td>
	</tr>
	<tr>
	<td><input type="number" name="generalQuantity"></td>
	<td><input type="number" name="studentQuantity"></td>
	<td><input type="number" name="seniorQuantity"></td>
	</table><br>
	<b>Add-on item:</b><br>
	<table>
	<tr>
	<td>Audio Guide (RM5.00)</td>
	<td>Museum Cafe Voucher (RM8.00)</td>
	</tr>
	<tr>
	<td><input type="number" name="audioQuantity"></td>
	<td><input type="number" name="cafeQuantity"></td>
	</tr>
	</table>
	<input type="submit">
	<input type="reset">
	</form>
</body>
</html>