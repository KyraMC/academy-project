package com.bptn.project;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	private static HashMap<String, Student> studentAccounts = new HashMap<>();
	private static HashMap<String, String> emailsToIds = new HashMap<>();
	private static int idCount = 0;

	public static boolean login(String studentID) {
		Scanner scan = new Scanner(System.in);
		if (studentAccounts.containsKey(studentID)) {

			Student student = studentAccounts.get(studentID);
			System.out.println("Please enter your password: ");
			String studentPassword = scan.nextLine();

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
		Scanner scan = new Scanner(System.in);
		if (isEmailValid(email)) {
			System.out.println("Please enter your first name: ");
			String studentFirst = scan.nextLine();

			System.out.println("Please enter your last name: ");
			String studentLast = scan.nextLine();

			System.out.println("Please enter your password: ");
			String studentPassword1 = scan.nextLine();

			System.out.println("Please re-enter your password: ");
			String studentPassword2 = scan.nextLine();
			if (!studentPassword1.equals(studentPassword2)) {
				do {
					System.out.println("Those passwords don't match, please re-enter your your password: ");
					studentPassword2 = scan.nextLine();
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
		int choice = 0;
		do {
			System.out.println("************************************************** \n"
					+ "*          University of BPTN Dashboard          *\n"
					+ "**************************************************");
			System.out.println("| Num |     What would you like to do? \n" + "|  1. | Login \n"
					+ "|  2. | Create an Account \n" + "|  3. | Exit \n");

			Scanner scan = new Scanner(System.in);

			try {
				choice = scan.nextInt();
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number!");
			}
			switch (choice) {
			case 1:
				System.out.println("Please enter your student ID: ");
				String studentID = scan.nextLine();
				if (login(studentID)) {
					StudentDashboard.dashboard(studentAccounts.get(studentID));
				} else {
					System.out.println("The login was unsuccessful! Please make sure you are"
							+ " entering the correct student ID and password!");
				}

				break;
			case 2:
				System.out.println("Please enter your student email: ");
				System.out.println("(should end in @school.com)");
				String email = scan.nextLine();
				if (emailsToIds.containsKey(email)) {
					System.out.println("This email already exists and belongs to student ID " + emailsToIds.get(email));
				} else {
					boolean success = createAccount(email);
					if (success) {
						System.out.println("Account created! Your student ID is " + emailsToIds.get(email));
					} else {
						System.out.println("Account could not be created! Please make sure you are using your"
								+ " school email ending in @school.com.");
					}
				}
				break;
			case 3:
				System.out.println("Thanks for stopping by!");
				break;
			default:
				System.out.println("Not a valid Selection, try again!");

			}
		} while (choice != 3);

	}

}
