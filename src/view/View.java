package view;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.GradeDeAlunos;
import model.GradeDeCursos;
import model.Rendimento;

public class View {

	private Scanner sc = new Scanner(System.in);

	public void menu() {
		System.out.println("\nO que deseja fazer?");
		System.out.println("Digite 1 para - Listar todos os cursos dados");
		System.out.println("Digite 2 para - Listar todos os alunos inscritos");
		System.out.println("Digite 3 para - Listar o hist�rico de um determinado aluno");
		System.out.println("Digite 4 para - Listar o relat�rio de rendimento de um determinado curso");
		System.out.println("Digite 5 para - Incluir um novo aluno");
		System.out.println("Digite 6 para - Incluir um novo curso");
		System.out.println("Digite 7 para - Incluir um novo rendimento");
		System.out.println("Digite 8 para - Sair\n");

	}

	public void listaCursos(GradeDeCursos cursos) {
		System.out.print("\nLista de Cursos:");
		System.out.println(cursos);
	}

	public void listaAlunos(GradeDeAlunos alunos) {
		System.out.print("\nLista de Alunos:");
		System.out.println(alunos);
	}

	public void escolherDeterminadoAluno(GradeDeAlunos alunos, boolean naoEntrouNaNota) {

		if (naoEntrouNaNota)
			System.out.println("\nQuais dos alunos a seguir voc� deseja mais detalhes?");

		System.out.println("\nEscolha a op��o de aluno desejado:\n");
		int i = 1;
		for (Aluno a : alunos) {
			System.out.println("Op��o " + i);
			System.out.println(a + "\n");
			i++;
		}

	}

	public void imprimeRelatorio(String relatorio) {
		System.out.println(relatorio);
	}

	public void escolherDeterminadoCurso(GradeDeCursos cursos, boolean naoEntrouNaNota) {

		if (naoEntrouNaNota)
			System.out.println("\nQuais dos cursos a seguir voc� deseja mais detalhes?");

		System.out.println("\nEscolha a opcao desejada de curso:\n");
		int opcao = 1;
		for (Curso c : cursos) {
			System.out.println("Op��o " + opcao);
			System.out.println(c + "\n");
			opcao++;
		}
	}

	public void incluiAluno(GradeDeAlunos alunos) {
		System.out.println("\nPara incluir um novo aluno, por favor:");
		System.out.println("Escolha o id do novo aluno que seja diferente dos seguintes IDs j� cadastrados:\n");
		for (Aluno a : alunos) {
			System.out.println(a.getId() + "\n");
		}
	}

	public void incluiCurso(GradeDeCursos cursos) {
		System.out.println("\nPara incluir um novo curso, por favor:");
		System.out.print("Escolha a combina��o de nome, nivel e ano para um curso");
		System.out.println(" que seja diferente da combina��o dos seguintes cursos j� cadastrados:");
		for (Curso c : cursos) {
			System.out.println("\n" + c);
		}
		System.out.print("\nSe cadastrar uma das combina��es apresentadas anteriormente,");
		System.out.println(" esta opera��o de cadastro de curso ser� automaticamnete cancelada!\n");
	}

	public void incluiRendimento(int i) {
		if (i == 1) {
			System.out.println("\nPara incluir um novo rendimento, por favor:");
			System.out.println("Escolha um aluno e um curso");
			System.out.println("Se o aluno e o curso escolhido j� tiver um rendimento cadastrado");
			System.out.print("Ser� dado a op��o de continuar o processo para atualizar as atuais notas cadastradas");
			System.out.println(" ou cancelar a opera��o de cadastro de rendimento");
		} else if (i == 2) {
			System.out.println("\nPara cadastrar uma nota, por favor siga as seguintes regras:");
			System.out.println("1 - A nota tem que ser um n�mero entre 0.00 e 10.00");
			System.out.println("2 - Se a nota tiver casas decimais:");
			System.out.println("\t2.1 - Ela ter� que usar o ponto (.) como separador de casas decimais");
			System.out.println("\t2.2 - O n�mero m�ximo de casas decimais permitidas � 2\n");
		}
	}

	public String leString(int opcao) {
		switch (opcao) {
		case 1:
			System.out.print("Digite o numero de uma das op��es mostradas: ");
			break;
		case 2:
			System.out.print("Digite o id do novo aluno: ");
			break;
		case 3:
			System.out.print("Digite o nome do novo aluno: ");
			break;
		case 4:
			System.out.print("Digite o nome do novo curso: ");
			break;
		case 5:
			System.out.println("Escolha 1 - para o nivel GRADUACAO ");
			System.out.println("Escolha 2 - para o nivel POS_GRADUACAO");
			System.out.print("Digite a op��o desejada: ");
			break;
		case 6:
			System.out.print("Digite o ano do novo curso: ");
			break;
		case 7:
			System.out.print("Digite a nota da NP1: ");
			break;
		case 8:
			System.out.print("Digite a nota da NP2: ");
			break;
		case 9:
			System.out.print("Digite a nota da reposi��o: ");
			break;
		case 10:
			System.out.print("Digite a nota do exame: ");
			break;
		}
		String valor = sc.nextLine();
		return valor;
	}

	public void mostraMessagemInclusaoBemSucessedida(int opcao) {
		switch (opcao) {
		case 1:
			System.out.println("\nAluno incluido com sucesso");
			break;
		case 2:
			System.out.println("\nCurso incluido com sucesso");
			break;
		case 3:
			System.out.println("\nRendimento incluido com sucesso");
			break;
		case 4:
			System.out.println("\nAs notas foram substituidas com sucesso para o rendimento escolhido");
			break;
		}
	}

	public void exibeEscolhasRendimento(Aluno aluno, Curso curso, Rendimento rendimento) {

		System.out.println("\nO aluno escolhido foi:");
		System.out.println(aluno);
		System.out.println("\nO curso escolhido foi:");
		System.out.println(curso);
		if (!(rendimento == null)) {
			System.out.println("\nQue possui um rendimento com as seguintes notas:");
			boolean aprovacao = rendimento.defineAprovacao();
			System.out.println(rendimento.getNota());
			if (aprovacao == true) {
				System.out.println("Situ��o: " + "Aprovado");
			} else {
				System.out.println("Situa��o: " + "Reprovado");
			}

		}
	}

	public void exibeMensagemDeErro(int i) {
		switch (i) {
		case -1:
			System.out.println(
					"\nO valor digitado n�o pode ser s� espa�o(s) ou vazio! Por favor, repita a opera��o novamente\n");
			break;

		case -2:
			System.out.println("\nOp��o inv�lida!");
			System.out.println(
					"N�o pode ser qualquer valor fora dos informados! Por favor, repita a opera��o novamente\n");
			break;

		case -3:
			System.out.println("\nO id tem que ser diferentes dos j� cadastrados");
			System.out.println("Por favor, repita a opera��o novamente\n");
			break;

		case -4:
			System.out.println("\nO ano tem que ser um n�mero inteiro e positivo! Por favor, repita a opera��o!\n");
			break;

		case -5:
			System.out.println("\nO valor tem que ser um numero entre 0.00 e 10.00!");
			System.out.println("Qualquer outro valor fora esse informado � considerado inv�lido!");
			System.out.println("Por Favor, repita a opera��o novamente!\n");
			break;

		case -6:
			System.out.println("\nO valor tem que ter at� 2 casas decimais! Por Favor, repita a opera��o novamente\n");
			break;
		case -7:
			System.out.println("\nO aluno e o curso informado j� possui um rendimento cadastrado");
			System.out.println("Se optar por continuar, as notas salvas ser�o substituidas pelas que ser�o informadas");
			System.out.println("O que deseja fazer?");
			System.out.println("Escolha 1 para - Continuar com a opera��o");
			System.out.println("Escolha 2 para - Cancelar a opera��o\n");
			break;
		case -8:
			System.out.println("\nO curso informado j� est� cadastrado!");
			System.out.println("Assim, a opera��o de inclus�o de curso foi cancelada!");
			break;
		}
	}
}
