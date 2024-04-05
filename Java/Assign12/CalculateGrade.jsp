<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeParseException" %>
<%@ page import="Calculator.AgeCalculator" %>
<%@ page import="Calculator.GradeCalculator" %>
<%
    String name = request.getParameter("name");
    String birthDateParam = request.getParameter("birthDate");
    LocalDate birthDate = null;
    if (birthDateParam != null && !birthDateParam.isEmpty()) {
        try {
            birthDate = LocalDate.parse(birthDateParam);
        } catch (DateTimeParseException e) {
            // Handle parsing exception
            e.printStackTrace();
        }
    }
    String userClass = request.getParameter("class");
    double percentage = Double.parseDouble(request.getParameter("percentage"));
    int age = (birthDate != null) ? AgeCalculator.calculateAge(birthDate) : 0;
    String grade = GradeCalculator.calculateGrade(percentage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Greeting</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px auto;
        padding: 20px;
        background-color: #f0f0f0;
        width: 50%;
        text-align: center;
        border: 2px solid #333;
        border-radius: 5px;
    }
    h2 {
        color: #333;
    }
    p {
        margin-bottom: 10px;
    }
    .error {
        color: red;
        font-weight: bold;
    }
    .message {
        color: #007bff;
        font-weight: bold;
    }
    span {
        font-size: 24px;
        background-color: #f8f9fa;
        padding: 5px 10px;
        border-radius: 5px;
    }
    /* New styles */
    .result {
        margin-top: 20px;
        font-size: 18px;
    }
    .result span {
        font-weight: bold;
    }
</style>
</head>
<body>
    <h2>Greeting</h2>
    <p>Hello <span><%= name %>,</span></p>
    <% if (birthDate != null) { %>
        <p>Your age is <span><%= age %> years.</span></p>
    <% } else { %>
        <p class="error">Invalid birthdate format.</p>
    <% } %>
    <p>Your grade is <span><%= grade %>.</span></p>
</body>
</html>
