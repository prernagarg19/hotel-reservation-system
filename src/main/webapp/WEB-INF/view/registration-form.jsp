<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css">
<title>Registration</title>
</head>
<body>
<div class="form-style-2">
<div class="form-style-2-heading">Register here!</div>

<form action="reserveGuest" method="post">
	<input type="hidden" id="hotel" name="hotel" value="${hotelName}">
    <table class="myRegisterForm">
        <tr>
            <td class="text2">Guest Name</td>
            <td>
                <input type="text" name="guestName" class="input-field" required/>
            </td>
        </tr>

        <tr>
            <td class="text2">Gender</td>
            <td>
  				<select name="gender" id="gender" class="select-field" required>
    				<option value="female">Female</option>
    				<option value="male">Male</option>
  				</select>
            </td>
        </tr>
        <tr>
            <td class="text2">Age</td>
            <td>
                <input type="number" id="age" name="age" class="input-field" required>
            </td>
        </tr>
         <tr>
            <td class="text2">Email Id</td>
            <td>
                <input type="email" id="email" name="email" class="input-field" required>
            </td>
        </tr>
        <tr>
            <td class="text2">Mobile Number</td>
            <td>
                <input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" class="input-field" required>
            </td>
        </tr>
        <tr>
            <td class="text2">
               <input type="submit" value="Reserve">
            </td>
        </tr>
    </table>
	
</form>
</div>
</body>
</html>