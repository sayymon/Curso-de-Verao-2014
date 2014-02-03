package br.com.banco.controle;

import java.util.Collection;

import br.com.banco.excessoes.ValorInvalidoException;
import br.com.banco.interfaces.Conta;

public class AtualizadorDeContas {

	private double taxa;

	public AtualizadorDeContas(double taxa) {
		this.taxa = taxa;
	}

	public void atualizaConta(Conta c) throws ValorInvalidoException {

		c.atualizaTaxa(taxa);

	}

	public void atualizaContas(Collection<Conta> contas) throws ValorInvalidoException {

		for (Conta conta : contas) {
			atualizaConta(conta);
		}

	}

}
