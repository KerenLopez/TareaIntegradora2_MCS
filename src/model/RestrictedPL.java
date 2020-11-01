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
	* @param name is a String variable that.
	* @param minutes is a list of integers that.
	* @param seconds is a list of integers that.
	* @param pAuthorizedUsers is a list of User objects that.
	*/
	public RestrictedPL(String name, int[] minutes, int[] seconds, User[] pAuthorizedUsers){
		super(name,minutes,seconds);
		authorizedUsers = pAuthorizedUsers;
	}

	@Override
	public String addSongToPlaylist(User objUser, Song objSong){
		String message = "";
		boolean find = false;
		for(int k=0; k<authorizedUsers.length && !stop;k++){
			if(objUser.getName().equalsIgnoreCase(authorizedUsers[k].getName())){
				message = super.addSongToPlaylist(objUser,objSong);
				find = true;
			} 
		}
		if(!find){
			message = "La cancion no se pudo agregar, ya que el usuario ingresado no tiene el permiso de acceder a la Playlist";
		}	
	}

}