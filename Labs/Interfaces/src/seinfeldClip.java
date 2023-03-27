
public class seinfeldClip implements playableWavs {
	private String filename;
	private String speaker;
	private String year;

	public seinfeldClip(String filename, String speaker, String year) {
		this.filename = filename;
		this.speaker = speaker;
		this.year = year;
	}

	public String getFilename() {
		return filename;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
