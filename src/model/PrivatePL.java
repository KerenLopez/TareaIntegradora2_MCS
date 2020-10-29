package model;

public class PrivatePL extends PlayList{

	//Relationships
	private User nameUser;
	private User authorizedUser;

	public PrivatePL(String name, int[] minutes, int[] seconds, User pNameUser, User pAuthorizedUser){
		super(name,minutes,seconds);
	}
}