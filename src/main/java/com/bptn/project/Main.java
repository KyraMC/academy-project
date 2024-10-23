package com.bptn.project;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	private static HashMap<String, Student> studentAccounts = new HashMap<>();
	private static HashMap<String, String> emailsToIds = new HashMap<>();
	private static int idCount = 0;
	private static Scanner scanner = new Scanner(System.in);

	public static boolean login(String studentID) {
		if (studentAccounts.containsKey(studentID)) {
			// Scanner scan = new Scanner(System.in);
			Student student = studentAccounts.get(studentID);
			System.out.println(ConsoleColors.CYAN + "Please enter your password: " + ConsoleColors.RESET);
			String studentPassword = scanner.nextLine();
			if (student.getStudentPassword().equals(studentPassword)) {
				return true;
			}
		}
		return false;
	}

	public static String idGenerator(String lastName) {
		String id = lastName + idCount;
		idCount++;
		return id;
	}

	public static boolean isEmailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@school.com", Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}

	public static boolean createAccount(String email) {
		if (isEmailValid(email)) {
			System.out.println(ConsoleColors.CYAN + "Please enter your first name: " + ConsoleColors.RESET);
			String studentFirst = scanner.nextLine();
			while (studentFirst.equals(" ") || studentFirst.equals("")) {
				System.out.println(
						ConsoleColors.CYAN + "That is not a valid name, please try again!" + ConsoleColors.RESET);
				studentFirst = scanner.nextLine();
			}

			System.out.println(ConsoleColors.CYAN + "Please enter your last name: " + ConsoleColors.RESET);
			String studentLast = scanner.nextLine();
			while (studentLast.equals(" ") || studentLast.equals("")) {
				System.out.println(
						ConsoleColors.CYAN + "That is not a valid name, please try again!" + ConsoleColors.RESET);
				studentLast = scanner.nextLine();
			}

			System.out.println(ConsoleColors.CYAN + "Please enter your password, it must be at least 8 characters: "
					+ ConsoleColors.RESET);
			String studentPassword1 = scanner.nextLine();
			while (studentPassword1.length() < 8) {
				System.out.println(
						ConsoleColors.CYAN + "Your password must be at least 8 characters!" + ConsoleColors.RESET);
				studentPassword1 = scanner.nextLine();
			}

			System.out.println(ConsoleColors.CYAN + "Please re-enter your password: " + ConsoleColors.RESET);
			String studentPassword2 = scanner.nextLine();
			if (!studentPassword1.equals(studentPassword2)) {
				do {
					System.out.println(
							ConsoleColors.CYAN + "Those passwords don't match, please re-enter your your password: "
									+ ConsoleColors.RESET);
					studentPassword2 = scanner.nextLine();
				} while (!studentPassword1.equals(studentPassword2));
			}
			String studentID = idGenerator(studentLast);
			Student student = new Student(studentID, studentFirst + studentLast, email, studentPassword1);
			studentAccounts.put(studentID, student);
			emailsToIds.put(email, studentID);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Student admin = new Student("admin", "admin", "admin@school.com", "admin");
		studentAccounts.put("admin", admin);
		emailsToIds.put(admin.getStudentEmail(), admin.getStudentID());
		int choice = 0;
		do {
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + ConsoleColors.LILAC
					+ "************************************************** \n"
					+ "*                   Login Menu                   *\n"
					+ "**************************************************" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_UNDERLINED + ConsoleColors.LILAC
					+ "| Num |     What would you like to do?_______\n" + ConsoleColors.RESET + ConsoleColors.LILAC
					+ "|  1. | Login \n" + "|  2. | Create an Account \n" + "|  3. | Exit \n" + ConsoleColors.RESET);

			try {
				choice = scanner.nextInt();

			} catch (InputMismatchException e) {
				// System.out.println(ConsoleColors.CYAN + "Please enter a number!" +
				// ConsoleColors.RESET);
			}
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println(ConsoleColors.CYAN + "Please enter your student ID: " + ConsoleColors.RESET);
				String studentID = scanner.nextLine();
				if (login(studentID)) {
					StudentDashboard.dashboard(studentAccounts.get(studentID), scanner);
				} else {
					System.out.println(ConsoleColors.CYAN + "The login was unsuccessful! Please make sure you are"
							+ " entering the correct student ID and password!" + ConsoleColors.RESET);
				}

				break;
			case 2:
				System.out.println(ConsoleColors.CYAN + "Please enter your student email: " + ConsoleColors.RESET);
				System.out.println(ConsoleColors.CYAN + "(should end in @school.com)" + ConsoleColors.RESET);
				String email = scanner.nextLine();
				if (emailsToIds.containsKey(email)) {
					System.out.println(ConsoleColors.CYAN + "This email already exists and belongs to student ID "
							+ emailsToIds.get(email) + ConsoleColors.RESET);
				} else {
					boolean success = createAccount(email);
					if (success) {
						System.out.println(ConsoleColors.CYAN + "Account created! Your student ID is "
								+ emailsToIds.get(email) + ConsoleColors.RESET);
					} else {
						System.out.println(
								ConsoleColors.CYAN + "Account could not be created! Please make sure you are using your"
										+ " school email ending in @school.com." + ConsoleColors.RESET);
					}
				}
				break;
			case 3:
				System.out.println(ConsoleColors.CYAN + "Thanks for stopping by!" + ConsoleColors.RESET);
				scanner.close();
				break;
			default:
				System.out.println(ConsoleColors.CYAN + "Not a valid Selection, try again!" + ConsoleColors.RESET);

			}
		} while (choice != 3);
		// scan.close();
	}
}
