
public class noteBookTest {

	private static noteBook calculusTwo = new noteBook();
	// ArrayList<String> notes = new ArrayList<String>();

	public static void main(String[] args) {
		populateNotes();
		moveNoteUpByTwo();
		displayNotes();
	}

	private static void populateNotes() {
		System.out.println("Creating notes: \n");
		calculusTwo.addNote("Derivatives");
		calculusTwo.addNote("Anti Derivatives");
		calculusTwo.addNote("Integrals");
		calculusTwo.addNote("Volume With Slices");
	}

	private static void moveNoteUpByTwo() {
		for (int moves = 0; moves < calculusTwo.getNumberOfNotes(); moves++)
			calculusTwo.moveNoteUp("Integrals");
	}

	private static void displayNotes() {
		System.out.println("Notes in notebook: " + "\n" + calculusTwo.getNotes());
	}
}
