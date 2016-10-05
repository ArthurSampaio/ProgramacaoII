package exception;

/**
 * Class for exceptions of type StringException that return a message with the exception
 *  
 * 
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *  
 */
public class StringException extends ValueException{
	
	private final static String MESSAGE = "A string nao pode ser nula ou vazia.";
	
	/**
	 * Constructor of exception StringException
	 */
	public StringException(){
		super(MESSAGE);
	}

	/**
	 * Constructor of exception StringException receiving a message by parameter
	 * @param message
	 */
	public StringException(String message){
		super(message);
	}
}
