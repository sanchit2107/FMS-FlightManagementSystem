package com.cg.sprint1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.sprint1.bean.Booking;
import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.bean.User;
import com.cg.sprint1.util.MyDBConnection;

/**
 * 
 * @author Sadia Usmani
 *
 */
public class BookingDaoImpl implements BookingDao {

	Connection con = MyDBConnection.getConnection();

	@Override
	public Booking addBooking(Booking booking) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into booking values(?,?,?,?,?,?)");
			ps.setLong(1, booking.getBookingID());
			ps.setLong(2, booking.getUserID());
			ps.setString(3, booking.getBookingDate());
			ps.setLong(4, booking.getTicketCost());
			ps.setInt(5, booking.getNoOfPassengers());
			ps.setLong(6, booking.getFlight());
			
			int a = ps.executeUpdate();
			if (a > 0) {
				return booking;
			} else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Booking modifyBooking(Booking booking) {
		try {
			PreparedStatement ps = con
					.prepareStatement("update booking set userid=?, bookingdate=?, ticketcost=?, passengercount=? where bookingid=?");
			ps.setLong(1, booking.getUserID());
			ps.setString(2, booking.getBookingDate());
			ps.setLong(3, booking.getTicketCost());
			ps.setInt(4, booking.getNoOfPassengers());
			ps.setLong(5, booking.getBookingID());
			
			int a = ps.executeUpdate();
			if (a > 0) {
				return booking;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Booking viewBooking(long bookingId) {
		Booking booking = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from booking where bookingid=?");
			ps.setLong(1, bookingId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				booking = new Booking();
				booking.setBookingID(rs.getLong(1));
				booking.setUserID(rs.getLong(2));
				booking.setBookingDate(rs.getString(3));
				booking.setTicketCost(rs.getLong(4));
				booking.setNoOfPassengers(rs.getInt(5));	
				booking.setFlight(rs.getLong(6));
			}
			return booking;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public List<Booking> viewBooking() {
		Booking booking = null;
		List<Booking> list = new ArrayList<Booking>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from booking");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				booking = new Booking();
				booking.setBookingID(rs.getLong(1));
				User user = new User();
				booking.setUserID(user.getUserId());
				booking.setBookingDate(rs.getString(3));
				booking.setTicketCost(rs.getLong(4));
				booking.setNoOfPassengers(rs.getInt(5));
				booking.setFlight(rs.getLong(6));
				list.add(booking);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteBooking(long bookingId) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from booking where bookingid=?");
			ps.setLong(1, bookingId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
