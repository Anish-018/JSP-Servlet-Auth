<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding-top: 50px;
    }

    form {
        background-color: #fff;
        padding: 20px;
        margin: -2px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0 16px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 6px;
        box-sizing: border-box;
    }

    input[type="submit"],
    input[type="button"] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 12px;
        margin-top: 10px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover,
    input[type="button"]:hover {
        background-color: #45a049;
    }

    .button-row {
        display: flex;
        justify-content: center;
        gap: 15px;
        margin-top: 20px;
    }

    .button-row form {
        width: auto;
    }

    .button-row input[type="submit"],
    .button-row input[type="button"] {
        width: auto;
        padding: 10px 20px;
    }
</style>
</head>
<body>

<form action="RegisterEmployeeServlet">
    <label>Name:</label>
    <input type="text" name="t1" placeholder="Enter Your Name" required>

    <label>EmailId:</label>
    <input type="email" name="e1" placeholder="Enter Email ID" required>

    <label>Password:</label>
    <input type="password" name="p1" placeholder="Enter Password" required>
    
    <label>Confirm Password:</label>
    <input type="password" name="p2" placeholder="Enter Confirm Password" required>

    <label>Address:</label>
    <input type="text" name="t2" placeholder="Enter Address" required>

    <input type="submit" value="Submit">
</form>

<div class="button-row">

    <form action="login.jsp">
        <input type="submit" value="Login Employee">
    </form>
    
    <form action="ViewAllEmployeeServlet">
        <input type="submit" value="View All Employees">
    </form>

    <form>
        <input type="button" value="Go Back" onclick="history.back()">
    </form>
</div>

</body>
</html>
