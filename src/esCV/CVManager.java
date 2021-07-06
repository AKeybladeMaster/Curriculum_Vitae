package esCV;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CVManager {

	ArrayList<Experience> list_of_exp = new ArrayList<Experience>();
	Scanner sc = new Scanner(System.in);

	private int sub_choice, salary, years_of_study, degree_duration, degree_grade;
	private Date exp_start_date, exp_end_date;
	private String id, tmp_date, brief_description, company_name, type_of_course_update, school_name, type_of_degree;
	private boolean is_course_updated = false;
	private Degree degree_achieved;
	DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");

	public void addExperience() {
		do {
			try {
				id = Integer.toHexString(ThreadLocalRandom.current().nextInt());
				System.out.println("Generated ID for the experience -> " + id);
				System.out.print("Type your experience start date (DD/MM/YYYY): ");
				tmp_date = sc.nextLine();
				exp_start_date = date_format.parse(tmp_date);
				System.out.print("Type your experience end date (DD/MM/YYYY): ");
				tmp_date = sc.nextLine();
				exp_end_date = date_format.parse(tmp_date);
				if (exp_start_date.compareTo(exp_end_date) > 0) {
					System.out.println("The ending date has to be more recent than the starting date!");
					throw new InputMismatchException();
				}
				System.out.println(
						"Choose what experience to add: " + "\n 1. Work experience " + "\n 2. Study experience");
				sub_choice = sc.nextInt();
				sc.nextLine();

				if (sub_choice == 1) {
					System.out.print("Type the name of the company you worked for: ");
					company_name = sc.nextLine();
					System.out.print("Type your monthly salary (number): ");
					salary = sc.nextInt();
					sc.nextLine();
					System.out.println("Have you ever had a course update?" + "\n 1. Yes " + "\n 2. No");
					sub_choice = sc.nextInt();
					sc.nextLine();
					if (sub_choice == 1) {
						is_course_updated = true;
						System.out.print("Write what type of course it was about: ");
						type_of_course_update = sc.nextLine();
					} else if (sub_choice == 2) {
						is_course_updated = false;
						type_of_course_update = null;
					} else
						throw new InputMismatchException();
					System.out.println("Type a brief description of this work experience: ");
					brief_description = sc.nextLine();
					list_of_exp.add(new WorkExperience(id.toUpperCase(), exp_start_date, exp_end_date,
							brief_description, company_name, salary, is_course_updated, type_of_course_update));
					System.out.println("Experience added!");
				} else if (sub_choice == 2) {
					System.out.print("Type the name of the school you studied in: ");
					school_name = sc.nextLine();
					System.out.print("Type how many years you studied there: ");
					years_of_study = sc.nextInt();
					sc.nextLine();
					System.out.println("Have you achieved a degree?" + "\n 1. Yes " + "\n 2. No");
					sub_choice = sc.nextInt();
					sc.nextLine();
					if (sub_choice == 1) {
						System.out.print("Write the type of degree you got: ");
						type_of_degree = sc.nextLine();
						System.out.print("Type your degree duration (years): ");
						degree_duration = sc.nextInt();
						sc.nextLine();
						System.out.print("Type your degree grade: ");
						degree_grade = sc.nextInt();
						sc.nextLine();
						degree_achieved = new Degree(type_of_degree, degree_duration, degree_grade);
					} else if (sub_choice == 2) {
						degree_achieved = null;
					} else
						throw new InputMismatchException();
					System.out.println("Type a brief description of this study experience: ");
					brief_description = sc.nextLine();
					list_of_exp.add(new StudyExperience(id.toUpperCase(), exp_start_date, exp_end_date,
							brief_description, school_name, years_of_study, degree_achieved));
					System.out.println("Experience added!");
				} else
					throw new InputMismatchException();
				System.out.println("Do you want to add new experiences? (y/n)");
			} catch (InputMismatchException e) {
				System.out.println("\nIncorrect input. Sending you to the start..."
						+ "\nIf the menu doesn't show up press Enter.");
			} catch (ParseException e) {
				System.out.println("\nI asked you a DD/MM/YYYY date format! Sending you to the start..."
						+ "\nIf the menu doesn't show up press Enter.");
			}
		} while (sc.nextLine().equalsIgnoreCase("y"));
	}

	public boolean deleteExperience(String id) {
		for (int i = 0; i < list_of_exp.size(); i++) {
			if (list_of_exp.get(i).getId().equals(id)) {
				list_of_exp.remove(i);
				return true;
			}
		}
		return false;
	}

	public void stampaCV() {
		Collections.sort(list_of_exp);

		if (list_of_exp.size() == 0)
			System.out.println("You haven't added experiences yet!");
		else {
			for (int j = 0; j < list_of_exp.size(); j++) {
				if (list_of_exp.get(j) instanceof WorkExperience) {
					System.out.println(list_of_exp.get(j));
				}
			}
			for (int k = 0; k < list_of_exp.size(); k++) {
				if (list_of_exp.get(k) instanceof StudyExperience) {
					System.out.println(list_of_exp.get(k));
				}
			}
		}
	}
}
