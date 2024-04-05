<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<%
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String address = request.getParameter("address");
    String contact = request.getParameter("contact");
	

    Connection conn = null;
    PreparedStatement ps = null;

    try {
       
        Class.forName("com.mysql.jdbc.Driver");
       conn=DriverManager.getConnection("jdbc:mysql://192.168.28.3/ca2304","ca2304","");
        ps = conn.prepareStatement("INSERT INTO login (first_name, last_name, username, password, address, contact) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, username);
        ps.setString(4, password);
        ps.setString(5, address);
        ps.setString(6, contact);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            out.println("<h2>Welcome, " + firstName + "!</h2>");
        } else {
            out.println("<h2>Registration failed.</h2>");
        }

    } catch (Exception e) {
        out.println("<h2>Error: " + e.getMessage() + "</h2>");
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            out.println("<h2>Error in closing resources: " + ex.getMessage() + "</h2>");
        }
    }

%>

