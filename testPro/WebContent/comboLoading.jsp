<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Combobox Loading</h1>
	<jsp:useBean id="obj" class="testProJsp.CountryName"></jsp:useBean>
	<select>
		<option>Select</option>
		<option>Option 1</option>
		<option>Option 2</option>
	</select>
	<select>
		<option>Select</option>
		<%
			int i;
			ArrayList name = obj.name();
			for (i = 0; i < name.size(); i++) {
				String cname = name.get(i).toString();
		%>
		<option value="<%= cname%>"><%= cname%></option>
		<%
			}
		%>

	</select>

</body>
</html>