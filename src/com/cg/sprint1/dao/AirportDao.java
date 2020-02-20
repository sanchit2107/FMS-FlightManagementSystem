package com.cg.sprint1.dao;

import java.util.List;

import com.cg.sprint1.bean.Airport;

/**
 * 
 * @author Piyush Kr Singh
 *
 */

public interface AirportDao {
	
	public List<Airport> viewAirport();
	public Airport viewAirport(String s);
	
}
