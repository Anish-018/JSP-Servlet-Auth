package com.crudexample.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection establishConnection() throws ClassNotFoundException, SQLException
	{
		String url,user,password;
		url = "jdbc:mysql://localhost:3306/jsp_servlet_crud_project";
		user = "root";
		password = "Root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,password);
		
		return conn;
	}

}
