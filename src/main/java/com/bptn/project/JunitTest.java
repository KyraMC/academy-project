package com.bptn.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class JunitTest {
	private Course course = new Course("KIN110", "Introduction to Kineseology II", "Professor Goodheart", "Friday",
			9.00, 12.30);
	private StudentSchedule schedule = new StudentSchedule();
	private CompleteSchedule ALL_COURSES = new CompleteSchedule();

	@Test
	public void testGetCourseName() {
		assertEquals("Introduction to Kineseology II", course.getCourseName());
	}

	@Test
	public void testGetSchedule() {
		HashMap<String, Course> testSchedule = new HashMap<>();
		testSchedule.put(course.getCourseID(), course);
		ALL_COURSES.getSchedule();
		schedule.addCourse(course.getCourseID(), ALL_COURSES);

		assertEquals(testSchedule.toString(), schedule.getSchedule().toString());
	}
}
