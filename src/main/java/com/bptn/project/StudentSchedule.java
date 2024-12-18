package com.bptn.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

// StudentSchedule class - child of Schedule
public class StudentSchedule extends Schedule {

	// Constructor
	public StudentSchedule() {
		super();
	}

	// Prints all the courses in a day
	public void printDay(List<Course> daySchedule) {
		for (Course course : daySchedule) {
			System.out.println(ConsoleColors.PURPLE + course.toString() + ConsoleColors.RESET);
		}
	}

	// Prints all the courses in the schedule
	public void printSchedule() {
		// Checking if there are courses in the schedule
		if (schedule.size() > 0) {
			Iterator<Entry<String, Course>> itr = schedule.entrySet().iterator();
			List<Course> monday = new ArrayList<>();
			List<Course> tuesday = new ArrayList<>();
			List<Course> wednesday = new ArrayList<>();
			List<Course> thursday = new ArrayList<>();
			List<Course> friday = new ArrayList<>();
			// Iterates over the courses in the schedule and sorts them into what day they
			// belong
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
			// Sorts the daily schedules by their course start times
			monday = sortSchedule(monday);
			tuesday = sortSchedule(tuesday);
			wednesday = sortSchedule(wednesday);
			thursday = sortSchedule(thursday);
			friday = sortSchedule(friday);

			// Prints the daily schedules to console
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "***************** SCHEDULE *******************\n"
					+ ConsoleColors.RESET);

			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n*****************MONDAY*******************"
					+ ConsoleColors.RESET);
			if (monday != null) {
				printDay(monday);
			}
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n*****************TUESDAY*****************"
					+ ConsoleColors.RESET);
			if (tuesday != null) {
				printDay(tuesday);
			}
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n****************WEDNESDAY****************"
					+ ConsoleColors.RESET);
			if (wednesday != null) {
				printDay(wednesday);
			}
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n****************THURSDAY*****************"
					+ ConsoleColors.RESET);
			if (thursday != null) {
				printDay(thursday);
			}
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n*****************FRIDAY******************"
					+ ConsoleColors.RESET);
			if (friday != null) {
				printDay(friday);
			}
		} else {
			System.out.println(
					ConsoleColors.CYAN_BOLD_BRIGHT + "There are no courses in your schedule!" + ConsoleColors.RESET);
		}

	}

	// Creates a txt file called schedule.txt that displays the user schedule
	public void printScheduleFile() {
		// If there are courses in the schedule, then proceed
		if (schedule.size() > 0) {
			// Creates a file called schedule.txt and checks that any existing files by the
			// same name are deleted
			File file = new File("schedule.txt");
			if (file.exists()) {
				file.delete();
			}
			// Writes the schedule to the txt file, by sorting the schedule and then writing
			// it
			try {
				FileWriter writer = new FileWriter("schedule.txt");
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

				writer.write("***************** SCHEDULE *******************\n");
				writer.write("\n*****************************************\n");
				writer.write("*****************MONDAY******************\n");
				if (monday != null) {
					for (Course course : monday) {
						writer.write(course.toString() + "\n");
					}
				}
				writer.write("\n*****************************************\n");
				writer.write("*****************TUESDAY*****************\n");
				if (tuesday != null) {
					for (Course course : tuesday) {
						writer.write(course.toString() + "\n");
					}
				}
				writer.write("\n*****************************************\n");
				writer.write("****************WEDNESDAY****************\n");
				if (wednesday != null) {
					for (Course course : wednesday) {
						writer.write(course.toString() + "\n");
					}
				}
				writer.write("\n*****************************************\n");
				writer.write("****************THURSDAY*****************\n");
				if (thursday != null) {
					for (Course course : thursday) {
						writer.write(course.toString() + "\n");
					}
				}
				writer.write("\n*****************************************\n");
				writer.write("*****************FRIDAY******************\n");
				if (friday != null) {
					for (Course course : friday) {
						writer.write(course.toString() + "\n");
					}
				}
				System.out.println("File created");
				writer.close();
				// If file cannot be created catches the exception
			} catch (IOException e) {
				System.out.println("Something went wrong when creating the file.");
			}
		}
	}

	// Checks if there is a course conflict when adding a course to schedule
	public int courseConflict(String courseID, CompleteSchedule ALL_COURSES) {
		// If course is already in schedule return -1,
		// if schedule conflict return 0, if no conflict return 1, if course doesn't
		// exist return 2
		if (schedule.isEmpty() && ALL_COURSES.courseExists(courseID.toUpperCase())) {
			return 1;
		} else if (!ALL_COURSES.courseExists(courseID.toUpperCase())) {
			return 2;
		} else if (schedule.containsKey(courseID.toUpperCase())) {
			return -1;
		} else {
			Course course = ALL_COURSES.getCourse(courseID.toUpperCase());
			int output = 0;
			for (Course c : schedule.values()) {
				if (course.getCourseEndTime() <= c.getCourseStartTime()
						|| course.getCourseStartTime() >= c.getCourseEndTime()) {
					output = 1;
				} else {
					return 0;
				}
			}
			return output;
		}
	}

	// Adds course to schedule if no conflict and user doesn't have 6 courses in
	// schedule
	public void addCourse(String courseID, CompleteSchedule ALL_COURSES) {
		int conflict = courseConflict(courseID, ALL_COURSES);
		if (conflict == 2) {
			System.out.println(ConsoleColors.CYAN + "This courseID does not exist!" + ConsoleColors.RESET);
		} else if (conflict == -1) {
			System.out.println(ConsoleColors.CYAN + "This course is already in your schedule!" + ConsoleColors.RESET);
		} else if (conflict == 0) {
			System.out.println(ConsoleColors.CYAN + "You have a conflict and cannot add this course to your schedule."
					+ ConsoleColors.RESET);
		} else if (schedule.size() >= 6) {
			System.out
					.println(ConsoleColors.CYAN + "You already have 6 courses in your schedule!" + ConsoleColors.RESET);
		} else {
			schedule.put(courseID.toUpperCase(), ALL_COURSES.getCourse(courseID.toUpperCase()));
			System.out.println(
					ConsoleColors.CYAN + "The course was successfully added to your schedule!" + ConsoleColors.RESET);
		}

	}

	// Deletes course from schedule if possible
	public void deleteCourse(String courseID, CompleteSchedule ALL_COURSES) {
		if (!ALL_COURSES.courseExists(courseID.toUpperCase())) {
			System.out.println(ConsoleColors.CYAN + "This courseID does not exist!" + ConsoleColors.RESET);
		} else if (!schedule.containsKey(courseID.toUpperCase())) {
			System.out.println(ConsoleColors.CYAN + "This course is not in your schedule!" + ConsoleColors.RESET);
		} else {
			schedule.remove(courseID.toUpperCase());
			System.out.println(ConsoleColors.CYAN + "The course was successfully removed from your schedule!"
					+ ConsoleColors.RESET);
		}
	}
}
