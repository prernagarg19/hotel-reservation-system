<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css">
	<title>Confirmation</title>
</head>
<body>
<div id="confirmationDiv">
<form action="register">
<input type="hidden" id="hotelName" name="hotelName" value="${hotelName}">

	<table class="center">
  	<tr class="headingHotelConfirmation">
    	<th>RoomType</th>
    	<th>Price</th>
    	<th>GST</th>
    	<th>Total</th>
  	</tr>
  	<tr class="detailsHotelConfirmation">
    	<td>${roomtype}</td>
    	<td>${price}</td>
    	<td>${gst}</td>
    	<td>${total}</td>
  	</tr>

</table>
<BR><BR>
<input type="submit" value="Confirm"/>

</form>
<BR><BR>
<a href="showForm">Back</a>
</div>
</body>
</html>