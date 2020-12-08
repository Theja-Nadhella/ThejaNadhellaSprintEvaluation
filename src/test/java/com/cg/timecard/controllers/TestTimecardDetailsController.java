package com.cg.timecard.controllers;
/**Author: Theja Nadhella 
 * Desc: This class tests all the possible test cases for the operations performed on Timecard Details Controller
 */
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.timecard.entities.TimecardDetails;
import com.cg.timecard.repositories.TimecardDetailsRepository;
import com.cg.timecard.services.ITimecardDetailsService;
import com.cg.timecard.services.MapValidationErrorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@WebMvcTest(value = TimecardDetailsController.class)
class TestTimecardDetailsController {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	TimecardDetailsRepository timecardDetailsRepository;
	@MockBean
	private ITimecardDetailsService timecardDetailsService;
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	
	/**This method checks if any errors are there in saving time card details
	 * @throws Exception
	 */
	@Test
	void testSaveTimecardDetails() throws Exception{
        String URI = "/timecard";
        TimecardDetails timecardDetails=new TimecardDetails();
        timecardDetails.setTimecardId("1");
        timecardDetails.setProjectId(123);
        timecardDetails.setProjectName("Fresher");
        timecardDetails.setHours(9);
        timecardDetails.setDate("12-03-2020");
        timecardDetails.setEmpId("900");
        timecardDetails.setTimecardStatus("Pending");
        
        String jsonInput = this.converttoJson(timecardDetails);
        Mockito.when(timecardDetailsService.saveTimecardDetails(Mockito.any(TimecardDetails.class))).thenReturn(timecardDetails);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
}	
	/**This method checks if any errors are there in listing time card details by time card ID
	 * @throws Exception
	 */
	@Test
	void testListByTimecardId() throws Exception {
		String URI= "/timecard/{timecardId}";
		TimecardDetails timecardDetails=new TimecardDetails();
        timecardDetails.setTimecardId("1");
        timecardDetails.setProjectId(123);
        timecardDetails.setProjectName("Fresher");
        timecardDetails.setHours(9);
        timecardDetails.setDate("12-03-2020");
        timecardDetails.setEmpId("980");
        timecardDetails.setTimecardStatus("Pending");
        String jsonInput = this.converttoJson(timecardDetails);
        Mockito.when(timecardDetailsService.listTimecardDetailsById(Mockito.any())).thenReturn(timecardDetails);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	/**This method checks if any errors are there in updating time card details
	 * @throws Exception
	 */
	@Test
	void testUpdate() throws Exception {
		String URI= "/timecard/{timecardId}";
		TimecardDetails timecardDetails=new TimecardDetails();
        timecardDetails.setTimecardId("1");
        timecardDetails.setProjectId(123);
        timecardDetails.setProjectName("Fresher");
        timecardDetails.setHours(9);
        timecardDetails.setDate("12-03-2020");
        timecardDetails.setEmpId("990");
        timecardDetails.setTimecardStatus("Pending");
        String jsonInput = this.converttoJson(timecardDetails);
        Mockito.when(timecardDetailsService.listTimecardDetailsById(Mockito.any())).thenReturn(timecardDetails);
        Mockito.when(timecardDetailsService.saveTimecardDetails(Mockito.any(TimecardDetails.class))).thenReturn(timecardDetails);
        Mockito.when(timecardDetailsService.update(timecardDetails)).thenReturn(timecardDetails);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,100).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	/**this method converts string to JSON Format
	 * @param timecardDetails
	 * @return
	 * @throws JsonProcessingException
	 */
	      
	private String converttoJson(Object timecardDetails) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(timecardDetails);
}   
}
