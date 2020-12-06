package com.cg.timecard.controllers;

/**Author: Theja Nadhella 
 * Project Desc: Time Card Service
 * class Desc: Accesses all the methods declared in service class*/

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.timecard.entities.Employee;
import com.cg.timecard.exception.EmployeeIdException;
import com.cg.timecard.services.IEmployeeService;
import com.cg.timecard.services.MapValidationErrorService;

@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	/**
	 * This method adds employees input to the database
	 * @param employee-object of customer
	 * @param result-object   of binding result
	 * @return customer and http status
	 */
	@PostMapping("/details")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee, BindingResult result) throws EmployeeIdException {
		logger.info("Employee details are saved");
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null) {
			return errorMap;
		}
		Employee newEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
	}
	
	/**
	 * this method updates Employee details in the data base
	 * @param empId-id of employee to be updated
	 * @param employee
	 * @return string
	 */
	@PutMapping("/details/{empId}")
	public ResponseEntity<?> update(@PathVariable String empId, @RequestBody Employee employee) throws EmployeeIdException {
		logger.info("Details are Updated");
		Employee emp=employeeService.listEmployeeById(empId);
		if(emp==null || empId.length()<=0) {
			throw new EmployeeIdException("Updation cannot be possible for unavailable employee");
		}
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
	}


	/**
	 * this method deletes employee from data base
	 * @param empId-id of employee
	 * @return string
	 */
	@DeleteMapping("/details/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String empId)throws EmployeeIdException {
		logger.info("Employee to be removed: ");
		boolean b=employeeService.deleteEmployee(empId);
		if(b) {
			throw new EmployeeIdException("Employee is not present to delete..");
		}		
		return new ResponseEntity<Employee>(employeeService.listEmployeeById(empId), HttpStatus.OK);
	}

	
	/**
	 * this method displays the employee through ID
	 * @param empId
	 * @return employee
	 */
	@GetMapping("/details/{empId}")
	public ResponseEntity<?> listByEmpId(@PathVariable String empId)throws EmployeeIdException {
		logger.info("Employee to be returned: ");
		Employee employee=employeeService.listEmployeeById(empId);
		if(employee==null || empId.length()<=0) {
			throw new EmployeeIdException("Employee with the ID " + empId + "does not exists");
		}
		return new ResponseEntity<Employee>(employeeService.listEmployeeById(empId), HttpStatus.OK);
	}

	/**
	 * this method displays all employees
	 * @return list of employees
	 */
	@GetMapping("/details/list")
	public Iterable<Employee> listAllEmployees() {
		logger.info("Listing all Employees");
		return employeeService.listAllEmployees();
	}
	
}
