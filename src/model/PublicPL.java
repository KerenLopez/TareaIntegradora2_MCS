package model;

public class PublicPL extends PlayList{

	//Atributes
	private int numGrades;
	private int grades;
	private double averageGrade;

	//Getters and Setters

	/**
	* This method returns the number of grades that a playlist has. <br>
	* <b>name</b>: getNumGrades <br>
	* @return integer <code> numGrades </code> that is a variable with the number of grades that a playlist has.
	*/

	public int getNumGrades(){
		return numGrades;
	}

	/**
	* this method modifies the number of grades that a playlist has. <br>
	* <b>name</b>: setNumGrades <br>
	* <b>post</b>: the number of playlist grades has been changed. <br>
	* @param pNumGrades is an integer variable.
	*/

	public void setNumGrades(int pNumGrades){
		numGrades = pNumGrades;
	}

	/**
	* This method returns the grades that a playlist has. <br>
	* <b>name</b>: getGrades <br>
	* @return integer <code> grades </code> that is a variable with the grades of a playlist.
	*/

	public int getGrades(){
		return grades;
	}

	/**
	* this method modifies the grades that a playlist has. <br>
	* <b>name</b>: setGrades <br>
	* <b>post</b>: the grades of the playlist has been changed. <br>
	* @param pGrades is an integer variable.
	*/

	public void setGrades(int pGrades){
		grades = pGrades;
	}  

	/**
	* This method returns the average of the grades that a playlist has. <br>
	* <b>name</b>: getAverageGrade <br>
	* @return double <code> averageGrade </code> that is a variable with the average grade of a playlist.
	*/

	public double getAverageGrade(){
		return averageGrade;
	}

	/**
	* this method modifies the average of the grades that a playlist has. <br>
	* <b>name</b>: setAverageGrade <br>
	* <b>post</b>: the average of the grades in the playlist has been changed. <br>
	* @param pAverageGrade is an integer variable.
	*/

	public void setAverageGrade(double pAverageGrade){
		averageGrade = pAverageGrade;
	}

	//Methods 

	/**
	* Builder method <br>
	* <b>name</b>: PublicPL <br>
	* <b>pre</b>: the variable name and the lists such as minutes and seconds are already inicializated. <br>
	* <b>post</b>: the atributes of the class were inicializated. <br>
	* @param name is a String variable that contains the name of a playlist.
	* @param minutes is a list of integers that contains the minutes that all the songs of a playlist lasts.
	* @param seconds is a list of integers that contains the seconds that all the songs of a playlist lasts.
	*/

	public PublicPL(String name, int[] minutes, int[] seconds){
		super(name,minutes,seconds);
		grades = 0;
		numGrades = 0;
		averageGrade = 0;
	}

	/**
	* This method adds a grade that a user wants to give to a public playlist. <br>
	* <b>name</b>: ratePlaylist.<br>
	* <b>pre</b>: the variable grade is already inicializated. <br>
 	* <b>post</b>: the public playlist was rated successfully. <br>
 	* @param grade is an integer variable that contains the grade of a playlist.   
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String ratePlaylist(int grade){
		String message = "\nLa calificacion de la playlist ha sido agregada correctamente";
		numGrades+=1;
		grades += grade;
		averageGrade = grades/numGrades; 
		return message;
	}

	/**
	* This method produces a String with the information of a public playlist. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of the playlist was returned. <br>
 	* @return out in a <code> String </code> variable all information of a playlist.
	*/

	@Override
	public String toString(){
		return super.toString()+"\n                                          **  Tipo: Publica"+"\n                                          **  Nota promedio: "+getAverageGrade();
	}
}