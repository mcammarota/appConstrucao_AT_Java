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

		<form action="/fundacao" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>

		<hr>

		<c:if test="${not empty fundacoes}">
		
			<c:if test="${not empty msg}">
				<div class="alert alert-success">
					<strong>Sucesso! </strong> ${msg}
				</div>
			</c:if>

			<h4>Quantidade de fundações existentes: ${fundacoes.size()}</h4>

			<hr>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descrição</th>
						<th>Valor</th>
						<th>Prazo</th>
						<th>Fundação Rasa</th>
						<th>Tipo</th>
						<th>Profundidade</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="f" items="${fundacoes}">
						<tr>
							<td>${f.id}</td>
							<td>${f.descricao}</td>
							<td>${f.valor}</td>
							<td>${f.prazoEntrega}</td>
							<td>${f.fundacaoRasa}</td>
							<td>${f.tipo}</td>
							<td>${f.profundidade}</td>
							<td><a href="/fundacao/${f.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty fundacoes}">
			<h4>Não existem fundações cadastradas!</h4>
		</c:if>
	</div>
</body>
</html>