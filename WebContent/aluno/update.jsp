<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Sucesso</title>
	</head>
	<body>
		<fieldset style="width: 240px; margin: auto;">
			<legend>Aluno:</legend>
			<form action="../frontHelper" method="post">
				<label for="nome">Nome:</label>
				<input id="nome" name="nome" type="text" value="<%=request.getParameter("nome")%>"/><br/><br/>
				<label for="matricula">Matricula:</label>
				<input id="matricula" name="matricula" type="number" value="<%=request.getParameter("matricula")%>" required/><br/>
				<input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
				<input type="hidden" name="servlet" value="Aluno/atualizar"/>
				<input type="submit" value="Atualizar"/>
			</form>
		</fieldset>
	</body>
</html>