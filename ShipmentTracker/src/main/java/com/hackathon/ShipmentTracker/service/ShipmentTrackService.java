package com.hackathon.ShipmentTracker.service;

import com.hackathon.ShipmentTracker.model.ServiceResponse;

public interface ShipmentTrackService {

	public ServiceResponse fetchDistinctLocation() throws Exception;
	public ServiceResponse saveOrders() throws Exception;
	public ServiceResponse openOrders() throws Exception;
	public ServiceResponse orderDetails() throws Exception;
	public ServiceResponse cancelOrder() throws Exception;
}
