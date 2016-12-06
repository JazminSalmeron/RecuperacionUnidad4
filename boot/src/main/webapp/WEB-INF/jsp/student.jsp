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
					<li><a href="new-student">New student</a></li>
					<li><a href="all-students">All student</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Student Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_STUDENTS'}">
			<div class="container text-center" id="studentsDiv">
				<h3>My Students</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Student ID</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Enrollment Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${students}">
								<tr>
									<td>${student.studentID}</td>
									<td>${student.firstName}</td>
									<td>${student.lastName}</td>
									<td>${student.enrollmentDate}</td>
	
									<td><a href="update-student?studentID=${student.studentID}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-student?studentID=${student.studentID}"> <span
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
				<h3>Manage Student</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-student">
					<input type="hidden" name="studentID" value="${student.studentID}" />
					<div class="form-group">
						<label class="control-label col-sm-3">FirstName:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="firstName"
								value="${student.firstName}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">LastName:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="lastName"
								value="${student.lastName}" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-sm-3">EnrollmentDate:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="enrollmentDate"
								value="${student.enrollmentDate}" />
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