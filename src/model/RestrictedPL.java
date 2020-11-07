package model;

public class RestrictedPL extends PlayList{

	//Constants
	public final static int MAX_NUM_USERS = 5;

	//Relationships
	private User[] authorizedUsers;

	/**
	* Builder method <br>
	* <b>name</b>: RestrictedPL <br>
	* <b>pre</b>: the variable name, the lists such as pAuthorizedUsers, minutes and seconds are already inicializated. <br>
	* <b>post</b>: the relationships and all the atributes of the class were inicializated. <br>
	* @param name is a String variable that contains the name of a playlist.
	* @param minutes is a list of integers that contains the minutes that all the songs of a playlist lasts.
	* @param seconds is a list of integers that contains the seconds that all the songs of a playlist lasts.
	* @param pAuthorizedUsers is a list of User objects that contains the information of all the users that can access to the playlist.
	*/
	public RestrictedPL(String name, int[] minutes, int[] seconds, User[] pAuthorizedUsers){
		super(name,minutes,seconds);
		authorizedUsers = pAuthorizedUsers;
	}

	/**
	* This method adds a song of the pool in a restricted playlist. <br>
	* <b>name</b>: addSongToPlaylist.<br>
 	* <b>post</b>: the song of the pool was added successfully or the song of the pool couldn't be incorporated to the restricted playlist. <br>
 	* @param objUser is an object of type User that contains the information of a user.
 	* @param objSong is an object of type Song that contains the information of a song.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	@Override
	public String addSongToPlaylist(User objUser, Song objSong){
		String message = "";
		boolean find = false;
		for(int k=0; k<authorizedUsers.length && !find;k++){
			if(objUser.getUserName().equalsIgnoreCase(authorizedUsers[k].getUserName())){
				message = super.addSongToPlaylist(objUser,objSong);
				find = true;
			} 
		}
		if(!find){
			message = "\nLa cancion no se pudo agregar, ya que el usuario ingresado no tiene el permiso de acceder a la Playlist";
		} return message;	
	}

	/**
	* This method returns a String with the information of a restricted playlist. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of the playlist was returned. <br>
 	* @return String <code> message </code> that is a variable with the information of a restricted playlist.
	*/

	@Override
	public String toString(){
		String message = "";
		for(int k=0;k<authorizedUsers.length;k++){
			if(authorizedUsers[k]!=null){
				message+="\n                                          **  Usuario #"+(k+1)+" con acceso: "+authorizedUsers[k].getUserName();
			}		
		}
		return super.toString()+"\n                                          **  Tipo: Restringida"+message;	
	}

}