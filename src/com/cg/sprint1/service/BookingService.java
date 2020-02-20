package com.cg.sprint1.service;

import java.util.List;

import com.cg.sprint1.bean.Booking;
import com.cg.sprint1.bean.Passenger;

/**
 * 
 * @author Sadia Usmani
 *
 */

public interface BookingService {
	
	public Booking addBooking(Booking b);
	public Booking modifyBooking(Booking b);
	public Booking viewBooking(long bID);
	public List<Booking> viewBooking();
	public void deleteBooking(long bID);
	public void validateBooking(Booking b);
	public void validatePassenger(Passenger p);
	
}
