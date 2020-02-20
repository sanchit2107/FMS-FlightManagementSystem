package com.cg.sprint1.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.cg.sprint1.bean.Airport;
import com.cg.sprint1.dao.AirportDao;
import com.cg.sprint1.dao.AirportDaoImpl;
import com.cg.sprint1.exceptions.AirportNotFoundException;
import com.cg.sprint1.util.MyDBConnection;

/**
 * 
 * @author Piyush Kr Singh
 *
 */
public class AirportServiceImpl implements AirpotService {

	Connection con = MyDBConnection.getConnection();
	AirportDao ad = new AirportDaoImpl();

	@Override
	public List<Airport> viewAirport() {
		List<Airport> airportList = new ArrayList<Airport>();
		airportList = ad.viewAirport();
		if (airportList != null) {
			return airportList;
		} else {
			throw new AirportNotFoundException("!! No Airport Exists !!");
		}
	}

	@Override
	public Airport viewAirport(String airportCode) {
		Airport airport = new Airport();
		airport = ad.viewAirport(airportCode);
		if (airport != null) {
			return airport;
		} else {
			throw new AirportNotFoundException("!! Airport Not Found !!");
		}
	}

}
