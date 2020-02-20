package com.cg.sprint1.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author Sanchit Singhal/Piyush/Sadia/Riya
 *
 */
public class Booking {
	
	private long bookingID;
	private long userID;
	private String bookingDate;
	private List<Passenger> passengerList;
	private long ticketCost;
	private long flight;
	private int noOfPassengers;
	
	/**
	 * 
	 * @param bookingID
	 * @param userID
	 * @param bookingDate
	 * @param passengerList
	 * @param ticketCost
	 * @param flight
	 * @param noOfPassengers
	 */
	public Booking(long bookingID, long userID, String bookingDate, List<Passenger> passengerList, long ticketCost,
			long flight, int noOfPassengers) {
		super();
		this.bookingID = bookingID;
		this.userID = userID;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flight = flight;
		this.noOfPassengers = noOfPassengers;
	}
	
	/**
	 * deafult constructor
	 */
	public Booking() {
	
	}

	/**
	 * 
	 * @return
	 */
	public long getBookingID() {
		return bookingID;
	}
	
	/**
	 * 
	 * @param bookingID
	 */
	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}

	/**
	 * 
	 * @return
	 */
	public long getUserID() {
		return userID;
	}
	
	/**
	 * 
	 * @param userID
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @return
	 */
	public String getBookingDate() {
		return bookingDate;
	}

	/**
	 * 
	 * @param bookingDate
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * 
	 * @return
	 */
	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	/**
	 * 
	 * @param passengerList
	 */
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	/**
	 * 
	 * @return
	 */
	public long getTicketCost() {
		return ticketCost;
	}

	/**
	 * 
	 * @param ticketCost
	 */
	public void setTicketCost(long ticketCost) {
		this.ticketCost = ticketCost;
	}

	/**
	 * 
	 * @return
	 */
	public long getFlight() {
		return flight;
	}

	/**
	 * 
	 * @param flight
	 */
	public void setFlight(long flight) {
		this.flight = flight;
	}

	/**
	 * 
	 * @return
	 */
	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	/**
	 * 
	 * @param noOfPassengers
	 */
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	
	
}
