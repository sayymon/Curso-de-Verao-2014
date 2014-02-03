package br.com.banco.excessoes;

public class SaldoInsuficienteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5963173007192596531L;

	public SaldoInsuficienteException() {
		super();
	}	
	
	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}

	
	
}
