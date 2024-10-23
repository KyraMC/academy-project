package com.bptn.project;

import java.util.HashMap;

public class AllCoursesSchedule {
	private static HashMap<String, Course> ALL_COURSES = new HashMap<>();;

	public static void AddCourses() {
		ALL_COURSES = new HashMap<>();
		// create courses and add them to ALL_COURSES
		// Monday Courses
		Course c1 = new Course("PHY100", "Introduction to Physics", "Professor X", "Monday", 12.00, 14.00);
		Course c2 = new Course("BIO100", "Introduction to Biology", "Professor Darwin", "Monday", 14.00, 15.30);
		Course c3 = new Course("CAL100", "Introduction to Calculus", "Professor Leibniz", "Monday", 14.00, 16.30);
		Course c4 = new Course("CSC100", "Introduction to Computer Science", "Professor Lovelace", "Monday", 10.00,
				12.30);
		Course c5 = new Course("LIT100", "Introduction to Literature", "Professor Austen", "Monday", 12.00, 15.00);
		ALL_COURSES.put("PHY100", c1);
		ALL_COURSES.put("BIO100", c2);
		ALL_COURSES.put("CAL100", c3);
		ALL_COURSES.put("CSC100", c4);
		ALL_COURSES.put("LIT100", c5);

		// Tuesday Courses
		Course c6 = new Course("PHY200", "Advanced Physics", "Professor Newton", "Tuesday", 14.00, 16.30);
		Course c7 = new Course("BIO200", "Advanced Biology", "Professor Darwin", "Tuesday", 14.00, 17.00);
		Course c8 = new Course("CAL200", "Advanced Calculus", "Professor Leibniz", "Tuesday", 9.00, 11.30);
		Course c9 = new Course("CSC200", "Advanced Computer Science", "Professor Lovelace", "Tuesday", 10.00, 12.30);
		Course c10 = new Course("LIT200", "Advanced Literature", "Professor Austen", "Tuesday", 13.00, 14.00);
		ALL_COURSES.put("PHY200", c6);
		ALL_COURSES.put("BIO200", c7);
		ALL_COURSES.put("CAL200", c8);
		ALL_COURSES.put("CSC200", c9);
		ALL_COURSES.put("LIT200", c10);

		// Wednesday Courses
		Course c11 = new Course("KIN100", "Introduction to Kineseology", "Professor Goodheart", "Wednesday", 15.00,
				16.30);
		Course c12 = new Course("BIO300", "Microbiology", "Professor Leeuwenhoek", "Wednesday", 14.00, 15.30);
		Course c13 = new Course("BIO350", "Evolutionary Biology", "Professor Darwin", "Wednesday", 9.30, 11.30);
		Course c14 = new Course("CSC400", "Ethics of Computer Science", "Professor Turing", "Wednesday", 10.00, 12.00);
		Course c15 = new Course("LIT250", "Non-Fiction Literature", "Professor Wilde", "Wednesday", 13.00, 15.30);
		ALL_COURSES.put("KIN100", c11);
		ALL_COURSES.put("BIO300", c12);
		ALL_COURSES.put("BIO350", c13);
		ALL_COURSES.put("CSC400", c14);
		ALL_COURSES.put("LIT250", c15);

		// Thursday Courses
		Course c16 = new Course("PHY210", "Advanced Physics", "Professor Newton", "Thursday", 14.00, 16.30);
		Course c17 = new Course("CAL110", "Introduction to Calculus II", "Professor Leibniz", "Thursday", 13.00, 15.30);
		Course c18 = new Course("BIO360", "Evolutionary Biology", "Professor Darwin", "Thursday", 9.30, 11.30);
		Course c19 = new Course("LIT210", "Advanced Literature", "Professor Austen", "Thursday", 12.00, 14.00);
		Course c20 = new Course("LIT260", "Fiction Literature", "Professor Shakespeare", "Thursday", 10.00, 11.30);
		ALL_COURSES.put("PHY210", c16);
		ALL_COURSES.put("CAL110", c17);
		ALL_COURSES.put("BIO360", c18);
		ALL_COURSES.put("LIT210", c19);
		ALL_COURSES.put("LIT260", c20);

		// Friday Courses
		Course c21 = new Course("KIN110", "Introduction to Kineseology II", "Professor Goodheart", "Friday", 9.00,
				12.30);
		Course c22 = new Course("BIO310", "Cellular biology", "Professor Leeuwenhoek", "Friday", 14.00, 15.30);
		Course c23 = new Course("CHM100", "Introduction to Chemistry", "Professor Mol", "Friday", 11.00, 12.30);
		Course c24 = new Course("CSC450", "Computer Science: Neural Networks", "Professor Turing", "Friday", 10.00,
				13.00);
		Course c25 = new Course("CIN100", "Introduction to Cinema", "Professor Abrams", "Friday", 15.00, 17.30);
		ALL_COURSES.put("KIN110", c21);
		ALL_COURSES.put("BIO310", c22);
		ALL_COURSES.put("CHM100", c23);
		ALL_COURSES.put("CSC450", c24);
		ALL_COURSES.put("CIN100", c25);
	}

	public static HashMap<String, Course> getALL_COURSES() {
		AddCourses();
		return ALL_COURSES;
	}

}
