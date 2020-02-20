package com.cg.sprint1.service;

import java.util.List;

import com.cg.sprint1.bean.Airport;


/**
 * 
 * @author Piyush Kr Singh
 *
 */
public interface AirpotService {
	
	public List<Airport> viewAirport();
	public Airport viewAirport(String s);
}
