package com.cg.timecard.controllers;
/**Author:Krish Vyas
* Desc: Accesses all the methods declared in service class*/
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.timecard.entities.TimecardDetails;
import com.cg.timecard.exception.TimecardIdException;
import com.cg.timecard.services.ITimecardDetailsService;
import com.cg.timecard.services.MapValidationErrorService;

@RestController
public class TimecardDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(TimecardDetailsController.class);
	@Autowired
	private ITimecardDetailsService timecardDetailsService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	
	/**This method adds time card details input to the database
	 * @param timecardDetails
	 * @param result
	 * @return
	 */
	@PostMapping("/timecard")
	public ResponseEntity<?> saveTimecardDetails(@Valid @RequestBody TimecardDetails timecardDetails, BindingResult result) throws TimecardIdException {
		logger.info("Timecard Details are Saved");
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null) {
			return errorMap;
		}
		TimecardDetails newTimecardDetails = timecardDetailsService.saveTimecardDetails(timecardDetails);
		return new ResponseEntity<TimecardDetails>(newTimecardDetails, HttpStatus.CREATED);
	}
	
	/**
	 * this method displays the time card details through ID
	 * @param timecardId
	 * @return TimecardDetails
	 */
	@GetMapping("/timecard/{timecardId}")
	public ResponseEntity<?> listByTimecardId(@PathVariable String timecardId) throws TimecardIdException {
		logger.info("Time card details to be displayed:");
		TimecardDetails timecardDetails=timecardDetailsService.listTimecardDetailsById(timecardId);
		if(timecardDetails==null || timecardId.length()<=0){
			throw new TimecardIdException("Timecard details with ID "+ timecardId + "does not exists");
		}
		return new ResponseEntity<TimecardDetails>(timecardDetailsService.listTimecardDetailsById(timecardId), HttpStatus.OK);
	}
	
	/**
	 * this method updates time card details in the data base
	 * @param timecardId
	 * @param timecardDetails
	 * @return string
	 */
	@PutMapping("/timecard/{timecardId}")
	public ResponseEntity<?> update(@PathVariable String timecardId, @RequestBody TimecardDetails timecardDetails) throws TimecardIdException {
		logger.info("Details are Updated");
		TimecardDetails timecardDetail=timecardDetailsService.listTimecardDetailsById(timecardId);
		if(timecardDetail==null || timecardId.length()<=0) {
			throw new TimecardIdException("Updation cannot be possible for unavailable time sheet");
		}
		return new ResponseEntity<TimecardDetails>(timecardDetailsService.saveTimecardDetails(timecardDetails), HttpStatus.OK);
	}

}
	
