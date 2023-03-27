
public class Movie {
	
	private String title;
	private int length;
	private String releaseDate;
	
	public Movie(String title, int length, String releaseDate){
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
