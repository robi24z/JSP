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
		$('#oname').change(function(e) {
			$.ajax({
				url : 'ServletForOrnament',
				type : "get",
				data : {
					name : document.getElementById("oname").value,
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
	<h3>Ornament Details</h3>
	<br>
	<form action="ServletForOrnament" method="post">
		<jsp:useBean id="obj" class="testProJsp.ActionClassForOranament"></jsp:useBean>
		Ornament : <select id="oname" name="oname">
			<option>Select</option>
			<%
				String name = "";
						ResultSet result = obj.onLoadingOrnamentName();
				//System.out.println("+result=="+result);
				if (result != null) {
					while (result.next()) {
						name = result.getString("ORNAMENTNAME");
			%>
			<option value="<%=name%>"><%=name%></option>
			<%
				}
				}
			%>
		</select> <br> <br> Price : <input type="text" id="price"
			name="price"> <br> <br> <input type="submit"
			value="View Details" id="button" name="button"> <br> <br>
		<table border="1">
			<tr>
				<td>Ornament name</td>
				<td>Price</td>
				<td>Gst</td>
				<td>Discount</td>
			</tr>
			<tr>
				<%
					ResultSet view = (ResultSet) request.getAttribute("Ornament");
					if (view != null) {
						while (view.next()) {
				%>
				<td><%=view.getString("ORNAMENTNAME")%></td>
				<td><%=view.getInt("PRICE")%></td>
				<td><%=view.getString("GST")%></td>
				<td><%=view.getString("DISCOUNT")%></td>
				<%
					}
					}
				%>
			</tr>

		</table>
	</form>
</body>
</html>