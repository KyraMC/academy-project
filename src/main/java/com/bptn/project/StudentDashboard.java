package com.bptn.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDashboard {

	public static void dashboard(Student student) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("************************************************** \n"
					+ "*          University of BPTN Dashboard          *\n"
					+ "**************************************************");
			System.out.println("| Num |     What would you like to do? \n" + "|  1. | View Schedule \n"
					+ "|  2. | Add a course \n" + "|  3. | Remove a course \n" + "|  4. | Get course information \n"
					+ "|  5. | Get Personal Info \n" + "|  6. | Change password \n" + "|  7. | Log Out \n");

			try {
				choice = scan.nextInt();
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number!");
			}
			switch (choice) {
			case 1:
				student.getStudentSchedule().printSchedule();
				break;
			case 2:
				System.out.println("Please enter the ID of the course you would like to add:");
				String courseID = scan.nextLine();
				student.getStudentSchedule().addCourse(courseID);
				break;
			case 3:
				System.out.println("Please enter the ID of the course you would like to remove:");
				String courseID2 = scan.nextLine();
				student.getStudentSchedule().deleteCourse(courseID2);
				break;
			case 4:
				System.out.println("These are all the courses we offer: ");
				Schedule.printALL_COURSES();
				System.out.println("Please enter the ID of the course you would like to view:");
				String courseID3 = scan.nextLine();
				if (student.getStudentSchedule().getCourse(courseID3) != null) {
					student.getStudentSchedule().getCourse(courseID3).printCourseInfo();
				} else {
					System.out.println("That course does not exist!");
				}
				break;
			case 5:
				System.out.println("Your Information: ");
				student.printInfo();
				break;

			case 6:
				System.out.println("Are you sure you want to change your password? (Y/N)");
				String passwordChange = scan.nextLine();
				if (passwordChange.toLowerCase().equals("y")) {
					System.out.println("Enter your new password: ");
					String newPassword = scan.nextLine();
					if (newPassword.equals(student.getStudentPassword())) {
						System.out.println(
								"This password is the same as your old password. " + "Your password has not changed.");

					} else {
						boolean success = false;
						while (!success) {
							System.out.println("Re-enter your new password: ");
							String newPassword2 = scan.nextLine();
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

	}

}
