package model;

public class User{

	//Atributes
	private String userName;
	private String password;
	private int age;
	private int numSongsAddToPool;

	//Relationships
	private Category userCategory;

	//Builder Method
	public User(String pUserName, String pPassword, int pAge){
		userName = pUserName;
		password = pPassword;
		age = pAge;
		userCategory = Category.NEWBIE;
		numSongsAddToPool = 0;
	}
	//End Builder Method

	//Getters & Setters of all the atributes or relationships

	public String getUserName(){
		return userName;
	}

	public void setUserName(String pUserName){
		userName = pUserName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String pPassword){
		password = pPassword;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int pAge){
		age = pAge;
	}

	public int getNumSongsAddToPool(){
		return numSongsAddToPool;
	}

	public void setNumSongsAddToPool(int pNumSongsAddToPool){
		numSongsAddToPool = pNumSongsAddToPool;
	}

	public Category getUserCategory(){
		return userCategory;
	}

	public void setUserCategory(Category pUserCategory){
		userCategory = pUserCategory;
	}

	//Methods

	public void changeUserCategory(){
		int numSongsAddToPool = getNumSongsAddToPool();
		switch(numSongsAddToPool){
			case 3 :
				setUserCategory(Category.LITTLE_CONTRIBUTOR)
				break;
			case 10 :
				setUserCategory(Category.MILD_CONTRIBUTOR);
				break;
			case 30 :
				setUserCategory(Category.STAR_CONTRIBUTOR);
				break;	
		}
	}
}