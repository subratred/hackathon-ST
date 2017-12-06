package com.hackathon.ShipmentTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.ShipmentTracker.dao.ShipmentTrackDAO;
import com.hackathon.ShipmentTracker.model.ServiceResponse;

@Service ("ShipmentTrackService")
public class ShipmentTrackServiceImpl implements ShipmentTrackService{
	@Autowired ShipmentTrackDAO shipmentTrackDAO;

	@Override
	public ServiceResponse fetchDistinctLocation() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<String> locations=new ArrayList<>();
		locations=shipmentTrackDAO.fetchDistinctLocation();
		serviceResponse.setData(locations);
		return serviceResponse;
	}

	@Override
	public ServiceResponse saveOrders() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<String> locations=new ArrayList<>();
		locations=shipmentTrackDAO.fetchDistinctLocation();
		serviceResponse.setData(locations);
		return null;
	}

	@Override
	public ServiceResponse openOrders() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<String> locations=new ArrayList<>();
		locations=shipmentTrackDAO.fetchDistinctLocation();
		serviceResponse.setData(locations);
		return null;
	}

	@Override
	public ServiceResponse orderDetails() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<String> locations=new ArrayList<>();
		locations=shipmentTrackDAO.fetchDistinctLocation();
		serviceResponse.setData(locations);
		return null;
	}

	@Override
	public ServiceResponse cancelOrder() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<String> locations=new ArrayList<>();
		locations=shipmentTrackDAO.fetchDistinctLocation();
		serviceResponse.setData(locations);
		return null;
	}

	
}
