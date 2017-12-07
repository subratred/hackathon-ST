package com.hackathon.ShipmentTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ShipmentTracker.model.OrderStats;
import com.hackathon.ShipmentTracker.model.ServiceResponse;
import com.hackathon.ShipmentTracker.service.ShipmentTrackService;

@RestController
public class Controller {
	@Autowired
	ShipmentTrackService shipmentTrackService;

	@RequestMapping(value="/test",produces="application/json",method=RequestMethod.GET)
	public String gettest(){
		System.out.println();
		return "FETCH 123";
	}
	
	@RequestMapping(value="/fetchData",produces="application/json",method=RequestMethod.GET)
	public ServiceResponse fetchData() throws Exception{
		ServiceResponse response=shipmentTrackService.fetchData();
		System.out.println();
		return response;
	}
	
	@RequestMapping(value="/fetchLocations",produces="application/json",method=RequestMethod.GET)
	public ServiceResponse fetchLocations() throws Exception{
		ServiceResponse response=shipmentTrackService.fetchDistinctLocation();
		System.out.println();
		return response;
	}
	
	@RequestMapping(value="/saveOrders",produces="application/json",method=RequestMethod.POST,consumes="application/json")
	public ServiceResponse saveOrders(@RequestBody OrderStats orderStats) throws Exception{
		ServiceResponse response=shipmentTrackService.saveOrders(orderStats);
		System.out.println();
		return response;
	}
	
	@RequestMapping(value="/openOrders",produces="application/json",method=RequestMethod.GET)
	public ServiceResponse openOrders() throws Exception{
		ServiceResponse response=shipmentTrackService.openOrders();
		System.out.println();
		return response;
	}
	
	@RequestMapping(value="/orderDetails",produces="application/json",method=RequestMethod.GET)
	public ServiceResponse orderDetails() throws Exception{
		ServiceResponse response=shipmentTrackService.orderDetails();
		System.out.println();
		return response;
	}
}
