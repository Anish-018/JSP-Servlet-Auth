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

@WebServlet("/SearchByNameServlet")
public class SearchByNameServlet extends HttpServlet{ 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 EmployeeDaoImpl dao = new EmployeeDaoImpl();
		 Employee e = new Employee();
		 resp.setContentType("text/html");
		 String uname = req.getParameter("uname");

		 
	     PrintWriter out = resp.getWriter(); 
	     
	     out.print("<form action='ResultByNameServlet' method='get'>");
	     out.print("Enter Employee Name: <input type='text' name='uname' required><br>");
	     out.print("<br><input type='submit' value='Search'>");
	     out.print("</form>");
	     out.print("<form>");
	     out.print("<input type='button' value='Go Back' onclick='history.back()'>");
	     out.print("</form>");
	     

			
	}

}
