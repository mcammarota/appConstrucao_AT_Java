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
	  <h2>Cadastro de Empresas</h2>
	  <form action="/empresa/incluir" method="post">

	    <div class="form-group">
	      <label>Nome:</label>
	      <input value="Marcos Cammarota" type="text" class="form-control" placeholder="Entre com o seu nome" name="nome">
	    </div>

	    <div class="form-group">
	      <label>E-mail:</label>
	      <input value="marcos@cammarota.com" type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email">
	    </div>

		<div class="form-group">
	      <label>Telefone:</label>
	      <input value="22221111" type="text" class="form-control" placeholder="Entre com a sua idade" name="idade">
	    </div>
		
	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>
	
</body>
</html>