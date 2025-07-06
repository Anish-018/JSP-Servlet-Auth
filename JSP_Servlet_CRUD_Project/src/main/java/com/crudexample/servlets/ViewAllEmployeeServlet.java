package com.crudexample.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.crudexample.daoimpl.EmployeeDaoImpl;
import com.crudexample.pojo.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllEmployeeServlet") 
public class ViewAllEmployeeServlet extends HttpServlet { 

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        List<Employee> list = dao.getAllEmployees();
        resp.setContentType("text/html");
 
        PrintWriter out = resp.getWriter();
        out.print("<h2>All Employee Records</h2>");
        out.print("<table border='1'><tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th><th>Address</th><th>Action</th></tr>");
        for (Employee e : list) {
            out.print("<tr><td>" + e.getEmpId() + "</td><td>" + e.getEmpName() + "</td><td>" + e.getEmpEmail()
                    + "</td><td>" + e.getEmpPassword() + "</td><td>" + e.getEmpAddress()
                    + "</td><td><a href='EditEmployeeServlet?id=" + e.getEmpId() + "'>Edit</a> | "
                    + "<a href='DeleteEmployeeServlet?id=" + e.getEmpId() + "'>Delete</a></td></tr>");
        }
        out.print("</table>");
        

		
	    out.print("<html><body>");
	    out.print("<br><form action = 'register.jsp'>");
	    out.print("<input type = 'submit' value = 'Register New Employee'> ");
	    out.print("</form>");
	    out.print("<form action = 'login.jsp'>");
	    out.print("<input type = 'submit' value = 'Login Employee'> ");
	    out.print("</form>");
	    out.print("<form action = 'SearchByNameServlet'>");
	    out.print("<input type = 'submit' value = 'Search Employee By Name'> ");
	    out.print("</form>");
	    out.print("<button onclick='history.back()'>Go Back</button>");
	    out.print("</body></html>");

    }
}