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
	<form action="LaptopFormDetails" method="get">
		<jsp:useBean id="obj" class="testProJsp.ActionClassForCustomerDetails"></jsp:useBean>
		Customer Name : <select name="cvalue" id="cvalue" onchange="submit();">
			<option>Select</option>
			<option>Select</option>
			<%
				String name = "";
				ResultSet res = obj.onLoadingCustomerName();
				if (res != null) {
					while (res.next()) {
						name = res.getString("CUSTOMERNAME");
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
				<td>Laptop</td>
				<td>Price</td>
				<td>Company Name</td>
			</tr>

			<tr>
				<%
					ResultSet result = (ResultSet) request.getAttribute("CustomerData");
					if (result != null) {
						while (result.next()) {
				%>
				<td><%=result.getString("CUSTOMERNAME")%></td>
				<td><%=result.getString("CUSTOMEREMAIL")%></td>
				<td><%=result.getString("LAPTOPNAME")%></td>
				<td><%=result.getInt("PRICE")%></td>
				<td><%=result.getString("COMPANYNAME")%></td>

				<%
					}
					}
				%>
			</tr>
		</table>
	</form>
</body>
</html>