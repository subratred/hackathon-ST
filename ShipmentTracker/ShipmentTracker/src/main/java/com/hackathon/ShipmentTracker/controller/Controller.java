package com.hackathon.ShipmentTracker.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/test")
	public String test() throws ClassNotFoundException, SQLException{
//		Object object=prodDetailsRepo.findAll();
//		System.out.println(object);
		return "FETCH SUCCESSFUL";
	}
}
