package model;

public class PrivatePL extends PlayList{

	//Relationships
	private User authorizedUser;

	/**
	* Builder method <br>
	* <b>name</b>: PrivatePL <br>
	* <b>pre</b>: the variable name, the object pAuthorizedUser and the lists like minutes and seconds are already inicializated. <br>
	* <b>post</b>: the atributes of the class were inicializated. <br>
	* @param name is a String variable that contains the name of a playlist.
	* @param minutes is a list of integers that contains the minutes that all the songs of a playlist lasts.
	* @param seconds is a list of integers that contains the seconds that all the songs of a playlist lasts.
	* @param pAuthorizedUser is an User object that contains the information of the only user that can access to the playlist.
	*/

	public PrivatePL(String name, int[] minutes, int[] seconds, User pAuthorizedUser){
		super(name,minutes,seconds);
		authorizedUser = pAuthorizedUser;
	}

	/**
	* This method adds a song of the pool in a private playlist. <br>
	* <b>name</b>: addSongToPlaylist.<br>
 	* <b>post</b>: the song of the pool was added successfully or the song of the pool couldn't be incorporated to the private playlist. <br>
 	* @param objUser is an object of type User that contains the information of a user.
 	* @param objSong is an object of type Song that contains the information of a song.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	@Override
	public String addSongToPlaylist(User objUser, Song objSong){
		String message = "";
		if(objUser.getUserName().equalsIgnoreCase(authorizedUser.getUserName())){
			message = super.addSongToPlaylist(objUser,objSong); 
		} else{
			message = "\nLa cancion no se pudo agregar, ya que el usuario ingresado no tiene el permiso de acceder a la Playlist";
		} return message;
	}

	/**
	* This method produces a String with the information of a private playlist. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of the playlist was returned. <br>
 	* @return out in a <code> String </code> variable all information of a private playlist.
	*/

	@Override
	public String toString(){
		return super.toString()+"\n                                          **  Tipo: Privada"+"\n                                          **  Usuario con acceso: "+authorizedUser.getUserName();
	}	
}