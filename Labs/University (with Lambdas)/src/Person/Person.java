package Person;

import java.util.HashMap;
import java.util.function.Predicate;
import java.lang.Integer;

/*
 * Build a class that works with polymorphic collections
 * @author Antonio Rosado
 * @version (10/17/22)
 */
public class Person {
	private long id; // id field
	private String firstName; // firstName field
	private String middleName; // middleName field
	private String lastName; // lastName field
	private String email; // email field
	private String ssn; // ssn field
	private Integer age; // age field
	private static int oldest; // oldest age field
	private static int youngest = 99; // youngest age field
	private static int maxAge = 0; // min age
	protected long lastID = 916421998; // last id field
	public Person() { // null person
		this.id = 0;
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.email = "";
		this.ssn = "";
		this.age = 0;
	
	}
	/**
	 * Creates a new person with fields to hold attributes
	 * 
	 * @param long    id id of person object
	 * @param String  firstName first name of person object
	 * @param String  middleName middle name of person object
	 * @param String  lastName last name of person object
	 * @param String  email email of person object
	 * @param String  ssn ssn of person object
	 * @param Integer age age of person object
	 */
	public Person(long id, String firstName, String middleName, String lastName, String email, String ssn, Integer age) // constructor
	{
		this.setId(id);
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setSsn(ssn);

		this.setAge(age);
		if (age > oldest) {
			oldest = age;
		}

		if (age < youngest) {
			youngest = age;
		}
	}
	
	/**
	 * Youngest person predicate
	 */
	public static Predicate<Person> youngestP = person -> { // youngest predicate
		if (person.getAge() == youngest) {
			return true;
		}

		else {
			return false;
		}
	};

	/**
	 * Oldest person predicate
	 */
	public static Predicate<Person> oldestP = person -> { // oldest predicate
		if (person.getAge() == oldest) {
			return true;
		} else {
			return false;
		}
	};
	
	/**
	 * Map of age predicates
	 */
	public static HashMap<String, Predicate<Person>> 
	evaluator;
	static {
		evaluator = new HashMap<>();
		evaluator.put("oldest" , oldestP);
		evaluator.put("youngest" , youngestP);
	}

	/**
	 * Returns id long
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets id long
	 * 
	 * @param long id id of person object
	 */
	public void setId(long id) // mutator method
	{
		this.id = id;
	}

	/**
	 * Returns firstName String
	 */
	public String getFirstName() // accessor method
	{
		return firstName;
	}

	/**
	 * Sets firstName String
	 * 
	 * @param String firstName first name of person object
	 */
	public void setFirstName(String firstName) // mutator method
	{
		this.firstName = firstName;
	}

	/**
	 * Returns middleName String
	 */
	public String getMiddleName() // accessor method
	{
		return middleName;
	}

	/**
	 * Sets middleName String
	 * 
	 * @param String middleName middle name of person object
	 */
	public void setMiddleName(String middleName) // mutator method
	{
		this.middleName = middleName;
	}

	/**
	 * Returns lastName String
	 */
	public String getLastName() // accessor method
	{
		return lastName;
	}

	/**
	 * Sets lastName String
	 * 
	 * @param String lastName last name of person object
	 */
	public void setLastName(String lastName) // mutator method
	{
		this.lastName = lastName;
	}

	/**
	 * Returns email String
	 */
	public String getEmail() // accessor method
	{
		return email;
	}

	/**
	 * Sets email String
	 * 
	 * @param String email email of person object
	 */
	public void setEmail(String email) // mutator method
	{
		this.email = email;
	}

	/**
	 * Returns ssn String
	 */
	public String getSsn() // accessor method
	{
		return ssn;
	}

	/**
	 * Sets ssn String
	 * 
	 * @param String ssn ssn of person object
	 */
	public void setSsn(String ssn) // mutator method
	{
		this.ssn = ssn;
	}

	/**
	 * Returns age Integer
	 */
	public Integer getAge() // accessor method
	{
		return age;
	}

	/**
	 * Sets age Integer
	 * 
	 * @param Integer age 	age of person object
	 */
	public void setAge(Integer age) // mutator method
	{
		if(age > maxAge) {
			maxAge = age;
		}
		this.age = age;
	}

	/**
	 * Concatenates firstName, middleName, and lastName String(s) then returns them
	 */
	public String toString() // accessor method
	{
		return (firstName + " " + middleName + " " + lastName);
	}

	/**
	 * Returns last four digits of ssn String
	 */
	public String getLast4SSN() // accessor method
	{
		return ssn.substring(7, 11); // +4 to index because of "-" x 2
	}

	/**
	 * Returns domain of email String
	 */
	public String getEmailDomain() // accessor method
	{	
		String error = "Error: email domain cannot be retrieved";
		if(email != null) {
			return email.substring(email.indexOf("@") + 1);
		}
		else{
			
			return error;
		}
	}
	
	/**
	 * Returns major of Student object
	 */
	public String getMajor() // accessor method
	{	
		return "";
	}
	
	/**
	 * Returns department of Instructor object
	 */
	public String getDepartment() // accessor method
	{	
		return "";
	}
	
	/**
	 * Returns true or false depending on if age is valid or not
	 * 
	 * @param String ageTest age to be tested
	 */
	public static boolean isAgeValid(String ageTest) // accessor method
	{
		Integer age = Integer.parseInt(ageTest);
		if (age > 16 && age < 100) {
			if (age > 100)

			{
				System.out.println("ERROR: Person age is above 100");
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns true or false depending on if email is valid or not
	 * 
	 * @param String email email of person object
	 */
	public static boolean isEmailValid(String emailTest) // accessor method
	{
		String domainRegex = "(?<=@)[a-zA-Z0-9\\.] + (?<=)";
		//regex returns domain
		if (emailTest.matches(domainRegex)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * eturns true or false depending on if ssn is valid or not
	 * 
	 * @param String ssnTest ssn to be tested
	 */
	public static boolean isSSNValid(String ssnTest) // accessor method
	{
		String regex = "^\\d{3}[-] ? \\d{2}[-] ? \\d{4} $"; // full breakdown below
		// ^ finds a match as the beginning of a string
		// \\d find digits, \\d{3} find three digits
		// [] find one character from the options in brackets, [-] finds hyphen
		// ? if else ternary operator
		// \\d find digits, \\d{2} find 2 digits
		// [] find one character from options in brackets, [-] find hyphen
		// ? if else ternary operator
		// \\d finds digits, \\d{4} finds 4 digits
		// $ finds a match at the end of the string
		// so, regex = three digits - two digits - four digits
		// regex = 111-22-3333
		if (ssnTest.matches(regex)) // if ssn matched requirements, return true
		{
			return true;
		} else {
			return false;
		}
	}

}