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
	  <h2>Cadastro de Acabamentos</h2>
	  <form action="/acabamento/incluir" method="post">

	    <div class="form-group">
	      <label>Descri��o:</label>
	      <input type="text" value="Acabamento da cozinha" class="form-control" placeholder="Entre com a descri��o" name="descricao">
	    </div>

	    <div class="form-group">
	      <label>Valor:</label>
	      <input type="text" value="3000" class="form-control" placeholder="Entre com o valor" name="valor">
	    </div>

	    <div class="form-group">
	      <label>Prazo de Entrega:</label>
	      <input type="text" value="25" class="form-control" placeholder="Entre com o prazo de entrega" name="prazoEntrega">
	    </div>
	    
	    <div class="form-group">
	      <label>Piso:</label>
	      <input type="text" value="Cer�mica" class="form-control" placeholder="Entre com o piso" name="piso">
	    </div>
	    
	    <div class="form-group">
	      <label>Pintura:</label>
	      <input type="text" value="Acetinada" class="form-control" placeholder="Entre com a pintura" name="pintura">
	    </div>
	    
	    <div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" name="rodape" checked>Rodap�</label>
	    </div>
		
	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>
	
</body>
</html>