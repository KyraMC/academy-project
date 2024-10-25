package com.bptn.project;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

abstract class Schedule {
	protected HashMap<String, Course> schedule;

	public Schedule() {
		schedule = new HashMap<>();
	}

	public HashMap<String, Course> getSchedule() {
		return schedule;
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

	public abstract void printDay(List<Course> daySchedule);

	public abstract void printSchedule();
}
