package com.cg.timecard.repositories;

/**Author : Theja Nadhella
 * Desc : This class checks all possible test cases for operations performed on Employee Repository
 */
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.timecard.entities.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * this method tests the find by employee id method 
	 * @throws Exception
	 */
	@Test
	 void testFindByEmpId() throws Exception{
		Employee employee=new Employee();		
		employee.setEmpId("108");
        employee.setEmpName("Theja Nadhella");
        employee.setEmpEmail("thejanadhella@gmail.com");
        employee.setPhoneNumber("908765431");
        employee.setSupervisorId(789);
        
		employeeRepository.save(employee);
		Assert.assertNotNull(employeeRepository.findByEmpId("108"));
	}

}
