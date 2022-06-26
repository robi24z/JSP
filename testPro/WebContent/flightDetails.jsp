<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<form action="ServletForFlight" method="get">
		<jsp:useBean id="obj" class="testProJsp.ActionClassForFlight"></jsp:useBean>
		Choose your flight :<select id="fvalue" name="fvalue"
			onchange="submit();">
			<option>Select</option>
			<%
				String name = null;
				ResultSet res = obj.onLoadingFlightName();
				if (res != null) {
					while (res.next()) {
						name = res.getString("FLIGHTNAME");
			%>
			<option value="<%=name%>"><%=name%></option>
			<%
				}
				}
			%>
		</select> <br> <br>
		<table border="1">
			<tr>
				<td>Flight name</td>
				<td>Origin</td>
				<td>Destination</td>
				<td>Time</td>
			</tr>
			<tr>
				<%
					ResultSet result = (ResultSet) request.getAttribute("FlightData");
					if (result != null) {
						while (result.next()) {
				%>
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
		<input type="text" id="flvalue" name="flvalue"
			value="<%=request.getAttribute("Flightname")%>" /> <br> <br>
		<input type="submit" value="Book Flight" name="button"
			id="Book Flight">
	</form>

</body>
</html>