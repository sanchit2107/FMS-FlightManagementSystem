package com.cg.sprint1.exceptions;

public class AirportNotFoundException extends RuntimeException{

	public AirportNotFoundException(String msg) {
		super(msg);
	}
}
