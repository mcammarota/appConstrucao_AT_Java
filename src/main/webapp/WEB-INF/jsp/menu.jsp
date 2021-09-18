<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">AppConstrucao</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<c:if test="${not empty user}">
				<li><a href="/usuario/lista">Usu�rio</a></li>
				<li><a href="/empresa/lista">Empresa</a></li>
				<li><a href="/produto/lista">Produto</a></li>
				<li><a href="/acabamento/lista">Acabamento</a></li>
				<li><a href="/estrutura/lista">Estrutura</a></li>
				<li><a href="/fundacao/lista">Funda��o</a></li>
				<li><a href="/cotacao/lista">Cota��o</a></li>
			</c:if>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty user}">
				<li><a href="/usuario"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
			<c:if test="${not empty user}">
				<li><a href="/logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</c:if>
		</ul>
	</div>
</nav>