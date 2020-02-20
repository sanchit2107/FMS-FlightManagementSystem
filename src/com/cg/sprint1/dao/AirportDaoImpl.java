package com.cg.sprint1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.sprint1.bean.Airport;
import com.cg.sprint1.util.MyDBConnection;

/**
 * 
 * @author Piyush Kr Singh
 *
 */

public class AirportDaoImpl implements AirportDao {

	Connection con = MyDBConnection.getConnection();
	private List<Airport> airportList = new ArrayList<Airport>();
	Airport airport = null;

	@Override
	public List<Airport> viewAirport() {
		try {
			PreparedStatement ps = con.prepareStatement("select * from airport");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				airport = new Airport();
				airport.setAirportCode(rs.getString(1));
				airport.setAirportName(rs.getString(2));
				airport.setAirportLocation(rs.getString(3));
			}
			airportList.add(airport);
			return airportList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Airport viewAirport(String airportCode) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from airport where airportCode=?");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				airport = new Airport();
				airport.setAirportCode(rs.getString(1));
				airport.setAirportName(rs.getString(2));
				airport.setAirportLocation(rs.getString(3));
			}
			return airport;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
