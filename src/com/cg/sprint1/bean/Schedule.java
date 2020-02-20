package com.cg.sprint1.bean;

import java.sql.Date;

/**
 * 
 * @author Sanchit Singhal/Piyush/Sadia/Riya
 *
 */
public class Schedule {
	
	private long scheduleID;
	private String sourceAirpot;
	private String destinationAirpot;
	private String arrivalTime;
	private String departureTime;
	
	public Schedule(String sourceAirpot, String destinationAirpot,
			String arrivalTime, String departureTime, long scheduleID) {
		super();
		this.sourceAirpot = sourceAirpot;
		this.destinationAirpot = destinationAirpot;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.scheduleID = scheduleID;
	}

	public Schedule() {
	}

	public String getSourceAirpot() {
		return sourceAirpot;
	}

	public void setSourceAirpot(String sourceAirpot) {
		this.sourceAirpot = sourceAirpot;
	}

	public String getDestinationAirpot() {
		return destinationAirpot;
	}

	public void setDestinationAirpot(String destinationAirpot) {
		this.destinationAirpot = destinationAirpot;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public long getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(long scheduleID) {
		this.scheduleID = scheduleID;
	}
	
	
}
