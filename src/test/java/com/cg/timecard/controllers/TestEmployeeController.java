package com.cg.timecard.controllers;
/**Author: Theja Nadhella 
 * Desc: This class tests all the possible test cases for the operations performed on Employee Controller
 */
import java.util.ArrayList;
import java.util.List;

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

import com.cg.timecard.entities.Employee;
import com.cg.timecard.repositories.EmployeeRepository;
import com.cg.timecard.services.IEmployeeService;
import com.cg.timecard.services.MapValidationErrorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
class TestEmployeeController {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	EmployeeRepository employeeRepository;
	@MockBean
	private IEmployeeService employeeService;
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	
	/**This method checks test cases for saving the employee details
	 * @throws Exception
	 */
	@Test
	void testSaveEmployee() throws Exception{
        String URI = "/details";
        Employee employee = new Employee();
        employee.setEmpId("100");
        employee.setEmpName("Theja");
        employee.setEmpEmail("theja@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId("789");
        String jsonInput = this.converttoJson(employee);
        Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(employee);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
}	
	/** This method checks possible test cases for finding employee by his/her ID in a database
	 * @throws Exception
	 */
	@Test
	void testListByEmpId() throws Exception {
		String URI= "/details/{empId}";
		Employee employee = new Employee();
        employee.setEmpId("1000");
        employee.setEmpName("Theja Nadhella");
        employee.setEmpEmail("thejanadhella@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId("789");
        String jsonInput = this.converttoJson(employee);
        Mockito.when(employeeService.listEmployeeById(Mockito.any())).thenReturn(employee);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	/**This method checks test cases for Updating the employee details
	 * @throws Exception
	 */
	@Test
	void testUpdate() throws Exception {
		String URI= "/details/{empId}";
		Employee employee = new Employee();
        employee.setEmpId("100");
        employee.setEmpName("NTheja");
        employee.setEmpEmail("ntheja@gmail.com");
        employee.setPhoneNumber("90870000");
        employee.setSupervisorId("7098");
        String jsonInput = this.converttoJson(employee);
        Mockito.when(employeeService.listEmployeeById(Mockito.any())).thenReturn(employee);
        Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(employee);
        Mockito.when(employeeService.updateEmployee(employee)).thenReturn(employee);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,100).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	/**This method checks test cases for Listing all the employees
	 * @throws Exception
	 */
	@Test
	void testListAllEmployees() throws Exception {
		String URI = "/details/list";
		Employee employee = new Employee();
        employee.setEmpId("100");
        employee.setEmpName("NTheja");
        employee.setEmpEmail("ntheja@gmail.com");
        employee.setPhoneNumber("90870000");
        employee.setSupervisorId("788");

        employee.setEmpId("108");
        employee.setEmpName("Theja Nadhella");
        employee.setEmpEmail("thejanadhella@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId("789");
        List<Employee> empList=new ArrayList<>();
        empList.add(employee);
        empList.add(employee);	    	 
        String jsonInput = this.converttoJson(empList);

	         Mockito.when(employeeService.listAllEmployees()).thenReturn(empList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();
	         assertThat(jsonInput).isEqualTo(jsonOutput);
	     }
	
	/**this method checks test cases for deleting employee from employee list
	 * @throws Exception
	 */
	@Test
	void testDelete() throws Exception {
		String URI = "/details/{empId}";
		Employee employee = new Employee();
        employee.setEmpId("100");
        employee.setEmpName("Theja Nadhella");
        employee.setEmpEmail("thejanadhella@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId("789");
       
        Mockito.when(employeeRepository.findByEmpId("100")).thenReturn(employee);
		Mockito.when(employeeService.deleteEmployee("100")).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 100).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonOutput).isEqualTo(jsonOutput);
	} 
	
	/**this method converts string to JSON Format
	 * @param timecardDetails
	 * @return
	 * @throws JsonProcessingException
	 */
	private String converttoJson(Object employee) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(employee);
}   

		
}
