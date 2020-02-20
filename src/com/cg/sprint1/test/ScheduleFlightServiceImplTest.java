package com.cg.sprint1.test;

import org.junit.Before;
import org.junit.Test;

import com.cg.sprint1.exceptions.ScheduleFlightNotFoundException;
import com.cg.sprint1.service.FlightServiceImpl;
import com.cg.sprint1.service.ScheduleFlightServiceImpl;

/**
 * 
 * @author Sanchit Singhal
 *
 */
public class ScheduleFlightServiceImplTest {
	
	ScheduleFlightServiceImpl service;
	
	@Before
	public void setUp() {
		service = new ScheduleFlightServiceImpl();
	}
	
	@Test(expected = ScheduleFlightNotFoundException.class)
	public void findByID_1() {
		long sID = 103;
		service.viewScheduledFlights(sID);
	}
	
	
}
