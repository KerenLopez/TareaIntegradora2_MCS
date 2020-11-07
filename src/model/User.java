package model;

public class User{

	//Atributes
	private String userName;
	private String password;
	private int age;
	private int numSongsAddToPool;

	//Relationships
	private Category userCategory;

	//Getters and Setters 

	/**
	* This method returns the name of a user. <br>
	* <b>name</b>: getUserName <br>
	* @return String <code> userName </code> that is a variable with the name of a user.
	*/

	public String getUserName(){
		return userName;
	}

	/**
	* this method modifies the name of a user. <br>
	* <b>name</b>: setUserName <br>
	* <b>post</b>: the name of the user has been changed. <br>
	* @param pUserName is a String variable.
	*/

	public void setUserName(String pUserName){
		userName = pUserName;
	}

	/**
	* This method returns the password of a user. <br>
	* <b>name</b>: getPassword <br>
	* @return Srting <code> password </code> that is variable with the password of a user.
	*/

	public String getPassword(){
		return password;
	}

	/**
	* this method modifies the password of a user. <br>
	* <b>name</b>: setPassword <br>
	* <b>post</b>: the password of the user has been changed. <br>
	* @param pPassword is a String variable.
	*/

	public void setPassword(String pPassword){
		password = pPassword;
	}

	/**
	* This method returns the age of a user. <br>
	* <b>name</b>: getAge <br>
	* @return integer <code> age </code> that is a variable with the age of a user.
	*/

	public int getAge(){
		return age;
	}

	/**
	* this method modifies the age of a user. <br>
	* <b>name</b>: setAge <br>
	* <b>post</b>: the age of the user has been changed. <br>
	* @param pAge is an integer variable.
	*/

	public void setAge(int pAge){
		age = pAge;
	}

	/**
	* This method returns the category of a user. <br>
	* <b>name</b>: getUserCategory <br>
	* @return Category <code> userCategory </code> that is a constant that represents the rank of a user.
	*/

	public Category getUserCategory(){
		return userCategory;
	}

	/**
	* this method modifies the category of a user. <br>
	* <b>name</b>: setUserCategory <br>
	* <b>post</b>: the category of the user has been changed. <br>
	* @param pUserCategory is a Category constant.
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
	* @param pUserName is a String variable that contains the name of a user.
	* @param pPassword is a String variable that contains the password of a user.
	* @param pAge is an integer variable that contains the age of a user.
	*/

	public User(String pUserName, String pPassword, int pAge){
		userName = pUserName;
		password = pPassword;
		age = pAge;
		userCategory = Category.NEWBIE;
		numSongsAddToPool = 0;
	}

	/**
	* this method changes the category of a user. <br>
	* <b>name</b>: changeUserCategory <br>
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