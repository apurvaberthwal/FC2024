import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class First extends JFrame implements ActionListener
{
    JTextField tf1, tf2, tf3, tf4;
    JButton b1, b2, b3, b4;
    Connection conn;
    ResultSet rs;
    int totalRecords = 0;
    int currentRecordIndex = 0;

    First()
    {
        JFrame f = new JFrame();
        JLabel l1 = new JLabel("Roll Number");
        JLabel l2 = new JLabel("Name");
        JLabel l3 = new JLabel("Total Marks");
        JLabel l4 = new JLabel("Record Number");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();

        b1 = new JButton("<< First");
        b2 = new JButton("< Previous");
        b3 = new JButton("Next >");
        b4 = new JButton("Last >>");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        l1.setBounds(140, 30, 80, 30);
        l2.setBounds(140, 80, 80, 30);
        l3.setBounds(140, 130, 80, 30);
        l4.setBounds(140, 180, 100, 30);

        tf1.setBounds(250, 30, 120, 30);
        tf2.setBounds(250, 80, 120, 30);
        tf3.setBounds(250, 130, 120, 30);
        tf4.setBounds(250, 180, 120, 30);

        b1.setBounds(20, 250, 100, 30);
        b2.setBounds(130, 250, 100, 30);
        b3.setBounds(240, 250, 100, 30);
        b4.setBounds(350, 250, 100, 30);

        //b1.setIcon(createArrowIcon(80, 30, Color.BLACK));

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(tf4);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.28.3/ca2304", "ca2304", "");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM student");

            rs.last();
            totalRecords = rs.getRow();
            rs.beforeFirst();

            if(rs.next())
            {
                displayRecord();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No record found in the database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource() == b1)
            {
                if(rs.first())
                {
                    currentRecordIndex = 0;
                    displayRecord();
                }
            }
            else if(e.getSource() == b2)
            {
                if(rs.previous())
                {
                    currentRecordIndex--;
                    displayRecord();
                }
            }
            else if(e.getSource() == b3)
            {
                if(rs.next())
                {
                    currentRecordIndex++;
                    displayRecord();
                }
            }
            else if(e.getSource() == b4)
            {
                if(rs.last())
                {
                    currentRecordIndex = totalRecords - 1;
                    displayRecord();
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    void displayRecord()
    {
        try
        {
            int rollNumber = rs.getInt("roll_number");
            String name = rs.getString("name");
            int totalMarks = rs.getInt("total_marks");

            tf1.setText(String.valueOf(rollNumber));
            tf2.setText(name);
            tf3.setText(String.valueOf(totalMarks));
            tf4.setText((currentRecordIndex + 1) + " of " + totalRecords);
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
        new First();
    }

