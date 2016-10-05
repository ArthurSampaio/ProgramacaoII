package excessoes;

public class ClubeDoLivroException extends Exception {

	private final static String MESSAGE = "Um erro inesperado ocorreu.";
	
	public ClubeDoLivroException(){
		super(MESSAGE);
	}
	public ClubeDoLivroException(String m){
		super(m);
	}
	
}
