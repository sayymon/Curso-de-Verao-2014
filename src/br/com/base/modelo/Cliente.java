package br.com.base.modelo;

import br.com.base.excessoes.ClienteException;
import br.com.base.excessoes.CnpjException;
import br.com.base.excessoes.CpfException;
import br.com.base.interfaces.Autenticavel;

public class Cliente implements Autenticavel {

	private Pessoa pessoa;
	private String senha;

	public Cliente(Cnpj cnpj) {
		pessoa = new PessoaJuridica(cnpj);
	}

	public Cliente(Cpf cpf) {
		pessoa = new PessoaFisica(cpf);
	}

	public Cliente(String documento) throws ClienteException {

		try {
			pessoa = new PessoaFisica(documento);
		} catch (CpfException eCpf) {
			try {
				pessoa = new PessoaJuridica(documento);
			} catch (CnpjException eCnpj) {
				throw new ClienteException("Documento Invalido : " + eCpf.getMessage()+" "
						+ eCnpj.getMessage());
			}
		}

	}

	public void setNome(String nome) {
		this.pessoa.setNome(nome);
	}

	public Documento getDocumento() {
		Documento documento = null;
		if (pessoa instanceof PessoaJuridica) {
			PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
			documento = pessoaJuridica.getCnpj();
		} else if (pessoa instanceof PessoaFisica) {
			PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
			documento = pessoaFisica.getCpf();
		}
		return documento;
	}

	@Override
	public void autentica(String senha) {

		if (this.senha != senha) {
			throw new IllegalArgumentException("Senha Invalida");
		}
		// pode fazer outras possíveis verificações, como saber se esse
		// departamento do gerente tem acesso ao Sistema
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [pessoa=" + pessoa + "]";
	}

}
