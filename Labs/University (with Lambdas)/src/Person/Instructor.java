package Person;

public class Instructor extends Person {

	public String department;

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
	 * @param String  department department of instructor
	 */
	public Instructor(long id, String firstName, String middleName, String lastName, String email, String ssn,
			Integer age, String department) {
		super(id, firstName, middleName, lastName, email, ssn, age);
		this.department = department;
	}

	/**
	 * Sets department String
	 * 
	 * @param String department department of instructor
	 */
	public void setDepartment(String department) // mutator method
	{
		this.department = department;
	}

	/**
	 * Returns department String
	 * 
	 * @param String department department of instructor
	 * @return
	 */
	public String getDepartment() // mutator method
	{
		return department;
	}

}
