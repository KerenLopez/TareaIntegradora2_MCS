package model;

public class PublicPL extends PlayList{

	//Atributes
	private int numGrades;
	private int grades;
	private double averageGrade;

	//Getters and Setters of all the atributes	
	public int getNumGrades(){
		return numGrades;
	}

	public void setNumGrades(int pNumGrades){
		numGrades = pNumGrades;
	} 

	public double getAverageGrade(){
		return averageGrade;
	}

	public void setAverageGrade(double pAverageGrade){
		averageGrade = pAverageGrade;
	}

	//Methods 

	/**
	* Builder method <br>
	* <b>name</b>: PublicPL <br>
	* <b>pre</b>: the variable name and the lists such as minutes and seconds are already inicializated. <br>
	* <b>post</b>: the atributes of the class were inicializated. <br>
	* @param name is a String variable that.
	* @param minutes is a list of integers that.
	* @param seconds is a list of integers that.
	*/
	public PublicPL(String name, int[] minutes, int[] seconds){
		super(name,minutes,seconds);
		grades = 0;
		numGrades = 0;
		averageGrade = 0;
	}

	public String ratePlaylist(int grade){
		String message = "\nLa calificacion de la playlist ha sido agregada correctamente";
		numGrades+=1;
		grades += grade;
		averageGrade = grades/numGrades; 
		return message;
	}

	public String toString(){
		return super.toString()+"\n                                          **  Tipo: Publica"+"\n                                          **  Nota promedio: "+getAverageGrade();
	}
}