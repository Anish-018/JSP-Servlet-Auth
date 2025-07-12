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

@WebServlet("/ResultByNameServlet")
public class ResultByNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        resp.setContentType("text/html");
        String uname = req.getParameter("uname");
        PrintWriter out = resp.getWriter();

        List<Employee> employees = dao.displayByName(uname);

        if (employees.isEmpty()) {
            out.println("No Employees Found"); 
        } else {
            for (Employee e : employees) {
                out.println("<br>ID: " + e.getEmpId() + "<br>" +
                            "Name: " + e.getEmpName() + "<br>" +
                            "Email: " + e.getEmpEmail() + "<br>" +
                            "Password: " + e.getEmpPassword() + "<br>" +
                            "Address: " + e.getEmpAddress() + "<br>");
            }
        }
    }
}