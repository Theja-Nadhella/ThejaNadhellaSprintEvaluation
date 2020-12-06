package com.cg.timecard.repositories;

/**Author: KrishVyas
 * Desc: Timecard details Repository Interface performing crud operations on timecard details*/

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.timecard.entities.TimecardDetails;
@Repository
public interface TimecardDetailsRepository extends CrudRepository<TimecardDetails, String>{

	/**Find time card details using time card ID
	 * @param timecardId
	 * @return
	 */
	TimecardDetails findByTimecardId(String timecardId);
}
