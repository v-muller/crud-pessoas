package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;



import controllers.Operacoes;
import entities.Aluno;
import entities.Pessoa;

public class Menu {
	private Operacoes operacoes = new Operacoes();
	private SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
	
	public Menu() {
	}

	public void executa() {
		int in = 0;
		Scanner sc = new Scanner(System.in);
		char opcao = ' ';
		Scanner entrada1 = new Scanner(System.in);
		
		System.out.println("Sistema de administração de pessoas e alunos. ");
		
		while (opcao != '5') {
			try {
				System.out.println("Opcoes: ");
				System.out.println("   [1] Criar pessoa ou aluno.");
				System.out.println("   [2] Mostrar todas as pessoas cadastradas.");
				System.out.println("   [3] Atualizar dados de pessoa ou aluno.");
				System.out.println("   [4] Deletar uma pessoa ou aluno");
				System.out.println("   [5] Sair");
				System.out.print("Digite a opcao desejada: ");
				opcao = sc.next().charAt(0);
				switch(opcao) {
				case '1':
					System.out.println("Digite o nome: ");
					String nome = entrada1.nextLine();
					System.out.println("Digite o telefone: ");
					String telefone = entrada1.nextLine();
					System.out.println("Digite a data de nascimento no formato dd/MM/aaa: ");
					String data = entrada1.nextLine();
					Date dataNascimento = sdf.parse(data);
					char opcaoAluno = ' ';
					while(opcaoAluno != '1' && opcaoAluno != '2') {
						System.out.println("Se desejar adicionar a nota final do curso digite 1, caso contrario digite 2.");
						opcaoAluno = sc.next().charAt(0);
						if(opcaoAluno != '1' && opcaoAluno != '2') {
							System.out.println("Dígito inválido, tente novamente.");
						}
					}
					if(opcaoAluno == '1') {
						System.out.println("Digite a nota do curso: ");
						double nota = sc.nextDouble();
						if(operacoes.criar(new Aluno(nome, telefone, dataNascimento, nota))) {
							System.out.println("Aluno Adicionado com sucesso!");
						}
						else {
							System.out.println("O aluno não pôde ser adicionado.");
						}
					}
					else {
						if(operacoes.criar(new Pessoa(nome, telefone, dataNascimento))) {
							System.out.println("Pessoa Adicionada com sucesso!");
						}
						else {
							System.out.println("A pessoa não pôde ser adicionada.");
						}
					}
					break;
				case '2':
					for(Pessoa p : operacoes.mostrarTudo()) {
						System.out.println(p.toString());
					}
					break;
				case '3':
					System.out.println("Digite o nome da pessoa ou aluno que deseja atualizar. ");
					String nomeParaAtualizar = entrada1.nextLine();
					char opcaoParaAtualizar = ' ';
					System.out.println("Digite o dado que deseja atualizar, sendo: ");
					System.out.println("1 para nome. ");
					System.out.println("2 para telefone.");
					System.out.println("3 para data de nascimento");
					opcaoParaAtualizar = sc.next().charAt(0);
					
					while(opcaoParaAtualizar != '1' && opcaoParaAtualizar != '2' && opcaoParaAtualizar != '3') {
						if(opcaoParaAtualizar == '1') {
							System.out.println("Digite o nove Nome:");
							String novoNome = sc.nextLine();
							if(operacoes.atualizarNome(nomeParaAtualizar, novoNome)) {
								System.out.println("Nome atualizado com sucesso!");
							}
							else {
								System.out.println("Nome não encontrado.");
							}
						}
						else if(opcaoParaAtualizar == '2') {
							System.out.println("Digite o novo telefone: ");
							String novoTelefone = sc.nextLine();
							if(operacoes.atualizarTelefone(nomeParaAtualizar, novoTelefone)) {
								System.out.println("Telefone atualizado com sucesso!");
							}
							else {
								System.out.println("Não foi possivel atualizar o telefone.");
							}
						}
						else if(opcaoParaAtualizar == '3') {
							System.out.println("Digite a data de nascimento atualizada no formato dd/MM/aaaa ");
							String dataParaAtualizar = sc.nextLine();
							Date novaData = sdf.parse(dataParaAtualizar);
							if(operacoes.atualizarDataNascimento(nomeParaAtualizar, novaData)) {
								System.out.println("Data atualizada com sucesso!");
							}
							else {
								System.out.println("Não foi possivel atualizar a data.");
							}
						}
					}
					break;
				case '4':
					System.out.println("Digite o nome da pessoa ou aluno que deseja remover ");
					String nomeParaRemover = sc.nextLine();
					if(operacoes.deletarDados(nomeParaRemover)) {
						System.out.println("Pessoa removida com sucesso!");
					}
					else {
						System.out.println("Não foi possível remover.");
					}
					break;
				case '5':
					break;
				default:
					System.out.println("Opção inválida redigite. ");
				}
			}catch(ParseException e) {
				System.out.println("Formato inválido!");
			}
			catch (InputMismatchException e) {
				System.out.println("Erro: Insira apenas números inteiros. ");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Até breve. ");
	}
}
