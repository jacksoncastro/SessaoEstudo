<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Bem vindo</title>
	</head>
	<body>
		<p>Bem vindo ${nome}</p>
		<form action="logar" method="get">
			<input type="submit" value="Logout">
		</form>
	</body>
</html>