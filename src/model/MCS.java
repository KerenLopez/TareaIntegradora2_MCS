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

	//Getters and Setters 

	/**
	* This method returns the information of the playlists in the manager as a list of PlayList objects. <br>
	* <b>name</b>: getPlaylists <br>
	* @return PlayList <code> playlists[] </code> that is a list with all the playlists that were created by a user.
	*/

	public PlayList[] getPlaylists(){
		return playlists;
	}

	/**
	* this method modifies the information of the playlists. <br>
	* <b>name</b>: setPlaylists <br>
	* <b>post</b>: the information of the playlists has been changed. <br>
	* @param playlists is a list of PlayList objects.
	*/

	public void setPlaylists(PlayList[] playlists){
		this.playlists = playlists;
	}

	/**
	* This method returns the information of the songs in the manager as a list of Song objects. <br>
	* <b>name</b>: getSongsPool <br>
	* @return Song <code> songsPool[] </code> that is a list with all the songs that were added to the pool.
	*/

	public Song[] getSongsPool(){
		return songsPool;
	}

	/**
	* this method modifies the information of the songs. <br>
	* <b>name</b>: setSongsPool <br>
	* <b>post</b>: the information of the songs has been changed. <br>
	* @param songsPool is a list of Song objects.
	*/

	public void setSongsPool(Song[] songsPool){
		this.songsPool = songsPool;
	}

	/**
	* This method returns the information of the users in the manager as a list of User objects. <br>
	* <b>name</b>: getUsers <br>
	* @return User <code> users[] </code> that is a list with all the users that were registered in the MCS.
	*/

	public User[] getUsers(){
		return users;
	}

	/**
	* this method modifies the information of the users. <br>
	* <b>name</b>: setUsers <br>
	* <b>post</b>: the information of the users has been changed. <br>
	* @param users is a list of User objects.
	*/

	public void setUsers(User[] users){
		this.users = users;
	}

	//Methods

	/**
	* Builder method <br>
	* <b>name</b>: MCS <br>
	* <b>post</b>: The relationships like the lists of playlists, songsPool and users were inicializated. <br>
	*/

	public MCS(){
		playlists = new PlayList[MAX_NUM_PLAYLISTS];
		songsPool = new Song[MAX_NUM_SONGS];
		users = new User[MAX_NUM_USERS];
	}

	/**
	* This method looks for the name of a user in the list of registered users, and returns an object of type User. <br>
	* <b>name</b>: findUser.<br>
	* <b>pre</b>: the variable nameUser is already inicializated. <br>
 	* <b>post</b>: An object of type User was returned. <br>
 	* @param nameUser is a String variable that contains the name of the user. 
 	* @return User <code> objUser </code> that is an object that could be null or full.
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
	* This method creates a new user with its features, and adds it to the list of users. <br>
	* <b>name</b>: createUser.<br>
	* <b>pre</b>: the variables userName, password, and age are already inicializated. <br>
 	* <b>post</b>: the user was created successfully or the user couldn't be created. <br>
 	* @param userName is a String variable that contains the name of the user. 
 	* @param password is a String variable that contains the password of the user.
 	* @param age is an integer variable that contains the age of the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
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
	* This method displays the information of all the users that were registered in the MCS. <br>
	* <b>name</b>: showUsers.<br>
 	* <b>post</b>: the information of each user was saved in a String variable that is going to be shown in the Main class. <br>
 	* @return String <code> message </code> that is a variable with the information of all the users that were registered in the MCS.
	*/

	public String showUsers(){
		String message="";
		int numNullUsers = 0;
		for(int k=0;k<users.length;k++){
			if(users[k]==null){
				numNullUsers +=1;
			}
			if(users[k]!=null){
				message +="\n                                          *************  Usuario **************"+
				"\n                                            **  Nombre: "+users[k].getUserName()+
				"\n                                            **  Edad: "+users[k].getAge()+
				"\n                                            **  Categoria: "+users[k].getUserCategory()+
				"\n                                          *************************************\n"; 
			}
		} 
		if(numNullUsers==MAX_NUM_USERS){
			message = "                                           No se ha registrado un usuario todavia";
		} return message;
	}

	/**
	* This method looks for a specific song in the list of songsPool, and returns an object of type Song. <br>
	* <b>name</b>: findSongInPool.<br>
	* <b>pre</b>: the variables title and artist are already inicializated. <br>
 	* <b>post</b>: An object of type Song was returned. <br>
 	* @param title is a String variable that contains the name of a song. 
 	* @param artist is a String variable that contains the artist's name of a song.
 	* @return Song <code> objSong </code> that is an object that could be null or full.
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
	* This method adds a new song with all its features and includes it to the pool of songs. <br>
	* <b>name</b>: addSongsToPool.<br>
	* <b>pre</b>: the variables such as nameUser, title, artist, date, minutes, seconds, and genre are already inicializated. <br>
 	* <b>post</b>: the song was added successfully or the song couldn't be incorporated to the pool of songs. <br>
 	* @param nameUser is a String variable that contains the name of a user. 
 	* @param title is a String variable that contains the name of a song.
 	* @param artist is a String variable that contains the artist's name of a song.
 	* @param date is a String variable that contains the release date of a song.
 	* @param minutes is an integer variable that contains the minutes that a song lasts.
 	* @param seconds is an integer variable that contains the seconds that a song lasts.
 	* @param genre is an integer variable that represents the type of genre that a song belongs to.
 	* @return String <code> message </code> that is a variable with a notice for the user.
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
	* This method displays the information of all the songs that were added to the pool of songs. <br>
	* <b>name</b>: showSongsInPool.<br>
 	* <b>post</b>: the information of each song of the pool was saved in a String variable that is going to be shown in the Main class. <br>
 	* @return String <code> message </code> that is a variable with the information of all the songs that were added to the pool.
	*/
	
	public String showSongsInPool(){
		String message = "";
		int numNullSongs = 0;
		for(int k=0;k<songsPool.length;k++){
			if(songsPool[k]==null){
				numNullSongs+=1;
			}
			if(songsPool[k]!=null){
				message +="\n                                          ************* Cancion **************"+
				"\n                                          **  Titulo: "+songsPool[k].getTitle()+
				"\n                                          **  Artista o banda: "+songsPool[k].getArtistName()+
				"\n                                          **  Duracion: "+songsPool[k].getMinutes()+":"+songsPool[k].getSeconds()+
				"\n                                          **  Genero: "+songsPool[k].getGenre()+
				"\n                                          ************************************"; 
			}
		} 
		if(numNullSongs==MAX_NUM_SONGS){
			message = "\n\n                                           Todavia no se han agregado canciones al Pool";
		}return message;
	}
	
	/**
	*  This method looks for a especific playlist in the list of playlists, and returns an object of type PlayList. <br>
	* <b>name</b>: findPlaylist.<br>
	* <b>pre</b>: the variable namePlaylist is already inicializated. <br>
 	* <b>post</b>: An object of type PlayList was returned. <br>
 	* @param namePlaylist is a String variable that contains the name of a playlist. 
 	* @return PlayList <code> objPlaylist </code> that is an object that could be null or full.
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
	* This method adds a new playlist with all its features and includes it to the list of playlists. <br>
	* <b>name</b>: addPlaylist.<br>
	* <b>pre</b>: the variables namePlaylist, nameUser, and option are already inicializated. <br>
 	* <b>post</b>: the playlist was added successfully or the playlist couldn't be incorporated to the list of playlists. <br>
 	* @param namePlaylist is a String variable that contains the name of the playlist.
 	* @param nameUser is a String variable that contains the name of a user.
 	* @param option is an integer variable that represents the type of playlist that the user wants to create.    
 	* @return String <code> message </code> that is a variable with a notice for the user.
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
	* This method adds a new playlist with all its features and includes it to the list of playlists. <br>
	* <b>name</b>: addPlaylist.<br>
	* <b>pre</b>: the list nameUserPlaylistR and the variables like namePlaylist or option are already inicializated. <br>
 	* <b>post</b>: the playlist was added successfully or the playlist couldn't be incorporated to the list of playlists. <br>
 	* @param namePlaylist is a String variable that contains the name of a playlist.
 	* @param nameUsersPlaylistR is a list of Strings that contains the names of all the users that are going to have access to the playlist.
 	* @param numAddUsers is an integer variable that represents the number of users that are going to have access to the playlist.    
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String addPlaylist(String namePlaylist, String[] nameUsersPlaylistR, int numAddUsers){
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
		if(objPlaylist==null && numRegisteredUsers==(numAddUsers+1)){
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
	* This method adds a song of the pool in a specific playlist. <br>
	* <b>name</b>: addSongToPlaylist.<br>
	* <b>pre</b>: the variables nameUser, namePlaylist, nameSong and artistSong are already inicializated. <br>
 	* <b>post</b>: the song of the pool was added successfully or the song of the pool couldn't be incorporated to the playlist. <br>
 	* @param nameUser is a String variable that contains the name of a user.
 	* @param namePlaylist is a String variable that contains the name of a playlist.
 	* @param nameSong is a String variable that contains the name of a song.
 	* @param artistSong is a String variable that contains the artist's name of a song.
 	* @return String <code> message </code> that is a variable with a notice for the user.
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

	/**
	* This method displays the information of all the playlists that were created by the user. <br>
	* <b>name</b>: showPlaylists.<br>
 	* <b>post</b>: the information of each song of each playlist was saved in a String variable that is going to be shown in the Main class. <br>
 	* @return String <code> message </code> that is a variable with all the information of the playlists that were added by a user.
	*/

	public String showPlaylists(){
		String message = "";
		int numNullPlaylists = 0;
		for(int k=0;k<playlists.length;k++){
			if(playlists[k]==null){
				numNullPlaylists+=1;
			}
			if(playlists[k]!=null){
				message += playlists[k].toString();
			}
		} 
		if(numNullPlaylists==MAX_NUM_PLAYLISTS){
			message = "\n                                                No se han creado playlists aun";
		} return message;
	}

	/**
	* This method adds a score given by the user to rate a public playlist. <br>
	* <b>name</b>: ratePublicPlaylists.<br>
	* <b>pre</b>: the variables nameUser, namePlaylist, and grade are already inicializated. <br>
 	* <b>post</b>: the public playlist was rated successfully or the public playlist couldn't be rated. <br>
 	* @param nameUser is a String variable that contains the name of a user.
 	* @param namePlaylist is a String variable that contains the name of a public playlist.
 	* @param grade is an integer variable that represents the score that a user wants to give to a public playlist.    
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String ratePublicPlaylists(String nameUser, String namePlaylist, int grade){
		String message =  "";
		User objUser = findUser(nameUser);
		PlayList objPlaylist = findPlaylist(namePlaylist);
		if(objPlaylist!=null && objUser!=null){
			if(objPlaylist instanceof PublicPL){
				message = ((PublicPL)objPlaylist).ratePlaylist(grade);
			} else{
				message += "\nLa playlist no es de tipo publica, intentelo nuevamente";
			}
		} else{
			if(objUser==null){
				message += "\nEl usuario ingresado no se encuentra registrado, intentelo nuevamente";
			}
			if(objPlaylist==null){
				message += "\nLa playlist no existe, intentelo nuevamente";
			}	
		} return message;
	}
}