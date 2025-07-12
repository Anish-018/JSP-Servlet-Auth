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

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String address = req.getParameter("address");

        Employee e = new Employee();
        e.setEmpId(id);
        e.setEmpName(name);
        e.setEmpEmail(email);
        e.setEmpPassword(password);
        e.setEmpAddress(address);

        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        boolean updated = dao.updateEmployee(e);

        PrintWriter out = resp.getWriter();
        if (updated) {
            resp.sendRedirect("ViewAllEmployeeServlet");
        } else {
            out.print("Update failed");
        }
    }
}





