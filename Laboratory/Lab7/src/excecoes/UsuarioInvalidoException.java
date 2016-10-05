package excecoes;

public class UsuarioInvalidoException extends Exception{
	
	private final static String MSG = "Usuário inválido";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioInvalidoException(String msg) {
		super(msg); 
	}
	
	public UsuarioInvalidoException(){
		super(MSG);
	}

}

