package com.bptn.project;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// Schedule abstract class
abstract class Schedule {
	// Class variable
	protected HashMap<String, Course> schedule;

	// Constructor
	public Schedule() {
		schedule = new HashMap<>();
	}

	// Getter
	public HashMap<String, Course> getSchedule() {
		return schedule;
	}

	// Sorts list of courses by their start time
	public static List<Course> sortSchedule(List<Course> courses) {
		if (courses.size() > 0) {
			List<Course> sorted = courses.stream().sorted(Comparator.comparing(Course::getCourseStartTime))
					.collect(Collectors.toList());
			return sorted;
		} else {
			return null;
		}

	}

	// abstract class for printing all the courses in a day
	public abstract void printDay(List<Course> daySchedule);

	// abstract class for printing all the courses in a schedule
	public abstract void printSchedule();
}
