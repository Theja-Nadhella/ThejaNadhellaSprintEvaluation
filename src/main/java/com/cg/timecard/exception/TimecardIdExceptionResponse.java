package com.cg.timecard.exception;

public class TimecardIdExceptionResponse {
	private String timecardId;

	public TimecardIdExceptionResponse(String timecardId) {
		super();
		
	}

	public String getTimecardId() {
		return timecardId;
	}

	public void setTimecardId(String timecardId) {
		this.timecardId = timecardId;
	}
}
