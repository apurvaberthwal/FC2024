import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
import java.sql.*;

public class Second extends JFrame
{
    static JTextField tf1, tf2, tf3;
    static JButton b1, b2, b3, b4, b5;
    static JLabel l4;
    static Connection conn;

    Second()
    {
        JFrame f = new JFrame();
        JLabel l1 = new JLabel("Roll Number");
        JLabel l2 = new JLabel("Name");
        JLabel l3 = new JLabel("Marks");
        l4 = new JLabel();

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        b1 = new JButton("Add");
        b2 = new JButton("Delete");
        b3 = new JButton("Update");
        b4 = new JButton("Search");
        b5 = new JButton("Clear");

        l1.setBounds(140, 30, 80, 30);
        l2.setBounds(140, 80, 80, 30);
        l3.setBounds(140, 130, 80, 30);

        tf1.setBounds(250, 30, 120, 30);
        tf2.setBounds(250, 80, 120, 30);
        tf3.setBounds(250, 130, 120, 30);

        b1.setBounds(20, 200, 80, 30);
        b2.setBounds(110, 200, 80, 30);
        b3.setBounds(200, 200, 80, 30);
        b4.setBounds(290, 200, 80, 30);
        b5.setBounds(380, 200, 80, 30);

        l4.setBounds(180, 250, 200, 30);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(l4);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(e -> addRecord());
        b2.addActionListener(e -> deleteRecord());
        b3.addActionListener(e -> updateRecord());
        b4.addActionListener(e -> searchRecord());
        b5.addActionListener(e -> clearFields());

        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.28.3/ca2304", "ca2304", "");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    static void addRecord()
    {
        String rollNumber = tf1.getText();
        String name = tf2.getText();
        String marks = tf3.getText();

        if(!rollNumber.isEmpty() && !name.isEmpty() && !marks.isEmpty())
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student VALUES(?, ?, ?)");
                pstmt.setString(1, rollNumber);
                pstmt.setString(2, name);
                pstmt.setString(3, marks);
                int rowsAffected = pstmt.executeUpdate();
                if(rowsAffected > 0)
                    l4.setText("Record added successfully");
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            l4.setText("Please fill in all the fields");
        }
    }

    static void deleteRecord()
    {
        String rollNumber = tf1.getText();

        if(!rollNumber.isEmpty())
        {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete these record?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION)
            {
                try
                {
                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM student WHERE roll_number = ?");
                    pstmt.setString(1, rollNumber);
                    int rowsAffected = pstmt.executeUpdate();
                    if(rowsAffected > 0)
                        l4.setText("Record deleted successfully");
                    else
                        l4.setText("Record not found");
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            l4.setText("Please enter a roll number to delete");
        }
    }

    static void updateRecord()
    {
        String rollNumber = tf1.getText();
        String name = tf2.getText();
        String marks = tf3.getText();

        if(!rollNumber.isEmpty() && !name.isEmpty() && !marks.isEmpty())
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE student SET name = ?, total_marks = ? WHERE roll_number = ?");
                pstmt.setString(1, name);
                pstmt.setString(2, marks);
                pstmt.setString(3, rollNumber);
                int rowsAffected = pstmt.executeUpdate();
                if(rowsAffected > 0)
                    l4.setText("Record updated successfully");
                else
                    l4.setText("Record not found");
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            l4.setText("Please fill in all fields");
        }
    }

    static void searchRecord()
    {
        String rollNumber = tf1.getText();
        
        if(!rollNumber.isEmpty())
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE roll_number = ?");
                pstmt.setString(1, rollNumber);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next())
                {
                    tf2.setText(rs.getString("name"));
                    tf3.setText(rs.getString("total_marks"));
                    l4.setText("Record Found");
                }
                else
                {
                    l4.setText("Record not found");
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            l4.setText("Please enter a roll number to search");
        }
    }

    static void clearFields()
    {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        l4.setText("");
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
        new Second();
    }
}
