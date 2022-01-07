package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	private String nome;
	private String telefone;
	private Date dataNascimento;
	private Date dataCadastro;
	private Date dataAlteração;
	//private SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
	
	public Pessoa() {}

	public Pessoa(String nome, String telefone, Date dataNascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = new Date();
		this.dataAlteração = new Date();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAlteração() {
		return dataAlteração;
	}

	public void setDataAlteração(Date dataAlteração) {
		this.dataAlteração = dataAlteração;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("nome: %s; telefone: %s; data de nascimento: %s;"
				+ "data do cadastro: %s; data da última alteração: %s", getNome(), getTelefone(),
				sdf.format(getDataNascimento()), sdf.format(getDataCadastro()), sdf.format(getDataAlteração())));
		return sb.toString();
	}
}
