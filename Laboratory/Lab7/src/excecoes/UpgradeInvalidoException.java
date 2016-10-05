package excecoes;

public class UpgradeInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Impossivel realizar upgrade, quantidade de x2p insuficiente!";
	
	public UpgradeInvalidoException(String msg) {
		super(msg); 
	}

	public UpgradeInvalidoException(){
		super(MSG);
	}
}
