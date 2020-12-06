package com.cg.timecard.exception;
/**Author: Theja Nadhella 
Project Desc: Time Card Service
Class Desc: This Exception refers for impossibilities in Employee class**/
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIdException extends Exception {

	private static final long serialVersionUID = 1L;
	
	//No-arg Constructor
	public EmployeeIdException() {
		super();
	}
	
	//Parameterized constructor
	public EmployeeIdException(String message) {
		super(message);
	}
}
