package com.cg.timecard.entities;

/**Author:  KrishVyas
Class Desc: Time card details Entity describing all attributes related to Timecard**/

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity(name="timecard")
public class TimecardDetails { 
	
	@Id
	@Column(unique=true,updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)	
	    private int id;
		@Column(unique=true,updatable=false)
		@NotNull(message = "Timecard ID is Required")
	    private String timecardId;	    
	    @Column(name="Project_Id")
		private int projectId;
	    @Column(name="hours")
	    private int hours;
	    @JsonFormat(pattern= "dd-MM-yyyy")
		private Date date;
		@NotNull(message = "Project Name is Required")
		private String projectName;
		@NotNull(message ="Initially, the Status is Pending")
		private String timecardStatus;
		@Column(unique=true,updatable=false)
		private int empId;
		
		/*no-argument constructor*/
		public TimecardDetails() {
			super();
		}
		/*This constructor initialize data members with the values of passed arguments while object of that class created.*/
		public TimecardDetails(int id, String timecardId, int projectId, int hours, Date date, String projectName,String timecardStatus,int empId) {
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
		
		/* Create getters and setter methods
		 * Purpose :getter reads the value of a variable, setter updates the value of a variable */
		
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
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
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
		
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		/*toString method : when we need a string representation of an object(Not Mandatory)*/
		@Override
		public String toString() {
			return "TimecardDetails [id=" + id + ", timecardId=" + timecardId + ", projectId=" + projectId + ", hours="
					+ hours + ", date=" + date + ", projectName=" + projectName + ", timecardStatus=" + timecardStatus
					+ ", empId=" + empId + "]";
		}
			

}
