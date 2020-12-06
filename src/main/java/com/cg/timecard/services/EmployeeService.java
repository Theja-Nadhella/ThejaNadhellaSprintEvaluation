package com.cg.timecard.services;
/**Author : Theja Nadhella
 * Desc : Employee service class deals with all methods to perform different operations on object
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.timecard.entities.Employee;
import com.cg.timecard.exception.EmployeeIdException;
import com.cg.timecard.repositories.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**this method adds new employee
	 * @param employee
	 */
	public Employee saveEmployee(Employee employee) {		
		return employeeRepository.save(employee);
	}	
	
	
	/**
	 * this method deletes Employee from database
	 * @param empId-id of customer to be deleted
	 * @return 
	 */	
	public boolean deleteEmployee(String empId)throws EmployeeIdException{
		Employee emp=employeeRepository.findByEmpId(empId);
		try {
			if(emp==null) {
				throw new EmployeeIdException("Employee with the given ID is not found");
			}
			else {
				employeeRepository.deleteById(empId);
				return true;
			}
		}
		catch(EmployeeIdException e) {
		return false;			        
	}
}
	/**
	 * this method updates employee in the database		
	 * @param employee-employee to be updated
	 * @return employee
	 */		
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
		 
	}	

	/**
	 * this method give employee by his/her Id
	 * @param empId-id of employee to be shown
	 * @return employee
	 */	
	@Override
	public Employee listEmployeeById(String empId)throws EmployeeIdException {  
		Employee emp=employeeRepository.findByEmpId(empId);
		try {
		    if(emp==null)
			    throw new EmployeeIdException("Employee not found");
		    else
		    	return emp;
		}
		catch(EmployeeIdException e) {
			return null;
		}
	}

	
	
	
	/**
     * this method shows all employees available in the database
     * @return list of employees
     */
	@Override
	public Iterable<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}
	
}


