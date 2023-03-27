package college;

import java.text.DecimalFormat;

public class Player {

	String name;
	int numberOfClubs;
	int numberOfFriends;
	int money;
	int happiness;
	double gpa;
	int location;
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public Player(String name) {
		this.name = name;
		this.numberOfClubs = Game.NUMBER_OF_CLUBS;
		this.numberOfFriends = Game.NUMBER_OF_FRIENDS;
		this.money = Game.MONEY;
		this.happiness = Game.HAPPINESS;
		this.gpa = Game.GPA;
		this.location = 0;
	}
	
	public void move(int squares) {
		this.location += squares;
		if (this.location >= Game.LAST_SQUARE) this.location = Game.LAST_SQUARE;
		// Use System.err output stream to get red text!  No error here.
		System.err.println("\n" + Game.squareText.get(this.location));
		if (this.location == Game.LAST_SQUARE) getStats();
	}
	
	public void moveTo(int square) {
		this.location = square;
		if (this.location >= Game.LAST_SQUARE) this.location = Game.LAST_SQUARE;
		// Use System.err output stream to get red text!  No error here.
		System.err.println("\n" + Game.squareText.get(this.location));
		if (this.location == Game.LAST_SQUARE) getStats();
	}

	private void getStats() {
		Double delta;
		System.out.println("\nFINAL RESULTS");
		delta = (double) (this.numberOfFriends - Game.NUMBER_OF_FRIENDS);
		outputStat("Number of Friends", delta); 
		delta = (double) (this.money - Game.MONEY );
		outputStat("Money", delta); 
		delta = (double) (this.happiness - Game.HAPPINESS );
		outputStat("Happiness", delta); 
		delta = (double) (this.gpa - Game.GPA);
		outputStat("GPA", delta); 
	}
	
	private void outputStat(String property, double delta) {
		if (delta > 0) {
			System.out.println("\t" + property + " improved!");
		}
		else if (delta < 0) {
			System.err.println("\t" + property + " worsened!");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfClubs() {
		return numberOfClubs;
	}

	public void setNumberOfClubs(int numberOfClubs) {
		this.numberOfClubs = numberOfClubs;
	}

	public int getNumberOfFriends() {
		return numberOfFriends;
	}

	public void setNumberOfFriends(int numberOfFriends) {
		this.numberOfFriends = numberOfFriends;
		if (this.numberOfFriends < 0) this.numberOfFriends = 0;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
		if (this.gpa < 0.0) this.gpa = 0.0;
		if (this.gpa > 4.0) this.gpa = 4.0;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return name + ": [" + "numberOfClubs=" + numberOfClubs + ", numberOfFriends=" + numberOfFriends
				+ ", money=$" + money + ", happiness=" + happiness + ", gpa=" + df.format(gpa) + ", location=" + location + "]";
	}
	
	
}
