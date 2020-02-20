package com.cg.sprint1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.bean.Schedule;
import com.cg.sprint1.util.MyDBConnection;


/**
 * 
 * @author Sanchit Singhal
 *
 */
public class ScheduleFlightDaoImpl implements ScheduleFlightDao {
	
	Connection con = MyDBConnection.getConnection();

	@Override
	public Schedule scheduleFlights(Schedule s) {
		Schedule sobj;
		try {
			PreparedStatement ps = con.prepareStatement("insert into schedule values (?,?,?,?,?)");
			ps.setLong(1, s.getScheduleID());
			ps.setString(2, s.getSourceAirpot());
			ps.setString(3, s.getDestinationAirpot());
			ps.setString(4, s.getDepartureTime());
			ps.setString(5, s.getArrivalTime());
			int a=ps.executeUpdate();
			if(a>0) 
				System.out.println("Flight Scheduled!  Your id="+s.getScheduleID());
			else
				System.out.println("Flights Not Scheduled!");
			
			PreparedStatement ps2 = con.prepareStatement("select * from schedule");
			
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				sobj = new Schedule();
				sobj.setScheduleID(rs.getLong(1));
				sobj.setSourceAirpot(rs.getString(2));
				sobj.setDestinationAirpot(rs.getString(3));
				sobj.setDepartureTime(rs.getString(4));
				sobj.setArrivalTime(rs.getString(5));
				return sobj;
			}
			else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public List<Schedule> viewScheduledFlight(String a1, String a2, String d) {

		List<Schedule> sList = new ArrayList<>();
		Schedule s;
		try {
			PreparedStatement ps = con.prepareStatement
					("select * from schedule where arrivaldatetime=? and "
							+ "sourceairport=? and destinationairport=?");
			ps.setString(1, d);
			ps.setString(2, a1);
			ps.setString(3, a2);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new Schedule();
				s.setScheduleID(rs.getLong(1));
				s.setSourceAirpot(rs.getString(2));
				s.setDestinationAirpot(rs.getString(3));
				s.setDepartureTime(rs.getString(4));
				s.setArrivalTime(rs.getString(5));
				sList.add(s);
			}
			
			return sList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	@Override
	public Schedule viewScheduledFlights(long fno) {
		
		Schedule f = null;
		try {
			PreparedStatement ps = con.prepareStatement
					("select * from schedule where scheduleid = ?");
			ps.setLong(1, fno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = new Schedule();
				f.setSourceAirpot(rs.getString(2));
				f.setDestinationAirpot(rs.getString(3));
				f.setDepartureTime(rs.getString(4));
				f.setArrivalTime(rs.getString(5));
				return f;
			}
			else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Schedule> viewScheduledFlight() {
		
		Schedule sobj;
		List<Schedule> sList= new ArrayList<Schedule>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from schedule");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sobj = new Schedule();
				sobj.setScheduleID(rs.getLong(1));
				sobj.setSourceAirpot(rs.getString(2));
				sobj.setDestinationAirpot(rs.getString(3));
				sobj.setDepartureTime(rs.getString(4));
				sobj.setArrivalTime(rs.getString(5));
				sList.add(sobj);
			}
			
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	

	@Override
	public Schedule modifyScheduledFlight(Schedule s) {
		
		
		try {
			PreparedStatement ps = con.prepareStatement("update schedule set sourceairport=?, destinationairport=?"
					+ ", departuredatetime=?, arrivaldatetime=? where scheduleid=?");
			
			ps.setString(1, s.getSourceAirpot());
			ps.setString(2, s.getDestinationAirpot());
			ps.setString(3, s.getDepartureTime());
			ps.setString(4, s.getArrivalTime());
			ps.setLong(5, s.getScheduleID());
			int rowAffected = ps.executeUpdate();
			
			if(rowAffected > 0 ) {
				return s;
			}
			else {
				return null;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}

	@Override
	public void deleteScheduledFlight(long fno) {

		try {
			PreparedStatement ps = con.prepareStatement
					("delete from schedule where scheduleid=?");
			ps.setLong(1, fno);
				int rowsAffected = ps.executeUpdate();
				System.out.println(String.format("Row affected %d", rowsAffected));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
