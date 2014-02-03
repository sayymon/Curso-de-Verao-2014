package br.com.base.modelo;

import br.com.base.excessoes.CnpjException;

public class PessoaJuridica extends Pessoa {
	Cnpj cnpj;

	public PessoaJuridica(Cnpj cnpj) {
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica(String cnpj) throws CnpjException {
		setCnpj(cnpj);
	}

	public Cnpj getCnpj() {
		return cnpj;
	}

	private void setCnpj(String cnpj) throws CnpjException {
		this.cnpj = new Cnpj(cnpj);
	}

	
}
