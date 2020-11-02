package model;

public class PlayList{

	//Atributes
	private String name;
	private int[] minutes;
	private int[] seconds;

	//Constants
	public final static int NUM_GENRES = 7; 

	//Relationships
	private Genre[] genres;
	private Song[] songs;

	//Getters and Setters of all the atributes or relationships

	/**
	* This method returns the name of a playlist. <br>
	* @return out a <code> String </code> variable that contains the name of a playlist.
	*/
	public String getName(){
		return name;
	}
	/**
	* this method modifies the name of a playlist. <br>
	* <b>post</b>: the name of the playlist has been changed. <br>
	* @param pName is a String variable.
	*/
	public void setName(String pName){
		name = pName;
	}
	/**
	* This method returns the minutes that the songs of a playlist lasts in the manager as list of integers. <br>
	* @return out an <code> integer </code> list that contains the minutes of each song that was saved by the user.
	*/
	public int[] getMinutes(){
		return minutes;
	}
	/**
	* this method modifies the list of minutes that the songs of a playlist lasts. <br>
	* <b>post</b>: the list of minutes that the songs of a playlist lasts has been changed. <br>
	* @param pMinutes is a list of integer variables.
	*/
	public void setMinutes(int[] pMinutes){
		minutes = pMinutes;
	}
	/**
	* This method returns the seconds that the songs of a playlist lasts in the manager as list of integers. <br>
	* @return out an <code> integer </code> list that contains the seconds of each song that was saved by the user.
	*/
	public int[] getSeconds(){
		return seconds;
	}
	/**
	* this method modifies the list of seconds that the songs of a playlist lasts. <br>
	* <b>post</b>: the list of seconds that the songs of a playlist lasts has been changed. <br>
	* @param pSeconds is a list of integer variables.
	*/
	public void setSeconds(int[] pSeconds){
		seconds = pSeconds;
	}
	/**
	* This method returns the genres of a playlist in the manager as list of Genre objects. <br>
	* @return out a <code> Genre </code> list that contains the genres of a playlist.
	*/
	public Genre[] getGenres(){
		return genres;
	}
	/**
	* this method modifies the genres of a playlist. <br>
	* <b>post</b>: the genres of a playlist has been changed. <br>
	* @param pGenres is a list of Genre objects.
	*/
	public void setGenres(Genre[] pGenres){
		genres = pGenres;
	}
	/**
	* This method returns the songs of a playlist in the manager as list of Song objects. <br>
	* @return out a <code> Song </code> list that contains the songs of a playlist.
	*/
	public Song[] getSongs(){
		return songs;
	}
	/**
	* this method modifies the songs of a playlist. <br>
	* <b>post</b>: the songs of a playlist has been changed. <br>
	* @param pSongs is a list of Song objects.
	*/
	public void setSongs(Song[] pSongs){
		songs = pSongs;
	}

	//Methods 

	/**
	* Builder method <br>
	* <b>name</b>: PlayList <br>
	* <b>pre</b>: the variable pName and the lists such as pMinutes and pSeconds are already inicializated. <br>
	* <b>post</b>: the relationships and all the atributes of the class were inicializated. <br>
	* @param pName is a String variable that.
	* @param pMinutes is a list of integers that.
	* @param pSeconds is a list of integers that.
	*/
	public PlayList(String pName, int[] pMinutes, int[] pSeconds){
		name = pName;
		minutes = pMinutes;
		seconds = pSeconds; 
		genres = new Genre[NUM_GENRES];
		genres[0] = Genre.UNKNOWN;
		songs = new Song[MCS.MAX_NUM_SONGS];
	}

	public Song findSongInPlaylist(Song objSong){
		Song objFindSong = null;
		boolean find = false;
		for(int k=0;k<songs.length && !find;k++){
			if(songs[k]!=null && songs[k].getTitle().equalsIgnoreCase(objSong.getTitle())){
				find=true;
				objFindSong = songs[k];
			}
		}
		return objFindSong;
	}

	public String addSongToPlaylist(User objUser, Song objSong){
		String message = "";
		Song newObjSong = findSongInPlaylist(objSong);
		boolean stop = true, find = false, exit = true;
		if(newObjSong==null){	
			for(int k=0; k<songs.length && stop;k++){
				if(songs[k]==null){
					songs[k]= objSong;
					minutes[k]= objSong.getMinutes();
					seconds[k]= objSong.getSeconds();
					message = "\nLa cancion ha sido agregada exitosamente a la playlist";
					for(int i=0;i<genres.length && !find;i++){
						if(genres[i]!=null && genres[i]==objSong.getGenre()){
							find = true;
						}
					}
					if(!find){
						for(int x=0;x<genres.length && exit;x++){
							if(genres[x]==Genre.UNKNOWN){
								genres[x]= objSong.getGenre();
								exit = false;
							}else if(genres[x]==null){
								genres[x]=objSong.getGenre();
								exit = false;
							}	
						}
					} 
					stop = false;
				}
			}
		} else{
			message = "\nLa cancion ya se encuentra registrada en la playlist, pruebe con otra";
		} return message;
	}

	public String calculateDuration(){
		String message = "";
		int sumMinutes = 0, sumSeconds = 0, sumHours = 0, residue = 0;
		for(int k=0;k<seconds.length && k<minutes.length;k++){
			sumSeconds += seconds[k];
			sumMinutes += minutes[k];
		}
		sumMinutes+= sumSeconds/60;
		sumHours += sumMinutes/60;
		sumMinutes = sumMinutes%60;
		sumSeconds = sumSeconds%60;
		message = sumHours+":"+sumMinutes+":"+sumSeconds;
		return message;
	}

	public String toString(){
		String message = "";
		for(int k=0;k<genres.length;k++){
			if(genres[k]!=null){
				message+=getGenres()[k]+" ";
			}	
		}
		return  "\n                     *************************************"+
				"\n                     ************* PlayList **************"+
				"\n                     **  Titulo: "+name+
				"\n                     **  Duracion: "+calculateDuration()+
				"\n                     **  Genero: "+message;
	}
}

	