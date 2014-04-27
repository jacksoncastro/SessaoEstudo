<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<body>
		
		
		<form action="cadastrar.jsp" method="post">
			<input type="submit" value="Cadastrar"/>
		</form>
	
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Matricula</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="reserva" items="${reservas}">
				<tr>
					<td>${reserva.id}</td>
					<td>${reserva.nome}</td>
					<td>${reserva.matricula}</td>
					<td>
						<form action="frontHelper" method="post" style="display: inline; float: left;">
							<input type="hidden" name="servlet" value="Aluno/deletar"/>
							<input type="hidden" name="id" value="${aluno.id}"/>
							<input type="submit" value="Deletar"/>
						</form>
						<form action="aluno/update.jsp" method="post" style="display: inline; float: left;">
							<input type="hidden" name="id" value="${aluno.id}"/>
							<input type="hidden" name="nome" value="${aluno.nome}"/>
							<input type="hidden" name="matricula" value="${aluno.matricula}"/>
							<input type="submit" value="Atualizar"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="index.html">Voltar</a>		
	</body>
</html>
