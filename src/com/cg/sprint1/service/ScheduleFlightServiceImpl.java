package com.cg.sprint1.service;

import java.sql.Connection;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;


import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.bean.Schedule;
import com.cg.sprint1.dao.ScheduleFlightDao;
import com.cg.sprint1.dao.ScheduleFlightDaoImpl;
import com.cg.sprint1.exceptions.IncorrectFlightNumber;
import com.cg.sprint1.exceptions.ScheduleFlightNotFoundException;
import com.cg.sprint1.util.MyDBConnection;

/**
 * 
 * @author Sanchit Singhal
 *
 */

public class ScheduleFlightServiceImpl implements ScheduleFlightService {

	ScheduleFlightDao sfd = new ScheduleFlightDaoImpl();
	Connection con = MyDBConnection.getConnection();
	
	
	@Override
	public Schedule scheduleFlights(Schedule s) {
		
		if(s!=null)
			return sfd.scheduleFlights(s);
		else
			throw new ScheduleFlightNotFoundException("Flight Not Scheduled!!");
		
	}

	@Override
	public List<Schedule> viewScheduledFlight(String a1, String a2, String d) {

		List<Schedule> sList = new ArrayList<Schedule>();
		sList = sfd.viewScheduledFlight(a1, a2, d);
		if(sList!= null)
			return sList;
		else
			throw new ScheduleFlightNotFoundException("Scheduled Flight Not found!!! ");
	}

	@Override
	public Schedule viewScheduledFlights(long fno) {
		if(fno <= 0) {
			throw new IncorrectFlightNumber("Inavlid Scheduled Flight!!");
		}
		Schedule f = new Schedule();
		f = sfd.viewScheduledFlights(fno);
		return f;
//		else
//			throw new ScheduleFlightNotFoundException("Scheduled Flight Not found for given flight number!!! ");
	}

	@Override
	public List<Schedule> viewScheduledFlight() {
		
		List<Schedule> sList = new ArrayList<>();
		sList = sfd.viewScheduledFlight();
		
		if(sList!=null)
			return sList;
		else
		{
			throw new ScheduleFlightNotFoundException("The following Scheduled Flight Not found!! ");
		}
	}

	@Override
	public Schedule modifyScheduledFlight(Schedule s) {
		
		return sfd.modifyScheduledFlight(s);
		
	}

	@Override
	public void deleteScheduledFlight(long fno) {
		
		sfd.deleteScheduledFlight(fno);

	}

	@Override
	public void validateScheduleFlight(Schedule s) {
		
		Schedule sch = new Schedule();
		sch = sfd.viewScheduledFlights(s.getScheduleID());
		
		if(sch==null)
			throw new ScheduleFlightNotFoundException("Schedule Flight Not Found!!");

	}

}
