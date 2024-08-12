package com.example.CRUD_OPERATIONS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private String StudentName;
	private String StudentEmail;
	private String StudentAddress;
	
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	
	
	public Student(long iD, String studentName, String studentEmail, String studentAddress) {
		super();
		ID = iD;
		StudentName = studentName;
		StudentEmail = studentEmail;
		StudentAddress = studentAddress;
	}
	
	
	public Student() {
		super();	
	}
	
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", StudentName=" + StudentName + ", StudentEmail=" + StudentEmail
				+ ", StudentAddress=" + StudentAddress + "]";
	}
	
	
	
	
}
