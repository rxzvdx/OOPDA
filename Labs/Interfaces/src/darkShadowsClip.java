
public class darkShadowsClip implements playableWavs {
	private String filename;
	private String episode;
	private String speaker;

	public darkShadowsClip(String filename, String episode, String speaker) {
		this.filename = filename;
		this.episode = episode;
		this.speaker = speaker;
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

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
