package herd;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A dataset is a collection of statistics
 */
public class DataSet {
	String fileName = "serialize.ser";
	/** the collection of statistics **/
	private ArrayList<Statistic> stats = new ArrayList<Statistic>(20);

	/**
	 * the full-argument constructor
	 * @param stats the ArrayList of Statistics
	 */
	public DataSet(ArrayList<Statistic> stats) {
		this.stats = stats;
	}
		
	/**
	 * the no-argument constructor which initializes the stats collection
	 */
	public DataSet() {
		this.stats = new ArrayList<Statistic>();
	}

	/**
	 * addStatistic will add a stat to the stats collection
	 * @param stat the statistic to add
	 */
	public void addStatistic(Statistic stat) {
		this.stats.add(stat);
	}

	/**
	 * standard accessor method
	 * @return the stats
	 */
	public ArrayList<Statistic> getStats() {
		return stats;
	}

	/**
	 * standard mutator method
	 * @param stats the stats to set
	 */
	public void setStats(ArrayList<Statistic> stats) {
		this.stats = stats;
	}
	
	/**
	 * @param Statistic statistic	The statistic to be serialized
	 * @throws StatisticDataNotFoundException
	 */
	public void serialize(Statistic statistic) throws StatisticDataNotFoundException{
		try{
			FileOutputStream fileOutput = new FileOutputStream(fileName);
			ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
			objOutput.writeObject(statistic);
			objOutput.close();
			fileOutput.close();
			// s.o.p.f for output
			System.out.printf("Serialized data for state %s is saved in: %s\n", ((StateStatistic) statistic).getState(), fileName);
		}
		catch(IOException e) {
			throw new StatisticDataNotFoundException("Serialized file: " + fileName 
					+ " not found at: " + LocalDate.now());
		}
	}
	
	/**
	 * @throws StatisticDataNotFoundException
	 */
	public void deserialize() throws StatisticDataNotFoundException{
		try{
			try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(fileName))) {
				StateStatistic stateStat = ((StateStatistic) objInput.readObject());
				System.out.println("State: " + stateStat.getState() + "\nHorses: " + stateStat.getNumHorses()
				+ "\nBurros: " + stateStat.getNumBurros());
			}
		}
		catch(Exception e) {
			throw new StatisticDataNotFoundException("No data to deserialize");
		}
	}
	
}
