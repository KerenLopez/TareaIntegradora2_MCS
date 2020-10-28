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

	public String showUsers(){
		String message="";
		for(int k=0;k<users.length;k++){
			if(users[k]!=null){
				message +="\n*************  Usuario **************"+"\n**  Nombre: "+users[k].getUserName()+"\n**  Edad: "+users[k].getAge()+"\n**  Categoria: "+users[k].getUserCategory()+"\n*************************************\n"; 
			}
		} return message;
	}

	public String addPoolSongs(String title, String artist, String date, int[] minutes, int[] seconds, int genre){
		String message = "";
		boolean stop = true;
		for(int k=0;k<songsPool.length && stop;k++){
			if(songsPool[k]==null){
				stop = false;
				songsPool[k]= new Song(title,artist,date,minutes,seconds,genre);
				message = "La cancion ha sido agregada exitosamente al pool de canciones";
			}
		} return message;
	}

	public String showSongsInPool(){
		String message = "";
		for(int k=0;k<songsPool.length;k++){
			if(songsPool[k]!=null){
				message +="\n************* Cancion **************"+"\n**  Titulo: "+songsPool[k].getTitle()+"\n**  Artista o banda: "+songsPool[k].getArtistName()+"\n**  Duracion: "+songsPool[k].getMinutes()[k]+":"+songsPool[k].getSeconds()[k]+"\n**  Genero: "+songsPool[k].getGenre()+"\n***********************************"; 
			}
		} return message;
	}

	public User findUser(String nameUser){
		User objUser;
		boolean find =false;
		for(int k=0;k<users.length && !find;k++){
			if(users[k]!=null && users[k].getUserName().equalsIgnoreCase(nameUser)){
				find=true;
				objUser = users[k];
				users[k].setNumSongsAddToPool(getNumSongsAddToPool()+1);	
			}
		} return objUser;
	}

	public PlayList findPlaylist(String namePlaylist){
		PlayList objPlaylist;
		boolean find =false;
		for(int k=0;k<playlists.length && !find;k++){
			if(playlists[k]!=null && playlists[k].getName().equalsIgnoreCase(namePlaylist)){
				find=true;
				objPlaylist = playlists[k];
			}
		}
		return objPlaylist;
	}

	public void addPlaylist(String nameUser, String namePlaylist){
		User objUser = findUser(nameUser); 
		PlayList objPlaylist = findPlaylist(namePlaylist);

	}


	public void addPlaylist(String nameUser, String namePlaylist, String authorizedUser){
		User objUser = findUser(nameUser); 
		User objUserAuthorized = findUser(nameUser); 
		PlayList objPlaylist = findPlaylist(namePlaylist);
	}

	public void addPlaylist(String nameUser, String namePlaylist, String[] nameUsersPlaylistR){
		User objUser = findUser(nameUser); 
		PlayList objPlaylist = findPlaylist(namePlaylist);
	}

	public boolean findSongInPool(String title, String artist){
		boolean find =false;
		for(int k=0;k<songsPool.length && !find;k++){
			if(songsPool[k]!=null && songsPool[k].getTitle().equalsIgnoreCase(title) && songsPool[k].getArtistName().equalsIgnoreCase(artist)){
				find=true;
			}
		}
		return find;
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