package hackathon.ShipmentTrack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/test";  
	   //  Database credentials 
	   static final String USER = "root"; 
	   static final String PASS = "root"; 
	   
	   public Connection getConnection() throws ClassNotFoundException{
	   Connection conn = null;  
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	             
	         //STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      }
	      catch(SQLException se) { 
		         //Handle errors for JDBC 
		         se.printStackTrace(); 
		      }
		return conn; 
	   }
}

