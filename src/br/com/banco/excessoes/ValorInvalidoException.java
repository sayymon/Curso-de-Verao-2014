package br.com.banco.excessoes;

public class ValorInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4643342177554275219L;

	public ValorInvalidoException() {
		super();
	}
	
	public ValorInvalidoException(String message) {
		super(message);
	}	
	
}
