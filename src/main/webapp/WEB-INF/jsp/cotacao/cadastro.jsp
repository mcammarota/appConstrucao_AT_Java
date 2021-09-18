<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>App2021 - Cadastro</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de Cotações</h2>
	  <form action="/cotacao/incluir" method="post">
	  
	  	<div class="form-group">
		  <label>Empresa:</label>
		  <select class="form-control" name="empresa.id">
		  		<c:forEach var="e" items="${empresas}">
					<option value="${e.id}">${e.nome}</option>
				</c:forEach>
		  </select>
		</div>	

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input value="Primeira cotacao" type="text" class="form-control" placeholder="Entre com a descrição da cotação" name="descricao">
	    </div>
	    
	    <div class="form-group">
		  <label>Produtos:</label>
		  <c:forEach var="p" items="${produtos}">
		  	<div class="form-check">
		  		<label class="form-check-label">
		  		<input name="produtosId" type="checkbox" value="${p.id}">${p.descricao}
		  		</label>		
		  	</div>
		  </c:forEach>
		</div>
		
	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>
	
</body>
</html>