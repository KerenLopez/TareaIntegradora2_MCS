package model;

public class PlayList{

	//Atributes
	protected String name;
	protected int[] minutes;
	protected int[] seconds;

	//Constants
	public final static int NUM_GENRES = 7; 

	//Relationships
	protected Genre[] genres;
	protected Song[] songs;

	//Methods 

	public PlayList(String pName, int[] pMinutes, int[] pSeconds){
		name = pName;
		minutes = pMinutes;
		seconds = pSeconds; 
		genres = new Genre[NUM_GENRES];
		songs = new Song[MCS.MAX_NUM_SONGS];
	}

	public void addSongToPlaylist(User nameUser, Song nameSong){

	}
	//Getters & Setters

	public String getName(){
		return name;
	}

	public void setName(String pName){
		name = pName;
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

	public Genre[] getGenres(){
		return genres;
	}

	public void setGenres(Genre[] pGenres){
		genres = pGenres;
	}

	public Song[] getSongs(){
		return songs;
	}

	public void setSongs(Song[] pSongs){
		songs = pSongs;
	}
}