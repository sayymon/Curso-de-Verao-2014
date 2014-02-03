package br.com.base.excessoes;

public class ClienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ClienteException(String mensagem){
		super(mensagem);
	}
	
}
