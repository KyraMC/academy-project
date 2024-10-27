package com.bptn.project;

public class Student {
//	Class Variables:
	private String studentID;
	private String studentName;
	private String studentEmail; // email will be a school email “blah@school.com”
	private String studentPassword;
	private StudentSchedule studentSchedule;

	// Constructor
	public Student(String studentID, String studentName, String studentEmail, String studentPassword) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPassword = studentPassword;
		this.studentSchedule = new StudentSchedule();

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

	public StudentSchedule getStudentSchedule() {
		return studentSchedule;
	}

	// Prints all student info
	public void printInfo() {
		System.out.println(ConsoleColors.PURPLE + "Student ID: " + studentID.toUpperCase() + "\nName: "
				+ studentName.toUpperCase() + "\nEmail: " + studentEmail.toLowerCase() + ConsoleColors.RESET);
	}

	// setter
	public void setPassword(String newPassword) {
		studentPassword = newPassword;
	}
}
