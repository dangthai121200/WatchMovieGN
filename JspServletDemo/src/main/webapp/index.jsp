<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= application.getContextPath()%>/login" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input name="username"/></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input name="password" /></td>
			</tr>
		</table>
		<button type="submit">Submit</button>
	</form>
</body>
</html>