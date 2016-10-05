package exception;


/**
 * Class for exceptions of type P2CG2Exception that return a message with the exception
 *  
 * 
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *  
 */
public class P2CG2Exception extends Exception{
	
	private final static String MESSAGE = "Ocorreu uma excessao no Sistema.";
	
	/**
	 * Constructor of exception P2CG2
	 */
	public P2CG2Exception(){
		super(MESSAGE);
	}

	/**
	 * Constructor of exception P2CG2 receiving a string by parameters
	 * @param message
	 */
	public P2CG2Exception(String message){
		super(message);
	}
	

}
