package com.cg.timecard.repositories;

/**Author: Theja Nadhella 
Project Desc: Time Card Service
Desc: EmployeeRepository Interface performing crud operations on Employee**/

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.timecard.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
	
	/**Find employee details by using ID
	 * @param empId
	 * @return
	 */
	Employee findByEmpId(String empId);

	

}
