<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    h2 {
        color: #333;
    }
    form {
        width: 50%;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }
    label {
        font-weight: bold;
    }
    input[type="text"],
    input[type="number"],
    input[type="date"],
    input[type="submit"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        cursor: pointer;
    }
</style>
</head>
<body>
    <center><h2>Enter Your Details</h2></center>
    <form action="CalculateGrade.jsp" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br><br>
        
        <label for="birthDate">Birthdate:</label><br>
        <input type="date" id="birthDate" name="birthDate"><br><br>
        
        <label for="class">Class:</label><br>
        <input type="text" id="class" name="class"><br><br>
        
        <label for="percentage">Percentage:</label><br>
        <input type="number" id="percentage" name="percentage"><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
