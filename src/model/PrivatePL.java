package model;

public class PrivatePL extends PlayList{

	//Relationships
	private User nameUser;
	private User authorizedUser;

	/**
	* Builder method <br>
	* <b>name</b>: PrivatePL <br>
	* <b>pre</b>: the variable name, the objects like pNameUser, pAuthorizedUser, and the lists such as minutes and seconds are already inicializated. <br>
	* <b>post</b>: the relationships and all the atributes of the class were inicializated. <br>
	* @param name is a String variable that.
	* @param minutes is a list of integers that.
	* @param seconds is a list of integers that.
	* @param pNameUser is an User object that.
	* @param pAuthorizedUser is an User object that.
	*/
	public PrivatePL(String name, int[] minutes, int[] seconds, User pNameUser, User pAuthorizedUser){
		super(name,minutes,seconds);
		nameUser = pNameUser;
		authorizedUser = pAuthorizedUser;
	}

	@Override
	public String addSongToPlaylist(User objUser, Song objSong){
		String message = "";
		if(objUser.getName().equalsIgnoreCase(nameUser.getName())||objUser.getName().equalsIgnoreCase(authorizedUser.getName())){
			message = super.addSongToPlaylist(objUser,objSong); 
		} else{
			message = "La cancion no se pudo agregar, ya que el usuario ingresado no tiene el permiso de acceder a la Playlist";
		}
	}	
}