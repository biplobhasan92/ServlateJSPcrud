package com.crud.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crud.dao.EmployeeDao;
import com.crud.model.Employee;



/**
 * Servlet implementation class EmpServlate
 */


@WebServlet("/")
public class EmpServlate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	EmployeeDao emp;
    public EmpServlate() {
        super();
    }
    public void init() {
		 emp = new EmployeeDao();
	}


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("Action : "+action);
		
		try {
			switch(action){
				case "/new":
					showForm(request, response);
					break;
				case "/insert":
					insertEmp(request, response);
					break;
				case "/delete":
					deleteEmp(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateEmp(request, response);
					break;
				default:
					listUser(request, response);
					System.out.println("Default --> ");
					break;				
			}
		} catch (Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}
	
	
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		List<Employee> listUser = emp.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Emp-List.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	
	private void showForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		RequestDispatcher dispatch = request.getRequestDispatcher("emp_entry.jsp");
		dispatch.forward(request, response);
	}
	
	
	
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingUser = emp.getEmpById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("emp_entry.jsp");
		request.setAttribute("emp", existingUser);
		dispatcher.forward(request, response);
	}
	
	
	
	
	private void insertEmp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name   = request.getParameter("emp_name");
		String email  = request.getParameter("emp_email");
		String dept   = request.getParameter("emp_dept");
		Employee newEmp = new Employee(name, email, dept);
		emp.insertEmployee(newEmp);
		response.sendRedirect("list");
	}
	
	
	
	private void deleteEmp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));		
		if(emp.deleteEmp(id)){
			response.sendRedirect("list");
		}else{
			
		}
	}
	
	
	
	
	private void updateEmp(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("emp_name");
		String email= request.getParameter("emp_email");
		String dept = request.getParameter("emp_dept");
		Employee newEmp = new Employee(id, name, email, dept);
		if(emp.updateEmp(newEmp)) {
			response.sendRedirect("list");
		}else {
			
		}
	}
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
