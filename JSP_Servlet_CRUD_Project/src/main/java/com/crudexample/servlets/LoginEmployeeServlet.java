package com.crudexample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.crudexample.daoimpl.EmployeeDaoImpl;
import com.crudexample.pojo.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginEmployeeServlet")
public class LoginEmployeeServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			PrintWriter out = resp.getWriter(); 
			
			Employee e = new Employee();
			
			resp.setContentType("text/html");
			
			
			String email = req.getParameter("E1");
		    String password = req.getParameter("P1");

		    e.setEmpEmail(email);
		    e.setEmpPassword(password);

		    EmployeeDaoImpl edi =new EmployeeDaoImpl();
		    boolean flag = edi.loginEmployee(e);
		    

		    if (flag) {
		    	out.print("Login Successful");
		} else {
			out.print("Invalid Email Id or Password");
		}
	}
}
