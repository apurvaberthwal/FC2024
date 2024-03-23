import java.sql.*;
import java.util.*;
import java.io.*;

class book{

	public static void main(String args[])
	{

		Connection conn=null;
		Statement stmt =null;
		PreparedStatement ps=null;
		ResultSet rs=null;


	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.28.3/ca2304","ca2304","");
		if(conn==null)
		System.out.println("Connection Failed");
		else{
				System.out.println("Connection successful");
				stmt=conn.createStatement();
				
				stmt.executeUpdate("Create table if not exists Book(book_name varchar(250),author varchar(250),ISBN varchar(250),price int)");
				System.out.println("Table creaTED");
		

	 int num,price;
	String name,author,isbn;
		System.out.println("Enter number of records to insserted");
		Scanner sc = new  Scanner(System.in);
		num=sc.nextInt();
		while(num>0){
			System.out.println("Enter book name");
			name=sc.next();
			System.out.println("Enter author");
			author=sc.nextLine();
			System.out.println("Enter Isbn");
			isbn=sc.nextLine();
			System.out.println("Enter price");
			price=sc.nextInt();
			System.out.println(name);
			System.out.println(author);
			System.out.println(isbn);
			System.out.println(price);

	
			String sq="insert into Book values(?,?,?,?)";
			 ps = conn.prepareStatement(sq);
			ps.setString(1,name);
			ps.setString(2,author);
			ps.setString(3,isbn);
			ps.setInt(4,price);
			ps.executeUpdate();
			num--;


				
		}
			stmt=conn.createStatement();
				rs=stmt.executeQuery("Select * from Book");

				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				while (rs.next())
				{
					System.out.println("Book Name= "+rs.getString(1));
					System.out.println("Author NAme= "+rs.getString(2));
System.out.println("ISBN= "+rs.getString(3));
System.out.println("Price= "+rs.getInt(4));
				}
System.out.println("---------------------------------------------------------------------------------------------------------------------");


	conn.close();
		

		}
		
		

	
	}
	catch(Exception e){
		System.out.println(e);
	}
}
}
