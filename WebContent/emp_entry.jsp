<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<%@include file="include.jsp" %>
</head>
<body>
		<header>
			<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
				<div>
					<a href="#" class="navbar-brand"> 
						Employee Management App 
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
			            			Edit Employee
				            		</c:if>
									<c:if test="${emp == null}">
				            			Add New Employee
				            		</c:if>
								</h2>
							</caption>
							
								<c:if test="${emp != null}">
									<input type="hidden" name="id" value="<c:out value='${emp.id}' />" />
								</c:if>
								
								<fieldset class="form-group">
									<label>Emp Name</label>
									<input type="text" value="<c:out value='${emp.emp_name}'/>" class="form-control" name="emp_name" required="required" />
								</fieldset>
				
								<fieldset class="form-group">
									<label>Emp Email</label> 
									<input type="text" value="<c:out value='${emp.emp_email}'/>" class="form-control" name="emp_email" />
								</fieldset>
				
								<fieldset class="form-group">
									<label>Emp Dept</label> 
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