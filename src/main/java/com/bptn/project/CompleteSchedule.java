package com.bptn.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class CompleteSchedule extends Schedule {

	public CompleteSchedule() {
		super();
	}

	public void addCourse() {
		// create courses and add them to ALL_COURSES
		// Monday Courses
		Course c1 = new Course("PHY100", "Introduction to Physics", "Professor X", "Monday", 12.00, 14.00);
		Course c2 = new Course("BIO100", "Introduction to Biology", "Professor Darwin", "Monday", 14.00, 15.30);
		Course c3 = new Course("CAL100", "Introduction to Calculus", "Professor Leibniz", "Monday", 14.00, 16.30);
		Course c4 = new Course("CSC100", "Introduction to Computer Science", "Professor Lovelace", "Monday", 10.00,
				12.30);
		Course c5 = new Course("LIT100", "Introduction to Literature", "Professor Austen", "Monday", 12.00, 15.00);
		schedule.put("PHY100", c1);
		schedule.put("BIO100", c2);
		schedule.put("CAL100", c3);
		schedule.put("CSC100", c4);
		schedule.put("LIT100", c5);

		// Tuesday Courses
		Course c6 = new Course("PHY200", "Advanced Physics", "Professor Newton", "Tuesday", 14.00, 16.30);
		Course c7 = new Course("BIO200", "Advanced Biology", "Professor Darwin", "Tuesday", 14.00, 17.00);
		Course c8 = new Course("CAL200", "Advanced Calculus", "Professor Leibniz", "Tuesday", 9.00, 11.30);
		Course c9 = new Course("CSC200", "Advanced Computer Science", "Professor Lovelace", "Tuesday", 10.00, 12.30);
		Course c10 = new Course("LIT200", "Advanced Literature", "Professor Austen", "Tuesday", 13.00, 14.00);
		schedule.put("PHY200", c6);
		schedule.put("BIO200", c7);
		schedule.put("CAL200", c8);
		schedule.put("CSC200", c9);
		schedule.put("LIT200", c10);

		// Wednesday Courses
		Course c11 = new Course("KIN100", "Introduction to Kineseology", "Professor Goodheart", "Wednesday", 15.00,
				16.30);
		Course c12 = new Course("BIO300", "Microbiology", "Professor Leeuwenhoek", "Wednesday", 14.00, 15.30);
		Course c13 = new Course("BIO350", "Evolutionary Biology", "Professor Darwin", "Wednesday", 9.30, 11.30);
		Course c14 = new Course("CSC400", "Ethics of Computer Science", "Professor Turing", "Wednesday", 10.00, 12.00);
		Course c15 = new Course("LIT250", "Non-Fiction Literature", "Professor Wilde", "Wednesday", 13.00, 15.30);
		schedule.put("KIN100", c11);
		schedule.put("BIO300", c12);
		schedule.put("BIO350", c13);
		schedule.put("CSC400", c14);
		schedule.put("LIT250", c15);

		// Thursday Courses
		Course c16 = new Course("PHY210", "Advanced Physics", "Professor Newton", "Thursday", 14.00, 16.30);
		Course c17 = new Course("CAL110", "Introduction to Calculus II", "Professor Leibniz", "Thursday", 13.00, 15.30);
		Course c18 = new Course("BIO360", "Evolutionary Biology", "Professor Darwin", "Thursday", 9.30, 11.30);
		Course c19 = new Course("LIT210", "Advanced Literature", "Professor Austen", "Thursday", 12.00, 14.00);
		Course c20 = new Course("LIT260", "Fiction Literature", "Professor Shakespeare", "Thursday", 10.00, 11.30);
		schedule.put("PHY210", c16);
		schedule.put("CAL110", c17);
		schedule.put("BIO360", c18);
		schedule.put("LIT210", c19);
		schedule.put("LIT260", c20);

		// Friday Courses
		Course c21 = new Course("KIN110", "Introduction to Kineseology II", "Professor Goodheart", "Friday", 9.00,
				12.30);
		Course c22 = new Course("BIO310", "Cellular biology", "Professor Leeuwenhoek", "Friday", 14.00, 15.30);
		Course c23 = new Course("CHM100", "Introduction to Chemistry", "Professor Mol", "Friday", 11.00, 12.30);
		Course c24 = new Course("CSC450", "Computer Science: Neural Networks", "Professor Turing", "Friday", 10.00,
				13.00);
		Course c25 = new Course("CIN100", "Introduction to Cinema", "Professor Abrams", "Friday", 15.00, 17.30);
		schedule.put("KIN110", c21);
		schedule.put("BIO310", c22);
		schedule.put("CHM100", c23);
		schedule.put("CSC450", c24);
		schedule.put("CIN100", c25);
	}

	@Override
	public HashMap<String, Course> getSchedule() {
		addCourse();
		return schedule;
	}

	@Override
	public void printDay(List<Course> daySchedule) {
		for (Course course : daySchedule) {
			System.out.println(course.getCourseID() + ": " + course.getCourseName());
		}
	}

	public boolean courseExists(String courseID) {
		return schedule.containsKey(courseID.toUpperCase());
	}

	public Course getCourse(String courseID) {
		if (courseExists(courseID)) {
			return schedule.get(courseID.toUpperCase());
		} else {
			return null;
		}
	}

	public void printSchedule() {
		Iterator<Entry<String, Course>> itr = schedule.entrySet().iterator();
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
//*******
		System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n*****************MONDAY*******************"
				+ ConsoleColors.RESET);
		printDay(monday);

		System.out.println(
				ConsoleColors.PURPLE_BOLD_BRIGHT + "\n*****************TUESDAY*****************" + ConsoleColors.RESET);
		printDay(tuesday);

		System.out.println(
				ConsoleColors.PURPLE_BOLD_BRIGHT + "\n****************WEDNESDAY****************" + ConsoleColors.RESET);
		printDay(wednesday);

		System.out.println(
				ConsoleColors.PURPLE_BOLD_BRIGHT + "\n****************THURSDAY*****************" + ConsoleColors.RESET);
		printDay(thursday);

		System.out.println(
				ConsoleColors.PURPLE_BOLD_BRIGHT + "\n*****************FRIDAY******************" + ConsoleColors.RESET);
		printDay(friday);
	}
}
