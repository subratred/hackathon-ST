package com.hackathon.ShipmentTracker.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hackathon.ShipmentTracker.model.OrderStats;

@Component
public class ShipmentTrackDAOImpl implements ShipmentTrackDAO{
	JdbcTemplate jdbcTemplate = null;
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
		
		System.out.println("Fetch Data from table in given database..."); 
		conn = dbConnection.getConnection(); 
		stmt = conn.createStatement();
		String sql="SELECT * FROM PROD_DETAILS";
		Object object=stmt.executeQuery(sql);
//		Object object=jdbcTemplate.queryForList(sql);
//		System.out.println(object);
		
		return null;
	}

	@Override
	public List<String> fetchDistinctLocation() throws Exception {
		String query="SELECT DISTINCT LOCATION FROM TABLE_NAME";
		List<String> locations=jdbcTemplate.queryForList(query, String.class);
		return locations;
	}

	@Override
	public List<OrderStats> saveOrders() throws Exception {
		String query="INSERT INTO TABLE_NAME (USER_ID,MOBILE_NO,LOCATION) VALUES (?,?,?)";
		List<Map<String,Object>> objects=jdbcTemplate.queryForList(query);
		OrderStats orderStats=new OrderStats();
		for(Map<String,Object> object:objects) {
		orderStats.setDestination(object.get("DESTINATION").toString());
		orderStats.setSource(object.get("SOURCE").toString());
		orderStats.setRemarks(object.get("REMARKS").toString());
		orderStats.setMobileNo(Long.parseLong(object.get("MOBILE_NO").toString()));
		orderStats.setOrderNumber(Long.parseLong(object.get("ORDER_NO").toString()));
		}
		return null;
	}

	@Override
	public List<OrderStats> openOrders() throws Exception {
		String query="SELECT * FROM TABLE_NAME WHERE USER='USER1' WHERE STATUS='OPEN'";
		List<Map<String,Object>> objects=jdbcTemplate.queryForList(query);
		OrderStats orderStats=new OrderStats();
		for(Map<String,Object> object:objects) {
		orderStats.setDestination(object.get("DESTINATION").toString());
		orderStats.setSource(object.get("SOURCE").toString());
		orderStats.setRemarks(object.get("REMARKS").toString());
		orderStats.setMobileNo(Long.parseLong(object.get("MOBILE_NO").toString()));
		orderStats.setOrderNumber(Long.parseLong(object.get("ORDER_NO").toString()));
		}
		return null;
	}

	@Override
	public Map<String,Object> orderDetails() throws Exception {
		String query="SELECT * FROM TABLE_NAME WHERE USER='USER1' WHERE STATUS='OPEN'";
		List<Map<String,Object>> objects=jdbcTemplate.queryForList(query);
//		OrderStats orderStats=new OrderStats();
		for(Map<String,Object> object:objects) {
			return object;
		}
		return null;
	}

	@Override
	public List<String> cancelOrder(Long orderNumber) throws Exception {
		String query="UPDATE TABLE_NAME SET STATUS='CANCEL' WHERE USER='USER1' AND STATUS='OPEN'";
		
		return null;
	}
}
