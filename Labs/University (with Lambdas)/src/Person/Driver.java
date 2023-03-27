package Person;

import java.util.HashMap;
import java.util.Scanner;

public class Driver {
public String department;
public String major;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HashMap<Integer, Person> map = new HashMap<Integer, Person>();

		System.out.println("How should we evaluate? [Enter 'oldest' or 'youngest']");
		String ageLabel = input.nextLine();

		System.out.println("Enter person's first name: " + "\n");
		String firstName = input.nextLine();

		System.out.println("Enter person's middle name: " + "\n");
		String middleName = input.nextLine();

		System.out.println("Enter person's last name: " + "\n");
		String lastName = input.nextLine();

		System.out.println("Enter person's email address" + "\n");
		String emailTest = input.nextLine();

		System.out.println("Enter person's SSN (in ###-##-#### format): " + "\n");
		String ssnTest = input.nextLine();

		System.out.println("Enter person's age: " + "\n");
		String ageTest = input.nextLine();
		input.close();
		map.put(1, new Person(916421999, "Rip", "Van", "Winkle", "rip@rowan.edu", "111-22-3333", 99));
		/*
		 * 916421999 Rip Van Winkle (Person) rowan.edu 3333 oldest: true
		 */
		Person student = new Student(916422000, "Jane", "Marie", "Doe", "jmd@students.rowan.edu", "222-33-4444", 17, "Computer Science");
		/*
		 * 916422000 Jane Marie Doe (Student) students.rowan.edu 4444 oldest: false
		 */
		Person instructor = new Instructor(916422001, "Chia", "C.", "Chien", "chien@rowan.edu", "333-44-5555", 40, "Math/Science");
		/*
		 * 916422001 Chia C. Chien (Instructor) rowan.edu 5555 oldest: false
		 */
		map.put(2, student);
		map.put(3, instructor);
		
		Integer age = 0;
		if (Person.isAgeValid(ageTest)) {
			age = Integer.parseInt(ageTest);
		}

		String email = null;
		if (Person.isEmailValid(emailTest)) {
			email = emailTest;
		}
		email = emailTest;

		String ssn = null;
		if (Person.isSSNValid(ssnTest)) {
			ssn = ssnTest;
		}
		ssn = ssnTest;
		input.close();

		map.put(4, new Person(916422002, firstName, middleName, lastName, email, ssn, age));
		if (ageLabel.matches("Youngest") || ageLabel.matches("youngest")) {
			for (int key : map.keySet()) // iterate thru HashMap to label correct youngest
			{
				String label = ""; // empty because there's no "youngest" yet
				map.get(key);
				if (Person.youngestP.test(map.get(key))) {
					label = "Youngest: true";
				} else {
					label = "Youngest: false";
				}

				System.out.println("\n" + map.get(key).getId() 
						+ "\n" + map.get(key).toString()
						+ "\n" + map.get(key).getEmailDomain() 
						+ "\n" + map.get(key).getLast4SSN() 
						+ "\n" + label 
						+ "\n" + map.get(key).getMajor() 
						+ "\n" + map.get(key).getDepartment());
			}
		} else if ((ageLabel.matches("Oldest") || ageLabel.matches("oldest"))) {
			for (int key : map.keySet()) // iterate thru HashMap to label correct youngest
			{
				String label = ""; // empty because there's no "youngest" yet
				map.get(key);
				if (Person.oldestP.test(map.get(key))) {
					label = "Oldest: true";
				} else {
					label = "Oldest: false";

				}

				System.out.println("\n" + map.get(key).getId() 
						+ "\n" + map.get(key).toString()
						+ "\n" + map.get(key).getEmailDomain() 
						+ "\n" + map.get(key).getLast4SSN() 
						+ "\n" + label 
						+ "\n" + map.get(key).getMajor() 
						+ "\n" + map.get(key).getDepartment());
			}

		} else {
			System.out.println("Error: Invalid input. Type 'youngest' or 'oldest'");
		}
	}
}
