package aplicacao;

import java.text.ParseException;

import ui.Menu;

public class Main {
	public static void main(String[] args) throws ParseException {
		/*Operacoes op = new Operacoes();
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		List<Pessoa> pessoas = new ArrayList<>();
		Date d = sdf.parse("12/12/2021");
		Pessoa p1 = new Pessoa("pedro", "12312312", d);
		d = sdf.parse("04/06/2021");
		Aluno a1 = new Aluno("Vitória", "12321231", d, 9.2);
		pessoas.add(a1);
		pessoas.add(p1);
		
		for(Pessoa p : pessoas) {
			System.out.println(p);
		}
		d = sdf.parse("03/06/2024");
		op.criar(a1);
		op.criar(p1);
		op.atualizarNotaFinal("vitória", 0.0);
		for(Pessoa p : op.mostrarTudo()) {
			System.out.println(p);
		}*/
		
		Menu menu = new Menu();
		menu.executa();
	}
}
