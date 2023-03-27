package herd; 


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		DataSet myDataSet = new DataSet(); // new DataSet object
		String file = "herdManagement.csv"; // file name to be read
		try {
			loadStatistics(myDataSet, file, 3); // loadStatistics method with myDataSet, file, and 3 passed in as
												// parameters
		} catch (StatisticDataNotFoundException e) { // catch exception if stat data not found
			System.out.println(e.getMessage()); // print error message
		}
		Random random = new Random(); // random for state statistic
		ArrayList<Statistic> statistic = myDataSet.getStats(); // stat arrayList
		if(statistic.size() > 0) { // if stats size is greater than 0, fetch a random state
			int randomState = random.nextInt(statistic.size());
			StateStatistic state = (StateStatistic) statistic.get(randomState);
			System.out.println("\n Serializing...");
		
		try {
			myDataSet.serialize(state); // try to serialize
		}
		catch(StatisticDataNotFoundException e){ // if not, catch an exception
			System.out.println(e.getMessage());
		}
		
	System.out.println("\n Deserializing..."); 
		try {
			myDataSet.deserialize(); // try to deserialize
		}
		catch(StatisticDataNotFoundException e) {
			System.out.println(e.getMessage()); // if not deserialize 
			}
		}
	}

	private static void loadStatistics(DataSet myDataSet, String file, int numOfHeaderRows) throws StatisticDataNotFoundException {
		String line; // line string 
		String[] fields; // array of string fields
		try {	
				BufferedReader reader = 
						new BufferedReader(new FileReader(file)); // new bufferedReader to read through file
				for(int i = 0; i < numOfHeaderRows; i++) {
					reader.readLine(); 
				}
				while ((line = reader.readLine()) != null) { // while line (which equals reader.readLine != null, split wherever "," exists
					fields = line.split(",");  // split into fields
					State state = State.valueOf(fields[0]);
					// the number of acres that contain horses and burros overseen by the BLM
					long herdAreaAcresBLM = Long.parseLong(fields[1]); 
					// the number of acres that contain horses and burros not overseen by the BLM
					long herdAreaAcresOther = Long.parseLong(fields[2]); 
					// the subset of herdAreaAcres overseen by the BLM where population management is active
					long herdManagementAreaAcresBLM = Long.parseLong(fields[3]); 
					// the subset of herdAreaAcres not overseen by the BLM where population management is active
					long herdManagementAreaAcresOther = Long.parseLong(fields[4]);
					// the number of wild horses in the state
					long numHorses = Long.parseLong(fields[5]);
					// the number of wild burros in the state
					long numBurros = Long.parseLong(fields[6]);
					myDataSet.addStatistic(new StateStatistic(state, herdAreaAcresBLM, herdAreaAcresOther, herdManagementAreaAcresBLM, 
							herdManagementAreaAcresOther, numHorses, numBurros));
				}
				reader.close();
			}
		catch(IOException e){
				throw new StatisticDataNotFoundException("Data not found: " + file + "\n Data access request at: " + LocalDate.now());
	}
}

	@SuppressWarnings("unused")
	private static void displayStatistics(DataSet myDataSet) {
		int horses = 0;
		int burros = 0;
		for(Statistic statistic : myDataSet.getStats()) {
			horses += ((StateStatistic) statistic).getNumHorses();
			burros += ((StateStatistic) statistic).getNumBurros();
			System.out.println("At state: " + ((StateStatistic) statistic).getState() 
					+ "\n Horses: " + ((StateStatistic) statistic).getNumHorses()
					+ "\n Burros: " + ((StateStatistic) statistic).getNumBurros());
		}
		if (myDataSet.getStats().size() > 0) {
		System.out.println("\n The total number of horses: " + horses + "\n The total number of burros: " + burros + "\n");	
		}
	}
}