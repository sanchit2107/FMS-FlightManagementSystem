package com.cg.sprint1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.util.MyDBConnection;


/**
 * 
 * @author Piyush Kr Singh
 *
 */
public class FlightDaoImpl implements FlightDao {

	List<Flight> flightList = new ArrayList<>();
	Connection con = MyDBConnection.getConnection();

	@Override
	public Flight addFlight(Flight flight) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into flight values(?,?,?,?)");
			ps.setLong(1, flight.getFlightNumber());
			ps.setString(2, flight.getFlightModel());
			ps.setString(3, flight.getCarrierName());
			ps.setInt(4, flight.getSeatCapacity());
			int a = ps.executeUpdate();
			if (a > 0) {
				return flight;
			} else
				return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Flight modifyFlight(Flight flight) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con
					.prepareStatement("update flight set flightmodel=?, carriername=?, seatcapacity=?");
			ps.setString(1, flight.getFlightModel());
			ps.setString(2, flight.getCarrierName());
			ps.setInt(3, flight.getSeatCapacity());
			int a = ps.executeUpdate();
			if (a > 0) {
				return flight;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Flight viewFlight(long flightNumber) {
		// TODO Auto-generated method stub
		Flight flight = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from flight where flightnumber=?");
			ps.setLong(1, flightNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				flight = new Flight();
				flight.setFlightNumber(rs.getLong(1));
				flight.setFlightModel(rs.getString(2));
				flight.setCarrierName(rs.getString(3));
				flight.setSeatCapacity(rs.getInt(4));
			}
			return flight;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Flight> viewFlight() {
		// TODO Auto-generated method stub
		Flight flight = null;
		List<Flight> list = new ArrayList<Flight>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from flight");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				flight = new Flight();
				flight.setFlightNumber(rs.getLong(1));
				flight.setFlightModel(rs.getString(2));
				flight.setCarrierName(rs.getString(3));
				flight.setSeatCapacity(rs.getInt(4));
				list.add(flight);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void deleteFlight(long flightNumber) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from flight where flightnumber=?");
			ps.setLong(1, flightNumber);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
