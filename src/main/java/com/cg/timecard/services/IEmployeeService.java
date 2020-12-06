package com.cg.timecard.services;

/**Author: Theja Nadhella 
 * Project Desc: Time Card Service
 * Interface Desc: IEmployeeService Interface invokes methods of Employee service class*/
import org.springframework.stereotype.Service;
import com.cg.timecard.entities.Employee;
import com.cg.timecard.exception.EmployeeIdException;
@Service
public interface IEmployeeService {

	/**Adds new employee
	 * @param employee
	 * @return
	 */
	public Employee saveEmployee(Employee employee);

	/**Delete an Employee
	 * @param empId
	 * @return 
	 * @throws EmployeeIdException 
	 */
	public boolean deleteEmployee(String empId) throws EmployeeIdException;

	/**Update an Employee
	 * @param employee
	 * @param object 
	 * @return
	 * @throws EmployeeIdException 
	 */
	public Employee updateEmployee(Employee employee);

	/**Show the list of all employees 
	 * @return
	 */
	public Iterable<Employee> listAllEmployees();

	/**Display employee by his/her ID
	 * @param empId
	 * @return
	 * @throws EmployeeIdException 
	 */
	public Employee listEmployeeById(String empId) throws EmployeeIdException;	

}
