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
	<h3>Department Details</h3>
	<br>

	<form action="ServletForDepartment" method="post">
		<jsp:useBean id="obj"
			class="testProJsp.ActionClassForDepartmentDetails"></jsp:useBean>
		Department Name :<select id="dname" name="dname"><option>Select</option>
			<%
				String name = null;
				ResultSet res = obj.onLoadingDeptName();
				if (res != null) {
					while (res.next()) {
						name = res.getString("DEPTNAME");
			%>
			<option value="<%=name%>"><%=name%></option>
			<%
				}
				}
			%>

		</select><br> <br>Department Type:<select id="dtype" name="dtype"><option>Select</option>
			<option>Dtype 1</option>
			<option>Dtype 2</option>
			<option>Dtype 3</option>
		</select><br> <br>Sub Department:<input type="text" name="sname"
			id="sname"> <br> <br> <input type="submit"
			value="Save" name="save" id="save">
	</form>
	<br>
	<br>
	<table border="1">
		<tr>
			<td>Sub Department</td>
			<td>Department Name</td>
			<td>Department Type</td>
		</tr>
		<%-- <tr>
			<%
				ResultSet table = (ResultSet) request.getAttribute("Display");
				if (table != null) {
					while (table.next()) {
			%>
			<td><%=table.getString("SUBDEPARTMENT")%></td>
			<td><%=table.getString("DEPARTMENTTYPE")%></td>
			<td><%=table.getString("DEPTNAME")%></td>
			<%
				}
				}
			%>
		</tr> --%>
		<tr>
			<%
				ResultSet result = (ResultSet) request.getAttribute("Dept");
				if (result != null) {
					while (result.next()) {
			%>
			<td><%=result.getString("SUBDEPARTMENT")%></td>
			<td><%=result.getString("DEPARTMENTTYPE")%></td>
			<td><%=result.getString("DEPTNAME")%></td>
			<%
				}
				}
			%>
		</tr>

	</table>
</body>
</html>