<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Booking</title>
</head>
<body>
<a href="">List</a>
	<h1>Malacca Heritage Museum</h1>
	<h6>Get Your e-Tickets Here</h6>
	<form action="BookingController" method="post">
	<b>Booking Id:</b><br>
	<input type="number" name="bookingId" value="${booking.bookingId }" readonly><br><br>
	<b>User Id:</b><br>
	<input type="text" name="userId" value="1"><br>
	<b>Select Visit Date:</b><br>
	<input type="date" name="date" value="${booking.date }"><br>
	<b>Select session:</b><br>
	<input type="radio" name="session" value="10.00am" <c:if test="${booking.session=='10.00am' }">checked</c:if>>10:00 AM
	<input type="radio" name="session" value="12.30pm" <c:if test="${booking.session=='12.30pm' }">checked</c:if>>12:30 PM
	<input type="radio" name="session" value="15.00pm" <c:if test="${booking.session=='15.00pm' }">checked</c:if>>15:00 PM
	<input type="radio" name="session" value="17.30pm" <c:if test="${booking.session=='17.30pm' }">checked</c:if>>17:30 PM<br>
	<b>Guided Tour:</b><br>
	<input type="radio" name="guide" value="Yes" <c:if test="${booking.guide =='Yes' }">checked</c:if>>Yes
	<input type="radio" name="guide" value="No" <c:if test="${booking.guide =='No' }">checked</c:if>>No<br>
	<b>Ticket:</b><br>
	<table>
	<tr>
	<td>General Admission (RM25.00)</td>
	<td>Student Admission (RM15.00)</td>
	<td>Senior Admission (RM10.00)</td>
	</tr>
	<tr>
	<td><input type="number" name="generalQuantity" value="${booking.generalQuantity }"></td>
	<td><input type="number" name="studentQuantity" value="${booking.studentQuantity }"></td>
	<td><input type="number" name="seniorQuantity" value="${booking.seniorQuantity }"></td>
	</table><br>
	<b>Add-on item:</b><br>
	<table>
	<tr>
	<td>Audio Guide (RM5.00)</td>
	<td>Museum Cafe Voucher (RM8.00)</td>
	</tr>
	<tr>
	<td><input type="number" name="audioQuantity" value="${booking.audioQuantity }"></td>
	<td><input type="number" name="cafeQuantity" value="${booking.cafeQuantity }"></td>
	</tr>
	</table>
	<input type="submit">
	<input type="reset">
	</form>
</body>
</html>