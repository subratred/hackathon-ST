package com.hackathon.ShipmentTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ShipmentTracker.dao.ShipmentTrackDAOImpl;

@RestController
public class Controller {
	@Autowired
	ShipmentTrackDAOImpl shipmentTrackDAO;

	@RequestMapping(value="/getAllInfo",produces="application/json",method=RequestMethod.GET)
	public String getAllData(){
		System.out.println();
		return "FETCH 123";
	}
	
	@RequestMapping(value="/getInfo",produces="application/json",method=RequestMethod.GET)
	public String getData() throws ClassNotFoundException{
		String response=shipmentTrackDAO.getConnection();
		System.out.println();
		return response;
	}
}
