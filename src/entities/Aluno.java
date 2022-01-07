package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno extends Pessoa {
	private Double notaFinalDoCurso;
	
	public Aluno() {
		super();
	}

	public Aluno(String nome, String telefone, Date dataNascimento, Double notaFinalDoCurso) {
		super(nome, telefone, dataNascimento);
		this.notaFinalDoCurso = notaFinalDoCurso;
	}

	public Double getNotaFinalDoCurso() {
		return notaFinalDoCurso;
	}

	public void setNotaFinalDoCurso(Double notaFinalDoCurso) {
		this.notaFinalDoCurso = notaFinalDoCurso;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("nome: %s; telefone: %s; data de nascimento: %s;"
				+ "data do cadastro: %s; data da última alteração: %s; nota final: %.2f", getNome(), getTelefone(),
				sdf.format(getDataNascimento()), sdf.format(getDataCadastro()),
				sdf.format(getDataAlteração()), getNotaFinalDoCurso()));
		return sb.toString();
	}
}
