package hackathon.ShipmentTrack.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackathon.ShipmentTrack.dao.ShipmentTrackDAOImpl;

@RestController
public class ShipmentTrackController {
	@Autowired
	ShipmentTrackDAOImpl shipmentTrackerDao;
	
	@RequestMapping("/getAllInfo")
	public Object getAllData() throws ClassNotFoundException, SQLException{
		Object object=shipmentTrackerDao.getData();
		System.out.println();
		return object;
	}

}
