<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APP2021 - Confirmação</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<form action="/empresa" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>

		<hr>

		<c:if test="${not empty lista}">
		
			<c:if test="${not empty msg}">
				<div class="alert alert-success">
					<strong>Sucesso! </strong> ${msg}
				</div>
			</c:if>

			<h4>Quantidade de empresas existentes: ${lista.size()}</h4>

			<hr>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Telefone</th>
						<th>Usuário</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${lista}">
						<tr>
							<td>${e.id}</td>
							<td>${e.nome}</td>
							<td>${e.email}</td>
							<td>${e.telefone}</td>
							<td>${e.usuario.nome}</td>
							<td><a href="/empresa/${e.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty lista}">
			<h4>Não existem empresas cadastradas!</h4>
		</c:if>
	</div>
</body>
</html>