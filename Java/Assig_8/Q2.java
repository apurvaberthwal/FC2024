import java.sql.*;
import java.util.Scanner;

public class Q2{

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.28.3/ca2304";
    static final String USER = "ca2304";
    static final String PASS = "";

    static Connection conn = null;
    static Statement stmt = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.28.3/ca2304", "ca2304", "");
            stmt = conn.createStatement();

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student Alumni");
                System.out.println("2. Delete Student Alumni");
                System.out.println("3. Update Student Alumni");
                System.out.println("4. Search Student Alumni");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        addStudentAlumni();
                        break;
                    case 2:
                        deleteStudentAlumni();
                        break;
                    case 3:
                        updateStudentAlumni();
                        break;
                    case 4:
                        searchStudentAlumni();
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        conn.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	static void show() throws SQLException{

		String sql = "Select * from Student_Alumni";
		ResultSet rs = stmt.executeQuery(sql);

       		if (rs.next()) {
		    System.out.println("Name: " + rs.getString("Name"));
		    System.out.println("Address: " + rs.getString("Address"));
		    System.out.println("Designation: " + rs.getString("Designation"));
		    System.out.println("Contact No.: " + rs.getString("Contact_num"));
		    System.out.println("Email: " + rs.getString("Email"));
		    System.out.println("Year: " + rs.getInt("Year"));
			
}else {System.out.println("No Data Available");
}
}




    static void addStudentAlumni() throws SQLException {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        System.out.println("Enter Designation:");
        String designation = scanner.nextLine();

        System.out.println("Enter Contact No.:");
        String contact_No = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        System.out.println("Enter Year:");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        String sql = "INSERT INTO Student_Alumni (Name, Address,Designation, Contact_num, Email, Year) " +
                "VALUES ('" + name + "', '" + address + "', '" + designation + "', '" + contact_No + "', '" + email + "', " + year + ")";
        stmt.executeUpdate(sql);
        System.out.println("Student Alumni added successfully.");
	show();
    }

    static void deleteStudentAlumni() throws SQLException {
        System.out.println("Enter Name to delete:");
        String name = scanner.nextLine();

        String sql = "DELETE FROM Student_Alumni WHERE Name='" + name + "'";
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected > 0)
            System.out.println("Student Alumni deleted successfully.");
		
        else
            System.out.println("Student Alumni not found.");
	show();
	
    }

    static void updateStudentAlumni() throws SQLException {
        System.out.println("Enter Name to update:");
        String name = scanner.nextLine();

        System.out.println("Enter New Name:");
        String newName = scanner.nextLine();

        System.out.println("Enter New Address:");
        String newAddress = scanner.nextLine();

        System.out.println("Enter New Designation:");
        String newDesignation = scanner.nextLine();

        System.out.println("Enter New Contact No.:");
        String newContactNo = scanner.nextLine();

        System.out.println("Enter New Email:");
        String newEmail = scanner.nextLine();

        System.out.println("Enter New Year:");
        int newYear = scanner.nextInt();

        String sql = "UPDATE Student_Alumni SET Name='" + newName + "',Address='" + newAddress + "',Designation='" + newDesignation +
                "', Contact_num='" + newContactNo + "',Email='" + newEmail + "', Year=" + newYear +
                " WHERE Name='" + name + "'";
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected > 0)
            System.out.println("Student Alumni updated successfully.");
        else
            System.out.println("Student Alumni not found.");
	show();
    }

    static void searchStudentAlumni() throws SQLException {
        System.out.println("Enter Name to search:");
        String name = scanner.nextLine();

        String sql = "SELECT * FROM Student_Alumni WHERE Name='" + name + "'";
        ResultSet rs = stmt.executeQuery(sql);
	if (rs.next()){
	rs.previous();
        while (rs.next()) {
            System.out.println("\n Name: " + rs.getString("Name"));
            System.out.println("Address: " + rs.getString("Address"));
            System.out.println("Designation: " + rs.getString("Designation"));
            System.out.println("Contact No.: " + rs.getString("Contact_num"));
            System.out.println("Email: " + rs.getString("Email"));
            System.out.println("Year: " + rs.getInt("Year"));}
        } else {
            System.out.println("Student Alumni not found.");
        }
    }
}
