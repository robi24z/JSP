<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletForFlight" method="post">
		Customer Name :<input type="text" name="cname"><br> <br>
		Customer Email :<input type="text" name="cemail"><br> <br>

		<%
			String flname = (String) request.getAttribute("Flightname");
		%>

		Flight Name : <input type="text" disabled name="fliname" id="fliname"
			value="<%=flname%>"> <br> <br> <input type="submit"
			value="Confirm Booking" id="buttonConfirm" name="buttonConfirm">
		<input type="hidden" name="f" id="f" value="<%=flname%>">
	</form>
</body>
</html>