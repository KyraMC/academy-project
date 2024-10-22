package com.bptn.project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Schedule {
//	Class Variables:
	private static HashMap<String, Course> ALL_COURSES; // (String is courseID)
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
		return ALL_COURSES.containsKey(courseID.toUpperCase());
	}

	public Course getCourse(String courseID) {
		if (courseExists(courseID)) {
			return ALL_COURSES.get(courseID.toUpperCase());
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
			currentSchedule.put(courseID.toUpperCase(), ALL_COURSES.get(courseID.toUpperCase()));
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

	public static List<Course> sortSchedule(List<Course> courses) {
		if (courses.size() > 0) {
			List<Course> sorted = courses.stream().sorted(Comparator.comparing(Course::getCourseStartTime))
					.collect(Collectors.toList());
			return sorted;
		} else {
			return null;
		}
	}

	public void printDay(List<Course> daySchedule) {
		for (Course course : daySchedule) {
			course.printCourseInfo();
		}
	}

	public static void printDayAllCourses(List<Course> daySchedule) {
		for (Course course : daySchedule) {
			System.out.println(course.getCourseID() + ": " + course.getCourseName());
		}
	}

	public static void printALL_COURSES() {
		Iterator<Entry<String, Course>> itr = ALL_COURSES.entrySet().iterator();
		List<Course> monday = new ArrayList<>();
		List<Course> tuesday = new ArrayList<>();
		List<Course> wednesday = new ArrayList<>();
		List<Course> thursday = new ArrayList<>();
		List<Course> friday = new ArrayList<>();
		while (itr.hasNext()) {
			Entry<String, Course> entry = itr.next();
			if (entry.getValue().getCourseDay().equals("Monday")) {
				monday.add(entry.getValue());
			} else if (entry.getValue().getCourseDay().equals("Tuesday")) {
				tuesday.add(entry.getValue());
			} else if (entry.getValue().getCourseDay().equals("Wednesday")) {
				wednesday.add(entry.getValue());
			} else if (entry.getValue().getCourseDay().equals("Thursday")) {
				thursday.add(entry.getValue());
			} else {
				friday.add(entry.getValue());
			}
		}
		monday = sortSchedule(monday);
		tuesday = sortSchedule(tuesday);
		wednesday = sortSchedule(wednesday);
		thursday = sortSchedule(thursday);
		friday = sortSchedule(friday);

		System.out.println("*********MONDAY*********");
		printDayAllCourses(monday);

		System.out.println("*********TUESDAY*********");
		printDayAllCourses(tuesday);

		System.out.println("*********WEDNESDAY*********");
		printDayAllCourses(wednesday);

		System.out.println("*********THURSDAY*********");
		printDayAllCourses(thursday);

		System.out.println("*********FRIDAY*********");
		printDayAllCourses(friday);

	}

	public void printSchedule() {
		if (currentSchedule.size() > 0) {
			Iterator<Entry<String, Course>> itr = currentSchedule.entrySet().iterator();
			List<Course> monday = new ArrayList<>();
			List<Course> tuesday = new ArrayList<>();
			List<Course> wednesday = new ArrayList<>();
			List<Course> thursday = new ArrayList<>();
			List<Course> friday = new ArrayList<>();
			while (itr.hasNext()) {
				Entry<String, Course> entry = itr.next();
				if (entry.getValue().getCourseDay().equals("Monday")) {
					monday.add(entry.getValue());
				} else if (entry.getValue().getCourseDay().equals("Tuesday")) {
					tuesday.add(entry.getValue());
				} else if (entry.getValue().getCourseDay().equals("Wednesday")) {
					wednesday.add(entry.getValue());
				} else if (entry.getValue().getCourseDay().equals("Thursday")) {
					thursday.add(entry.getValue());
				} else {
					friday.add(entry.getValue());
				}
			}
			monday = sortSchedule(monday);
			tuesday = sortSchedule(tuesday);
			wednesday = sortSchedule(wednesday);
			thursday = sortSchedule(thursday);
			friday = sortSchedule(friday);

			System.out.println("*********MONDAY*********");
			if (monday.size() > 0) {
				printDay(monday);
			}
			System.out.println("*********TUESDAY*********");
			if (tuesday != null) {
				printDay(tuesday);
			}
			System.out.println("*********WEDNESDAY*********");
			if (wednesday != null) {
				printDay(wednesday);
			}
			System.out.println("*********THURSDAY*********");
			if (thursday != null) {
				printDay(thursday);
			}
			System.out.println("*********FRIDAY*********");
			if (friday != null) {
				printDay(friday);
			}
		} else {
			System.out.println("There are no courses in your schedule!");
		}

	}
}
