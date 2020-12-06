package com.cg.timecard.exception;
/**Author: Theja Nadhella and Krish Vyas
Project Desc: Time Card Service
Class Desc: This Exception refers for impossibilities in Employee class**/
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TimecardIdException extends Exception {

	private static final long serialVersionUID = 1L;
	
	//No parameter Constructor
	public TimecardIdException() {
		super();
	}
	
	//Parameterized Constructor
	public TimecardIdException(String message) {
		super(message);
	}

}
