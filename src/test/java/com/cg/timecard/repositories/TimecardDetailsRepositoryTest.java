package com.cg.timecard.repositories;

/**Author : Theja Nadhella
 * Desc : This class checks all possible test cases for operations performed on Time card Details Repository
 */
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.timecard.entities.TimecardDetails;
@RunWith(SpringRunner.class)
@DataJpaTest
class TimecardDetailsRepositoryTest {
	
	@Autowired
	private TimecardDetailsRepository timecardDetailsRepository;
	
	/**This method checks possible test cases for finding time card details by time card ID 
	 * @throws Exception
	 */ 
	@Test
	void findByTimecardId() throws Exception {
		TimecardDetails timecardDetails=new TimecardDetails();
        timecardDetails.setTimecardId("199");
        timecardDetails.setProjectId(123);
        timecardDetails.setProjectName("Fresher");
        timecardDetails.setHours(9);
        timecardDetails.setDate("12-03-2020");
        timecardDetails.setEmpId("390");
        timecardDetails.setTimecardStatus("Pending");
        
        timecardDetailsRepository.save(timecardDetails);
		Assert.assertNotNull(timecardDetailsRepository.findByTimecardId("199"));
	}

}
