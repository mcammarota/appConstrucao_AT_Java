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

		<form action="/acabamento" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>

		<hr>

		<c:if test="${not empty acabamentos}">
		
			<c:if test="${not empty msg}">
				<div class="alert alert-success">
					<strong>Sucesso! </strong> ${msg}
				</div>
			</c:if>

			<h4>Quantidade de acabamentos existentes: ${acabamentos.size()}</h4>

			<hr>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descrição</th>
						<th>Valor</th>
						<th>Prazo</th>
						<th>Piso</th>
						<th>Pintura</th>
						<th>Rodapé</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${acabamentos}">
						<tr>
							<td>${a.id}</td>
							<td>${a.descricao}</td>
							<td>${a.valor}</td>
							<td>${a.prazoEntrega}</td>
							<td>${a.piso}</td>
							<td>${a.pintura}</td>
							<td>${a.rodape}</td>
							<td><a href="/acabamento/${a.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty acabamentos}">
			<h4>Não existem acabamentos cadastrados!</h4>
		</c:if>
	</div>
</body>
</html>