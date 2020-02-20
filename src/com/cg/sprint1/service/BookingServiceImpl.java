package com.cg.sprint1.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.sprint1.bean.Booking;
import com.cg.sprint1.bean.Passenger;
import com.cg.sprint1.dao.BookingDao;
import com.cg.sprint1.dao.BookingDaoImpl;
import com.cg.sprint1.exceptions.InvalidBookingException;
import com.cg.sprint1.exceptions.PassengerNotFoundException;

/**
 * 
 * @author Sadia Usmani
 *
 */

public class BookingServiceImpl implements BookingService {

	BookingDao bd = new BookingDaoImpl();
	
	@Override
	public Booking addBooking(Booking b) {
		
		
		if(b!=null)
			return bd.addBooking(b);
		else
			throw new InvalidBookingException("Inavlid Booking Details!!");
			
	}

	@Override
	public Booking modifyBooking(Booking b) {
		
		if(b!=null)
			return bd.modifyBooking(b);
		
		else
			throw new InvalidBookingException("Booking details not exists!!");
	}

	@Override
	public Booking viewBooking(long bID) {
		Booking book = new Booking();
		book = bd.viewBooking(bID);
		if(book != null)
			return book;
		else
			throw new InvalidBookingException("Booking Details not Exists!!");
	}

	@Override
	public List<Booking> viewBooking() {
		List<Booking> bList = new ArrayList<>();
		bList = bd.viewBooking();
		if(bList != null)
			return bList;
		else 
			throw new InvalidBookingException("Booking Details not Exists!!");
	}

	@Override
	public void deleteBooking(long bID) {
		bd.deleteBooking(bID);
	}

	
	@Override
	public void validateBooking(Booking b) {
		
		String bID = Long.toString(b.getBookingID());
		if(bID == null ) {
			throw new InvalidBookingException("Booking doesn't exists!!!");
		}
	}

	
	@Override
	public void validatePassenger(Passenger p) {
		
		String pnrNum = Long.toString(p.getPnrNumber());
		if(pnrNum == null) 
			throw new PassengerNotFoundException("Passenger not exist!!");

	}

}
