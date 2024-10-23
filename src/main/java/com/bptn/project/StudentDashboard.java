package com.bptn.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDashboard {

	public static void dashboard(Student student, Scanner scanner) {
		int choice = 0;
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

			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println(ConsoleColors.CYAN + "Please enter a number!" + ConsoleColors.RESET);
			}
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println(ConsoleColors.CYAN + "Would you like to save your schedule in a text file? (Y/N)");
				String save = scanner.nextLine();
				if (save.toUpperCase().equals("Y")) {
					student.getStudentSchedule().printScheduleFile();
				} else if (!save.toUpperCase().equals("N")) {
					System.out.println("That is not a valid selection! Your schedule will not save to a text file.");
				}
				student.getStudentSchedule().printSchedule();
				System.out.println(ConsoleColors.RESET);
				break;
			case 2:
				System.out.println(ConsoleColors.CYAN + "Please enter the ID of the course you would like to add:");
				String courseID = scanner.nextLine();
				student.getStudentSchedule().addCourse(courseID);
				System.out.println(ConsoleColors.RESET);
				break;
			case 3:
				System.out.println(ConsoleColors.CYAN + "Please enter the ID of the course you would like to remove:");
				String courseID2 = scanner.nextLine();
				student.getStudentSchedule().deleteCourse(courseID2);
				System.out.println(ConsoleColors.RESET);
				break;
			case 4:
				System.out.println(ConsoleColors.CYAN + "These are all the courses we offer: \n" + ConsoleColors.RESET);
				Schedule.printALL_COURSES();
				System.out.println(ConsoleColors.CYAN + "\nPlease enter the ID of the course you would like to view:"
						+ ConsoleColors.RESET);
				String courseID3 = scanner.nextLine();
				if (student.getStudentSchedule().getCourse(courseID3) != null) {
					System.out.println(student.getStudentSchedule().getCourse(courseID3).toString());
				} else {
					System.out.println(ConsoleColors.CYAN + "That course does not exist!");
				}
				System.out.println(ConsoleColors.RESET);
				break;
			case 5:
				System.out.println(ConsoleColors.CYAN + "Your Information: ");
				student.printInfo();
				System.out.println(ConsoleColors.RESET);
				break;

			case 6:
				System.out.println(ConsoleColors.CYAN + "Are you sure you want to change your password? (Y/N)");
				String passwordChange = scanner.nextLine();
				if (passwordChange.toLowerCase().equals("y")) {
					System.out.println("Enter your new password: ");
					String newPassword = scanner.nextLine();
					while (newPassword.length() < 8) {
						System.out.println("Your password must be at least 8 characters! Enter your new password: ");
						newPassword = scanner.nextLine();
					}
					if (newPassword.equals(student.getStudentPassword())) {
						System.out.println(
								"This password is the same as your old password. " + "Your password has not changed.");

					} else {
						boolean success = false;
						while (!success) {
							System.out.println("Re-enter your new password: ");
							String newPassword2 = scanner.nextLine();
							if (!newPassword.equals(newPassword2)) {
								System.out.println("These passwords don't match! Try again!");
							} else {
								success = true;
								student.setPassword(newPassword);
								System.out.println("Your password has been changed!");
							}
						}
					}

					break;
				} else if (passwordChange.toLowerCase().equals("n")) {
					System.out.println("Your password will not be changed!");
					break;
				} else {
					System.out.println("That is not a valid selection! You will now go back to the selection menu!");
					break;
				}
			case 7:
				System.out.println("Logging out. You will now exit!");
				break;

			default:
				System.out.println("Not a valid Selection, try again!");
			}

		} while (choice != 7);
		System.out.println(ConsoleColors.RESET);
//		try {
//			scan.close();
//		} catch (NoSuchElementException e) {
//
//		}
	}

}
