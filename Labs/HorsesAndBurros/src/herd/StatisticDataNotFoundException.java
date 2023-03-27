package herd;

import java.io.FileNotFoundException;

public class StatisticDataNotFoundException extends FileNotFoundException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2522594321374814263L;

	public StatisticDataNotFoundException(String exception) {
        super(exception);
    }
}