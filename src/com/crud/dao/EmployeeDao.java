package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.crud.model.Employee;

public class EmployeeDao {

	DBConnection conn = new DBConnection();
	
	
	
	public void insertEmployee(Employee employee) {
		try {
			Connection con = conn.getDbConnection();
			String sql = " insert into employee(emp_name, emp_email, emp_dept) values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, employee.getEmp_name());
			pst.setString(2, employee.getEmp_email());
			pst.setString(3, employee.getEmp_dept());
			System.out.println(pst);
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e){
			conn.printSQLException(e);
		}
	}
	
	
	
	
	
	public List<Employee> selectAllUsers() {
		
		List<Employee> emp = new ArrayList<>();
		String SELECT_ALL_USERS = "select * from employee ";
		try (Connection con = conn.getDbConnection();
			PreparedStatement pst = con.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("emp_name");
				String email = rs.getString("emp_email");
				String dept = rs.getString("emp_dept");
				emp.add(new Employee(id, name, email, dept));
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			conn.printSQLException(e);
		}
		return emp;
	}
	
	
	
	
	
	public Employee getEmpById(int id){
		Employee emp = null;
		Connection con = conn.getDbConnection();
		String SELECT_ONE_EMP = " select * from Employee where id = ?";
		try {
			PreparedStatement pst = con.prepareStatement(SELECT_ONE_EMP);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String name = rs.getString("emp_name");
				String email= rs.getString("emp_email");
				String dept = rs.getString("emp_dept");
				emp = new Employee(id, name, email, dept);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			conn.printSQLException(e);
		}
		return emp;
	}
	
	
	
	
	public boolean deleteEmp(int id){
		boolean b=false;
		Connection con = conn.getDbConnection();
		String DELETE_EMP =" delete from Employee where id = ?";
		try{
			PreparedStatement pst = con.prepareStatement(DELETE_EMP);
			pst.setInt(1, id);
			b=pst.executeUpdate() > 0;
		}catch(SQLException e){
			conn.printSQLException(e);
		}
		return b;
	}
	
	
	
	public boolean updateEmp(Employee emp){
		boolean b=false;
		Connection con = conn.getDbConnection();
		String UPDATE_EMP =" update Employee set emp_name = ?, emp_email = ?, emp_dept=? where id = ?";
		try{
			PreparedStatement pst = con.prepareStatement(UPDATE_EMP);
			pst.setString(1, emp.getEmp_name());
			pst.setString(2, emp.getEmp_email());
			pst.setString(3, emp.getEmp_dept());
			pst.setInt(4, emp.getId());
			b=pst.executeUpdate() > 0;
		}catch(SQLException e){
			conn.printSQLException(e);
		}
		return b;
	}
	
	
	
}
