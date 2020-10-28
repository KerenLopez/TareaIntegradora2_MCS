package model;

public class Song{

	//Atributes
	private String title;
	private String artistName;
	private String releaseDate;
	private int[] minutes;
	private int[] seconds;
	private Genre genre;

	//Builder Method
	public Song(String pTitle, String pArtistName, String pReleaseDate, int[] pMinutes, int[] pSeconds, int pGenre){
		title = pTitle;
		artistName = pArtistName;
		releaseDate = pReleaseDate;
		minutes = pMinutes;
		seconds = pSeconds;
		switch(pGenre){
			case 1:
				genre = Genre.ROCK; 
				break;
			case 2:
				genre = Genre.HIPHOP;
				break;
			case 3:
				genre = Genre.CLASSICAL;
				break;
			case 4:
				genre = Genre.REGGAE; 
				break;
			case 5:
				genre = Genre.SALSA;
				break;
			case 6:
				genre = Genre.METAL;
				break;					
		}
	}
	//End Builder Method 

	//Getters & Setters

	public String getTitle(){
		return title;
	}

	public void setTitle(String pTitle){
		title = pTitle;
	}

	public String getArtistName(){
		return artistName;
	}

	public void setArtistName(String pArtistName){
		artistName = pArtistName;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(String pReleaseDate){
		releaseDate = pReleaseDate;
	}

	public int[] getMinutes(){
		return minutes;
	}

	public void setMinutes(int[] pMinutes){
		minutes = pMinutes;
	}

	public int[] getSeconds(){
		return seconds;
	}

	public void setSeconds(int[] pSeconds){
		seconds = pSeconds;
	}

	public Genre getGenre(){
		return genre;
	}

	public void setGenre(Genre pGenre){
		genre = pGenre;
	}
}