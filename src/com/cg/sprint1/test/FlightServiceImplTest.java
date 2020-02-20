package com.cg.sprint1.test;

import java.util.Scanner;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.exceptions.InvalidArgumentException;
import com.cg.sprint1.service.FlightServiceImpl;

public class FlightServiceImplTest {

	Scanner sc = new Scanner(System.in);
	FlightServiceImpl service;
	Flight flight = null;
	Flight result = null;
	long flightNumber;
	String carrierName;

	@Before
	public void setUp() {
		service = new FlightServiceImpl();
	}

	/**
	 * Add Flight Test Case-1
	 * 
	 * @param flight
	 */
	@Test(expected = InvalidArgumentException.class)
	public void testAddFlight_1() {
		flight = new Flight();
		flightNumber = 20;
		flight.setFlightNumber(flightNumber);
		String carrierName = "VI";
		flight.setCarrierName(carrierName);
		service.addFlight(flight);
	}

	/**
	 * Add Flight Test Case-2
	 */
	@Test
	public void testAddFlight_2() {
		flight = new Flight();
		flightNumber = 6000;
		flight.setFlightNumber(flightNumber);
		carrierName = "RAJHANSA";
		flight.setCarrierName(carrierName);
		result = new Flight();
		result = service.addFlight(flight);
		Assert.assertNotNull(result);
		Assert.assertEquals(flightNumber, result.getFlightNumber());
		Assert.assertEquals(carrierName, result.getCarrierName());
	}

	/**
	*
	*/
	@Test
	public void testViewFlight_1() {
		flight = new Flight();
		flight = service.viewFlight(70707);
		Assert.assertNotNull(flight);
	}
}