import java.util.ArrayList;

/*
 * Build a driver class and enhance a Notebook class with several useful ArrayList methods.
 * @author Antonio Rosado
 * @version (9/20/22)
 */
public class noteBook {

	private ArrayList<String> notes; // ArrayList for notes

	/**
	 * Creates a new empty list to hold notes
	 */
	public noteBook() // Constructor
	{
		notes = new ArrayList<>();
	}

	/**
	 * Returns notes in list
	 */
	public ArrayList<String> getNotes() // accessor method
	{
		return notes;
	}

	/**
	 * Returns number of notes in list
	 */
	public int getNumberOfNotes() // accessor method
	{
		return notes.size();
	}

	/**
	 * Allows user to add note(s) to list and prints newly added note
	 * 
	 * @param String noteName name of note added
	 */
	public boolean addNote(String noteName) // mutator method
	{
		if (noteName != null && !notes.contains(noteName)) {
			System.out.println("ADDED " + noteName.toLowerCase());

			return notes.add(noteName.toLowerCase());
		} else {
			System.out.println("Error: can NOT add invalid note");
			return false;
		}
	}

	/**
	 * Allows user to delete note(s) in list and prints deleted note
	 * 
	 * @param String noteName name of note removed
	 */
	public boolean deleteNote(String noteName) // mutator method
	{
		if (noteName != null) {
			System.out.println("DELETED " + noteName.toLowerCase() + " " + notes.remove(noteName));
			return notes.remove(noteName);
		} else {
			System.out.println("Error: can NOT delete invalid note");
			return false;
		}
	}

	/**
	 * Prints position of a note based on it's value
	 * 
	 * @param String noteName name of note removed
	 */
	public void getNoteNumber(String noteName) // accessor method
	{
		if (noteName != null) {
			System.out.println("Note: " + noteName + "at " + noteName.indexOf(noteName));
		} else {
			System.out.println("NO note found");
		}
	}

	/**
	 * Prints note based on it's given position
	 * 
	 * @param int index index of note searched for
	 */
	public void getNote(int index) // accessor method
	{
		if (index >= 0 && index <= notes.size()) {
			System.out.println(notes.get(index) + " at index " + index);
		} else {
			System.out.println("NO note found at index " + index);
		}
	}

	/**
	 * Updates note text for a given position
	 * 
	 * @param int    index index of note searched for
	 * @param String newNote newNote to replace given position
	 */
	public void setNote(String newNote, int index) // mutator method
	{
		if (newNote != null && index >= 0 && index <= notes.size()) {
			System.out.println("Replacing note at index: " + index + "/n with new note: " + newNote);
			notes.set(index, newNote);
		} else {
			System.out.println("NO note found at index " + index);
		}
	}

	/**
	 * Moves note text up at a given position
	 * 
	 * @param String newNote name of note to be replaced
	 */
	public void moveNoteUp(String noteName) // mutator method
	{
		int noteIndex = notes.indexOf(noteName.toLowerCase());
		if (noteIndex == 0) {
			return;
		}

		if (noteIndex == -1) {
			System.out.println("No note with that name exists");
			return;
		}
		notes.remove(noteIndex);
		notes.add(noteIndex - 1, noteName.toLowerCase());
	}

	/**
	 * Moves note text down at a given position
	 * 
	 * @param String newNote name of note to be replaced
	 */
	public void moveNoteDown(String noteName) // mutator method
	{
		int noteIndex = notes.indexOf(noteName);
		if (noteIndex == 0)
			return;
		if (noteIndex == -1) {
			System.out.println("No note with that name exists");
			return;
		}
		notes.remove(noteIndex);
		notes.add(noteIndex + 1, noteName);
	}

	/**
	 * Moves note text to the top of the list at a given position
	 * 
	 * @param String noteName name of note to be moved
	 */
	public void moveNoteToTop(String noteName) // mutator method
	{
		if (noteName != null) {
			int noteIndex = notes.indexOf(noteName);
			notes.remove(noteIndex);
			notes.add(0, noteName);
		} else {
			System.out.println("No note with that name exists");
		}
	}

	/**
	 * Moves note text to the bottom of the list at a given position
	 * 
	 * @param String noteName name of note to be moved
	 */
	public void moveNoteToBottom(String noteName) // mutator method
	{
		int noteIndex = notes.indexOf(noteName);
		notes.remove(noteIndex);
		notes.add(noteName);
	}

}
