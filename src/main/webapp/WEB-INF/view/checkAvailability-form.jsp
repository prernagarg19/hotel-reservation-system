<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
<script src="${pageContext.request.contextPath}/resources/js/dateJS.js"></script>
	<title>Search Hotels</title>
</head>
<body>
<div class="form-style-2">
<div class="form-style-2-heading">Search Hotels</div>
	
<form action="search" method="POST">
    <table class="myCheckForm">
        <tr>
            <td class="text1">City:</td>
            <td>
                <form:select path="cities" name="cityName" class="select-field">
    				<form:options items="${cities}" />
				</form:select>
            </td>
        </tr>

        <tr>
            <td class="text1">Hotel: </td>
            <td>
                <form:select path="hotels" name="hotelName" class="select-field">
    				<form:options items="${hotels}" />
				</form:select>
            </td>
        </tr>
        <tr>
            <td class="text1">Date:</td>
            <td>
                <input type="date" id="datefield" name="date" placeholder="yyyy-MM-dd" class="select-field">
            </td>
        </tr>
        <tr>
            <td class="text1">
               <input type="submit" value="Check Availability">
            </td>
        </tr>
    </table>
</form>
</div>	

</body>
</html>