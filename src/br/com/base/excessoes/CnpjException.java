package br.com.base.excessoes;

public class CnpjException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CnpjException(String mensagem){
		super(mensagem);
	}
}
