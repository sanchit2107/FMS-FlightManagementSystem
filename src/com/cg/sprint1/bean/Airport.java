package com.cg.sprint1.bean;

/**
 * 
 * @author Sanchit Singhal/Piyush/Sadia/Riya
 *
 */

public class Airport {

	private String airportName;
	private String airportCode;
	private String airportLocation;
	
	/**
	 * parameterized constructor 
	 * @param airportName
	 * @param airportCode
	 * @param airportLocation
	 */
	public Airport(String airportName, String airportCode, String airportLocation) {
		super();
		this.airportName = airportName;
		this.airportCode = airportCode;
		this.airportLocation = airportLocation;
	}

	/**
	 * default constructor
	 */
	public Airport() {
	
	}
	
	/**
	 * 
	 * @return airportName
	 */
	public String getAirportName() {
		return airportName;
	}

	/**
	 * 
	 * @param airportName
	 */
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	/**
	 * 
	 * @return
	 */
	public String getAirportCode() {
		return airportCode;
	}

	/**
	 * 
	 * @param airportCode
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	/**
	 * 
	 * @return
	 */
	public String getAirportLocation() {
		return airportLocation;
	}

	/**
	 * 
	 * @param airportLocation
	 */
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	
	
}
