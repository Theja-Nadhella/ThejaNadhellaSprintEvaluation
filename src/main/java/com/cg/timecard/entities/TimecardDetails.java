package com.cg.timecard.entities;

/**Author:  ThejaNadhella
Class Desc: Time card details Entity describing all attributes related to Timecard**/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="timecard")
public class TimecardDetails { 
	
	@Id
	@Column(unique=true,updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)	
	    private int id;
		@Column(unique=true,updatable=false)
		@NotNull(message = "Timecard ID is Required")
		@Size(min=3,max=7)
	    private String timecardId;	    
	    @Column(name="Project_Id")
		private int projectId;
	    @Column(name="hours")
	    private int hours;
	    @JsonFormat(pattern= "dd-MM-yyyy")
		private String date;
		@NotNull(message = "Project Name is Required")
		private String projectName;
		@NotNull(message ="Initially, the Status is Pending")
		private String timecardStatus;
		@Column(unique=true,updatable=false)
		@NotNull(message ="Employee ID is required")
		@Size(min= 3, max = 6)
		private String empId;
		
		
		/**no-argument constructor
		 */
		public TimecardDetails() {
			super();
		}
		/**This constructor initialize data members with the values of passed arguments while object of that class created
		 * @param id
		 * @param timecardId
		 * @param projectId
		 * @param hours
		 * @param date
		 * @param projectName
		 * @param timecardStatus
		 * @param empId
		 */
		public TimecardDetails(int id, String timecardId, int projectId, int hours, String date, String projectName,String timecardStatus,String empId) {
			super();
			this.id=id;
			this.timecardId = timecardId; 
			this.projectId = projectId;
			this.hours = hours;
			this.date = date;
			this.projectName = projectName;
			this.timecardStatus = timecardStatus;
			this.empId=empId;
		}
		
		/**Create getters and setter methods
		 * 
		 * @return
		 */	
		public int getProjectId() {
			return projectId;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTimecardId() {
			return timecardId;
		}
		public void setTimecardId(String timecardId) {
			this.timecardId = timecardId;
		}
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getHours() {
			return hours;
		}
		public void setHours(int hours) {
			this.hours = hours;
		}
		public String getTimecardStatus() {
			return timecardStatus;
		}
		public void setTimecardStatus(String timecardStatus) {
			this.timecardStatus = timecardStatus;
		}
		public String getEmpId() {
			return empId;
		}
		public void setEmpId(String empId) {
			this.empId = empId;
		}
		/**cardinality that give relationship between two entities
		
		@ManyToOne(fetch=FetchType.LAZY, optional=false)		
		
		private Employee employee;
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		} */
		
}
