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

		<form action="/estrutura" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>

		<hr>

		<c:if test="${not empty estruturas}">
		
			<c:if test="${not empty msg}">
				<div class="alert alert-success">
					<strong>Sucesso! </strong> ${msg}
				</div>
			</c:if>

			<h4>Quantidade de estruturas existentes: ${estruturas.size()}</h4>

			<hr>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descrição</th>
						<th>Valor</th>
						<th>Prazo</th>
						<th>Característica</th>
						<th>Tamanho da Ferragem</th>
						<th>Metálica</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${estruturas}">
						<tr>
							<td>${e.id}</td>
							<td>${e.descricao}</td>
							<td>${e.valor}</td>
							<td>${e.prazoEntrega}</td>
							<td>${e.caracteristica}</td>
							<td>${e.tamanhoFerragem}</td>
							<td>${e.metalica}</td>
							<td><a href="/estrutura/${e.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty estruturas}">
			<h4>Não existem estruturas cadastradas!</h4>
		</c:if>
	</div>
</body>
</html>