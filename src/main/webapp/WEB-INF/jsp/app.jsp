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
	  <h3>Quantidades:</h3>  
		<ul class="list-group">
	    <c:forEach var="mapa" items="${total}">
	    	<li class="list-group-item">${mapa.key} <span class="badge">${mapa.value}</span></li>
	    </c:forEach>
	  	</ul>
	</div>
	
</body>
</html>