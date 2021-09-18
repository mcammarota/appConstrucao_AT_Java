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
	  <h2>Cadastro de Fundações</h2>
	  <form action="/fundacao/incluir" method="post">

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input type="text" value="Fundacao para casa" class="form-control" placeholder="Entre com a descrição" name="descricao">
	    </div>

	    <div class="form-group">
	      <label>Valor:</label>
	      <input type="text" value="5000" class="form-control" placeholder="Entre com o valor" name="valor">
	    </div>

	    <div class="form-group">
	      <label>Prazo de Entrega:</label>
	      <input type="text" value="20" class="form-control" placeholder="Entre com o prazo de entrega" name="prazoEntrega">
	    </div>
	    
	   	<div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" name="fundacaoRasa" checked>Fundação Rasa</label>
	    </div>
	    
	    <div class="form-group">
	      <label>Tipo:</label>
	      <input type="text" value="Radier" class="form-control" placeholder="Entre com o tipo de fundação" name="tipo">
	    </div>
	    
	    <div class="form-group">
	      <label>Profundidade</label>
	      <input type="text" value="2" class="form-control" placeholder="Entre com a profundidade" name="profundidade">
	    </div>
	    

		
	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>
	
</body>
</html>