package com.cg.timecard.services;
/**Author : Theja Nadhella
 * Desc : This class checks all possible test cases for operations performed on Employee Service class
 */
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.timecard.entities.Employee;
import com.cg.timecard.exception.EmployeeIdException;
import com.cg.timecard.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
 class EmployeeServiceTest {
	@MockBean
	private EmployeeRepository employeeRepository;
	@Autowired
	private IEmployeeService employeeService;

	/**This method checks possible test cases for saving employee details in a database
	 * @throws Exception
	 */
		@Test
		void testSaveEmployee() {
		Employee employee = new Employee();
        employee.setEmpId("100");
        employee.setEmpName("Theja");
        employee.setEmpEmail("theja@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId("789");	
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.saveEmployee(employee)).isEqualTo(employee);	
	}
	
	/** This method checks possible test cases for finding employee by his/her ID in a database
	 * @throws EmployeeIdException 
	 * @throws Exception
	 */
	@Test
	 void testListEmployeeById() throws EmployeeIdException {
		
		Employee employee = new Employee();
        employee.setEmpId("10");
        employee.setEmpName("Theja Nadhella");
        employee.setEmpEmail("thejanadhella@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId("789");   
        Mockito.when(employeeRepository.findByEmpId("100")).thenReturn(employee);
        assertThat(employeeService.listEmployeeById("100")).isEqualTo(employee);
	}
	
	
	/**This method checks for test cases for Updating the employee details
	 * @throws Exception
	 */
	@Test
	 void testUpdate() throws EmployeeIdException{
		Employee employee = new Employee();
        employee.setEmpId("109");
        employee.setEmpName("Theja N");
        employee.setEmpEmail("thejanadhella@gmail.com");
        employee.setPhoneNumber("90876431");
        employee.setSupervisorId("789");  
		Mockito.when(employeeRepository.findByEmpId("109")).thenReturn(employee);
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.updateEmployee(employee)).isEqualTo(employee);		
	}
	
	/**This method check for test cases for Listing all the employees
	 * @throws Exception
	 */
	@Test
	public void testListAllEmployees() {
		Employee employee = new Employee();
        employee.setEmpId("100");
        employee.setEmpName("NTheja");
        employee.setEmpEmail("ntheja@gmail.com");
        employee.setPhoneNumber("90870000");
        employee.setSupervisorId("78");

        employee.setEmpId("108");
        employee.setEmpName("Theja Nadhella");
        employee.setEmpEmail("thejanadhella@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId("789");
        List<Employee> empList=new ArrayList<>();
        empList.add(employee);
        empList.add(employee);	    
        Mockito.when(employeeRepository.findAll()).thenReturn(empList);
        assertThat(employeeService.listAllEmployees()).isEqualTo(empList);
	}
	
	/**this method checks test cases for deleting employee from employee list
	 * @throws Exception
	 */
	@Test
	 void testDelete() throws Exception {
		Employee employee = new Employee();
        employee.setEmpId("100");
        employee.setEmpName("Theja Nadhella");
        employee.setEmpEmail("thejanadhella@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId("789");
        employeeRepository.save(employee);
        Mockito.when(employeeRepository.findByEmpId("100")).thenReturn(employee);
		employeeService.deleteEmployee("100");
		Assert.assertNotNull(employeeRepository.findByEmpId("100"));
        
	}
	
}
