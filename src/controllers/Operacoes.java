package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Aluno;
import entities.Pessoa;

public class Operacoes {
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public Operacoes() {}
	
	public boolean criar(Pessoa pessoa) {
		return pessoas.add(pessoa);
	}
	
	public List<Pessoa> mostrarTudo(){
		return pessoas;
	}
	
	/*public boolean atualizarDados(Pessoa pessoa) {
		int indice = 0;
		for(Pessoa p : pessoas) {
			if(p.getNome().toUpperCase().equals(pessoa.getNome().toUpperCase())) {
				indice = pessoas.indexOf(p);
				pessoas.set(indice, pessoa);
				return true;
			}
		}
		return false;
	}*/
	
	public boolean atualizarNome(String nomeAntigo, String nomeNovo) {
		for(int i =0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().toUpperCase().equals(nomeAntigo.toUpperCase())) {
				pessoas.get(i).setNome(nomeNovo);
				pessoas.get(i).setDataAlteração(new Date());
				return true;
			}
		}
		return false;
	}
	
	public boolean atualizarTelefone(String nome, String telefone) {
		for(int i =0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().toUpperCase().equals(nome.toUpperCase())) {
				pessoas.get(i).setTelefone(telefone);
				pessoas.get(i).setDataAlteração(new Date());
				return true;
			}
		}
		return false;
	}
	
	public boolean atualizarDataNascimento(String nome, Date dataNascimento) {
		for(int i =0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().toUpperCase().equals(nome.toUpperCase())) {
				pessoas.get(i).setDataNascimento(dataNascimento);
				pessoas.get(i).setDataAlteração(new Date());
				return true;
			}
		}
		return false;
	}
	
	public boolean atualizarNotaFinal(String nome, double novaNota) {
		for(int i =0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().toUpperCase().equals(nome.toUpperCase()) && pessoas.get(i) instanceof Aluno) {
				Aluno a = (Aluno) pessoas.get(i);
				a.setNotaFinalDoCurso(novaNota);
				int indice = pessoas.indexOf(pessoas.get(i));
				pessoas.set(indice, a);
				pessoas.get(i).setDataAlteração(new Date());
				return true;
			}
		}
		return false;
	}
	
	public boolean deletarDados(String nome) {
		int indice = 0;
		for(int i =0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().toUpperCase().equals(nome.toUpperCase())) {
				indice = pessoas.indexOf(pessoas.get(i));
				pessoas.remove(indice);
				return true;
			}
		}
		return false;
	}
}
