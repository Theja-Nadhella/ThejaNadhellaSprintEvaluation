package com.cg.timecard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.timecard.entities.TimecardDetails;
import com.cg.timecard.repositories.TimecardDetailsRepository;

@Service
public class TimecardDetailsService implements ITimecardDetailsService {
	@Autowired
	private TimecardDetailsRepository timecardDetailsRepository;
	
	/**This method adds time card details
	 * @param timecardDetails
	 */	
	public TimecardDetails saveTimecardDetails(TimecardDetails timecardDetails) {
		return timecardDetailsRepository.save(timecardDetails);		
	}
	
	@Override
	public TimecardDetails update(TimecardDetails timecardDetails) {
		return timecardDetailsRepository.save(timecardDetails);
				}

	/**This method finds time card details using time card ID
	 * @param timecardId
	 */

	@Override
	public TimecardDetails listTimecardDetailsById(String timecardId){  	
		return timecardDetailsRepository.findByTimecardId(timecardId);
	}
	
}
