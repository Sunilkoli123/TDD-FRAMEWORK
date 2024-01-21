package practice;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {
	public static void main(String[] args) throws SQLException {
		
	
	//create driver object import from mysql
	Driver driverRef= new Driver();
	
	
	// Step 1: register the database/driver
	
	DriverManager.registerDriver(driverRef);
	// step 2: get the connection with 
DriverManager.getConnection("", "root", "root");
	// step 3 : issue create statement
	// step 4: execute a query
	// step 5: close the DB
	}
}
