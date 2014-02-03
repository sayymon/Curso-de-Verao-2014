package br.com.banco.controle;

import br.com.banco.interfaces.Tributavel;

public class GerenciadorDeImpostoDeRenda {

	private double total;

	public void adiciona(Tributavel t) {
		System.out.println("Adicionando tributavel: " + t);
		this.total += t.calculaTributos();
	}

	public double getTotal() {
		return this.total;
	}

}
