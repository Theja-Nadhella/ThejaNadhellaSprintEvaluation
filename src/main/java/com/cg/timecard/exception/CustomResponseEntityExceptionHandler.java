package com.cg.timecard.exception;
/**Author: Theja Nadhella
 * Project Desc: Time Card Service
 * Class Desc: This class Handles all the Exceptions
 */
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler{
	
	/**It handles all errors responsible to Employee details
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler
	public final ResponseEntity<Object> handleEmployeeIdException(EmployeeIdException e, WebRequest request)
	{
		EmployeeIdExceptionResponse exceptionResponse=new EmployeeIdExceptionResponse(e.getMessage());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
				
	}
	
	/**It handles all errors responsible to time card details
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler
	public final ResponseEntity<Object> handleTimecardIdException(TimecardIdException ex, WebRequest request)
	{
		TimecardIdException exceptionResponse=new TimecardIdException(ex.getMessage());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
				
	}
	
	/**
	 * It gives the error details when an Exception is thrown
	 * @param ex
	 * @param request
	 * @return error details and http status
	 */

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	

}
