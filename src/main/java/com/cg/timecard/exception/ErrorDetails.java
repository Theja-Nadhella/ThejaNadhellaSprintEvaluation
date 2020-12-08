package com.cg.timecard.exception;
/**Author : Theja Nadhella
 */
import java.util.Date;
 
public class ErrorDetails {
	private String message;
	private String details;
	private Date timestamp;
	
	/**Parameterized Constructor
	 * 
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
