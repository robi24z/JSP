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
	<form>
		<table border="1">
			<tr>
				<td>Customer Name</td>
				<td>Customer Email</td>
				<td>Flight Name</td>
				<td>Origin</td>
				<td>Destination</td>
				<td>Time</td>
			</tr>
			<tr>
				<%
					ResultSet result = (ResultSet) request.getAttribute("Details");
					if (result != null) {
						while (result.next()) {
				%>
				<td><%=result.getString("CUSTOMERNAME")%></td>
				<td><%=result.getString("CUSTOMEREMAIL")%></td>
				<td><%=result.getString("FLIGHTNAME")%></td>
				<td><%=result.getString("ORIGIN")%></td>
				<td><%=result.getString("DESTINATION")%></td>
				<td><%=result.getString("TIME")%></td>
				<%
					}
					}
				%>
			</tr>
		</table>

	</form>
</body>
</html>