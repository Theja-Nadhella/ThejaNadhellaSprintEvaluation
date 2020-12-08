package com.cg.timecard.entities;

/**Author: Theja Nadhella 
 * Project Desc: Time Card Service
 * Class Desc: Employee Entity describing all attributes related to employee**/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**creating table with name employees*/
@Entity(name="employees")  
public class Employee {
	
	@Id
	@Column(unique=true,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique=true,updatable=false)
	@JoinColumn(name="empId")
	@NotNull(message = "Employee ID is Required")
	@Size(min=3,max=6)
	private String empId;
	@NotNull(message = "Employee Name is Required")
	private String empName;
	@NotNull(message = "Employee phone number is Required")
	@Size(min=10,max=10)
	private String phoneNumber;
	@NotNull(message = "Employee Email is Required")
	private String empEmail;
	@NotNull(message = "Supervisor Id is Required")
	@Size(min=3,max=6)
	private String supervisorId;
	
	/**no-argument constructor
	 */
	public Employee() {
		super();
	}
	
    /**This constructor initialize data members with the values of passed arguments while object of that class created
     * 
     * @param id
     * @param empId
     * @param empName 
     * @param phoneNumber
     * @param empEmail
     * @param supervisorId
     */
	public Employee(int id, String empId, String empName, String phoneNumber,String empEmail, String supervisorId) {
		super();
		this.id=id;
		this.empId = empId;
		this.empName = empName;
		this.phoneNumber = phoneNumber;
		this.empEmail = empEmail;
		this.supervisorId = supervisorId;
	}
	 /**Create getters and setter methods  
	  * @return
	  */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	
	/**one employee can fill time card once for a day
	 * @OneToOne - Cardinality or Relationship between two entities
	@OneToMany
	private List<TimecardDetails> timecardDetails=new ArrayList<>();
	public List<TimecardDetails> getTimecardDetails() {
		return timecardDetails;
	}

	public void setTimecardDetails(List<TimecardDetails> timecardDetails) {
		this.timecardDetails = timecardDetails;
	}
	*/
	
}
