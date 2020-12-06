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


/*creating table with name employees*/
@Entity(name="employees")  
public class Employee {
	
	@Id
	@Column(unique=true,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique=true,updatable=false)
	@JoinColumn(name="empId")
	@NotNull(message = "Employee ID is Required")
	private String empId;
	@NotNull(message = "Employee Name is Required")
	private String empName;
	@NotNull(message = "Employee phone number is Required")
	private String phoneNumber;
	@NotNull(message = "Employee Email is Required")
	private String empEmail;
	@Column(name="supervisorId")
	private int supervisorId;
	
	/*no-argument constructor*/
	public Employee() {
		
	}
	
    /*This constructor initialize data members with the values of passed arguments while object of that class created.*/
	public Employee(int id, String empId, String empName, String phoneNumber,String empEmail, int supervisorId) {
		super();
		this.id=id;
		this.empId = empId;
		this.empName = empName;
		this.phoneNumber = phoneNumber;
		this.empEmail = empEmail;
		this.supervisorId = supervisorId;
	}

	 /* Create getters and setter methods */	 
	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", empName=" + empName + ", phoneNumber=" + phoneNumber
				+ ", empEmail=" + empEmail + ", supervisorId=" + supervisorId + "]";
	}

	/**public List<TimecardDetails> getTimecard() {
		return timecard;
	}

	public void setTimecard(List<TimecardDetails> timecard) {
		this.timecard = timecard;
	}
	
	/*Override Annotation : Subclass can implement a parent class method based on its requirement
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", empName=" + empName + ", phoneNumber=" + phoneNumber
				+ ", empEmail=" + empEmail + ", supervisorId=" + supervisorId + ", timecard=" + timecard + "]";
	}*/
	

}
