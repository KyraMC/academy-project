package com.bptn.project;

public class Course {

	// Class Variables:
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

	// Returns course info as string and checks if its am or pm
	@Override
	public String toString() {
		String start = "";
		String end = "";
		if (courseStartTime < 12.00) {
			start = "a.m";
			if (courseEndTime < 12.00) {
				end = "a.m";
			} else {
				end = "p.m";
			}
		} else {
			start = "p.m";
			end = "p.m";
		}
		String printStart = "";
		String printEnd = "";
		if ((courseStartTime - 0.29) > (int) courseStartTime) {
			printStart = (int) (courseStartTime - 0.3) + ":30";
		} else {
			printStart = (int) courseStartTime + ":00";
		}
		if ((courseEndTime - 0.29) > (int) courseEndTime) {
			printEnd = (int) (courseEndTime - 0.3) + ":30";
		} else {
			printEnd = (int) courseEndTime + ":00";
		}
		return "Course ID: " + courseID + "\nCourse Name: " + courseName + "\nProfessor Name: " + professorName
				+ "\nCourse Day: " + courseDay + "\nStart Time: " + printStart + start + "\nEnd Time: " + printEnd + end
				+ "\n";
	}

}
