package animals;

import java.util.List;

/**
 * Provide an animal class that finds commonality between Fox and Rabbit classes
 * 
 * @author Antonio Rosado
 * @version 2022.11.11
 */
public abstract class Animal {

	protected boolean alive; // boolean on whether animal is alive or not
	protected Location location; // location of animal
	protected Field field; // field object
	protected int age; // age of animal

	/**
	 * Create an animal. An animal can be created as a new born (age zero and not
	 * hungry) or with a random age and food level.
	 * 
	 * @param randomAge If true, the fox will have random age and hunger level.
	 * @param field     The field currently occupied.
	 * @param location  The location within the field.
	 */
	public Animal(boolean randomAge, Field field, Location location) {
		super();
		age = 0;
		alive = true;
		this.field = field;
		setLocation(location);
	}

	/**
	 * Return the fox or rabbit's location.
	 * 
	 * @return The fox or rabbit's location.
	 */
	protected Location getLocation() {
		return location;
	}

	/**
	 * Place the fox or rabbit at the new location in the given field.
	 * 
	 * @param newLocation The fox or rabbit's new location.
	 */
	protected void setLocation(Location newLocation) {
		if (location != null) {
			field.clear(location);
		}
		location = newLocation;
		field.place(this, newLocation);
	}

	/**
	 * Check whether the fox or rabbit is alive or not.
	 * 
	 * @return true if the fox or rabbit is still alive.
	 */
	protected boolean isAlive() {
		return alive;
	}

	/**
	 * Indicate that the fox or rabbit is no longer alive. It is removed from the
	 * field.
	 */
	protected void setDead() {
		alive = false;
		if (location != null) {
			field.clear(location);
			location = null;
			field = null;
		}
	}

	/**
	 * Return the Field object.
	 * 
	 * @return Field object
	 */
	protected Field getField() {
		return field;
	}

	/**
	 * Return the Animal's age
	 * 
	 * @return The Animal's age
	 */
	protected int getAge() {
		return age;
	}

	/**
	 * Set the Animal's age
	 * 
	 * @param age
	 */
	protected void setAge(int age) {
		this.age = age;
	}

	/**
	 * Return breeding age of animal object
	 * 
	 * @return BREEDING_AGE
	 */
	abstract protected int getBreedingAge();

	/**
	 * Return boolean if age >= BREEDING_AGE
	 * 
	 * @return BREEDING_AGE
	 */
	protected boolean canBreed() {
		return age >= getBreedingAge();
	}

	/**
	 * Cause animal to act (hunt, run, etc.)
	 */
	public abstract void act(List<Animal> newAnimals);

}
