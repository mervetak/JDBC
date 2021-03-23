package JDBC_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test2 {

	public static void main(String[] args) {
		
		// jdbc:mysql://localhost:3306/databasename
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String url = "jdbc:mysql://localhost:3306/amazon_books";
		String username = "root";
		String password = "11221122";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			
			String select = "select * from books;";
			System.out.println("The SQL Query is " + select);
			
			resultSet = statement.executeQuery(select);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("title") + " - " + resultSet.getString("author_fname")+ " - "
						+resultSet.getString("author_lname"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
}
	
}
