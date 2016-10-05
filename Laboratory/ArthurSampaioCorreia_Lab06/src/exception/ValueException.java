package exception;

/**
 * Class for exceptions of type ValueException that return a message with the exception
 *  
 * 
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *  
 */
public class ValueException extends P2CG2Exception{
	
	private final static String MESSAGE = "Ocorreu uma excessao de valor.";
	
	
	/**
	 * Constructor of exception ValueException
	 */
	public ValueException(){
		super(MESSAGE);
	}
	
	/**
	 * Constructor of exception ValueException receiving a string by parameter
	 * @param message
	 */
	public ValueException(String message){
		super(message);
	}
	

}
