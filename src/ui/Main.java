package ui;
import model.MCS;
import java.util.Scanner;

public class Main{

	//Global variable
	public Scanner lector;

	//Relationship
	private MCS mainMCS;

	/**
	* Builder method <br>
	* <b>name</b>: Main <br>
	* <b>post</b>: The relationship and the global variable were inicializated. <br>
	*/

	public Main(){
		lector = new Scanner(System.in);
		mainMCS = new MCS();
	}	

	public static void main(String[] args){

		System.out.println(
			"\n************************************************************************************************************************\n"+   
			"                                      Bienvenido a la aplicacion Music Collect & Share"+
			"\n************************************************************************************************************************\n"+   
			"                                     (((((((((((((((((((((((((((((((((((((((((((((((((\n"+
			"                                     ((((((((((((((((/((((((((((((((((((((((((((((((((\n"+
			"                                     (((/  .(((((((*  .((((((*        (((((/      /(((\n"+
			"                                     (((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"+
			"                                     (((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"+
			"                                     (((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"+
			"                                     (((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"+
			"                                     (((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"+
			"                                     (((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"+
			"                                     (((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"+
			"                                     (((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"+
			"                                     (((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"+
			"                                     (((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"+
			"                                     (((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"+
			"                                     (((/  .((((((((.  *((((((.        *((   .   .((((\n"+
			"                                     (((((((((((((((/*/((((((((((///(((((((////(((((((\n"+
			"                                     (((((((((((((((((((((((((((((((((((((((((((((((((\n"+
            "                                                     ./(###((///((###(*\n"+                
			"                                                 *#(,                   *((,\n"+           
			"                                              ,#/                           ((\n"+         
			"                                            .#*          .**/////*,.          ((\n"+       
			"                                           *(.      .//////////////////*       *#\n"+      
			"                                          .#,     *///////////////////////,     /(\n"+     
			"                                          /(    *///////////////////////////    .#.\n"+    
			"                                        ,/////,*/////////////////////////////,*////*.\n"+  
			"                                        /////////////////////////*,...,/////////////,\n"+  
			"                                        //////*,,,********,,.............,,,,,//////,\n"+  
			"                                        //////*.........//*........//*.......,//////,\n"+  
			"                                        //////*.........,,.........,,........,//////,\n"+  
			"                                        //////*..............................,//////,\n"+  
			"                                         *///*  ........,/.........**.......  .*///,\n"+   
			"                                                  .......,/*.....,/*.......\n"+            
			"                                                     ........,,,,.......\n"+               
			"                                                           .........\n"                    
		);
		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!= 9);
	}

	/**
	* This method displays a menu and appeals to other methods depending on the option chosen by the user. <br>
	* <b>name</b>: menu.<br>
 	* <b>post</b>: the option that the user chose was returned. <br>
 	* @return integer <code> option </code> that is a variable with a number that the user selected.
	*/

	public int menu(){
		int option = 0;
		boolean menu = true;
		while(menu){
			System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                               Seleccione una opcion para continuar"+
				"\n************************************************************************************************************************\n"+
				"      1. Registrar un nuevo usuario\n"+
				"      2. Conocer la lista de usuarios registrados\n"+
				"      3. Agregar una cancion al Pool de canciones\n"+
				"      4. Conocer la lista de canciones que han sido agregadas al Pool\n"+
				"      5. Crear una playlist\n"+
				"      6. Agregar una cancion a una playlist\n"+
				"      7. Conocer todas las playlists que han sido creadas\n"+
				"      8. Calificar una playlist publica\n"+
				"      9. Finalizar la aplicacion\n"
			);
			option = lector.nextInt(); lector.nextLine();
			switch(option){
				case 1:
					if(mainMCS.getUsers()[(MCS.MAX_NUM_USERS)-1]==null){
						addUser();
					} else {
						System.out.println("\n************************************************************************************************************************"+"\nYa se han registrado la maxima cantidad de usuarios posibles, no puede agregar otro");
					}	
					menu = false;
					break;
				case 2:
					displayUsers();
					menu = false;
					break;
				case 3:
					if(mainMCS.getSongsPool()[(MCS.MAX_NUM_SONGS)-1]==null){
						addSongToPool();
					} else{
						System.out.println("\n************************************************************************************************************************"+"\nYa ha ingresado la maxima cantidad de canciones posibles, no puede agregar otra");
					}
					menu = false;
					break;	
				case 4:
					displayPoolSongs();
					menu = false;
					break;		
				case 5:
					if(mainMCS.getPlaylists()[(MCS.MAX_NUM_PLAYLISTS)-1]==null){
						createPlaylist();
					} else{
						System.out.println("\n************************************************************************************************************************"+"\nYa ha creado la maxima cantidad de playlists posibles, no puede agregar otra");
					}
					menu = false;
					break;	
				case 6:	
					addSongToPlaylist();
					menu = false;
					break;
				case 7:	
					displayPlaylists();
					menu = false;
					break;
				case 8:	
					ratePlaylist();
					menu = false;
					break;
				case 9:	
					System.out.println("\n************************************************************************************************************************\n"+"Gracias por utilizar nuestra aplicacion"+"\n************************************************************************************************************************\n");
					menu = false;
					break;				
				default:
					System.out.println("\n************************************************************************************************************************\n"+"Error, opcion no valida");
					menu = false;
					break;	    	
			} 	
		} return option;
    }

    /**
	* This method asks for all the features of an user to create a new one. <br>
	* <b>name</b>: addUser.<br>
 	* <b>post</b>: All the information that is necessary to create a new user was asked. <br>
	*/

	public void addUser(){
		String name = "", password, message;
		int age;
		boolean correct;
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                         Crear un usuario"+
			"\n************************************************************************************************************************"
		);
		do{
			do{
				correct = true;
				System.out.println("\nIngrese un nombre o apodo, recuerde que no debe contener ningun espacio en blanco: ");
				name = lector.nextLine();
				for(int k=0;k<name.length()&&correct;k++){
					if(name.charAt(k)==' '){
						correct = false;
					} 				
				}
				if(!correct){
					System.out.println("\nEl nombre de usuario ingresado contiene un espacio en blanco, digitelo nuevamente");
				}
			} while(!correct);
			System.out.println("\nIngrese una contrasenia: ");
			password = lector.nextLine();
			System.out.println("\nIngrese su edad: ");
			age = lector.nextInt();lector.nextLine();
			message = mainMCS.createUser(name, password, age);
			System.out.println(message);
			if(message.equals("\nEl usuario ya se encuentra registrado, intentelo nuevamente")){
				System.out.println("\n***********************************************************************************************************************\n");
			}
		} while(message.equals("\nEl usuario ya se encuentra registrado, intentelo nuevamente"));
	}

	/**
	* This method shows the users that are register in the MCS. <br>
	* <b>name</b>: displayUsers.<br>
 	* <b>post</b>: All the users of the MCS were displayed. <br>
	*/

	public void displayUsers(){
		String message = mainMCS.showUsers();
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                               Lista de usuarios registrados"+
			"\n************************************************************************************************************************\n"
		);
		System.out.println(message);
	}

	/**
	* This method asks for all the features that a song has to include it in the pool. <br>
	* <b>name</b>: addSongToPool.<br>
 	* <b>post</b>: All the information that is necessary to add a new song was asked. <br>
	*/

	public void addSongToPool(){
		String title, artist, date, message, nameUser;
		int minutes, seconds, genre = 0;
		do{ 
			System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                            Agregar una cancion al Pool de canciones"+
			"\n************************************************************************************************************************"
		    );
			System.out.println("\nIngrese su nombre de usuario: ");
			nameUser = lector.nextLine();
			System.out.println("\nIngrese el titulo de la cancion que desea agregar: ");
			title = lector.nextLine();
			System.out.println("\nIngrese el nombre del artista o banda al que pertenece la cancion: ");
			artist = lector.nextLine();
			System.out.println("\nIngrese la fecha de lanzamiento de la cancion (DD/MM/AAAA): ");
			date = lector.nextLine();
			System.out.println("\nIngrese los minutos que dura la cancion: ");
			minutes = lector.nextInt();	
			System.out.println("\nIngrese los segundos que dura la cancion: ");
			seconds = lector.nextInt();
			do{
				System.out.println(
					"\nSeleccione el genero de la cancion: "+
					"\n    1. Rock"+
					"\n    2. Hip hop"+
					"\n    3. Musica clasica"+
					"\n    4. Reggae"+
					"\n    5. Salsa"+
					"\n    6. Metal\n"
				);
				genre = lector.nextInt();lector.nextLine();
				if(genre!=1 && genre!=2 && genre!=3 && genre!=4 && genre!=5 && genre!=6){
					System.out.println("\nIngrese una opcion correcta");
				}
			} while(genre!=1 && genre!=2 && genre!=3 && genre!=4 && genre!=5 && genre!=6);
			message = mainMCS.addSongsToPool(nameUser,title, artist, date, minutes, seconds, genre);
			System.out.println(message);
			if(!message.equals("\nLa cancion ha sido agregada exitosamente al pool de canciones")){
				System.out.println("\n***********************************************************************************************************************\n");
			}	
		} while(!message.equals("\nLa cancion ha sido agregada exitosamente al pool de canciones"));		
	}

	/**
	* This method shows the songs that were added in the pool. <br>
	* <b>name</b>: displayPoolSongs.<br>
 	* <b>post</b>: All the songs of the pool were shown. <br>
	*/

	public void displayPoolSongs(){
		String message = mainMCS.showSongsInPool();
		System.out.println(
			"\n***********************************************************************************************************************\n"+
			"                                    Lista de canciones compartidas en el Pool de canciones"+
			"\n***********************************************************************************************************************"+
			message
		);
	}

	/**
	* This method asks for all the features of a playlist depending on its type to create a new one. <br>
	* <b>name</b>: createPlaylist.<br>
 	* <b>post</b>: All the information that is necessary to create a playlist was asked. <br>
	*/

	public void createPlaylist(){
		int option, numAddUsers;
		String nameUser, namePlaylist, message;
		String[] nameUsersPlaylistR = new String[5];
		do{
			do{
				System.out.println(
					"\n***********************************************************************************************************************\n"+
					"                                                        Crear una Playlist"+
					"\n***********************************************************************************************************************"+
					"\nSeleccione el tipo de playlist que desea crear: "+
					"\n    1. Publica"+
					"\n    2. Privada"+
					"\n    3. Restringida"
				);
				option = lector.nextInt();lector.nextLine();
				if(option!=1 && option!=2 && option!=3){
					System.out.println("Ingrese una opción correcta");
				}
			} while(option!=1 && option!=2 && option!=3);	
			if(option==1 || option==2){
				System.out.println("\nIngrese su nombre de usuario: ");
				nameUser = lector.nextLine();
				System.out.println("\nIngrese el nombre que le va a dar a su nueva playlist: ");
				namePlaylist = lector.nextLine();	
				message = mainMCS.addPlaylist(namePlaylist,nameUser,option);
				System.out.println(message);
				if(option==2 && message.equals("\nLa playlist fue creada exitosamente")){
					System.out.println("\nRecuerde que usted sera el unico que tendra acceso a esta playlist");
				} else{
					System.out.println("\n***********************************************************************************************************************\n");
				}	
			} else{	
				System.out.println("\nIngrese su nombre de usuario: ");
				nameUsersPlaylistR[0] = lector.nextLine();
				do{
					System.out.println("\nIngrese el numero de usuarios que va a registrar para que tengan acceso a su playlist, recuerde que tiene permitido solamente 4: ");
					numAddUsers = lector.nextInt();lector.nextLine();
				}while(numAddUsers!=1 && numAddUsers!=2 && numAddUsers!=3 && numAddUsers!=4);					
				for(int k=1;k<numAddUsers+1;k++){
					System.out.println("\nIngrese el nombre del usuario #"+(k+1)+" que va a tener acceso a esta playlist: ");
					nameUsersPlaylistR[k] = lector.nextLine();
				}
				System.out.println("\nIngrese el nombre que le va a dar a su nueva playlist: ");
				namePlaylist = lector.nextLine();
				message = mainMCS.addPlaylist(namePlaylist,nameUsersPlaylistR,numAddUsers);
				System.out.println(message);
				if(message.equals("\nLa playlist fue creada exitosamente")){
					System.out.println("\nRecuerde que usted y las personas que ingreso seran las unicas con acceso a esta playlist");
				}else{
					System.out.println("\n***********************************************************************************************************************\n");
				}
			}	
		} while(!message.equals("\nLa playlist fue creada exitosamente"));	
	}

	/**
	* This method asks to the user everything needed to add a song of the pool in a playlist. <br>
	* <b>name</b>: addSongToPlaylist.<br>
 	* <b>post</b>: the user typed all that is necessary to add a song of the pool in a playlist. <br>
	*/

	public void addSongToPlaylist(){
		String nameUser, namePlaylist, nameSong, artistSong, message;
		System.out.println(
			"\n***********************************************************************************************************************\n"+
			"                                             Agregar una cancion a una Playlist"+
			"\n***********************************************************************************************************************"
		);
		System.out.println("\nIngrese su nombre de usuario: ");
		nameUser = lector.nextLine();
		System.out.println("\nIngrese el nombre de la playlist a la que desea agregar una cancion: ");
		namePlaylist = lector.nextLine();
		System.out.println("\nIngrese el titulo de la cancion que desea agregar: ");
		nameSong = lector.nextLine();
		System.out.println("\nIngrese el artista al que pertenece la cancion que desea agregar: ");
		artistSong = lector.nextLine();
		message = mainMCS.addSongToPlaylist(nameUser, namePlaylist, nameSong, artistSong);
		System.out.println(message);
	}

	/**
	* This method shows the playlists that were created in the MCS. <br>
	* <b>name</b>: displayPlaylists.<br>
 	* <b>post</b>: All the playlists were shown. <br>
	*/

	public void displayPlaylists(){
		String message = mainMCS.showPlaylists();
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                  Lista de playlists creadas"+
			"\n************************************************************************************************************************"+
			message
		);
	}

	/**
	* This method asks to the user what grade wants to give to a public playlist. <br>
	* <b>name</b>: ratePlaylist.<br>
 	* <b>post</b>: The grade of a public playlist was asked. <br>
	*/

	public void ratePlaylist(){
		String nameUser, namePlaylist, message;
		int grade;
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                Calificar una playlist publica"+
			"\n************************************************************************************************************************"
		);
		System.out.println("\nIngrese su nombre de usuario: ");
		nameUser = lector.nextLine();
		System.out.println("\nIngrese el nombre de la playlist publica a la que desea calificar: ");
		namePlaylist = lector.nextLine();
		do{
			System.out.println("\nElija un numero entre 1 y 5 para calificar la playlist (Recuerde que 1 es la nota mas baja y 5 la nota mas alta): ");
			grade = lector.nextInt(); lector.nextLine();
			if(grade!=1 && grade!=2 && grade!=3 && grade!=4 && grade!=5){
				System.out.println("\nIngrese una opcion correcta");
			}
		}while(grade!=1 && grade!=2 && grade!=3 && grade!=4 && grade!=5);
		message = mainMCS.ratePublicPlaylists(nameUser, namePlaylist, grade);
		System.out.println(message);
	}
}