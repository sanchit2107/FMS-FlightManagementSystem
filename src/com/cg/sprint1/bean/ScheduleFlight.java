package com.cg.sprint1.bean;


/**
 * 
 * @author Sanchit Singhal/Piyush/Sadia/Riya
 *
 */
public class ScheduleFlight {
	
	private Flight flight;
	private int availableSeats;
	private Schedule schedule;
	
	public ScheduleFlight(Flight flight, int availableSeats, Schedule schedule) {
		super();
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	public ScheduleFlight() {
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	
	
}
