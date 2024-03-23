import java.sql.*;
import java.util.Scanner;

public class q1{

    public static void main(String[] args) throws SQLException {
	try{

        Scanner scanner = new Scanner(System.in);
	Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.28.3/ca2304","ca2304","");
        DatabaseMetaData metadata = connection.getMetaData();

        int choice;

        do {
            System.out.println("\n=====================");
            System.out.println("1.Database Details");
            System.out.println("2. List of tables in a database");
            System.out.println("3. Column information in a table");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listDatabases(metadata);
                    break;
                case 2:
                    listTables(metadata, scanner);
                    break;
                case 3:
                    listColumnInfo(metadata, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        scanner.close();
        connection.close();
	}
	catch(Exception e){
		System.out.println(e);
	}	
    }

    private static void listDatabases(DatabaseMetaData metadata) throws SQLException {
        System.out.println("\n===Database Details ===");
        System.out.println("Database product name :"+metadata.getDatabaseProductName());
	System.out.println("Database product version :"+metadata.getDatabaseProductVersion());
	System.out.println("Database driver name :"+metadata.getDriverName());
	System.out.println("Database driver version :"+metadata.getDriverVersion());
        
    }

    private static void listTables(DatabaseMetaData metadata, Scanner scanner) throws SQLException {
        System.out.print("\nEnter database name: ");
        String databaseName = scanner.next();

        System.out.println("\n=== List of Tables in " + databaseName + " ===");
        ResultSet tables = metadata.getTables(databaseName,null, null, null);
        while (tables.next()) {
            System.out.println(tables.getString("TABLE_NAME"));
        }
        tables.close();
    }

    private static void listColumnInfo(DatabaseMetaData metadata, Scanner scanner) throws SQLException {
        System.out.print("\nEnter database name: ");
        String databaseName = scanner.next();

        System.out.print("\nEnter table name: ");
        String tableName = scanner.next();

        System.out.println("\n=== Column Information in " + tableName + " ===");
        ResultSet columns = metadata.getColumns(databaseName,null, tableName, null);
        while (columns.next()) {
            System.out.println("Column Name: " + columns.getString("COLUMN_NAME"));
            System.out.println("Data Type: " + columns.getString("DATA_TYPE"));
            System.out.println("Nullable: " + columns.getString("IS_NULLABLE"));
            
            System.out.println("----");
        }
        columns.close();
    }
}
