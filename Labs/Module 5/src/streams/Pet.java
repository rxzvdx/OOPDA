package streams;

public class Pet {

	private String name;
	private int ageInMonths;
	
	public Pet(String name, int ageInMonths) {
		this.name = name;
		this.ageInMonths = ageInMonths;
	}
	
	public String getName() {
		return name;
	}

	public int getAgeInMonths() {
		return ageInMonths;
	}

	public String toString() {
		return this.getClass().getSimpleName() + " " + this.name + " (" + this.ageInMonths + " months)";
	}
	
}