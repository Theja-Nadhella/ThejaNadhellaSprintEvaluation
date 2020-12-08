package com.cg.timecard.services;
/**Author: Theja Nadhella */
import org.springframework.stereotype.Service;

import com.cg.timecard.entities.TimecardDetails;
@Service
public interface ITimecardDetailsService {

	/**To add time card details
	 * @param timecard
	 * @return 
	 */
	TimecardDetails saveTimecardDetails(TimecardDetails timecardDetails);

	/**To update the time card status
	 * @param timecardId
	 * @param timecardStatus
	 * @return 
	 */
	TimecardDetails update(TimecardDetails timecardDetails);
	
	/**To view timecard Details by timecard ID
	 * @param timecardId
	 * @return
	 */
	TimecardDetails listTimecardDetailsById(String timecardId);

	
}
