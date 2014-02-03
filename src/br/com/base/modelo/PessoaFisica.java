package br.com.base.modelo;

import br.com.base.excessoes.CpfException;

public class PessoaFisica extends Pessoa {

	private Cpf cpf;

	public PessoaFisica(String cpf) throws CpfException {

		super();
		setCpf(cpf);

	}

	public PessoaFisica(Cpf cpf) {
		this.cpf = cpf;
	}

	public Cpf getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) throws CpfException {
		this.cpf = new Cpf(cpf);
	}

}
