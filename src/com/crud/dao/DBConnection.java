package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBConnection {
	
	private String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
	private String userName = "root";
	private String password = "";
	
	
	
	public Connection getDbConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args){
		DBConnection conn = new DBConnection();
		System.out.println(conn.getDbConnection());
	}
	
	
}
