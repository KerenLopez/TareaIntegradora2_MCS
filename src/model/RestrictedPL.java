package model;

public class RestrictedPL extends PlayList{

	//Constants
	public final static int MAX_NUM_USERS = 5;

	//Relationships
	private User[] authorizedUsers;

	public RestrictedPL(String name, int[] minutes, int[] seconds, User[] authorizedUsers){
		super(name,minutes,seconds);
	}

}