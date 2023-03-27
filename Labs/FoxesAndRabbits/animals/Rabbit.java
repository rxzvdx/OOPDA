package animals;

import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit. Rabbits age, move, breed, and die.
 * 
 * @Author Antonio Rosado
 * @version 2022.11.11
 */
public class Rabbit extends Animal {
	// Characteristics shared by all rabbits (class variables).
	// A shared random number generator to control breeding.
	// The age at which a rabbit can start to breed.
	private static final int BREEDING_AGE = 5;
	// The age to which a rabbit can live.
	private static final int MAX_AGE = 40;
	// The likelihood of a rabbit breeding.
	private static final double BREEDING_PROBABILITY = 0.12;
	// The maximum number of births.
	private static final int MAX_LITTER_SIZE = 4;
	// The food value of a single rabbit. In effect, this is the
	// number of steps a rabbit can go before it has to eat again.
	private static final int RABBIT_FOOD_VALUE = 9;
	// A shared random number generator to control breeding.
	private static final Random rand = Randomizer.getRandom();

	// Individual characteristics (instance fields).

	/**
	 * Create a new rabbit. A rabbit may be created with age zero (a new born) or
	 * with a random age.
	 * 
	 * @param randomAge If true, the rabbit will have a random age.
	 * @param field     The field currently occupied.
	 * @param location  The location within the field.
	 */
	public Rabbit(boolean randomAge, Field field, Location location) {
		super(randomAge, field, location);
		if (randomAge) {
			age = rand.nextInt(MAX_AGE);
		}
	}

	/**
	 * This is what the rabbit does most of the time - it runs around. Sometimes it
	 * will breed or die of old age.
	 * 
	 * @param newRabbits A list to return newly born rabbits.
	 */
	public void act(List<Animal> newRabbits) {
		incrementAge();
		if (alive) {
			giveBirth(newRabbits);
			// Try to move into a free location.
			Location newLocation = field.freeAdjacentLocation(location);
			if (newLocation != null) {
				setLocation(newLocation);
			} else {
				// Overcrowding.
				setDead();
			}
		}
	}

	/**
	 * Increase the age. This could result in the fox's death.
	 */
	private void incrementAge() {
		age++;
		if (age > MAX_AGE) {
			setDead();
		}
	}

	/**
	 * Check whether or not this rabbit is to give birth at this step. New births
	 * will be made into free adjacent locations.
	 * 
	 * @param newRabbits A list to return newly born rabbits.
	 */
	private void giveBirth(List<Animal> newRabbits) {
		// New rabbits are born into adjacent locations.
		// Get a list of adjacent free locations.
		List<Location> free = field.getFreeAdjacentLocations(location);
		int births = breed();
		for (int b = 0; b < births && free.size() > 0; b++) {
			Location loc = free.remove(0);
			Rabbit young = new Rabbit(false, field, loc);
			newRabbits.add(young);
		}
	}

	/**
	 * Generate a number representing the number of births, if it can breed.
	 * 
	 * @return The number of births (may be zero).
	 */
	private int breed() {
		int births = 0;
		if (canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
			births = rand.nextInt(MAX_LITTER_SIZE) + 1;
		}
		return births;
	}

	/**
	 * Return breeding age of rabbit
	 * 
	 * @return BREEDING_AGE
	 */
	public int getBreedingAge() {
		return BREEDING_AGE;
	}

	/**
	 * Return rabbit food value
	 * 
	 * @return RABBIT_FOOD_VALUE
	 */
	public static int getRabbitFoodValue() {
		return RABBIT_FOOD_VALUE;
	}

}
