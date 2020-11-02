package model;

public class PublicPL extends PlayList{

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
	}

	public String toString(){
		return super.toString()+"\n                     **  Tipo: Publica";
	}
}