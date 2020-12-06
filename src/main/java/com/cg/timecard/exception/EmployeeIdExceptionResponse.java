package com.cg.timecard.exception;
/**Author : Theja Nadhella*/

public class EmployeeIdExceptionResponse {
	private String empId;
	
	//Parameterized Constructor
	public EmployeeIdExceptionResponse(String empId) {
		super();
		this.empId=empId;
		
	}
	
	/**get Employee Id
	 * @return
	 */
	public String getEmpId() {
		return empId;
	}
	
	/**set input to employee ID
	 * @param empId
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}
}
