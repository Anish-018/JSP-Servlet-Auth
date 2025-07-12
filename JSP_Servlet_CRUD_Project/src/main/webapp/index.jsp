<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            text-align: center;
            padding-top: 100px;
        }

        h1 {
            color: #333;
        }

        .button {
            display: inline-block;
            margin: 20px;
            padding: 15px 30px;
            font-size: 16px;
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            border-radius: 8px;
        }

        .button:hover {
            background-color: #0056b3;
        }

        footer {
            margin-top: 100px;
            color: gray;
        }
    </style>
    
</head>
<body>
   <h1>Welcome to Employee Management System</h1>

    <a href="register.jsp" class="button">Register New Employee</a>
    <a href="login.jsp" class="button">Login Employee</a>
    <a href="ViewAllEmployeeServlet" class="button">View All Employees</a>

    <footer>
        <p>&copy; 2025 CRUD Example. All rights reserved.</p>
    </footer>

</body>
</html>