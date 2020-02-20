package com.cg.sprint1.dao;

import java.sql.Date;

import java.util.List;

import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.bean.Schedule;

/**
 * 
 * @author Sanchit Singhal
 *
 */

public interface ScheduleFlightDao {
	
	/**
	 * 
	 * @param ss
	 * @return
	 */
	public Schedule scheduleFlights(Schedule s);
	
	
	/**
	 * 
	 * @param a1
	 * @param a2
	 * @param d
	 * @return
	 */
	public List<Schedule> viewScheduledFlight(String a1, String a2, String d);
	
	
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
	 * @param fid
	 * @param sid
	 * @param availSeats
	 * @return
	 */
	public Schedule modifyScheduledFlight(Schedule s);
	
	
	
	/**
	 * 
	 * @param fno
	 */
	public void deleteScheduledFlight(long fno);

	

	
	
}
