package com.bptn.project;

public class Course {

//		Class Variables:
	private String courseID;
	private String courseName;
	private String professorName;
	private String courseDay;
	private double courseStartTime;
	private double courseEndTime;

	// Constructor
	public Course(String courseID, String courseName, String professorName, String courseDay, double courseStartTime,
			double courseEndTime) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.professorName = professorName;
		this.courseDay = courseDay;
		this.courseStartTime = courseStartTime;
		this.courseEndTime = courseEndTime;
	}

//	Methods:

//	Getters
	public String getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getProfessorName() {
		return professorName;
	}

	public String getCourseDay() {
		return courseDay;
	}

	public double getCourseStartTime() {
		return courseStartTime;
	}

	public double getCourseEndTime() {
		return courseEndTime;
	}

//	print all course info
	public void printCourseInfo() {
		System.out.println("Course ID: " + courseID + "\n Course Name: " + courseName + "\n Professor Name: "
				+ professorName + "\n Course Day: " + courseDay + "\n Start Time: " + courseStartTime + "\n End Time: "
				+ courseEndTime);
	}

}
