package com.hackathon.ShipmentTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.ShipmentTracker.dao.ShipmentTrackDAO;
import com.hackathon.ShipmentTracker.model.OrderStats;
import com.hackathon.ShipmentTracker.model.ProdTrackDetails;
import com.hackathon.ShipmentTracker.model.ServiceResponse;

@Service ("ShipmentTrackService")
public class ShipmentTrackServiceImpl implements ShipmentTrackService{
	@Autowired ShipmentTrackDAO shipmentTrackDAO;

	@Override
	public ServiceResponse fetchData() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		Object locations=new Object();
		locations=shipmentTrackDAO.getData();
		List<Object> objects=new ArrayList<>();
		objects.add(locations);
		serviceResponse.setData(objects);
		return serviceResponse;
	}
	
	@Override
	public ServiceResponse fetchDistinctLocation() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<Object> locations=new ArrayList<>();
		locations=shipmentTrackDAO.fetchDistinctLocation();
		serviceResponse.setData(locations);
		return serviceResponse;
	}

	@Override
	public ServiceResponse saveOrders(OrderStats orderStats) throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<OrderStats> orders=new ArrayList<>();
		orders=shipmentTrackDAO.saveOrders(orderStats);
		serviceResponse.setData(orders);
		return serviceResponse;
	}

	@Override
	public ServiceResponse openOrders() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
	List<OrderStats> orders=new ArrayList<>();
	orders=shipmentTrackDAO.openOrders();
	serviceResponse.setData(orders);
	return serviceResponse;
	}

	@Override
	public ServiceResponse orderDetails() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<ProdTrackDetails> prodTrackDetails=new ArrayList<>();
		List<String> locations=new ArrayList<>();
		prodTrackDetails=shipmentTrackDAO.orderDetails();
		serviceResponse.setData(prodTrackDetails);
		return serviceResponse;
	}

	@Override
	public ServiceResponse cancelOrder() throws Exception {
		ServiceResponse serviceResponse=new ServiceResponse();
		List<String> locations=new ArrayList<>();
//		locations=shipmentTrackDAO.fetchDistinctLocation();
		serviceResponse.setData(locations);
		return null;
	}

	
}
