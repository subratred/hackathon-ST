package com.hackathon.ShipmentTracker.dao;


import java.sql.SQLException;


public interface ShipmentTrackDAO {

	public String getConnection() throws ClassNotFoundException;
	public Object getData() throws ClassNotFoundException, SQLException;
}
