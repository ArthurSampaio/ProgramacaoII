package excecoes;

public class JogoInvalidoException extends Exception{

	private final static String MSG = "Jogo invalido. Verifique os dados passados"
			+ "como parametro";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JogoInvalidoException(String msg) {
		super(msg); 
	}
	
	public JogoInvalidoException(){
		super(MSG);
	}

}


