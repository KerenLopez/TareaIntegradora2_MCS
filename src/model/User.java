package model;

public class User{

	//Atributes
	private String userName;
	private String password;
	private int age;
	private int numSongsAddToPool;

	//Relationships
	private Category userCategory;

	//Getters and Setters of all the atributes or relationships

	/**
	* This method returns the user's name. <br>
	* @return out a <code> String </code> variable that contains the user's name.
	*/
	public String getUserName(){
		return userName;
	}
	/**
	* this method modifies the user's name. <br>
	* <b>post</b>: the user's name has been changed. <br>
	* @param pUserName is a String variable.
	*/
	public void setUserName(String pUserName){
		userName = pUserName;
	}
	/**
	* This method returns the user's password. <br>
	* @return out a <code> String </code> variable that contains the user's password.
	*/
	public String getPassword(){
		return password;
	}
	/**
	* this method modifies the user's password. <br>
	* <b>post</b>: the user's password has been changed. <br>
	* @param pPassword is a String variable.
	*/
	public void setPassword(String pPassword){
		password = pPassword;
	}
	/**
	* This method returns the user's age. <br>
	* @return out an <code> integer </code> variable that contains the user's age.
	*/
	public int getAge(){
		return age;
	}
	/**
	* this method modifies the user's age. <br>
	* <b>post</b>: the user's age has been changed. <br>
	* @param pAge is an integer variable.
	*/
	public void setAge(int pAge){
		age = pAge;
	}
	/**
	* This method returns the user's category. <br>
	* @return out an <code> Category </code> object that contains the user's rank.
	*/
	public Category getUserCategory(){
		return userCategory;
	}
	/**
	* this method modifies the user's category. <br>
	* <b>post</b>: the user's rank has been changed. <br>
	* @param pUserCategory is a Category object.
	*/
	public void setUserCategory(Category pUserCategory){
		userCategory = pUserCategory;
	}

	//Methods

	/**
	* Builder method <br>
	* <b>name</b>: User <br>
	* <b>pre</b>: the variables pUserName, pPassword and pAge are already inicializated. <br>
	* <b>post</b>: the relationships and all the atributes of the class were inicializated. <br>
	* @param pUserName is a String variable that.
	* @param pPassword is a String variable that.
	* @param pAge is an integer variable that.
	*/
	public User(String pUserName, String pPassword, int pAge){
		userName = pUserName;
		password = pPassword;
		age = pAge;
		userCategory = Category.NEWBIE;
		numSongsAddToPool = 0;
	}
	/**
	* this method . <br>
	* <b>post</b>: the category of the user has been changed. <br>
	*/
	public void changeUserCategory(){ 
		numSongsAddToPool+=1;

		if(numSongsAddToPool >= 3){
			setUserCategory(Category.LITTLE_CONTRIBUTOR);
		}
		if(numSongsAddToPool >=10){
			setUserCategory(Category.MILD_CONTRIBUTOR);
		}
		if(numSongsAddToPool >=30){
			setUserCategory(Category.STAR_CONTRIBUTOR);
		}
	}
}