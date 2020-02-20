package com.cg.sprint1.dao;

import java.util.List;

import com.cg.sprint1.bean.Flight;

/**
 * 
 * @author Piyush Kr Singh
 *
 */

public interface FlightDao {

	public Flight addFlight(Flight f);
	public Flight modifyFlight(Flight f);
	public Flight viewFlight(long fno);
	public List<Flight> viewFlight();
	public void deleteFlight(long fno);
	
}
