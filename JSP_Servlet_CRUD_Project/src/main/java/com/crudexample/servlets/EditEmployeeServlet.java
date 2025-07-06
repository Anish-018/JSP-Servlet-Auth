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

@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        Employee e = dao.getEmployeeById(id);
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print("<form action='UpdateEmployeeServlet' method='post'>");
        out.print("<input type='hidden' name='id' value='" + e.getEmpId() + "'/>");
        out.print("Name: <input type='text' name='name' value='" + e.getEmpName() + "'/><br>");
        out.print("Email: <input type='email' name='email' value='" + e.getEmpEmail() + "'/><br>");
        out.print("Password: <input type='password' name='password' value='" + e.getEmpPassword() + "'/><br>");
        out.print("Address: <input type='text' name='address' value='" + e.getEmpAddress() + "'/><br>");
        out.print("<input type='submit' value='Update'/>");
        out.print("</form>");
    }
}