package com.crudexample.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudexample.pojo.Employee;
import com.crudexample.utility.DBConnection;

public class EmployeeDaoImpl {
	
	
	Connection conn;
	
	PreparedStatement ps;
	
	String registerQuery;
	
	int row;
	
	public boolean registerEmployee(Employee e)
	{
		
		try {
			
			registerQuery = "INSERT INTO users(uname, uemail, upassword, uaddress)VALUES(?,?,?,?)";
			conn = DBConnection.establishConnection();
			
			ps =  conn.prepareStatement(registerQuery);
			
			ps.setString(1, e.getEmpName()); 
			ps.setString(2, e.getEmpEmail());
			ps.setString(3, e.getEmpPassword());
			ps.setString(4, e.getEmpAddress());
			
			row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return false;
		
	}
	
	
	public boolean loginEmployee(Employee e) {
         try {
         	 String email = e.getEmpEmail();
             String password = e.getEmpPassword();
             String registerQuery = "SELECT * FROM users WHERE uemail=? AND upassword=?";
             conn = DBConnection.establishConnection();
             ps = conn.prepareStatement(registerQuery);
             ps.setString(1, email);
             ps.setString(2, password); 
             ResultSet rs = ps.executeQuery(); 
             
             if (rs.next()) {
             	return true;                 	
             } else 
             {
             	return false;
             }                
             
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         return false;
     }
	
	
	 
	public List<Employee> getAllEmployees() {
	    List<Employee> employees = new ArrayList<>();
	    try {
	        conn = DBConnection.establishConnection();
	        String query = "SELECT * FROM users";
	        ps = conn.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Employee e = new Employee();
	            e.setEmpId(rs.getInt("uid"));
	            e.setEmpName(rs.getString("uname"));
	            e.setEmpEmail(rs.getString("uemail"));
	            e.setEmpPassword(rs.getString("upassword"));
	            e.setEmpAddress(rs.getString("uaddress"));
	            employees.add(e);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return employees;
	}
	
	
	public Employee getEmployeeById(int id) {
	    Employee e = new Employee();
	    try {
	        conn = DBConnection.establishConnection();
	        String query = "SELECT * FROM users WHERE uid=?";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            e.setEmpId(rs.getInt("uid"));
	            e.setEmpName(rs.getString("uname"));
	            e.setEmpEmail(rs.getString("uemail"));
	            e.setEmpPassword(rs.getString("upassword"));
	            e.setEmpAddress(rs.getString("uaddress"));
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return e;
	}
	
	
	
	
	public boolean updateEmployee(Employee e) {
	    try {
	        conn = DBConnection.establishConnection();
	        String query = "UPDATE users SET uname=?, uemail=?, upassword=?, uaddress=? WHERE uid=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, e.getEmpName());
	        ps.setString(2, e.getEmpEmail());
	        ps.setString(3, e.getEmpPassword());
	        ps.setString(4, e.getEmpAddress());
	        ps.setInt(5, e.getEmpId());

	        int rows = ps.executeUpdate();
	        return rows > 0;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
	
	
	public boolean deleteEmployee(int id) {
	    try {
	        conn = DBConnection.establishConnection();
	        String query = "DELETE FROM users WHERE uid=?";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);

	        int rows = ps.executeUpdate();
	        return rows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	
	 	public List<Employee> displayByName(String uname) {
	 		List<Employee> employees = new ArrayList<>();
	 		String query = "SELECT * FROM users WHERE uname=?";
	    
	 		try {
	 			conn = DBConnection.establishConnection();
	 			ps = conn.prepareStatement(query);
	 			ps.setString(1, uname);
	 			ResultSet rs = ps.executeQuery();

	 			while (rs.next()) {
	 				Employee e = new Employee();
	 				e.setEmpId(rs.getInt("uid"));
	 				e.setEmpName(rs.getString("uname"));
	 				e.setEmpEmail(rs.getString("uemail"));
	 				e.setEmpPassword(rs.getString("upassword"));
	 				e.setEmpAddress(rs.getString("uaddress"));
	 				employees.add(e);
	 			}
	 		} catch (ClassNotFoundException | SQLException e1) {
	 			e1.printStackTrace();
	 		}

	 		return employees;
	 	}
}