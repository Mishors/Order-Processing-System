package main;

import java.sql.*;

public class main {
	private static Connection connect = null;
	private static Statement statement = null;
	private PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object x;
		float i = (float)5.2;
		x = i;
		System.out.println(x.getClass().getSimpleName());
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connect = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/book_store?useSSL=false", "root", "admin");
//			 // Statements allow to issue SQL queries to the database
//            statement = connect.createStatement();
//            // Result set get the result of the SQL query
//            boolean test = statement
//            		.execute("insert into categories values('test')");
//            System.out.println(statement.getUpdateCount());
////                    .executeQuery("select * from book_store.books where isbn=10");
////            boolean b = statement.execute("select * from categories");
//			System.out.println("   " + test);
//			ResultSet resultSet = statement.getResultSet();
//			while(resultSet.next())
//            	System.out.println("book name: " + resultSet.getString("category"));
//            
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
