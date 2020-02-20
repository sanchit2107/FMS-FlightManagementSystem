package com.cg.sprint1.service;

import java.sql.Date;
import java.util.List;

import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.bean.Schedule;


/**
 * 
 * @author Sanchit Singhal
 *
 */

public interface ScheduleFlightService {
	/**
	 * 
	 * @param s
	 * @return
	 */
	public Schedule scheduleFlights(Schedule s);
	
	/**
	 * 
	 * @param a1
	 * @param a2
	 * @param scheduleDate
	 * @return
	 */
	public List<Schedule> viewScheduledFlight(String a1, String a2, String scheduleDate);
	
	/**
	 * 
	 * @param fno
	 * @return
	 */
	public Schedule viewScheduledFlights(long fno);
	
	/**
	 * 
	 * @return
	 */
	public List<Schedule> viewScheduledFlight();
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public Schedule modifyScheduledFlight(Schedule s);
	
	/**
	 * 
	 * @param fno
	 */
	public void deleteScheduledFlight(long fno);
	
	/**
	 * 
	 * @param s
	 */
	public void validateScheduleFlight(Schedule s);
	
	
	
}
