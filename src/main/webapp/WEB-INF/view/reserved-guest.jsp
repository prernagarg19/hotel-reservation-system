<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css">
<title>Thank you!</title>
</head>
<body>
<div class="form-style-2">
<div class="form-style-2-heading">${param.hotel}</div>


<p id="thankyouMsg">Dear <span style="text-decoration: underline;"> ${param.guestName}</span>, Thank you for choosing ${param.hotel}. It is our pleasure to confirm your reservation.</p>
</div>

</body>
</html>