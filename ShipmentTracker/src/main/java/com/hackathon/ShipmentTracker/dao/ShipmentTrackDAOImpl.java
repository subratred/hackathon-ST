package com.hackathon.ShipmentTracker.dao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hackathon.ShipmentTracker.model.OrderStats;
import com.hackathon.ShipmentTracker.model.ProdInfo;
import com.hackathon.ShipmentTracker.model.ProdTrackDetails;

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
			String sql =  "CREATE TABLE   REGISTRATION456 " + 
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
		HashMap<String,Object> row=new HashMap<String,Object>();
		List<Object> response=new ArrayList<>();
		//Object object = null;
		try {
			//System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement();
			String sql="SELECT * FROM PROD_INFO ";
			ResultSet object=stmt.executeQuery(sql);
			ResultSetMetaData md = object.getMetaData();
			 int columns = md.getColumnCount();
			 
			  while (object.next()) {
				  ProdInfo prodInfo=new ProdInfo();
				  prodInfo.setKey(Integer.parseInt(object.getString("ID")));
				  prodInfo.setArea(object.getString("LOCATION"));
				  prodInfo.setLatitude(Integer.parseInt(object.getString("LATITUDE")));
				  prodInfo.setLongitude(Integer.parseInt(object.getString("LONGITUDE")));
				  prodInfo.setStatus(object.getString("STATUS"));
//			     for (int i = 1; i <= columns; i++) {
////			       row.put(md.getColumnName(i), object.getObject(i));
			       response.add(prodInfo);
//			     }
			  }
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
		return response;
	}

	@Override
	public List<Object> fetchDistinctLocation() throws Exception {

		System.out.println("Fetch Data from table in given database..."); 
		conn = dbConnection.getConnection(); 
		HashMap<String,Object> row=new HashMap<String,Object>();
		List<Object> response=new ArrayList<>();
		//Object object = null;
		try {
			//System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement();
			String sql="SELECT LOCATION FROM PROD_INFO ";
			ResultSet object=stmt.executeQuery(sql);
			ResultSetMetaData md = object.getMetaData();
			 int columns = md.getColumnCount();
			 
			  while (object.next()) {
			     for (int i = 1; i <= columns; i++) {
			       row.put(md.getColumnName(i), object.getObject(i));
			       response.add(object.getObject(i));
			     }
			  }
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
		return response;
	
	}

	@Override
	public List<OrderStats> saveOrders(OrderStats orderStats) throws Exception {
		BigDecimal d = null;
		List<OrderStats> orders=new ArrayList<>();
		//Object object = null;
		try {
			System.out.println("Creating table in given database..."); 
			String query="INSERT INTO ORDER_DETAILS (ORDER_ID,USER_ID,MOBILE_NO,LOCATION,ORDER_STAT) VALUES (?,?,?,?,?)";
			PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "ANUBHAB07@GMAIL.COM");
			preparedStatement.setBigDecimal(3, d = new BigDecimal(9439471510L));
			preparedStatement.setString(4, "Infosys,Patia");
			preparedStatement.setString(5, "TYPE1");
			preparedStatement .executeUpdate();
			orderStats=new OrderStats();
			orders.add(orderStats);
			
			System.out.println("Fetch Data from table in given database..."); 
			conn = dbConnection.getConnection(); 
			HashMap<String,Object> row=new HashMap<String,Object>();
			List<Object> response=new ArrayList<>();
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
		return orders;
	
	}

	@Override
	public List<OrderStats> openOrders() throws Exception {
		System.out.println("Fetch Data from table in given database..."); 
		conn = dbConnection.getConnection(); 
		HashMap<String,Object> row=new HashMap<String,Object>();
		List<OrderStats> response=new ArrayList<>();
		//Object object = null;
		try {
			//System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement();
			String sql="SELECT * FROM ORDER_DETAILS WHERE ORDER_STAT='TYPE1'";
			ResultSet object=stmt.executeQuery(sql);
			ResultSetMetaData md = object.getMetaData();
			 int columns = md.getColumnCount();
			 
			 while (object.next()) {
				 OrderStats orderStats=new OrderStats();
				 orderStats.setOrderNumber(object.getLong("ORDER_ID"));
				 orderStats.setUserId(object.getString("USER_ID"));
				 orderStats.setDestination(object.getString("LOCATION"));
				 orderStats.setRemarks(object.getString("ORDER_STAT"));
				 orderStats.setMobileNo(object.getBigDecimal("MOBILE_NO"));				 
//			     for (int i = 1; i <= columns; i++) {
//			       row.put(md.getColumnName(i), object.getObject(i));
//			       response.add(object.getObject(i));
//			     }
				 response.add(orderStats);
			  }
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
		return response;
	}

	@Override
	public List<ProdTrackDetails> orderDetails() throws Exception {
		System.out.println("Fetch Data from table in given database..."); 
		conn = dbConnection.getConnection(); 

		List<ProdTrackDetails> response=new ArrayList<>();
		//Object object = null;
		try {
			ProdTrackDetails prodTrackDetails=new ProdTrackDetails();
			//System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement();
			String sql="SELECT * FROM PROD_INFO WHERE ID=1";
			ResultSet object=stmt.executeQuery(sql);
			ResultSetMetaData md = object.getMetaData();
			 int columns = md.getColumnCount();
			 
			 while (object.next()) {
				 ProdInfo prodInfo=new ProdInfo();
				 prodInfo.setKey(object.getInt("ID"));
				 prodInfo.setArea(object.getString("LOCATION"));
				 prodInfo.setLatitude(object.getInt("LATITUDE"));
				 prodInfo.setLongitude(object.getInt("LONGITUDE"));
				 prodTrackDetails.setSource(prodInfo);	
//				 prodTrackDetails.setDestination(prodInfo);
//			     for (int i = 1; i <= columns; i++) {
//			       row.put(md.getColumnName(i), object.getObject(i));
//			       response.add(object.getObject(i));
//			     }
				 response.add(prodTrackDetails);
			  }
			 
			 sql="SELECT * FROM PROD_INFO WHERE ID=5";
			 object=stmt.executeQuery(sql);
			 md = object.getMetaData();
			 columns = md.getColumnCount();
				 
				 while (object.next()) {
					 ProdInfo prodInfo=new ProdInfo();
					 prodInfo.setKey(object.getInt("ID"));
					 prodInfo.setArea(object.getString("LOCATION"));
					 prodInfo.setLatitude(object.getInt("LATITUDE"));
					 prodInfo.setLongitude(object.getInt("LONGITUDE"));	
					 prodTrackDetails.setDestination(prodInfo);
					 response.add(prodTrackDetails);
				  }
				 List<ProdInfo> prodInfos= new ArrayList<>();
				 sql="SELECT * FROM PROD_INFO WHERE ID!=1 and ID!=5";
				 object=stmt.executeQuery(sql);
				 md = object.getMetaData();
				 columns = md.getColumnCount();
				
				 while (object.next()) {
				     for (int i = 1; i <= columns; i++) {
						 ProdInfo prodInfo=new ProdInfo();
						 prodInfo.setKey(object.getInt("ID"));
						 prodInfo.setArea(object.getString("LOCATION"));
						 prodInfo.setLatitude(object.getInt("LATITUDE"));
						 prodInfo.setLongitude(object.getInt("LONGITUDE"));
						 prodInfos.add(prodInfo);	 
				     }
				  }prodTrackDetails.setIntermediateLocations(prodInfos);	
				  	response.add(prodTrackDetails);		 
			 
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
		return response;
	}

	@Override
	public List<String> cancelOrder(Long orderNumber) throws Exception {
		String query="UPDATE TABLE_NAME SET STATUS='CANCEL' WHERE USER='USER1' AND STATUS='OPEN'";
		
		return null;
	}
}
