package animals;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field containing
 * rabbits and foxes.
 * 
 * @author Antonio Rosado
 * @version 2022.11.11
 */
public class Simulator {
	// Constants representing configuration information for the simulation.
	// The default width for the grid.
	private static final int DEFAULT_WIDTH = 50;
	// The default depth of the grid.
	private static final int DEFAULT_DEPTH = 50;
	// The probability that a fox will be created in any given grid position.
	private static final double FOX_CREATION_PROBABILITY = 0.02;
	// The probability that a rabbit will be created in any given position.
	private static final double RABBIT_CREATION_PROBABILITY = 0.08;

	// Lists of animals in the field.
	private List<Animal> animals;
	// private List<animals> foxes;
	// The current state of the field.
	private Field field;
	// The current step of the simulation.
	private int step;
	// A graphical view of the simulation.
	private SimulatorView view;

	/**
	 * Construct a simulation field with default size.
	 */
	public Simulator() {
		this(DEFAULT_DEPTH, DEFAULT_WIDTH);
	}

	/**
	 * Create a simulation field with the given size.
	 * 
	 * @param depth Depth of the field. Must be greater than zero.
	 * @param width Width of the field. Must be greater than zero.
	 */
	public Simulator(int depth, int width) {
		if (width <= 0 || depth <= 0) {
			System.out.println("The dimensions must be >= zero.");
			System.out.println("Using default values.");
			depth = DEFAULT_DEPTH;
			width = DEFAULT_WIDTH;
		}

		animals = new ArrayList<>();
		// foxes = new ArrayList<>();
		field = new Field(depth, width);

		// Create a view of the state of each location in the field.
		view = new SimulatorView(depth, width);
		view.setColor(Rabbit.class, Color.ORANGE);
		view.setColor(Fox.class, Color.BLUE);

		// Setup a valid starting point.
		reset();
	}

	/**
	 * Run the simulation from its current state for a reasonably long period (4000
	 * steps).
	 */
	public void runLongSimulation() {
		simulate(4000);
	}

	/**
	 * Run the simulation for the given number of steps. Stop before the given
	 * number of steps if it ceases to be viable.
	 * 
	 * @param numSteps The number of steps to run for.
	 */
	public void simulate(int numSteps) {
		for (int step = 1; step <= numSteps && view.isViable(field); step++) {
			simulateOneStep();
			// delay(60); // uncomment this to run more slowly
		}
	}

	/**
	 * Run the simulation from its current state for a single step. Iterate over the
	 * whole field updating the state of each fox and rabbit.
	 */
	public void simulateOneStep() {
		step++;

		// Provide space for newborn rabbits.
		List<Animal> newRabbits = new ArrayList<>();
		// Let all rabbits act.
		for (Iterator<Animal> it = animals.iterator(); it.hasNext();) {
			Animal rabbit = it.next();
			rabbit.act(newRabbits);
			if (!rabbit.isAlive()) {
				it.remove();
			}
		}

		// Provide space for newborn foxes.
		List<Animal> newFoxes = new ArrayList<>();

		// Let all foxes act.
		for (Iterator<Animal> it = animals.iterator(); it.hasNext();) {
			Animal fox = it.next();
			fox.act(newFoxes);
			if (!fox.isAlive()) {
				it.remove();
			}
		}

		// Add the newly born foxes and rabbits to the main lists.
		animals.addAll(newRabbits);
		animals.addAll(newFoxes);

		view.showStatus(step, field);

	}

	/**
	 * Reset the simulation to a starting position.
	 */
	public void reset() {
		step = 0;
		animals.clear();
		populate();

		// Show the starting state in the view.
		view.showStatus(step, field);
	}

	/**
	 * Randomly populate the field with foxes and rabbits.
	 */
	private void populate() {
		Random rand = Randomizer.getRandom();
		field.clear();
		for (int row = 0; row < field.getDepth(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				if (rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
					Location location = new Location(row, col);
					Fox fox = new Fox(true, field, location);
					animals.add(fox);
				} else if (rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
					Location location = new Location(row, col);
					Rabbit rabbit = new Rabbit(true, field, location);
					animals.add(rabbit);
				}
				// else leave the location empty.
			}
		}
	}

	/**
	 * Pause for a given time.
	 * 
	 * @param millisec The time to pause for, in milliseconds
	 */
	private void delay(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException ie) {
			// wake up
		}
	}
}