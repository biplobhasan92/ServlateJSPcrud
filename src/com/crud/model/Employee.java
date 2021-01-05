package com.crud.model;

public class Employee {
	
	private int id;
	private String emp_name;
	private String emp_email;
	private String emp_dept;
	
	
	
	
	public Employee() {
		super();
	}
	
	
	
	public Employee(String emp_name, String emp_email, String emp_dept) {
		super();
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_dept = emp_dept;
	}


	

	public Employee(int id, String emp_name, String emp_email, String emp_dept) {
		super();
		this.id = id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_dept = emp_dept;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	
	
}
