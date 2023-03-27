
public class gameOfThronesClip implements playableGifs {
	private String filename;
	private String character;

	public gameOfThronesClip(String filename, String character) {
		this.filename = filename;
		this.character = character;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
