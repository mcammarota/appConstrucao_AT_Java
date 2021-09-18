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
	
	
	<div class="container">
	
		<c:if test="${not empty mensagem}">
			<div class="alert alert-danger">
				<strong>Erro!</strong> ${mensagem}
			</div>
		</c:if>
	
	  <h2>Cadastro de Usu�rios</h2>

			<form action="/cep" class="form-inline" method="post">
				<div class="form-group">
				  <label>Cep:</label>
				  <input type="text" class="form-control" placeholder="Entre com o seu cep" name="cep">
				</div>
				<button type="submit" class="btn btn-primary">Buscar</button>
			</form>
		
		<form action="/usuario" method="post">
		
		<div class="form-group">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu e-mail" name="nome">
	    </div>
	    
	    <div class="form-group">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email">
	    </div>

		<div class="form-group">
	      <label>Senha:</label>
	      <input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha">
	    </div>
	    
	    <c:import url="/WEB-INF/jsp/endereco.jsp"/>
		
	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>
	
</body>
</html>