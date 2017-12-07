package com.hackathon.ShipmentTracker.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hackathon.ShipmentTracker.model.OrderStats;
import com.hackathon.ShipmentTracker.model.ProdTrackDetails;


public interface ShipmentTrackDAO {

	public String getConnection() throws ClassNotFoundException;
	public Object getData() throws ClassNotFoundException, SQLException;
	
	public List<Object> fetchDistinctLocation() throws Exception;
	public List<OrderStats> saveOrders(OrderStats orderStats) throws Exception;
	public List<OrderStats> openOrders() throws Exception;
	public List<ProdTrackDetails> orderDetails() throws Exception;
	public List<String> cancelOrder(Long orderNumber) throws Exception;
}
