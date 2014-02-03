package br.com.banco.modelo;

import br.com.banco.excessoes.SaldoInsuficienteException;
import br.com.banco.excessoes.ValorInvalidoException;
import br.com.banco.interfaces.Conta;
import br.com.base.modelo.Cliente;

public class ContaPoupanca implements Conta {

	private int numero;
	private Cliente titular;
	private double saldo;
	private double limite = 0;
	
	public ContaPoupanca(int numero, Cliente titular) {
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




	/**
	 * A ContaPoupanca deve atualizar-se com o triplo da taxa.
	 * @throws ValorInvalidoException 
	 */
	
	@Override
	public void atualizaTaxa(double taxa) throws ValorInvalidoException{
		Banco.validaValor(taxa);
		this.saldo += this.saldo * (taxa * 3);		
	}


	@Override
	public double getSaldo() {
		return this.saldo;
	}


	@Override
	public void deposita(double valor) throws ValorInvalidoException {
		Banco.validaValor(valor);
		this.saldo += valor;
	}


	@Override
	public void saca(double valor)throws SaldoInsuficienteException, ValorInvalidoException {
		Banco.validaValor(valor);
		if (getSaldo() >= valor) {
			this.saldo -= valor;
		}else{
			throw new SaldoInsuficienteException(
					"Valor maior do que o permitido.");
		}
		
	}

	
	
}
