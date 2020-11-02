package model;

public class MCS{

	//Constants
	public final static int MAX_NUM_USERS = 10;
	public final static int MAX_NUM_PLAYLISTS = 20;
	public final static int MAX_NUM_SONGS = 50;

	//Relationships
	private PlayList[] playlists;
	private Song[] songsPool;
	private User[] users;

	//Methods

	/**
	* Builder method <br>
	* <b>name</b>: MCS <br>
	* <b>post</b>: The arrays of playlists, songsPool and users were inicializated. <br>
	*/
	public MCS(){
		playlists = new PlayList[MAX_NUM_PLAYLISTS];
		songsPool = new Song[MAX_NUM_SONGS];
		users = new User[MAX_NUM_USERS];
	}
	/**
	* This method search . <br>
	* <b>name</b>: findUser.<br>
	* <b>pre</b>: the variable nameUser is already inicializated. <br>
 	* <b>post</b>: the user object was found or not. <br>
 	* @param nameUser is a String variable that . 
 	* @return an <code> User </code> object that could contains.
	*/
	public User findUser(String nameUser){
		User objUser = null;
		boolean find =false;
		for(int k=0;k<users.length && !find;k++){
			if(users[k]!=null && users[k].getUserName().equalsIgnoreCase(nameUser)){
				find=true;
				objUser = users[k];
			}
		} return objUser;
	}
	/**
	* This method creates . <br>
	* <b>name</b>: createUser.<br>
	* <b>pre</b>: the variables userName, password and age are already inicializated. <br>
 	* <b>post</b>: the . <br>
 	* @param userName is a String variable. 
 	* @param password is a String variable .
 	* @param age is an integer variable .
 	* @return a <code> String </code> variable that .
	*/
	public String createUser(String userName, String password, int age){
		User objUser = findUser(userName);
		String message = "\nEl usuario ha sido registrado exitosamente";
		boolean stop = true;
		if(objUser==null){
			for(int k=0;k<users.length && stop;k++){
				if(users[k]==null){
					stop = false;
					users[k]= new User(userName,password,age);
				}
			}
		} else{
			message = "\nEl usuario ya se encuentra registrado, intentelo nuevamente";
		} return message;	
	}
	/**
	* This method  . <br>
	* <b>name</b>: showUsers.<br>
 	* <b>post</b>: the . <br>
 	* @return a <code> String </code> variable that .
	*/
	public String showUsers(){
		String message="";
		for(int k=0;k<users.length;k++){
			if(users[k]!=null){
				message +="\n                     *************  Usuario **************"+
				"\n                      **  Nombre: "+users[k].getUserName()+
				"\n                      **  Edad: "+users[k].getAge()+
				"\n                      **  Categoria: "+users[k].getUserCategory()+
				"\n                     *************************************\n"; 
			}
		} return message;
	}
	/**
	* This method  . <br>
	* <b>name</b>: findSongInPool.<br>
	* <b>pre</b>: the variables title and artist are already inicializated. <br>
 	* <b>post</b>: the . <br>
 	* @param title is a String variable. 
 	* @param artist is a String variable.
 	* @return a <code> Song </code> object that .
	*/
	public Song findSongInPool(String title, String artist){
		boolean find =false;
		Song objSong = null;
		for(int k=0;k<songsPool.length && !find;k++){
			if(songsPool[k]!=null && songsPool[k].getTitle().equalsIgnoreCase(title) && songsPool[k].getArtistName().equalsIgnoreCase(artist)){
				find=true;
				objSong = songsPool[k];
			}
		}
		return objSong;
	}
	/**
	* This method  . <br>
	* <b>name</b>: addSongsToPool.<br>
	* <b>pre</b>: the arrays like minutes and seconds, and also the variables such as nameUser, title, artist, date and genre are already inicializated. <br>
 	* <b>post</b>: the . <br>
 	* @param nameUser is a String variable. 
 	* @param title is a String variable.
 	* @param artist is a String variable.
 	* @param date is a String variable.
 	* @param minutes is an integer variable that .
 	* @param seconds is an integer variable that .
 	* @param genre is an integer variable .
 	* @return a <code> String </code> variable that .
	*/
	public String addSongsToPool(String nameUser, String title, String artist, String date, int minutes, int seconds, int genre){
		Song objSong = findSongInPool(title, artist);
		User objUser = findUser(nameUser);
		String message = "";
		boolean stop = true;
		if(objSong==null && objUser!=null){
			for(int k=0;k<songsPool.length && stop;k++){
				if(songsPool[k]==null){
					stop = false;
					songsPool[k]= new Song(title,artist,date,minutes,seconds,genre);
					objUser.changeUserCategory();
					message = "\nLa cancion ha sido agregada exitosamente al pool de canciones";
				}
			}	
		} else{
			if (objUser==null){
				message += "\nEl usuario ingresado no existe, intentelo nuevamente";
			} 
			if(objSong!=null){
				message += "\nLa cancion ya se encuentra registrada, intentelo nuevamente";
			}
		}
		return message;
	}
	/**
	* This method  . <br>
	* <b>name</b>: showSongsInPool.<br>
 	* <b>post</b>: the . <br>
 	* @return a <code> String </code> variable that .
	*/
	public String showSongsInPool(){
		String message = "";
		for(int k=0;k<songsPool.length;k++){
			if(songsPool[k]!=null){
				message +="\n                     ************* Cancion **************"+
				"\n                     **  Titulo: "+songsPool[k].getTitle()+
				"\n                     **  Artista o banda: "+songsPool[k].getArtistName()+
				"\n                     **  Duracion: "+songsPool[k].getMinutes()+":"+songsPool[k].getSeconds()+
				"\n                     **  Genero: "+songsPool[k].getGenre()+
				"\n                     ************************************"; 
			}
		} return message;
	}
	/**
	* This method  . <br>
	* <b>name</b>: findPlaylist.<br>
	* <b>pre</b>: the variable namePlaylist is already inicializated. <br>
 	* <b>post</b>: the . <br>
 	* @param namePlaylist is a String variable. 
 	* @return a <code> PlayList </code> object that .
	*/
	public PlayList findPlaylist(String namePlaylist){
		PlayList objPlaylist = null;
		boolean find =false;
		for(int k=0;k<playlists.length && !find;k++){
			if(playlists[k]!=null && playlists[k].getName().equalsIgnoreCase(namePlaylist)){
				find=true;
				objPlaylist = playlists[k];
			}
		}
		return objPlaylist;
	}
	/**
	* This method  . <br>
	* <b>name</b>: addPlaylist.<br>
	* <b>pre</b>: the variables namePlaylist and nameUser are already inicializated. <br>
 	* <b>post</b>: the . <br>
 	* @param namePlaylist is a String variable.
 	* @param nameUser is a String variable.  
 	* @return a <code> String </code> variable that .
	*/
	public String addPlaylist(String namePlaylist, String nameUser, int option){
		User objUser = findUser(nameUser); 
		PlayList objPlaylist = findPlaylist(namePlaylist);
		String message = "";
		boolean stop = false;
		int[] minutes = new int[MAX_NUM_SONGS];
		int[] seconds = new int[MAX_NUM_SONGS];
		for(int i = 0;i<minutes.length && i<seconds.length;i++) {
			minutes[i]= 0;
			seconds[i]= 0;
		}
		if(objPlaylist==null && objUser!=null){
			for(int k=0;k<playlists.length && !stop;k++){
				if(playlists[k]==null){
					stop = true;
					if(option==1){
						playlists[k]= new PublicPL(namePlaylist, minutes, seconds);
						message = "\nLa playlist fue creada exitosamente";
					}
					if(option==2){
						playlists[k]= new PrivatePL(namePlaylist, minutes, seconds, objUser);
						message = "\nLa playlist fue creada exitosamente";
					}	
				}
			}
		} else{
			if(objPlaylist!=null) {
				message += "\nYa existe una playlist con el nombre ingresado, intentelo nuevamente";
			}
			if (objUser==null){
				message += "\nEl usuario ingresado no existe, intentelo nuevamente";
			} 
		} 
		return message;
	}
	/**
	* This method  . <br>
	* <b>name</b>: addPlaylist.<br>
	* <b>pre</b>: the list nameUsersPlaylistR and the variable namePlaylist are already inicializated. <br>
 	* <b>post</b>: the . <br>
 	* @param namePlaylist is a String variable.
 	* @param nameUsersPlaylistR is a list of Strings.  
 	* @return a <code> String </code> variable that .
	*/
	public String addPlaylist(String namePlaylist, String[] nameUsersPlaylistR){
		int numRegisteredUsers = 0;
		boolean stop = false;
		User[] objAuthorizedUsers = new User[RestrictedPL.MAX_NUM_USERS]; 
		PlayList objPlaylist = findPlaylist(namePlaylist);
		String message = "";
		int[] minutes = new int[MAX_NUM_SONGS];
		int[] seconds = new int[MAX_NUM_SONGS];
		for(int i = 0;i<minutes.length && i<seconds.length;i++) {
			minutes[i]= 0;
			seconds[i]= 0;
		}
		for(int j=0;j<nameUsersPlaylistR.length;j++){
			objAuthorizedUsers[j] = findUser(nameUsersPlaylistR[j]);
			if(objAuthorizedUsers[j]!=null){
				numRegisteredUsers+=1;
			}
		}
		if(objPlaylist==null && numRegisteredUsers==RestrictedPL.MAX_NUM_USERS){
			for(int k=0;k<playlists.length && !stop;k++){
				if(playlists[k]==null){
					stop = true;
					playlists[k]= new RestrictedPL(namePlaylist, minutes, seconds, objAuthorizedUsers);
					message = "\nLa playlist fue creada exitosamente";	
				}
			}
		} else{
			if(objPlaylist!=null) {
				message += "\nYa existe una playlist con el nombre ingresado, pruebe con uno distinto";
			}
			if(numRegisteredUsers<RestrictedPL.MAX_NUM_USERS){
				message += "\nAlguno de los usuarios que digito no existe, intentelo nuevamente";
			}
		} return message;
	}
	/**
	* This method  . <br>
	* <b>name</b>: addSongToPlaylist.<br>
	* <b>pre</b>: the variables nameUser, namePlaylist, nameSong and artistSong are already inicializated. <br>
 	* <b>post</b>: the . <br>
 	* @param nameUser is a String variable.
 	* @param namePlaylist is a String variable.
 	* @param nameSong is a String variable.
 	* @param artistSong is a String variable.
 	* @return a <code> String </code> variable that .
	*/
	public String addSongToPlaylist(String nameUser, String namePlaylist, String nameSong, String artistSong){
		String message = "";
		User objUser = findUser(nameUser);
		PlayList objPlaylist = findPlaylist(namePlaylist);
		Song objSong = findSongInPool(nameSong, artistSong);
		if(objPlaylist!=null && objUser!=null && objSong!=null){
			message = objPlaylist.addSongToPlaylist(objUser, objSong);
		} else{
			if(objSong==null){
				message += "\nLa cancion no se encuentra registrada en el Pool, intentelo nuevamente";
			}
			if(objUser==null){
				message += "\nEl usuario ingresado no existe, intentelo nuevamente";
			}
			if(objPlaylist==null){
				message += "\nLa playlist no existe, intentelo nuevamente";
			}	
		} return message;
	}

	public String showPlaylists(){
		String message = "";
		for(int k=0;k<playlists.length;k++){
			if(playlists[k]!=null){
				message += playlists[k].toString();
			}
		} return message;
	}

	public String ratePublicPlaylists(String nameUser, String namePlaylist, int grade){
		String message =  "";
		return message;
	}

	//Getters and Setters

	/**
	* This method returns the information of the playlists in the manager as a list of PlayList objects. <br>
	* @return out a <code> PlayList </code> list of objects that contains the information of each playlist created by the user.
	*/
	public PlayList[] getPlaylists(){
		return playlists;
	}
	/**
	* this method modifies the information of the playlists. <br>
	* <b>post</b>: the information of the playlists has been changed. <br>
	* @param playlists is a list of PlayList objects.
	*/
	public void setPlaylists(PlayList[] playlists){
		this.playlists = playlists;
	}
	/**
	* This method returns the information of the songs in the manager as a list of Song objects. <br>
	* @return out a <code> Song </code> list of objects that contains the information of each song added by the user.
	*/
	public Song[] getSongsPool(){
		return songsPool;
	}
	/**
	* this method modifies the information of the songs. <br>
	* <b>post</b>: the information of the songs has been changed. <br>
	* @param songs is a list of Song objects.
	*/
	public void setSongsPool(Song[] songs){
		this.songsPool = songsPool;
	}
	/**
	* This method returns the information of the users in the manager as a list of User objects. <br>
	* @return out an <code> User </code> list of objects that contains the information of each registered user.
	*/
	public User[] getUsers(){
		return users;
	}
	/**
	* this method modifies the information of the users. <br>
	* <b>post</b>: the information of the users has been changed. <br>
	* @param users is a list of User objects.
	*/
	public void setUsers(User[] users){
		this.users = users;
	}
}