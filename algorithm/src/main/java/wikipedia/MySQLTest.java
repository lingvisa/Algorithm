package wikipedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class MySQLTest {
 
  public static void main(String[] argv) {
		
	Connection connection = null;
 
	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/","bword", "bword");
 
	} catch (SQLException e) {
		System.out.println("Connection Failed!");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("Successful!");
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}
