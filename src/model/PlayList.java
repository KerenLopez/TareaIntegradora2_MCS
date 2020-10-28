package model;

public class PlayList{

	//Atributes
	private String name;
	private int duration;

	//Constants
	public final static int NUM_GENRES = 7; 

	//Relationships
	private Genre[] genres;
	private Song[] songs;

	//Methods

	public PlayList(String pName, int pDuration){
		name = pName;
		duration = pDuration;
		genres = new Genre[NUM_GENRES];
		songs = new Song[MCS.MAX_NUM_SONGS];
	}

	//Getters & Setters

	public String getName(){
		return name;
	}

	public void setName(String pName){
		name = pName;
	}

	public int getDuration(){
		return duration;
	}

	public void setDuration(int pDuration){
		duration = pDuration;
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