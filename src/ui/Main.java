package ui;
import model.*;
import java.util.Scanner;

public class Main{

	public Scanner lector;

	//Atributes
	private MCS mainMCS;

	//Builder Method
	public Main(){
		lector = new Scanner(System.in);
		mainMCS = new MCS();
	}
	//End Builder	

	public static void main(String[] args){

		System.out.println(
			"\n**********************************************************************************\n"+   
			"                  Bienvenido a la aplicacion Music Collect & Share"+
			"\n**********************************************************************************\n"+   
			"                (((((((((((((((((((((((((((((((((((((((((((((((((\n"+
			"                ((((((((((((((((/((((((((((((((((((((((((((((((((\n"+
			"                (((/  .(((((((*  .((((((*        (((((/      /(((\n"+
			"                (((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"+
			"                (((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"+
			"                (((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"+
			"                (((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"+
			"                (((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"+
			"                (((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"+
			"                (((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"+
			"                (((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"+
			"                (((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"+
			"                (((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"+
			"                (((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"+
			"                (((/  .((((((((.  *((((((.        *((   .   .((((\n"+
			"                (((((((((((((((/*/((((((((((///(((((((////(((((((\n"+
			"                (((((((((((((((((((((((((((((((((((((((((((((((((\n"+
            "                                ./(###((///((###(*\n"+                
			"                            *#(,                   *((,\n"+           
			"                         ,#/                           ((\n"+         
			"                       .#*          .**/////*,.          ((\n"+       
			"                      *(.      .//////////////////*       *#\n"+      
			"                     .#,     *///////////////////////,     /(\n"+     
			"                     /(    *///////////////////////////    .#.\n"+    
			"                   ,/////,*/////////////////////////////,*////*.\n"+  
			"                   /////////////////////////*,...,/////////////,\n"+  
			"                   //////*,,,********,,.............,,,,,//////,\n"+  
			"                   //////*.........//*........//*.......,//////,\n"+  
			"                   //////*.........,,.........,,........,//////,\n"+  
			"                   //////*..............................,//////,\n"+  
			"                    *///*  ........,/.........**.......  .*///,\n"+   
			"                            .......,/*.....,/*.......\n"+            
			"                               ........,,,,.......\n"+               
			"                                     .........\n"                    
		);
		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!= 9);
	}

	public int menu(){
		int option = 0;
		boolean menu = true;
		while(menu){
			System.out.println(
				"\n**********************************************************************************\n"+
				"                         Seleccione una opcion para continuar"+
				"\n**********************************************************************************\n"+
				"      1. Registrar un nuevo usuario\n"+
				"      2. Conocer la lista de usuarios registrados\n"+
				"      3. Agregar una cancion al Pool de canciones\n"+
				"      4. Conocer la lista de canciones que han sido agregadas al Pool\n"+
				"      5. Crear una playlist\n"+
				"      6. Agregar una cancion a una playlist\n"+
				"      7. Conocer la lista de playlists creadas\n"+
				"      8. Calificar una playlist publica\n"+
				"      9. Finalizar la aplicacion\n"
			);
			option = lector.nextInt(); lector.nextLine();
			switch(option){
				case 1:
					if(mainMCS.getUsers()[(MCS.MAX_NUM_USERS)-1]==null){
						addUser();
					} else {
						System.out.println("\n**********************************************************************************"+"\nYa se han registrado la maxima cantidad de usuarios posibles, no puede agregar otra");
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
						System.out.println("\n**********************************************************************************"+"\nYa ha ingresado la maxima cantidad de canciones posibles, no puede agregar otra");
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
						System.out.println("\nYa ha creado la maxima cantidad de playlists posibles, no puede agregar otra");
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
					ratePublicPlaylists();
					menu = false;
					break;
				case 9:	
					System.out.println("\n**********************************************************************************\n"+"Gracias por utilizar nuestra aplicacion"+"\n**********************************************************************************\n");
					menu = false;
					break;				
				default:
					System.out.println("\n**********************************************************************************\n"+"Error, opcion no valida");
					menu = false;
					break;	    	
			} 	
		} return option;
    }

	public void addUser(){
		String name = "", password, message;
		int age;
		boolean correct, exist = true;
		System.out.println(
			"\n**********************************************************************************\n"+
			"                                    Crear un usuario"+
			"\n**********************************************************************************\n"
		);
		do{
			do{
				correct = true;
				System.out.println("Ingrese un nombre o apodo, recuerde que no debe contener ningun espacio: ");
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
			exist = mainMCS.verifyUser(name);
			if(exist==true){
				System.out.println("\nEl nombre de usuario ingresado ya esta en uso, pruebe con otro");
			}
		} while(exist);

		System.out.println("\nIngrese una contrasenia: ");
		password = lector.nextLine();
		System.out.println("\nIngrese su edad: ");
		age = lector.nextInt();
		message = mainMCS.createUser(name, password, age);
		System.out.println("\n"+message);
	}

	public void displayUsers(){
		String message = mainMCS.showUsers();
		System.out.println(
			"\n**********************************************************************************\n"+
			"\n                           Lista de usuarios registrados"+
			"\n**********************************************************************************\n"
		);
		System.out.println(message);
	}

	public void addSongToPool(){
		String title, artist, date, message, nameUser;
		int mins, secs, genre = 0;
		int[] minutes = new int [MCS.MAX_NUM_SONGS];
		int[] seconds = new int [MCS.MAX_NUM_SONGS];
		boolean access = true;
		System.out.println(
			"\n**********************************************************************************\n"+
			"                       Agregar una cancion al Pool de canciones"+
			"\n**********************************************************************************\n"
		);
		do{
			System.out.println("Ingrese su nombre de usuario: ");
			nameUser = lector.nextLine();
			access = mainMCS.verifyUser(nameUser);
			if(!access){
				System.out.println("\nEl nombre de usuario ingresado no existe, digitelo nuevamente");
			}
		} while(!access);
		do{	
			System.out.println("\nIngrese el titulo de la cancion: ");
			title = lector.nextLine();
			System.out.println("\nIngrese el nombre del artista o banda al que pertenece la cancion: ");
			artist = lector.nextLine();
			System.out.println("\nIngrese la fecha de lanzamiento de la cancion (DD/MM/AAAA): ");
			date = lector.nextLine();
			System.out.println("\nIngrese los minutos que dura la cancion: ");
			mins = lector.nextInt();
			for(int k=0;k<minutes.length;k++){
				minutes[k]= mins;
			}	
			System.out.println("\nIngrese los segundos que dura la cancion: ");
			secs = lector.nextInt();
			for(int k=0;k<minutes.length;k++){
				seconds[k]= secs;
			}
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
			System.out.println("\n"+message);
		} while(message.equals("La cancion ya se encuentra registrada, intentelo nuevamente"));		
	}

	public void displayPoolSongs(){
		String message = mainMCS.showSongsInPool();
		System.out.println(
			"\n**********************************************************************************\n"+
			"               Lista de canciones compartidas en el Pool de canciones"+
			"\n**********************************************************************************"+
			message
		);
	}

	public void createPlaylist(){
		int option;
		String nameUser, namePlaylist, authorizedUser, message;
		boolean access = true;
		String[] nameUsersPlaylistR = new String[RestrictedPL.MAX_NUM_USERS];
		System.out.println(
			"\n**********************************************************************************\n"+
			"                                   Crear una Playlist"+
			"\n**********************************************************************************\n"+
			"Seleccione el tipo de playlist que desea crear: "+
			"\n    1. Publica"+
			"\n    2. Privada"+
			"\n    3. Restringida"
		);
		option = lector.nextInt();lector.nextLine();
		switch(option){
			case 1:
				do{
					System.out.println("\nIngrese su nombre de usuario: ");
					nameUser = lector.nextLine();
					access = mainMCS.verifyUser(nameUser);
					if(!access){
						System.out.println("\nEl nombre de usuario ingresado no existe, digitelo nuevamente");
					}
				} while(!access);
				do{
					System.out.println("\nIngrese el nombre que le va a dar a su nueva playlist: ");
					namePlaylist = lector.nextLine();
					message = mainMCS.addPlaylist(namePlaylist);
					System.out.println(message);
				} while(message.equals("La playlist ya se encuentra registrada, intentelo nuevamente"));	
				break;
			case 2:
				do{
					System.out.println("\nIngrese su nombre de usuario: ");
					nameUser = lector.nextLine();
					access = mainMCS.verifyUser(nameUser);
					if(!access){
						System.out.println("\nEl nombre de usuario ingresado no existe, digitelo nuevamente");
					}
				} while(!access);
				do{
					System.out.println("\nIngrese el nombre del usuario que va a tener acceso a esta playlist: ");
					authorizedUser = lector.nextLine();
					access = mainMCS.verifyUser(authorizedUser);
					if(!access){
						System.out.println("\nEl nombre de usuario ingresado no existe, digitelo nuevamente");
					}
				} while(!access);
				do{
					System.out.println("\nIngrese el nombre que le va a dar a su nueva playlist: ");
					namePlaylist = lector.nextLine();
					message = mainMCS.addPlaylist(namePlaylist, nameUser, authorizedUser);
				}while(message.equals("La playlist ya se encuentra registrada, intentelo nuevamente"));
				break;
			case 3:
				do{
					System.out.println("\nIngrese su nombre de usuario: ");
					nameUser = lector.nextLine();
					access = mainMCS.verifyUser(nameUser);
					if(!access){
						System.out.println("\nEl nombre de usuario ingresado no existe, digitelo nuevamente");
					}
				} while(!access);				
				nameUsersPlaylistR[0] = nameUser;
				for(int k=0;k<RestrictedPL.MAX_NUM_USERS-1;k++){
					do{
						System.out.println("\nIngrese el nombre del usuario #"+(k+1)+" que va a tener acceso a esta playlist: ");
						authorizedUser = lector.nextLine();
						access = mainMCS.verifyUser(authorizedUser);
						if(!access){
							System.out.println("\nEl nombre de usuario ingresado no existe, digitelo nuevamente");
						}
					} while(!access);	
					nameUsersPlaylistR[k] = authorizedUser; 
				}
				do{
					System.out.println("\nIngrese el nombre que le va a dar a su nueva playlist: ");
					namePlaylist = lector.nextLine();
					message = mainMCS.addPlaylist(namePlaylist, nameUsersPlaylistR);
				} while(message.equals("La playlist ya se encuentra registrada, intentelo nuevamente"));
				break;		
		}
	}

	public void addSongToPlaylist(){
		String nameUser, namePlaylist, nameSong, artistSong, message;
		boolean access = true;
		System.out.println(
			"\n**********************************************************************************\n"+
			"\n                        Agregar una cancion a una Playlist"+
			"\n**********************************************************************************\n"
		);
		do{
			System.out.println("\nIngrese su nombre de usuario: ");
			nameUser = lector.nextLine();
			access = mainMCS.verifyUser(nameUser);
			if(!access){
				System.out.println("\nEl nombre de usuario ingresado no existe, digitelo nuevamente");
			}
		} while(!access);
		do{
			System.out.println("\nIngrese el nombre de la playlist a la que desea agregar una cancion: ");
			namePlaylist = lector.nextLine();
			System.out.println("\nIngrese el titulo de la cancion que desea agregar: ");
			nameSong = lector.nextLine();
			System.out.println("\nIngrese el artista al que pertenece la cancion que desea agregar: ");
			artistSong = lector.nextLine();
			message = mainMCS.addSongToPlaylist(nameUser, namePlaylist, nameSong, artistSong);
		} while(message.equals("La playlist no se encuentra registrada, intentelo nuevamente") && message.equals("La cancion no se encuentra registrada en el Pool, intentelo nuevamente"));
	}

	public void displayPlaylists(){

	}

	public void ratePublicPlaylists(){

	}

}