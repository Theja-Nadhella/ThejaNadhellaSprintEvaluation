package com.cg.timecard.exception;
/**Author: Theja Nadhella 
Project Desc: Time Card Service
Class Desc: This Exception refers for impossibilities in Employee class**/
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TimecardIdException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**No parameter constructor
	 */
	public TimecardIdException() {
		super();
	}
	
	/**Parameterized Constructor
	 * 
	 * @param message
	 */
	public TimecardIdException(String message) {
		super(message);
	}

}
