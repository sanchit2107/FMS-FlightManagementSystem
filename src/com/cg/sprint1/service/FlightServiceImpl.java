package com.cg.sprint1.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.dao.FlightDao;
import com.cg.sprint1.dao.FlightDaoImpl;
import com.cg.sprint1.exceptions.FlightNotFoundException;
import com.cg.sprint1.exceptions.InvalidCarrierNameException;
import com.cg.sprint1.exceptions.InvalidFlightException;

/**
 * 
 * @author Piyush Kr Singh
 *
 */
public class FlightServiceImpl implements FlightService {

	FlightDao fd = new FlightDaoImpl();

	@Override
	public Flight addFlight(Flight flight) {
		if (flight.getCarrierName().length() >= 3) {
			Double num = Math.random();
			long Number = Integer.parseInt(num.toString().substring(2, 6));
			flight.setFlightNumber(Number);
			return fd.addFlight(flight);
		} else {
			throw new InvalidCarrierNameException("!! Invalid Carrier Name !!");
		}
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		validateFlight(flight);
		Flight mf = new Flight();
		mf = fd.modifyFlight(flight);
		return mf;
	}

	@Override
	public Flight viewFlight(long flightNumber) {
		Flight flight = new Flight();
		flight = fd.viewFlight(flightNumber);
		if (flight != null) {
			return flight;
		} else {
			throw new FlightNotFoundException("!! Inavlid Flight !!");
		}
	}

	@Override
	public List<Flight> viewFlight() {
		List<Flight> flightList = new ArrayList<>();
		flightList = fd.viewFlight();
		if (flightList != null) {
			return flightList;
		} else {
			throw new FlightNotFoundException("!! No Flight Exists !!");
		}
	}

	@Override
	public void deleteFlight(long flightNumber) {
		Flight flight = new Flight();
		flight = fd.viewFlight(flightNumber);
		if (flight != null) {
			fd.deleteFlight(flightNumber);
		} else {
			throw new FlightNotFoundException("!! Flight Not Found !!");
		}
	}

	@Override
	public void validateFlight(Flight flight) {
		Flight f = new Flight();
		f = fd.viewFlight(flight.getFlightNumber());
		if (f == null) {
			throw new InvalidFlightException("!! Flight Not Found !!");
		}
	}

}
