package com.bptn.project;

public class StudentDashboard {

	public static void main(String[] args) {
		Schedule sched = new Schedule();
		System.out.println(sched.getAllCourses());

		sched.addCourse("KIN110");
		sched.addCourse("CHM100");
		sched.addCourse("CIN100");
		sched.addCourse("BIO100");
		sched.addCourse("BIO250");
		sched.addCourse("LIT250");
		sched.addCourse("PHY210");
		sched.addCourse("PHY210");
		sched.addCourse("bio310");
		sched.addCourse("CAL110");

		System.out.println(sched.getSchedule());

	}

}
