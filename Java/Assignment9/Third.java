import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Third extends JFrame
{
    JTable studentTable;
    DefaultTableModel tableModel;
    Third()
    {
        JFrame f = new JFrame();
        f.setTitle("Student Records");
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Roll Number");
        tableModel.addColumn("Name");
        tableModel.addColumn("Total Marks");

        studentTable = new JTable(tableModel);

        JScrollPane sp = new JScrollPane(studentTable);

        //getContentPane().add(sp, BorderLayout.CENTER);
        f.add(sp, BorderLayout.CENTER);

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.28.3/ca2304", "ca2304", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while(rs.next())
            {
                String rollNumber = rs.getString("roll_number");
                String name = rs.getString("name");
                String marks = rs.getString("total_marks");

                tableModel.addRow(new String[]{rollNumber, name, marks});
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        new Third();
    }
}
