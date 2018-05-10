package main;

import java.sql.*;

public class main {
	private static Connection connect = null;
	private static Statement statement = null;
	private PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/book_store?useSSL=false", "root", "admin");
			 // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from book_store.books where isbn=10");
			System.out.println(resultSet.first());
            while(resultSet.next())
            	System.out.println("book name: " + resultSet.getString("title"));
            
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
