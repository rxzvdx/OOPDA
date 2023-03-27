
public class darkClip implements playableGifs {
	private String filename;
	private String scene;

	public darkClip(String filename, String scene) {
		this.filename = filename;
		this.scene = scene;

	}

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
