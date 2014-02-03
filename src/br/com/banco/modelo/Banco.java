package br.com.banco.modelo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.com.banco.controle.AtualizadorDeContas;
import br.com.banco.excessoes.ValorInvalidoException;
import br.com.banco.interfaces.Conta;
import br.com.base.modelo.Cliente;
import br.com.base.modelo.Cpf;


public class Banco {

	private static int numeroConta;
	private AtualizadorDeContas atualizadorDeContas = new AtualizadorDeContas(0.01);	

	public Banco() {
		
	
	}
	
	public static int numeraConta(){
		return numeroConta + 1;
	}
	
	private Set<Conta> contas = new HashSet<Conta>();


	public ContaCorrente criaContaCorrente(Cliente cliente){
		
		ContaCorrente conta = new ContaCorrente(numeraConta(),cliente );
		adicionarConta(conta);
		return conta;
	}	

	public ContaPoupanca criaContaPoupanca(Cliente cliente){
		
		ContaPoupanca conta = new ContaPoupanca(numeraConta(),cliente );
		adicionarConta(conta);
		return conta;
	}		
	
	private void adicionarConta(Conta conta){
		contas.add(conta);
	}

	public Conta getConta(int numero){

		for (Conta conta : contas) {
			if(conta.getNumero() == numero ){
				return conta;
			} 
		}
		return null;
	}
	
	public Collection<Conta> getContas(){
		return contas;
		
	}
	
	public Collection<Conta> getContas(Cpf cpf){
		Set<Conta> contasCpf = new HashSet<Conta>();
		
		for (Conta conta : getContas()) {
			if(conta.getTitular().getDocumento().equals(cpf)){
				contasCpf.add(conta);
			} 
		}
		
		return contasCpf;
	}

	public AtualizadorDeContas getAtualizadorDeContas() {
		return atualizadorDeContas;
	}

	public double getSaldoTotal() {
		double saldoTotal = 0;
		
		for (Conta conta : contas) {
			saldoTotal += conta.getSaldo(); 
		}
		
		return saldoTotal;
	
	}

	public static void validaValor(double valor) throws ValorInvalidoException{
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor negativo ou zerado.");
		}
	}	
	

	public Cliente procuraCliente(Cpf cpf) throws IllegalArgumentException {
		Cliente cliente = null;
		for (Conta conta : contas) {
			if(conta.getTitular().getDocumento().getNumero().equals(cpf.getNumero())){
				cliente = conta.getTitular();
				break;
			}
		}
		
		if (cliente == null){
			throw new IllegalArgumentException("Cpf não consta na lista de Contas");
		}
		
		return cliente;
	}
	
}
