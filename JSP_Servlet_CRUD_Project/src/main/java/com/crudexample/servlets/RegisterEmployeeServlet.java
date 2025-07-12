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

@WebServlet("/RegisterEmployeeServlet")
public class RegisterEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter(); 
		
		Employee e = new Employee(); 
		
		resp.setContentType("text/html");
		
		EmployeeDaoImpl edi =new EmployeeDaoImpl();
		
		boolean flag;
		
		String name, email, password, address, cpassword;
		
		name = req.getParameter("t1");
		
		email = req.getParameter("e1");
		
		password = req.getParameter("p1");
		
		cpassword = req.getParameter("p2");
		
		address = req.getParameter("t2");
		
		if(password.equals(cpassword)) {
		e.setEmpName(name);
		e.setEmpEmail(email);
		e.setEmpPassword(password);
		e.setEmpAddress(address);
		
		
		flag = edi.registerEmployee(e);
		
		if(flag)
		{
			out.print("Registration Successfull");
		}
		else
		{
			out.print("This Email-Id is already registered");
		}
		
	}else {
		out.print("Password does not match!!!");
	}
  }
}
