package streams;

import java.util.List;
import java.util.ArrayList;

public class Celebrity {
	public String fname;
	public String lname;
	public List<Pet> pets = new ArrayList<Pet>();
	
	public Celebrity(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	public List<Pet> getPets() {
		return pets;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public void addPet(Pet p) {
		pets.add(p);
	}
	
	public String toString() {
		return fname + " " + lname + " " + pets.toString();
	}
}
