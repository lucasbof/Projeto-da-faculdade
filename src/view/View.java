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
		System.out.println("Digite 3 para - Listar o histórico de um determinado aluno");
		System.out.println("Digite 4 para - Listar o relatório de rendimento de um determinado curso");
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
			System.out.println("\nQuais dos alunos a seguir você deseja mais detalhes?");

		System.out.println("\nEscolha a opção de aluno desejado:\n");
		int i = 1;
		for (Aluno a : alunos) {
			System.out.println("Opção " + i);
			System.out.println(a + "\n");
			i++;
		}

	}

	public void imprimeRelatorio(String relatorio) {
		System.out.println(relatorio);
	}

	public void escolherDeterminadoCurso(GradeDeCursos cursos, boolean naoEntrouNaNota) {

		if (naoEntrouNaNota)
			System.out.println("\nQuais dos cursos a seguir você deseja mais detalhes?");

		System.out.println("\nEscolha a opcao desejada de curso:\n");
		int opcao = 1;
		for (Curso c : cursos) {
			System.out.println("Opção " + opcao);
			System.out.println(c + "\n");
			opcao++;
		}
	}

	public void incluiAluno(GradeDeAlunos alunos) {
		System.out.println("\nPara incluir um novo aluno, por favor:");
		System.out.println("Escolha o id do novo aluno que seja diferente dos seguintes IDs já cadastrados:\n");
		for (Aluno a : alunos) {
			System.out.println(a.getId() + "\n");
		}
	}

	public void incluiCurso(GradeDeCursos cursos) {
		System.out.println("\nPara incluir um novo curso, por favor:");
		System.out.print("Escolha a combinação de nome, nivel e ano para um curso");
		System.out.println(" que seja diferente da combinação dos seguintes cursos já cadastrados:");
		for (Curso c : cursos) {
			System.out.println("\n" + c);
		}
		System.out.print("\nSe cadastrar uma das combinações apresentadas anteriormente,");
		System.out.println(" esta operação de cadastro de curso será automaticamnete cancelada!\n");
	}

	public void incluiRendimento(int i) {
		if (i == 1) {
			System.out.println("\nPara incluir um novo rendimento, por favor:");
			System.out.println("Escolha um aluno e um curso");
			System.out.println("Se o aluno e o curso escolhido já tiver um rendimento cadastrado");
			System.out.print("Será dado a opção de continuar o processo para atualizar as atuais notas cadastradas");
			System.out.println(" ou cancelar a operação de cadastro de rendimento");
		} else if (i == 2) {
			System.out.println("\nPara cadastrar uma nota, por favor siga as seguintes regras:");
			System.out.println("1 - A nota tem que ser um número entre 0.00 e 10.00");
			System.out.println("2 - Se a nota tiver casas decimais:");
			System.out.println("\t2.1 - Ela terá que usar o ponto (.) como separador de casas decimais");
			System.out.println("\t2.2 - O número máximo de casas decimais permitidas é 2\n");
		}
	}

	public String leString(int opcao) {
		switch (opcao) {
		case 1:
			System.out.print("Digite o numero de uma das opções mostradas: ");
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
			System.out.print("Digite a opção desejada: ");
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
			System.out.print("Digite a nota da reposição: ");
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
				System.out.println("Situção: " + "Aprovado");
			} else {
				System.out.println("Situação: " + "Reprovado");
			}

		}
	}

	public void exibeMensagemDeErro(int i) {
		switch (i) {
		case -1:
			System.out.println(
					"\nO valor digitado não pode ser só espaço(s) ou vazio! Por favor, repita a operação novamente\n");
			break;

		case -2:
			System.out.println("\nOpção inválida!");
			System.out.println(
					"Não pode ser qualquer valor fora dos informados! Por favor, repita a operação novamente\n");
			break;

		case -3:
			System.out.println("\nO id tem que ser diferentes dos já cadastrados");
			System.out.println("Por favor, repita a operação novamente\n");
			break;

		case -4:
			System.out.println("\nO ano tem que ser um número inteiro e positivo! Por favor, repita a operação!\n");
			break;

		case -5:
			System.out.println("\nO valor tem que ser um numero entre 0.00 e 10.00!");
			System.out.println("Qualquer outro valor fora esse informado é considerado inválido!");
			System.out.println("Por Favor, repita a operação novamente!\n");
			break;

		case -6:
			System.out.println("\nO valor tem que ter até 2 casas decimais! Por Favor, repita a operação novamente\n");
			break;
		case -7:
			System.out.println("\nO aluno e o curso informado já possui um rendimento cadastrado");
			System.out.println("Se optar por continuar, as notas salvas serão substituidas pelas que serão informadas");
			System.out.println("O que deseja fazer?");
			System.out.println("Escolha 1 para - Continuar com a operação");
			System.out.println("Escolha 2 para - Cancelar a operação\n");
			break;
		case -8:
			System.out.println("\nO curso informado já está cadastrado!");
			System.out.println("Assim, a operação de inclusão de curso foi cancelada!");
			break;
		}
	}
}
