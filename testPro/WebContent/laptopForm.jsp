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
<script type="text/javascript">
	$(document).ready(function() {
		$('#cvalue').change(function(e) {
			$.ajax({
				url : 'LaptopFormDetails',
				type : "get",
				data : {
					val : document.getElementById("lprice").value = price,
				},
				success : function(data) {
					alert("Success===" + data);
				}
			});
		});
	});
</script>
</head>
<body>
	<form action="LaptopFormDetails" method="post">
		<jsp:useBean id="obj" class="testProJsp.ActionClassForLaptop"></jsp:useBean>
		<h2>Online Laptop Service</h2>
		<table>
			<tr>
				<td>Customer Name :</td>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr>
				<td>Customer Email :
				<td><input type="text" name="email"></td>
			</tr>

			<tr>
				<td>Laptop Name :</td>
				<td><select name="lname" onchange="submit();" id="cvalue">
						<option>Select</option>
						<%
							String name = null;
							ResultSet res = obj.onLoadingLaptopName();
							if (res != null) {
								while (res.next()) {
									name = res.getString("LAPTOPNAME");
						%>
						<option value="<%=name%>"><%=name%></option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Price :</td>
				<%
					String price = (String) request.getAttribute("price");
					//System.out.println(price);
				%>

				<td><input type="text" name="price" id="lprice"
					></td>
			</tr>
			<tr>
				<td>Customer Rate :</td>
				<td><input type="text" name="rate"></td>
			</tr>
			<tr>
				<td>Balance Price :</td>
				<td><input type="text" name="balance"></td>
			</tr>

		</table>
		<br> <input type="submit" value="Book" name="check">
	</form>
</body>
</html>