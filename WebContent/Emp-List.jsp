
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
		
		<script>
			
		</script>
	</head>
	
	<body>
		<header>
			<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
				<div>
					<a href="#" class="navbar-brand"> 
						User Management App 
					</a>
				</div>
	
				<ul class="navbar-nav">
					<li>
						<a href="<%=request.getContextPath()%>/list"
						class="nav-link">Users</a>
					</li>
				</ul>
			</nav>
		</header>
		
		<div class="row">
			<div class="container">
				<h3 class="text-center">List of Users</h3>
				<hr>
				<div class="container text-left">
					<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
						Add New User
					</a>
				</div>
				<br/>
				<table class="table table-bordered">
					<thead>
						<tr>
							<td>Id</td>
							<td>Name</td>
							<td>Email</td>
							<td>Dept</td>
							<td>Edit</td>
							<td>Delete</td>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="emp" items="${listUser}">
						<tr>
							<td> <c:out value="${emp.id}" /> </td>
							<td> <c:out value="${emp.emp_name}" />  </td>
							<td> <c:out value="${emp.emp_email}"/>  </td>
							<td> <c:out value="${emp.emp_dept}" />  </td>
							<td>
								<a href="edit?id=<c:out value='${emp.id}'/>">
									<button class="btn btn-primary">Edit</button>
								</a>
						  	</td>
						  	<td>
								<a href="delete?id=<c:out value='${emp.id}' />" onclick="return confirm('Are you sure you want to delete?')">
									<button class="btn btn-danger">Delete</button>
								</a>
						  	</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>