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
<script>
	$(document).ready(function() {
		$('#vvalue').change(function(e) {
			$.ajax({
				url : 'ServletForVehicle',
				type : "get",
				data : {
					vname : document.getElementById("vvalue").value,
				},
				success : function(data) {
					document.getElementById("price").value = data;
				}
			});
		});
	});
</script>
</head>
<body>
	<form action="ServletForVehicle" method="post">
		<jsp:useBean id="obj" class="testProJsp.ActionClassForVehicle"></jsp:useBean>
		<h3>Vehicle Sale</h3>
		<br> Customer Name :<input type="text" name="cname" id="cname"><br>
		<br> Customer Email :<input type="text" name="cemail" id="cemail"><br>
		<br>Customer Address :<input type="text" name="caddress"
			id="caddress"><br> <br>Vehicle :<select id="vvalue"
			name="vvalue">
			<option>Select</option>
			<%
				String name = null;
				ResultSet res = obj.onLoadingVehicleName();
				if (res != null) {
					while (res.next()) {
						name = res.getString("VEHICLENAME");
			%>
			<option value="<%=name%>"><%=name%></option>
			<%
				}
				}
			%>
		</select> <br> <br> Price :<input type="text" name="price" id="price"><br>
		<br>Customer Phone :<input type="text" name="cphone" id="cphone"><br>
		<br> <input type="submit" value="Book" name="b1" id="b1"><br>
		<br> <input type="submit" value="Show Customer" name="b2" id="b2">
		<br>
	</form>
</body>
</html>