package br.com.banco.interfaces;

import br.com.banco.excessoes.SaldoInsuficienteException;
import br.com.banco.excessoes.ValorInvalidoException;
import br.com.base.modelo.Cliente;

public interface Conta {
	public Cliente getTitular();
	public int getNumero();
	public double getSaldo();
	public void deposita(double valor) throws ValorInvalidoException;
	public void saca(double valor) throws SaldoInsuficienteException, ValorInvalidoException;
	public void atualizaTaxa(double taxaSelic) throws ValorInvalidoException;
}
