package model;

public class Song{

	//Atributes
	private String title;
	private String artistName;
	private String releaseDate;
	private int minutes;
	private int seconds;
	private Genre genre;	

	//Getters and Setters 

	/**
	* This method returns the title of a song. <br>
	* <b>name</b>: getTitle <br>
	* @return String <code> title </code> that is variable with the title of a song.
	*/

	public String getTitle(){
		return title;
	}

	/**
	* this method modifies the title of a song. <br>
	* <b>name</b>: setTitle <br>
	* <b>post</b>: the title of the song has been changed. <br>
	* @param pTitle is a String variable.
	*/

	public void setTitle(String pTitle){
		title = pTitle;
	}

	/**
	* This method returns the artist's name of a song. <br>
	* <b>name</b>: getArtistName <br>
	* @return String <code> artistName </code> that is a variable with the artist's name of a song.
	*/

	public String getArtistName(){
		return artistName;
	}

	/**
	* this method modifies the artist's name of a song. <br>
	* <b>name</b>: setArtistName <br>
	* <b>post</b>: the artist's name of the song has been changed. <br>
	* @param pArtistName is a String variable.
	*/

	public void setArtistName(String pArtistName){
		artistName = pArtistName;
	}

	/**
	* This method returns the release date of a song. <br>
	* <b>name</b>: getReleaseDate <br>
	* @return String <code> releaseDate </code> that is a variable with the release date of a song.
	*/

	public String getReleaseDate(){
		return releaseDate;
	}

	/**
	* this method modifies the release date of a song. <br>
	* <b>name</b>: setReleaseDate <br>
	* <b>post</b>: the release date of the song has been changed. <br>
	* @param pReleaseDate is a String variable.
	*/

	public void setReleaseDate(String pReleaseDate){
		releaseDate = pReleaseDate;
	}

	/**
	* This method returns the minutes of a song. <br>
	* <b>name</b>: getMinutes <br>
	* @return integer <code> minutes </code> that is a variable with the minutes that a song lasts.
	*/

	public int getMinutes(){
		return minutes;
	}

	/**
	* this method modifies the minutes of a song. <br>
	* <b>name</b>: setMinutes <br>
	* <b>post</b>: the minutes of the song has been changed. <br>
	* @param pMinutes is an integer variable.
	*/

	public void setMinutes(int pMinutes){
		minutes = pMinutes;
	}

	/**
	* This method returns the seconds of a song. <br>
	* <b>name</b>: getSeconds <br>
	* @return integer <code> seconds </code> that is a variable with the seconds that a song lasts.
	*/

	public int getSeconds(){
		return seconds;
	}

	/**
	* this method modifies the seconds of a song. <br>
	* <b>name</b>: setSeconds <br>
	* <b>post</b>: the seconds of the song has been changed. <br>
	* @param pSeconds is an integer variable.
	*/

	public void setSeconds(int pSeconds){
		seconds = pSeconds;
	}

	/**
	* This method returns the genre of a song. <br>
	* <b>name</b>: getGenre <br>
	* @return Genre <code> genre </code> that is a constant that represents the genre of a song.
	*/

	public Genre getGenre(){
		return genre;
	}

	/**
	* this method modifies the genre of a song. <br>
	* <b>name</b>: setGenre <br>
	* <b>post</b>: the genre of the song has been changed. <br>
	* @param pGenre is a constant of type Genre.
	*/

	public void setGenre(Genre pGenre){
		genre = pGenre;
	}

	//Methods 

	/**
	* Builder method <br>
	* <b>name</b>: Song <br>
	* <b>pre</b>: the variables pTitle, pArtistName, pReleaseDate, pGenre, pMinutes, and pSeconds are already inicializated. <br>
	* <b>post</b>: the relationships and all the atributes of the class were inicializated. <br>
	* @param pTitle is a String variable that contains the title of a song.
	* @param pArtistName is a String variable that contains the artist's name of a song.
	* @param pReleaseDate is a String variable that contains the release date of a song.
	* @param pMinutes is an integer variable that contains the minutes that song lasts.
	* @param pSeconds is an integer variable that contains the seconds that song lasts.
	* @param pGenre is an integer variable that represents the genre of a song.
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