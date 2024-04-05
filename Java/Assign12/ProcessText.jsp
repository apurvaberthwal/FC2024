<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Strings.TextCaseConverter" %>
<%@ page import="Strings.TextSubstring" %>
<%@ page import="Strings.TextReplace" %>
<%
    String text = request.getParameter("text");
    String operation = request.getParameter("operation");
    String searchString = request.getParameter("searchString");
    String replaceString = request.getParameter("replaceString");
    String result = "";

    if (text != null && !text.isEmpty()) {
        switch (operation) {
            case "upper":
                result = TextCaseConverter.convertToUpperCase(text);
                break;
            case "lower":
                result = TextCaseConverter.convertToLowerCase(text);
                break;
            case "search":
                result = TextSubstring.containsSubstring(text, searchString) ? "Substring found" : "Substring not found";
                break;
            case "count":
                result = "Substring count: " + TextSubstring.countSubstring(text, searchString);
                break;
            case "replace":
                result = TextReplace.replaceSubstring(text, searchString, replaceString);
                break;
            default:
                result = "Invalid operation";
        }
    } else {
        result = "Please enter a text line";
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Text Operation Result</title>
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
    p {
        margin-bottom: 10px;
    }
</style>
</head>
<body>
    <center><h2>Text Operation Result</h2></center>
    <p><%= result %></p>
</body>
</html>
