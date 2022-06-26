<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#value').change(function(e) {
			$.ajax({
				url : 'ExampleServlet',
				type : "post",
				data : {
					val : document.getElementById("value").value,
				},
				success : function(data) {
					alert("Success===" + data);
				}
			});
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		Text :<input type="text" id="ab"><br> <br> Select a
		value : <select id="value">
			<option>Select</option>
			<option>Value 1</option>
			<option>Value 2</option>
		</select><br> <br> <input type="button" value="submit" id="btn">
	</form>
</body>
</html>