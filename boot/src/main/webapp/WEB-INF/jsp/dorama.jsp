<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Boot Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-dorama">New dorama</a></li>
					<li><a href="all-doramas">All dorama</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Dorama Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_DORAMAS'}">
			<div class="container text-center" id="doramasDiv">
				<h3>My Doramas</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Dorama ID</th>
								<th>Nombre</th>
								<th>Produccion</th>
								<th>Descripcion</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dorama" items="${doramas}">
								<tr>
									<td>${dorama.doramaID}</td>
									<td>${dorama.nombre}</td>
									<td>${dorama.produccion}</td>
									<td>${dorama.descripcion}</td>
	
									<td><a href="update-dorama?doramaID=${dorama.doramaID}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-dorama?doramaID=${dorama.doramaID}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Dorama</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-dorama">
					<input type="hidden" name="doramaID" value="${dorama.doramaID}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Nombre:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="nombre"
								value="${dorama.nombre}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Produccion:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="produccion"
								value="${dorama.produccion}" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-sm-3">Descripcion:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="descripcion"
								value="${dorama.descripcion}" />
						</div>
					</div>
					

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
		</c:choose>
		<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
		

</body>
</html>