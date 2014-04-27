<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<body>
		<form action="reservas" method="get">
			<input id="nome" name="nome" type="text"/>
			<input type="submit" value="Pesquisar"/>
		</form>

		<form action="cadastrar.jsp" method="post">
			<input type="submit" value="Cadastrar"/>
		</form>

		<table border="1">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Balada</th>
				<th>Telefone</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="reserva" items="${reservas}">
				<tr>
					<td>${reserva.id}</td>
					<td>${reserva.nome}</td>
					<td>${reserva.balada}</td>
					<td>${reserva.telefone}</td>
					<td>
						<form action="frontHelper" method="post" style="display: inline; float: left;">
							<input type="hidden" name="servlet" value="Reservas/deletar"/>
							<input type="hidden" name="id" value="${reserva.id}"/>
							<input type="submit" value="Deletar"/>
						</form>
						<form action="aluno/update.jsp" method="post" style="display: inline; float: left;">
							<input type="hidden" name="id" value="${reserva.id}"/>
							<input type="hidden" name="nome" value="${reserva.nome}"/>
							<input type="hidden" name="balada" value="${reserva.balada}"/>
							<input type="hidden" name="telefone" value="${reserva.telefone}"/>
							<input type="submit" value="Atualizar"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="index.html">Voltar</a>		
	</body>
</html>
