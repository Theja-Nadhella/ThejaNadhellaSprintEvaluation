package com.cg.timecard.services;

/**Author : Theja Nadhella
 * Desc : This class checks all possible test cases for operations performed on Time card Service class
 */
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.timecard.entities.TimecardDetails;
import com.cg.timecard.repositories.TimecardDetailsRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class TimecardDetailsServiceTest {
	@MockBean
	private TimecardDetailsRepository timecardDetailsRepository;
	@Autowired
	private ITimecardDetailsService timecardDetailsService;
	
	/**This method checks possible test cases for saving time card Details details in a database
	 * @throws Exception
	 */
	@Test
	void testSaveTimecardDetails() {
		TimecardDetails timecardDetails=new TimecardDetails();
        timecardDetails.setTimecardId("1");
        timecardDetails.setProjectId(123);
        timecardDetails.setProjectName("Fresher");
        timecardDetails.setHours(9);
        timecardDetails.setDate("12-03-2020");
        timecardDetails.setEmpId("090");
        timecardDetails.setTimecardStatus("Pending");
        Mockito.when(timecardDetailsRepository.save(timecardDetails)).thenReturn(timecardDetails);
		assertThat(timecardDetailsService.saveTimecardDetails(timecardDetails)).isEqualTo(timecardDetails);	
	}
	
	/**This method checks for test cases for listing the time card details by time card ID
	 * @throws Exception
	 */
	@Test
	 void testListTimecardDetailsById() throws Exception {
		TimecardDetails timecardDetails=new TimecardDetails();
        timecardDetails.setTimecardId("1");
        timecardDetails.setProjectId(123);
        timecardDetails.setProjectName("Fresher");
        timecardDetails.setHours(9);
        timecardDetails.setDate("12-03-2020");
        timecardDetails.setEmpId("90");
        Mockito.when(timecardDetailsRepository.findByTimecardId("100")).thenReturn(timecardDetails);
        assertThat(timecardDetailsService.listTimecardDetailsById("100")).isEqualTo(timecardDetails);
	}
	
	/**This method checks for test cases for Updating the employee details
	 * @throws Exception
	 */
	@Test
	 void testUpdate() throws Exception{
		TimecardDetails timecardDetails=new TimecardDetails();
        timecardDetails.setTimecardId("1");
        timecardDetails.setProjectId(123);
        timecardDetails.setProjectName("Fresher");
        timecardDetails.setHours(9);
        timecardDetails.setDate("12-03-2020");
        timecardDetails.setEmpId("90");
        Mockito.when(timecardDetailsRepository.findByTimecardId("109")).thenReturn(timecardDetails);
		Mockito.when(timecardDetailsRepository.save(timecardDetails)).thenReturn(timecardDetails);
		assertThat(timecardDetailsService.update(timecardDetails)).isEqualTo(timecardDetails);
	}
	}


