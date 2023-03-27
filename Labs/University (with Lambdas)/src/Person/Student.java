package Person;

public class Student extends Person{

		
	public String major;

		/**
		 * Creates a new person with fields to hold attributes
		 * @param long id 				id of person object
		 * @param String firstName 		first name of person object
		 * @param String middleName 	middle name of person object
		 * @param String lastName 		last name of person object 
		 * @param String email 			email of person object 
		 * @param String ssn 			ssn of person object
		 * @param Integer age 			age of person object
		 * @param String major			major of student
		 */
		public Student(long id, String firstName, String middleName, String lastName, String email, String ssn, Integer age, String major ) 
		{
			super(id, firstName, middleName, lastName, email, ssn, age);
			this.major = major;
		}

		/**
		 * Sets major String
		 * @param String major		major of student
		 */
		public void setMajor(String major) //mutator method
		{
			this.major = major;
		}
		
		/**
		 * Returns major String
		 * @param String major		major of student
		 * @return 
		 */
		public String getMajor() //mutator method
		{
			return major;
		}

}

