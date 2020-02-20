package com.cg.sprint1.dao;

import java.util.List;

import com.cg.sprint1.bean.Booking;

/**
 * 
 * @author Sadia Usmani
 *
 */

public interface BookingDao {

	public Booking addBooking(Booking b);
	public Booking modifyBooking(Booking b);
	public Booking viewBooking(long bID);
	public List<Booking> viewBooking();
	public void deleteBooking(long bID);
	
}
