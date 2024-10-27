package com.bptn.project;

import java.util.InputMismatchException;
import java.util.Scanner;

// This class shows the menu options once the student has logged in
public class StudentDashboard {

	// Dashboard method that is called once logged in
	// Takes a student object (the student who logged in) and the scanner instance
	// as a parameter
	public static void dashboard(Student student, Scanner scanner) {
		// Option user chooses
		int choice = 0;

		// The complete schedule of all the courses being offered
		CompleteSchedule ALL_COURSES = new CompleteSchedule(); // CONSTANT variable
		ALL_COURSES.addCourse();

		// do while loop presenting menu options
		do {
			System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + ConsoleColors.PINK
					+ "************************************************** \n"
					+ "*          University of BPTN Dashboard          *\n"
					+ "**************************************************" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_UNDERLINED + ConsoleColors.PINK
					+ "| Num |     What would you like to do?________ \n" + ConsoleColors.RESET + ConsoleColors.PINK
					+ "|  1. | View schedule \n" + "|  2. | Add a course \n" + "|  3. | Remove a course \n"
					+ "|  4. | Get course information \n" + "|  5. | Get personal information \n"
					+ "|  6. | Change password \n" + "|  7. | Log out \n" + ConsoleColors.RESET);

			// Gets user input and if it's not an int, resets the choice and makes them try
			// again
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				choice = 0;
			}
			scanner.nextLine();

			// Switch statements for user options
			switch (choice) {

			// User can see their schedule printed to console and given the option to have
			// it saved as a txt
			case 1:
				System.out.println(ConsoleColors.CYAN + "Would you like to save your schedule in a text file? (Y/N)"
						+ ConsoleColors.RESET);
				String save = scanner.nextLine();
				if (save.toUpperCase().equals("Y")) {
					student.getStudentSchedule().printScheduleFile();
				} else if (!save.toUpperCase().equals("N")) {
					System.out.println(ConsoleColors.CYAN
							+ "That is not a valid selection! Your schedule will not save to a text file."
							+ ConsoleColors.RESET);
				}
				student.getStudentSchedule().printSchedule();
				break;

			// Adds a course to the schedule if there is no conflict
			case 2:
				System.out.println(ConsoleColors.CYAN + "Please enter the ID of the course you would like to add: "
						+ ConsoleColors.RESET);
				String courseID = scanner.nextLine();
				student.getStudentSchedule().addCourse(courseID, ALL_COURSES);
				break;

			// Removes a course from schedule if it exists and is present
			case 3:
				System.out.println(ConsoleColors.CYAN + "Please enter the ID of the course you would like to remove: "
						+ ConsoleColors.RESET);
				String courseID2 = scanner.nextLine();
				student.getStudentSchedule().deleteCourse(courseID2, ALL_COURSES);
				break;

			// Shows user all the courses the school offers and asks them which one they
			// would like information on
			// And presents the full course information
			case 4:
				System.out.println(ConsoleColors.CYAN + "These are all the courses we offer: \n" + ConsoleColors.RESET);
				ALL_COURSES.printSchedule();
				System.out.println(ConsoleColors.CYAN + "\nPlease enter the ID of the course you would like to view:"
						+ ConsoleColors.RESET);
				String courseID3 = scanner.nextLine();
				if (ALL_COURSES.getCourse(courseID3) != null) {
					System.out.println(ALL_COURSES.getCourse(courseID3).toString());
				} else {
					System.out.println(ConsoleColors.CYAN + "That course does not exist!" + ConsoleColors.RESET);
				}
				break;

			// Presents the user with all of their personal information
			case 5:
				System.out.println(ConsoleColors.CYAN + "Your Information: " + ConsoleColors.RESET);
				student.printInfo();
				break;

			// Allows the user to change their password as long as the new password is at
			// least 8 characters and not the same as their old password
			case 6:
				System.out.println(ConsoleColors.CYAN + "Are you sure you want to change your password? (Y/N)"
						+ ConsoleColors.RESET);
				String passwordChange = scanner.nextLine();
				if (passwordChange.toLowerCase().equals("y")) {
					System.out.println(ConsoleColors.CYAN + "Enter your new password: " + ConsoleColors.RESET);
					String newPassword = scanner.nextLine();
					while (newPassword.length() < 8) {
						System.out.println(ConsoleColors.CYAN
								+ "Your password must be at least 8 characters! Enter your new password: "
								+ ConsoleColors.RESET);
						newPassword = scanner.nextLine();
					}
					if (newPassword.equals(student.getStudentPassword())) {
						System.out.println(ConsoleColors.CYAN + "This password is the same as your old password. "
								+ "Your password has not changed." + ConsoleColors.RESET);

					} else {
						boolean success = false;
						while (!success) {
							System.out
									.println(ConsoleColors.CYAN + "Re-enter your new password: " + ConsoleColors.RESET);
							String newPassword2 = scanner.nextLine();
							if (!newPassword.equals(newPassword2)) {
								System.out.println(ConsoleColors.CYAN + "These passwords don't match! Try again!"
										+ ConsoleColors.RESET);
							} else {
								success = true;
								student.setPassword(newPassword);
								System.out.println(
										ConsoleColors.CYAN + "Your password has been changed!" + ConsoleColors.RESET);
							}
						}
					}

					break;
				} else if (passwordChange.toLowerCase().equals("n")) {
					System.out.println(ConsoleColors.CYAN + "Your password will not be changed!" + ConsoleColors.RESET);
					break;
				} else {
					System.out.println(ConsoleColors.CYAN
							+ "That is not a valid selection! You will now go back to the selection menu!"
							+ ConsoleColors.RESET);
					break;
				}

				// Logs the user out and brings them back to the login menu
			case 7:
				System.out.println(ConsoleColors.CYAN + "Logging out. You will now exit!" + ConsoleColors.RESET);
				break;

			default:
				System.out.println(ConsoleColors.CYAN + "Not a valid Selection, try again!" + ConsoleColors.RESET);
			}

		} while (choice != 7);

	}

}
