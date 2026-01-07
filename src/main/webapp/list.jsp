<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
<h1>Booking List</h1>
<a href="index.jsp">Add New Ticket</a><br><br>
<table style="border:1px solid black;">
<tr>
<th>Booking Id</th>
<th>User Id</th>
<th>Visit Date</th>
<th>Session</th>
<th>Guided Tour</th>
<th>General Admission</th>
<th>Student Admission</th>
<th>Senior Admission</th>
<th>Audio Guides</th>
<th>Cafe Vouchers</th>
<th>Action</th>
</tr>
<c:forEach items="${bookings}" var="booking">
	<tr>
		<td>${booking.bookingId }</td>
		<td>${booking.userId }</td>
		<td>${booking.date }</td>
		<td>${booking.session }</td>
		<td>${booking.guide }</td>
		<td>${booking.generalQuantity }</td>
		<td>${booking.studentQuantity }</td>
		<td>${booking.seniorQuantity }</td>
		<td>${booking.audioQuantity }</td>
		<td>${booking.cafeQuantity }</td>
		<td>
			<a href="BookingController?action=edit&bookingId=${booking.bookingId }">Edit</a> |
			<a href="BookingController?action=delete&bookingId=${booking.bookingId }" onclick="return confirm('Are you sure?');">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>