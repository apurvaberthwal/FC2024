<%@ page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File List</title>
</head>
<body>
    <h1>File List</h1>
    <form method="post" action="">
        Enter file extension: <input type="text" name="extension">
        <input type="submit" value="List Files">
    </form>
    <hr>
    <% 
        String extension = request.getParameter("extension");
        if (extension != null && !extension.isEmpty()) {
            String currentDir = "/exportspg/ca2304/tomcat/webapps/file";
            File dir = new File(currentDir);
            File[] files = dir.listFiles();
            boolean found = false; 
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith("." + extension)) {
                        found = true; 
    %>
                        <a href="<%= file.getName() %>"><%= file.getName() %></a><br>
    <%
                    }
                }
            }
            if (!found) { 
    %>
                <h3>No files found with extension <%= extension %></h3>
    <%
            }
        }
    %>
</body>
</html>

