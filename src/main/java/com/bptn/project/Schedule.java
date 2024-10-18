package com.bptn.project;

import java.util.HashMap;

public class Schedule {
//	Class Variables:
	private HashMap<String, Course> ALL_COURSES; // (String is courseID)
	private HashMap<String, Course> currentSchedule; // (String is courseID)

	// Constructor
	public Schedule() {
		ALL_COURSES = AllCoursesSchedule.getALL_COURSES();
		currentSchedule = new HashMap<>();

	}

//	Methods
	public HashMap<String, Course> getSchedule() {
		return currentSchedule;
	}

	public HashMap<String, Course> getAllCourses() {
		return ALL_COURSES;
	}

	public boolean courseExists(String courseID) {
		return ALL_COURSES.containsKey(courseID);
	}

	public Course getCourse(String courseID) {
		if (courseExists(courseID)) {
			return ALL_COURSES.get(courseID);
		} else {
			return null;
		}
	}

//		boolean courseConflict -> checks if the courseExists then checks if it can be added or if there is a conflict with other courses in the schedule
	public int courseConflict(String courseID) { // If course is already in schedule return -1,
		// if schedule conflict return 0, if no conflict return 1, if course doesn't
		// exist return 2
		if (currentSchedule.isEmpty()) {
			return 1;
		} else if (!courseExists(courseID.toUpperCase())) {
			return 2;
		} else {
			if (currentSchedule.containsKey(courseID.toUpperCase())) {
				return -1;
			} else {
				Course course = ALL_COURSES.get(courseID.toUpperCase());
				for (Course c : currentSchedule.values()) {
					if (course.getCourseEndTime() <= c.getCourseStartTime()
							|| course.getCourseStartTime() >= c.getCourseEndTime()) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

//	Void addCourse -> adds course if there is no course conflict and less than 6 courses in the schedule, otherwise print that you can’t get it
	public void addCourse(String courseID) {
		int conflict = courseConflict(courseID);
		if (conflict == 2) {
			System.out.println("This courseID does not exist!");
		} else if (conflict == -1) {
			System.out.println("This course is already in your schedule!");
		} else if (conflict == 0) {
			System.out.println("You have a conflict and cannot add this course to your schedule.");
		} else if (currentSchedule.size() >= 6) {
			System.out.println("You already have 6 courses in your schedule!");
		} else {
			currentSchedule.put(courseID, ALL_COURSES.get(courseID.toUpperCase()));
			System.out.println("The course was successfully added to your schedule!");
		}
	}

//		Void deleteCourse -> if courseID is in our schedule then we will remove it 
	public void deleteCourse(String courseID) {
		if (!courseExists(courseID.toUpperCase())) {
			System.out.println("This courseID does not exist!");
		} else if (!currentSchedule.containsKey(courseID.toUpperCase())) {
			System.out.println("This course is not in your schedule!");
		} else {
			currentSchedule.remove(courseID.toUpperCase());
			System.out.println("The course was successfully removed from your schedule!");
		}
	}
}
