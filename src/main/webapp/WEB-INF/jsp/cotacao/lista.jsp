<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APP2021 - Confirma��o</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<form action="/cotacao" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>

		<hr>

		<c:if test="${not empty lista}">
		
			<c:if test="${not empty msg}">
				<div class="alert alert-success">
					<strong>Sucesso! </strong> ${msg}
				</div>
			</c:if>

			<h4>Quantidade de cota��es existentes: ${lista.size()}</h4>

			<hr>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descri��o</th>
						<th>Empresa</th>
						<th>Produtos</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${lista}">
						<tr>
							<td>${c.id}</td>
							<td>${c.descricao}</td>
							<td>${c.empresa.nome}</td>
							<td>${c.produtos.size()}</td>
							<td><a href="/cotacao/${c.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty lista}">
			<h4>N�o existem cota��es cadastradas!</h4>
		</c:if>
	</div>
</body>
</html>