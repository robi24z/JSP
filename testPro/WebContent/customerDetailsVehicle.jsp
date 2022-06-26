<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletForVehicleCustomer" method="get">
		<jsp:useBean id="obj"
			class="testProJsp.ActionClassForCustomerDetailsVehicle"></jsp:useBean>
		<h3>Customer Details</h3>
		<br> Customer Name : <select id="cusname" name="cusname"
			onchange="submit();">
			<option>Select</option>
			<%
				String name = "";
				ResultSet result = obj.onLoadingCustomerName();
				if (result != null) {
					while (result.next()) {
						name = result.getString("CUSTOMERNAME");
						//request.setAttribute("Cusname", name);
			%>
			<option value="<%=name%>"><%=name%></option>
			<%
				}
				}
			%>
		</select> <br> <br>
		<table border="1">
			<tr>
				<td>Customer Name</td>
				<td>Customer Email</td>
				<td>Customer Address</td>
				<td>Customer Phone</td>
				<td>Vehicle Name</td>
				<td>Price</td>
				<td>Showroom</td>
			</tr>

			<tr>
				<%
					ResultSet res = (ResultSet) request.getAttribute("CusDetails");
					if (res != null) {
						while (res.next()) {
				%>
				<td><%=res.getString("CUSTOMERNAME")%></td>
				<td><%=res.getString("CUSTOMEREMAIL")%></td>
				<td><%=res.getString("CUSTOMERADDRESS")%></td>
				<td><%=res.getString("CUSTOMERPHONE")%></td>
				<td><%=res.getString("VEHICLENAME")%></td>
				<td><%=res.getInt("VEHICLEPRICE")%></td>
				<td><%=res.getString("SHOWROOM")%></td>

				<%
					}
					}
				%>
			</tr>
		</table>

		<br> <br>
	</form>
	<input type="submit" value="Back" name="b3" id="b3">
</body>
</html>