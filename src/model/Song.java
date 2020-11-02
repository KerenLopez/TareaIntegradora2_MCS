package model;

public class Song{

	//Atributes
	private String title;
	private String artistName;
	private String releaseDate;
	private int minutes;
	private int seconds;
	private Genre genre;	

	//Getters and Setters of all the atributes or relationships

	/**
	* This method returns the title of a song. <br>
	* @return out a <code> String </code> variable that contains the title of song.
	*/
	public String getTitle(){
		return title;
	}
	/**
	* this method modifies the title of a song. <br>
	* <b>post</b>: the title of a song has been changed. <br>
	* @param pTitle is a String variable.
	*/
	public void setTitle(String pTitle){
		title = pTitle;
	}
	/**
	* This method returns the artist's name of a song. <br>
	* @return out a <code> String </code> variable that contains the artist's name of a song.
	*/
	public String getArtistName(){
		return artistName;
	}
	/**
	* this method modifies the artist's name of a song. <br>
	* <b>post</b>: the artist's name of a song has been changed. <br>
	* @param pArtistName is a String variable.
	*/
	public void setArtistName(String pArtistName){
		artistName = pArtistName;
	}
	/**
	* This method returns the release date of a song. <br>
	* @return out a <code> String </code> variable that contains the release date of a song.
	*/
	public String getReleaseDate(){
		return releaseDate;
	}
	/**
	* this method modifies the release date of a song. <br>
	* <b>post</b>: the release date of a song has been changed. <br>
	* @param pReleaseDate is a String variable.
	*/
	public void setReleaseDate(String pReleaseDate){
		releaseDate = pReleaseDate;
	}

	public int getMinutes(){
		return minutes;
	}

	public void setMinutes(int pMinutes){
		minutes = pMinutes;
	}

	public int getSeconds(){
		return seconds;
	}

	public void setSeconds(int pSeconds){
		seconds = pSeconds;
	}

	public Genre getGenre(){
		return genre;
	}

	public void setGenre(Genre pGenre){
		genre = pGenre;
	}

	//Methods 

	/**
	* Builder method <br>
	* <b>name</b>: Song <br>
	* <b>pre</b>: the variables pTitle, pArtistName, pReleaseDate, pGenre, and the lists such as pMinutes and pSeconds are already inicializated. <br>
	* <b>post</b>: the relationships and all the atributes of the class were inicializated. <br>
	* @param pTitle is a String variable that.
	* @param pArtistName is a String variable that.
	* @param pReleaseDate is a String variable that.
	* @param pMinutes is an integer variable that.
	* @param pSeconds is an integer variable that.
	* @param pGenre is an integer variable that.
	*/
	public Song(String pTitle, String pArtistName, String pReleaseDate, int pMinutes, int pSeconds, int pGenre){
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
}