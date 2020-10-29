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

	public MCS(){
		playlists = new PlayList[MAX_NUM_PLAYLISTS];
		songsPool = new Song[MAX_NUM_SONGS];
		users = new User[MAX_NUM_USERS];
	}

	public String createUser(String userName, String password, int age){
		String message = "";
		boolean stop = true;
		for(int k=0;k<users.length && stop;k++){
			if(users[k]==null){
				stop = false;
				users[k]= new User(userName,password,age);
				message = "El usuario ha sido registrado exitosamente";
			}
		} return message;
	}

	public boolean verifyUser(String userName){
		boolean find =false;
		for(int k=0;k<users.length && !find;k++){
			if(users[k]!=null && users[k].getUserName().equalsIgnoreCase(userName)){
				find=true;
			}
		}
		return find;
	}

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

	public String showUsers(){
		String message="";
		for(int k=0;k<users.length;k++){
			if(users[k]!=null){
				message +="\n                     *************  Usuario **************"+
				"\n                      **  Nombre: "+users[k].getUserName()+
				"\n                      **  Edad: "+users[k].getAge()+
				"\n                      **  Categoria: "+users[k].getUserCategory()+
				"\n                      *************************************\n"; 
			}
		} return message;
	}

	public String addSongsToPool(String nameUser, String title, String artist, String date, int[] minutes, int[] seconds, int genre){
		Song objSong = findSongInPool(title, artist);
		User objUser = findUser(nameUser);
		String message = "La cancion ha sido agregada exitosamente al pool de canciones";
		boolean stop = true;
		if(objSong==null){
			for(int k=0;k<songsPool.length && stop;k++){
				if(songsPool[k]==null){
					stop = false;
					songsPool[k]= new Song(title,artist,date,minutes,seconds,genre);
					objUser.numSongsPool();
				}
			}	
		} else{
			message = "La cancion ya se encuentra registrada, intentelo nuevamente";
		}
		return message;
	}

	public String showSongsInPool(){
		String message = "";
		for(int k=0;k<songsPool.length;k++){
			if(songsPool[k]!=null){
				message +="\n                     ************* Cancion **************"+
				"\n                     **  Titulo: "+songsPool[k].getTitle()+
				"\n                     **  Artista o banda: "+songsPool[k].getArtistName()+
				"\n                     **  Duracion: "+songsPool[k].getMinutes()[k]+":"+songsPool[k].getSeconds()[k]+
				"\n                     **  Genero: "+songsPool[k].getGenre()+"\n***********************************"; 
			}
		} return message;
	}

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

	public String addPlaylist(String namePlaylist){
		boolean stop = false; 
		PlayList objPlaylist = findPlaylist(namePlaylist);
		String message = "";
		int[] minutes = new int[MAX_NUM_SONGS];
		int[] seconds = new int[MAX_NUM_SONGS];
		for(int i = 0;i<MAX_NUM_SONGS;i++) {
			minutes[i]= 0;
			seconds[i]= 0;
		}
		if(objPlaylist==null){
			for(int k=0;k<playlists.length && !stop;k++){
				if(playlists[k]==null){
					stop = true;
					playlists[k]= new PublicPL(namePlaylist, minutes, seconds);
					message = "La playlist fue creada exitosamente";	
				}
			}
		} else{
			message = "La playlist ya se encuentra registrada, intentelo nuevamente";
		} 
		return message;
	}

	public String addPlaylist(String namePlaylist, String nameUser, String authorizedUser){
		boolean stop = false;
		User objUser = findUser(nameUser); 
		User objAuthorizedUser = findUser(authorizedUser); 
		PlayList objPlaylist = findPlaylist(namePlaylist);
		String message = "";
		int[] minutes = new int[MAX_NUM_SONGS];
		int[] seconds = new int[MAX_NUM_SONGS];
		for(int i = 0;i<MAX_NUM_SONGS;i++) {
			minutes[i]= 0;
			seconds[i]= 0;
		}
		if(objPlaylist==null){
			for(int k=0;k<playlists.length && !stop;k++){
				if(playlists[k]==null){
					stop = true;
					playlists[k]= new PrivatePL(namePlaylist, minutes, seconds, objUser, objAuthorizedUser);
					message = "La playlist fue agregada exitosamente";	
				}
			}
		} else{
			message = "La playlist ya se encuentra registrada, intentelo nuevamente";
		}
		return message;
	}

	public String addPlaylist(String namePlaylist, String[] nameUsersPlaylistR){
		boolean stop = false;
		User[] objAuthorizedUsers = new User[RestrictedPL.MAX_NUM_USERS]; 
		PlayList objPlaylist = findPlaylist(namePlaylist);
		String message = "";
		int[] minutes = new int[MAX_NUM_SONGS];
		int[] seconds = new int[MAX_NUM_SONGS];
		for(int i = 0;i<MAX_NUM_SONGS;i++) {
			minutes[i]= 0;
			seconds[i]= 0;
		}
		for(int j=0;j<nameUsersPlaylistR.length;j++){
			objAuthorizedUsers[j] = findUser(nameUsersPlaylistR[j]);
		}
		if(objPlaylist==null){
			for(int k=0;k<playlists.length && !stop;k++){
				if(playlists[k]==null){
					stop = true;
					playlists[k]= new RestrictedPL(namePlaylist, minutes, seconds, objAuthorizedUsers);	
					message = "La playlist fue agregada exitosamente";
				}
			}
		} else{
			message = "La playlist ya se encuentra registrada, intentelo nuevamente";
		}
		return message;
	}

	public String addSongToPlaylist(String nameUser, String namePlaylist, String nameSong, String artistSong){
		String message = "";
		User objUser = findUser(nameUser);
		PlayList objPlaylist = findPlaylist(namePlaylist);
		Song objSong = findSongInPool(nameSong, artistSong);
		if(objPlaylist!=null){
			message = "La playlist no se encuentra registrada, intentelo nuevamente";
		} else if(objSong!=null){
			message = "La cancion no se encuentra registrada en el Pool, intentelo nuevamente";
		} else{
			objPlaylist.addSongToPlaylist(objUser, objSong);
		} return message;
	}

	//Getters & Setters

	public PlayList[] getPlaylists(){
		return playlists;
	}

	public void setPlaylists(PlayList[] playlists){
		this.playlists = playlists;
	}

	public Song[] getSongsPool(){
		return songsPool;
	}

	public void setSongsPool(Song[] songs){
		this.songsPool = songsPool;
	}

	public User[] getUsers(){
		return users;
	}

	public void setUsers(User[] users){
		this.users = users;
	}
}