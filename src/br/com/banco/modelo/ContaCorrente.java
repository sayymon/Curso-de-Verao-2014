package br.com.banco.modelo;

import br.com.banco.excessoes.SaldoInsuficienteException;
import br.com.banco.excessoes.ValorInvalidoException;
import br.com.banco.interfaces.ContaTributavel;
import br.com.base.modelo.Cliente;

public class ContaCorrente implements ContaTributavel {

	private int numero;
	private Cliente titular;
	private double saldo;
	private double limite = 0;

	public ContaCorrente(int numero, Cliente titular) {
		this.numero = numero;
		this.titular = titular;
	}	
	
	@Override
	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	
	@Override
	public int getNumero() {
		return numero;
	}

	public double getLimite() {
		return limite;
	}

	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}

	@Override
	public double getSaldo() {
		return this.saldo;
	}

	/**
	 * A ContaCorrente deve reescrever o método deposita , a fim de retirar uma
	 * taxa bancária de dez centavos de cada depósito.
	 * @throws ValorInvalidoException 
	 */

	@Override
	public void deposita(double valor) throws ValorInvalidoException{
		try {
			Banco.validaValor(valor);
		} catch (ValorInvalidoException e) {
			throw new ValorInvalidoException("Ao realizar o deposito de :"+valor+" foi retornada a seguinte mensagem ->"+e.getMessage());
		}
		
		
		valor -= 0.10;
		this.saldo += valor;

	}

	@Override
	public void saca(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
		Banco.validaValor(valor);
		if (getSaldo() >= valor) {
			this.saldo -= valor;
		}else{
			throw new SaldoInsuficienteException(
					"Valor maior do que o permitido.");
		}
	}

	/**
	 * A ContaCorrente deve atualizar-se com o dobro da taxa
	 * @throws ValorInvalidoException 
	 */
	@Override
	public void atualizaTaxa(double taxa)throws ValorInvalidoException {
		Banco.validaValor(taxa);
		this.saldo += this.saldo * (taxa * 2);
	}


	@Override
	public String toString() {
		return "ContaCorrente [getTitular()=" + getTitular() + ", getNumero()="
				+ getNumero() + "]";
	}

}

