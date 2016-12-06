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
					<li><a href="new-incident">New incident</a></li>
					<li><a href="all-incidents">All incident</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Incident Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_INCIDENTS'}">
			<div class="container text-center" id="incidentsDiv">
				<h3>My Incidents</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Incident ID</th>
								<th>Parent ID</th>
								<th>Search ID</th>
								<th>Name</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="incident" items="${incidents}">
								<tr>
									<td>${incident.incidentID}</td>
									<td>${incident.parentID}</td>
									<td>${incident.searchID}</td>
									<td>${incident.name}</td>
	
									<td><a href="update-incident?incidentID=${incident.incidentID}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-incident?incidentID=${incident.incidentID}"> <span
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
				<h3>Manage Incident</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-incident">
					<input type="hidden" name="incidentID" value="${incident.incidentID}" />
					<div class="form-group">
						<label class="control-label col-sm-3">ParentID:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="parentID"
								value="${incident.parentID}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">SearchID:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="searchID"
								value="${incident.searchID}" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-sm-3">name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${incident.name}" />
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