
public class rockyAndBullwinkleClip implements playableWavs {
	private String filename;
	private String speakers;

	public rockyAndBullwinkleClip(String filename, String speakers) {
		this.filename = filename;
		this.speakers = speakers;
	}

	public String getSpeakers() {
		return speakers;
	}

	public void setSpeakers(String speakers) {
		this.speakers = speakers;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
