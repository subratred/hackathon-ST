package com.hackathon.ShipmentTracker.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hackathon.ShipmentTracker.model.OrderStats;


public interface ShipmentTrackDAO {

	public String getConnection() throws ClassNotFoundException;
	public Object getData() throws ClassNotFoundException, SQLException;
	
	public List<String> fetchDistinctLocation() throws Exception;
	public List<OrderStats> saveOrders() throws Exception;
	public List<OrderStats> openOrders() throws Exception;
	public Map<String,Object> orderDetails() throws Exception;
	public List<String> cancelOrder(Long orderNumber) throws Exception;
}
