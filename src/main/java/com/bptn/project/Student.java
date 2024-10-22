package com.bptn.project;

public class Student {
//	Class Variables:
	private String studentID;
	private String studentName;
	private String studentEmail; // email will be a school email “blah@school.com”
	private String studentPassword;
	private Schedule studentSchedule;

	public Student(String studentID, String studentName, String studentEmail, String studentPassword) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPassword = studentPassword;
		this.studentSchedule = new Schedule();

	}

//		Methods:
//		Getters
	public String getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public Schedule getStudentSchedule() {
		return studentSchedule;
	}

	public void printInfo() {
		System.out.println("Student ID: " + studentID + "\nName: " + studentName + "\nEmail: " + studentEmail);
	}

	public void setPassword(String newPassword) {
		studentPassword = newPassword;
	}
}
