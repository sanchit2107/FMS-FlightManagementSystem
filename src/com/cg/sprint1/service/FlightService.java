package com.cg.sprint1.service;

import java.util.List;

import com.cg.sprint1.bean.Flight;

/**
 * 
 * @author Piyush Kr Singh
 *
 */
public interface FlightService {
	
	public Flight addFlight(Flight f);
	public Flight modifyFlight(Flight f);
	public Flight viewFlight(long fno);
	public List<Flight> viewFlight();
	public void deleteFlight(long fno);
	public void validateFlight(Flight f);
	
}
