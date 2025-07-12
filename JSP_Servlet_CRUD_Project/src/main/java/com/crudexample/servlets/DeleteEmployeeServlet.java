package com.crudexample.servlets;
import java.io.IOException;

import com.crudexample.daoimpl.EmployeeDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployeeServlet") 
public class DeleteEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        boolean deleted = dao.deleteEmployee(id);

        if (deleted) {
            resp.sendRedirect("ViewAllEmployeeServlet");
        } else {
            resp.getWriter().print("Failed to delete employee");
        }
    }
}