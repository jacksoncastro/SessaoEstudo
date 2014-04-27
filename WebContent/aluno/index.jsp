<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<body>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Matricula</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="aluno" items="${alunos}">
				<tr>
					<td>${aluno.id}</td>
					<td>${aluno.nome}</td>
					<td>${aluno.matricula}</td>
					<td><a href="Remover">Remover</a><a href="Atualizar">Atualizar</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="index.html">Voltar</a>		
	</body>
</html>
