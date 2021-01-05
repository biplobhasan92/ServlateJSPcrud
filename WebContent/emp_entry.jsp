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
		
		<br>
		
		<div class="main">
			<div class="container col-md-4">
				<div class="row">
					<div class="card">
						<div class="card-body">
							<c:if test="${emp != null}">
								<form action="update" method="post">
							</c:if>
							<c:if test="${emp == null}">
								<form action="insert" method="post">
							</c:if>
			
							<caption>
								<h2>
									<c:if test="${emp != null}">
			            			Edit User
				            		</c:if>
									<c:if test="${emp == null}">
				            			Add New User
				            		</c:if>
								</h2>
							</caption>
							
								<c:if test="${emp != null}">
									<input type="hidden" name="id" value="<c:out value='${emp.id}' />" />
								</c:if>
								
								<fieldset class="form-group">
									<label>User Name</label>
									<input type="text" value="<c:out value='${emp.emp_name}'/>" class="form-control" name="emp_name" required="required" />
								</fieldset>
				
								<fieldset class="form-group">
									<label>User Email</label> 
									<input type="text" value="<c:out value='${emp.emp_email}'/>" class="form-control" name="emp_email" />
								</fieldset>
				
								<fieldset class="form-group">
									<label>User Dept</label> 
									<input type="text" value="<c:out value='${emp.emp_dept}'/>" class="form-control" name="emp_dept" />
								</fieldset>
								<button type="submit" class="btn btn-success">Save</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>