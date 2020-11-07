package model;

public class PlayList{

	//Atributes
	private String name;
	private int[] minutes;
	private int[] seconds;

	//Constant
	public final static int NUM_GENRES = 7; 

	//Relationships
	private Genre[] genres;
	private Song[] songs;

	//Getters and Setters

	/**
	* This method returns the name of a playlist. <br>
	* <b>name</b>: getName <br>
	* @return String <code> name </code> that is a variable with the name of a playlist.
	*/

	public String getName(){
		return name;
	}

	/**
	* this method modifies the name of a playlist. <br>
	* <b>name</b>: setName <br>
	* <b>post</b>: the name of the playlist has been changed. <br>
	* @param pName is a String variable.
	*/

	public void setName(String pName){
		name = pName;
	}

	/**
	* This method returns the minutes that the songs of a playlist lasts in the manager as list of integers. <br>
	* <b>name</b>: getMinutes <br>
	* @return integer <code> minutes[] </code> that is a list with all the minutes of the songs that were added to a playlist.
	*/

	public int[] getMinutes(){
		return minutes;
	}

	/**
	* this method modifies the list of minutes that the songs of a playlist lasts. <br>
	* <b>name</b>: setMinutes <br>
	* <b>post</b>: the list of minutes that the songs of a playlist lasts has been changed. <br>
	* @param pMinutes is a list of integer variables.
	*/

	public void setMinutes(int[] pMinutes){
		minutes = pMinutes;
	}

	/**
	* This method returns the seconds that the songs of a playlist lasts in the manager as list of integers. <br>
	* <b>name</b>: getSeconds <br>
	* @return integer <code> seconds[] </code> that is a list with all the seconds of the songs that were added to a playlist.
	*/

	public int[] getSeconds(){
		return seconds;
	}

	/**
	* this method modifies the list of seconds that the songs of a playlist lasts. <br>
	* <b>name</b>: setSeconds <br>
	* <b>post</b>: the list of seconds that the songs of a playlist lasts has been changed. <br>
	* @param pSeconds is a list of integer variables.
	*/

	public void setSeconds(int[] pSeconds){
		seconds = pSeconds;
	}

	/**
	* This method returns the genres of a playlist in the manager as list of Genre constants. <br>
	* <b>name</b>: getGenres <br>
	* @return Genre <code> genres[] </code> that is a list with all the genres of a playlist.
	*/

	public Genre[] getGenres(){
		return genres;
	}

	/**
	* this method modifies the genres of a playlist. <br>
	* <b>name</b>: setGenres <br>
	* <b>post</b>: the genres of a playlist has been changed. <br>
	* @param pGenres is a list of Genre constants.
	*/

	public void setGenres(Genre[] pGenres){
		genres = pGenres;
	}

	/**
	* This method returns the songs of a playlist in the manager as list of Song objects. <br>
	* <b>name</b>: getSongs <br>
	* @return Song <code> songs[] </code> that is a list with all the songs of a playlist.
	*/

	public Song[] getSongs(){
		return songs;
	}

	/**
	* this method modifies the songs of a playlist. <br>
	* <b>name</b>: setSongs <br>
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
	* @param pName is a String variable that contains the name of a playlist.
	* @param pMinutes is a list of integers that contains the minutes that all the songs of a playlist lasts.
	* @param pSeconds is a list of integers that contains the seconds that all the songs of a playlist lasts.
	*/

	public PlayList(String pName, int[] pMinutes, int[] pSeconds){
		name = pName;
		minutes = pMinutes;
		seconds = pSeconds; 
		genres = new Genre[NUM_GENRES];
		genres[0] = Genre.UNKNOWN;
		songs = new Song[MCS.MAX_NUM_SONGS];
	}

	/**
	* This method looks for a specific song within of a playlist. <br>
	* <b>name</b>: findSongInPlaylist.<br>
 	* <b>post</b>: An object of type Song was returned. <br>
 	* @param objSong is an object of type Song.  
 	* @return Song <code> objFindSong </code> that is an object that could be null or full.
	*/

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

	/**
	* This method adds a song of the pool in a specific playlist. <br>
	* <b>name</b>: addSongToPlaylist.<br>
 	* <b>post</b>: the song of the pool was added successfully or the song of the pool couldn't be incorporated to the playlist. <br>
 	* @param objUser is an object of type User that contains the information of a user.
 	* @param objSong is an object of type Song that contains the information of a song.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

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

	/**
	* This method calculates the total duration of a playlist. <br>
	* <b>name</b>: calculateDuration.<br>
 	* <b>post</b>: the duration of the playlist was calculated. <br>
 	* @return String <code> message </code> that is a variable with the minutes and seconds that a playlist lasts.
	*/

	public String calculateDuration(){
		String message = "";
		int sumMinutes = 0, sumSeconds = 0, sumHours = 0;
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

	/**
	* This method returns a String with the information of a playlist. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of the playlist was returned. <br>
 	* @return String <code> message </code> that is a variable with all information of a playlist.
	*/

	public String toString(){
		String message = "";
		for(int k=0;k<genres.length;k++){
			if(genres[k]!=null){
				message+=getGenres()[k]+" ";
			}	
		}
		return  "\n                                          *************************************"+
				"\n                                          ************* PlayList **************"+
				"\n                                          **  Titulo: "+name+
				"\n                                          **  Duracion: "+calculateDuration()+
				"\n                                          **  Genero: "+message;
	}
}

	