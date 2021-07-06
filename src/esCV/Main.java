package esCV;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CVManager obj = new CVManager();

		String id = "";
		
		int menu_choice = 0;
		do {
			try {
			System.out.println("0. End the program");
			System.out.println("1. Add a new experience");
			System.out.println("2. Delete an experience by ID");
			System.out.println("3. Print the sorted CV (first work experiences then studies)");

			menu_choice = sc.nextInt();
			sc.nextLine();

			switch (menu_choice) {
			case 0:
				System.out.println("Program terminated.");
				System.exit(0);
				break;
			case 1:
				obj.addExperience();
				System.out.println("");
				break;

			case 2:
				System.out.println("Type the ID of the experience: ");
				id = sc.nextLine();
				if (obj.deleteExperience(id))
					System.out.println("Removed successfully!\n");
				else
					System.out.println("Nothing was removed.\n");
				break;

			case 3:
				obj.stampaCV();
				System.out.println("");
				break;

			default:
				System.out.println("Incorrect number. Try again.\n");
				break;
			}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect input. Ending the program.");
				sc.nextLine();
			}
		} while (menu_choice != 0);
		sc.close();
	}
}
