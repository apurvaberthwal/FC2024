<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Text Operation</title>
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
    <center><h2>Text Operation</h2></center>
    <form action="ProcessText.jsp" method="post">
        <label for="text">Text Line:</label><br>
        <input type="text" id="text" name="text"><br><br>
        
        <label for="operation">Operation:</label><br>
        <select id="operation" name="operation">
            <option value="upper">Convert to Uppercase</option>
            <option value="lower">Convert to Lowercase</option>
            <option value="search">Search Substring</option>
            <option value="count">Count Substring</option>
            <option value="replace">Replace Substring</option>
        </select><br><br>

        <label for="searchString">Search String:</label><br>
        <input type="text" id="searchString" name="searchString"><br><br>

        <label for="replaceString">Replace String:</label><br>
        <input type="text" id="replaceString" name="replaceString"><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
