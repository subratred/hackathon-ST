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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hackathon.ShipmentTracker.model.OrderStats;
import com.hackathon.ShipmentTracker.model.ProdInfo;
import com.hackathon.ShipmentTracker.model.ProdTrackDetails;

@Repository
public class ShipmentTrackDAOImpl implements ShipmentTrackDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	Connection conn=null;
	Statement stmt = null;
	
	public String getConnection() throws ClassNotFoundException, SQLException{
		conn = jdbcTemplate.getDataSource().getConnection(); 
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
		conn = jdbcTemplate.getDataSource().getConnection();
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
		conn = jdbcTemplate.getDataSource().getConnection();
		HashMap<String,Object> row=new HashMap<String,Object>();
		List<Object> response=new ArrayList<>();
		//Object object = null;
		try {
			//System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement();
			String sql="SELECT DISTINCT FINAL_DESTINATION FROM TRACK_ORDER";
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
		List<OrderStats> orders=new ArrayList<>();
		//Object object = null;
		try {
			System.out.println("Creating table in given database..."); 
			String query="INSERT INTO ORDER_DETAILS (ORDER_ID,USER_ID,MOBILE_NUMBER,LOCATION,STEP,DELIVERY_TYPE,LAST_MODIFIED_DATE,LAST_MODIFIED_TIME) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
			preparedStatement.setString(1, orderStats.getOrderNumber());
			preparedStatement.setString(2, orderStats.getUserId());
			preparedStatement.setBigDecimal(3, orderStats.getMobileNo());
			preparedStatement.setString(4,orderStats.getDestination());
			preparedStatement.setInt(5, orderStats.getStep());
			preparedStatement.setString(6, orderStats.getDeliveryType());
			preparedStatement.setDate(7, orderStats.getLastModifiedDate());
			preparedStatement.setTimestamp(8, orderStats.getLastModifiedTime());
			preparedStatement .executeUpdate();
			orderStats=new OrderStats();
			orders.add(orderStats);
			
			System.out.println("Fetch Data from table in given database..."); 
			conn = jdbcTemplate.getDataSource().getConnection();
			HashMap<String,Object> row=new HashMap<String,Object>();
			List<Object> response=new ArrayList<>();
			// STEP 4: Clean-up environment 
			conn.commit();
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
		conn = jdbcTemplate.getDataSource().getConnection(); 
		HashMap<String,Object> row=new HashMap<String,Object>();
		List<OrderStats> response=new ArrayList<>();
		//Object object = null;
		try {
			//System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement();
			String sql="SELECT * FROM USER_MASTER WHERE STEP!=5 AND STEP!=6";
			ResultSet object=stmt.executeQuery(sql);
			ResultSetMetaData md = object.getMetaData();
			 OrderStats orderStats=new OrderStats();
			 int columns = md.getColumnCount();
			 
			 while (object.next()) {
				 for (int i = 1; i <= columns; i++) {
				 orderStats.setOrderNumber(object.getString("ORDER_ID"));
				 orderStats.setUserId(object.getString("USER_ID"));
				 orderStats.setDestination(object.getString("LOCATION"));
				 orderStats.setRemarks(object.getString("STEP"));
				 orderStats.setMobileNo(object.getBigDecimal("MOBILE_NUMBER"));	
				 orderStats.setDeliveryType(object.getString("DELIVERY_TYPE"));
				 orderStats.setLastModifiedDate(object.getDate("LAST_MODIFIED_DATE"));
				 orderStats.setLastModifiedTime(object.getTimestamp("LAST_MODIFIED_TIME"));
//			     for (int i = 1; i <= columns; i++) {
//			       row.put(md.getColumnName(i), object.getObject(i));
//			       response.add(object.getObject(i));
//			     }
				 
				 }response.add(orderStats);
				 
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
		conn = jdbcTemplate.getDataSource().getConnection(); 

		List<ProdTrackDetails> response=new ArrayList<>();
		//Object object = null;
		try {
			ProdTrackDetails prodTrackDetails=new ProdTrackDetails();
			//System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement();
			String sql="SELECT USER_ID,LOCATION,LATITUDE,LONGITUDE FROM USER_MASTER WHERE USER_ID=1";
			ResultSet object=stmt.executeQuery(sql);
			ResultSetMetaData md = object.getMetaData();
			 int columns = md.getColumnCount();
			 
			 while (object.next()) {
				 ProdInfo prodInfo=new ProdInfo();
				 prodInfo.setKey(object.getInt("USER_ID"));
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
			 
			 sql="SELECT * FROM USER_MASTER WHERE USER_ID=5";
			 object=stmt.executeQuery(sql);
			 md = object.getMetaData();
			 columns = md.getColumnCount();
				 
				 while (object.next()) {
					 ProdInfo prodInfo=new ProdInfo();
					 prodInfo.setKey(object.getInt("USER_ID"));
					 prodInfo.setArea(object.getString("LOCATION"));
					 prodInfo.setLatitude(object.getInt("LATITUDE"));
					 prodInfo.setLongitude(object.getInt("LONGITUDE"));	
					 prodTrackDetails.setDestination(prodInfo);
					 response.add(prodTrackDetails);
				  }
				 List<ProdInfo> prodInfos= new ArrayList<>();
				 sql="SELECT * FROM USER_MASTER WHERE USER_ID!=1 and USER_ID!=5";
				 object=stmt.executeQuery(sql);
				 md = object.getMetaData();
				 columns = md.getColumnCount();
				
				 while (object.next()) {
				     for (int i = 1; i <= columns; i++) {
						 ProdInfo prodInfo=new ProdInfo();
						 prodInfo.setKey(object.getInt("USER_ID"));
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
