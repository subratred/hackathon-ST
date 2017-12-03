package com.hackathon.ShipmentTracker.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShipmentTrackDAOImpl implements ShipmentTrackDAO{
	DBConnection dbConnection=new DBConnection();
	Connection conn=null;
	Statement stmt = null;
	
	public String getConnection() throws ClassNotFoundException{
		conn = dbConnection.getConnection(); 
		try { 
			//STEP 3: Execute a query 
			System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement(); 
			String sql =  "CREATE TABLE   REGISTRATION123 " + 
					"(id INTEGER not NULL, " + 
					" first VARCHAR(255), " +  
					" last VARCHAR(255), " +  
					" age INTEGER, " +  
					" PRIMARY KEY ( id ))";  
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database..."); 

			// STEP 4: Clean-up environment 
			stmt.close(); 
			conn.close(); 
		} catch(SQLException se) { 
			//Handle errors for JDBC 
			se.printStackTrace(); 
		}finally { 
			//finally block used to close resources 
			try{ 
				if(stmt!=null) stmt.close(); 
			} catch(SQLException se2) { 
			} // nothing we can do 
			try { 
				if(conn!=null) conn.close(); 
			} catch(SQLException se){ 
				se.printStackTrace(); 
			} //end finally try 
		} //end try 
		System.out.println("Goodbye!");
		return null; 
	}
	
	public Object getData() throws ClassNotFoundException, SQLException{
		JdbcTemplate jdbcTemplate = null;
		System.out.println("Fetch Data from table in given database..."); 
		conn = dbConnection.getConnection(); 
		stmt = conn.createStatement();
		String sql="SELECT * FROM PROD_DETAILS";
//		Object object=stmt.executeQuery(sql);
		Object object=jdbcTemplate.queryForList(sql);
		System.out.println(object);
		
		return object;
	}
}
