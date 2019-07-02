package controller;

import model.Aluno;
import model.Curso;
import model.GradeDeAlunos;
import model.GradeDeCursos;
import model.Model;
import model.Nivel;
import model.Rendimento;
import view.View;

public class Controller {

	public void inicia() {
		Model model = new Model();
		View view = new View();
		Validador validador = new Validador();

		model.comecaLeituraCSV();

		GradeDeAlunos alunos = model.getAlunos();
		GradeDeCursos cursos = model.getCursos();

		int opcaoMenuPrincipal = 0;
		boolean continua = true;
		boolean naoEntrouNaNota = true;
		boolean repeteLoop;
		Aluno aluno = null;
		Curso curso = null;

		do {
			//processa opcao do menu principal
			if (naoEntrouNaNota) {
				repeteLoop = true;
				view.menu();
				while (repeteLoop) {
					String input = view.leString(1);
					int res = validador.validaOpcaoEscolha(input, 8);
					if (res < 0) {
						view.exibeMensagemDeErro(res);
					} else {
						repeteLoop = false;
						opcaoMenuPrincipal = res;
					}
				}
			}

			switch (opcaoMenuPrincipal) {
			//Lista todos os cursos dados
			case 1:
				view.listaCursos(cursos);
				break;
			//Lista todos os alunos inscritos
			case 2:
				view.listaAlunos(alunos);
				break;
			//Lista o histórico de um determinado aluno
			case 3:
				repeteLoop = true;
				view.escolherDeterminadoAluno(alunos, naoEntrouNaNota);
				while (repeteLoop) {
					String input = view.leString(1);
					int res = validador.validaOpcaoEscolha(input, model.getSizeAlunos());
					if (res < 0) {
						view.exibeMensagemDeErro(res);
					} else {
						repeteLoop = false;
						aluno = model.escolheAlunoEspecifico(res);
						//verifica se o usuário escolheu a opção 7 (incluir novo rendimento) 
						//ou se apertou a opção 3 direto (Lista o histórico de um determinado aluno)
						if (naoEntrouNaNota) {
							String relatorio = model.processaRelatorioDeAluno(aluno);
							view.imprimeRelatorio(relatorio);
						} else {
							//direciona para a opção 4 (Lista o relatório de rendimento de um determinado curso) para ser feita
							//a escolha do curso
							opcaoMenuPrincipal = 4;
							continue;
						}
					}
				}

				break;
			//Lista o relatório de rendimento de um determinado curso
			case 4:
				repeteLoop = true;
				view.escolherDeterminadoCurso(cursos, naoEntrouNaNota);
				while (repeteLoop) {
					String input = view.leString(1);
					int res = validador.validaOpcaoEscolha(input, model.getSizeCursos());

					if (res < 0) {
						view.exibeMensagemDeErro(res);
						;
					} else {
						repeteLoop = false;
						curso = model.escolheCursoEspecifico(res);
						//verifica se o usuário escolheu a opção 7 (incluir novo rendimento) 
						//ou se apertou a opção 4 direto (Lista o relatório de rendimento de um determinado curso)
						if (naoEntrouNaNota) {
							String relatorio = model.processaRelatorioDeCurso(curso);
							view.imprimeRelatorio(relatorio);
						} else {
							opcaoMenuPrincipal = 7;
							continue;
						}
					}
				}
				break;
			//Inclui um novo aluno
			case 5:
				view.incluiAluno(alunos);
				repeteLoop = true;
				String id = "";
				String nome = "";
				//processa o id do aluno
				while (repeteLoop) {
					String input = view.leString(2);
					input = input.toUpperCase().trim().replaceAll(" ", "");
					int res = validador.validaString(input);
					aluno = model.getAlunoEspecifico(input);
					if (res < 0) {
						view.exibeMensagemDeErro(res);
					} else if (!(aluno == null)) {
						view.exibeMensagemDeErro(-3);
					} else {
						repeteLoop = false;
						id = input;
					}
				}
				//processa o nome do aluno
				repeteLoop = true;
				while (repeteLoop) {
					String input = view.leString(3);
					input = input.toUpperCase().trim();
					while (input.contains("  ")) {
						input = input.replaceAll("  ", " ");
					}
					int res = validador.validaString(input);
					if (res < 0) {
						view.exibeMensagemDeErro(res);
					} else {
						repeteLoop = false;
						nome = input;
					}
				}
				model.addAluno(id, nome);
				aluno = null;
				view.mostraMessagemInclusaoBemSucessedida(1);
				break;
			//Inclui um novo curso
			case 6:
				nome = "";
				Nivel nivel = null;
				int ano = 0;

				repeteLoop = true;

				view.incluiCurso(cursos);
				//processa o nome do curso
				while (repeteLoop) {
					String input = view.leString(4);
					input = input.toUpperCase().trim();
					while (input.contains("  ")) {
						input = input.replaceAll("  ", " ");
					}
					int res = validador.validaString(input);
					if (res < 0) {
						view.exibeMensagemDeErro(res);
					} else {
						repeteLoop = false;
						nome = input;
					}
				}
				//processa o nivel do curso
				repeteLoop = true;
				while (repeteLoop) {
					String input = view.leString(5);
					int res = validador.validaOpcaoEscolha(input, 2);
					if (res < 0) {
						view.exibeMensagemDeErro(res);
					} else {
						repeteLoop = false;
						nivel = Nivel.values()[res - 1];
					}
				}
				//processa o ano do curso
				repeteLoop = true;
				while (repeteLoop) {
					String input = view.leString(6);
					int res = validador.validaAnoCurso(input);
					if (res < 0) {
						view.exibeMensagemDeErro(res);
					} else {
						repeteLoop = false;
						ano = res;
					}
				}

				curso = model.getCursoEspecifico(nome, nivel, ano);

				if (!(curso == null)) {
					view.exibeMensagemDeErro(-8);
				} else {
					model.addCurso(nome, nivel, ano);
					view.mostraMessagemInclusaoBemSucessedida(2);
				}
				curso = null;
				break;
			//inclui um novo rendimento
			case 7:
				if (naoEntrouNaNota) {
					/*primeiramente esse código irá levar até o case 3 (Lista o histórico de um determinado aluno)
					 * para o usuário escolher o aluno e em seguida para o case 4 (Lista o relatório de rendimento de um determinado curso)
					 * para o usuário escolher um curso
					 */
					view.incluiRendimento(1);
					naoEntrouNaNota = false;
					opcaoMenuPrincipal = 3;
					continue;
				}

				Rendimento rendimento = model.getRendimentoEspecifico(aluno, curso);
				view.exibeEscolhasRendimento(aluno, curso, rendimento);
				//verifica se já existe um rendimento cadastrado para o aluno e curso escolhido pelo usuário
				if (!(rendimento == null)) {
					view.exibeMensagemDeErro(-7);
					repeteLoop = true;
					int res = 0;
					while (repeteLoop) {
						String opcao = view.leString(1);
						res = validador.validaOpcaoEscolha(opcao, 2);
						if (res < 0) {
							view.exibeMensagemDeErro(res);
						} else {
							repeteLoop = false;
						}
					}
					if (res == 1) {
						model.removeRendimento(aluno, curso);
					} else {
						naoEntrouNaNota = true;
						aluno = null;
						curso = null;
						continue;
					}

				}

				double np1 = 0.0;
				double np2 = 0.0;
				double reposicao = 0.0;
				double exame = 0.0;

				view.incluiRendimento(2);
				for (int i = 7; i <= 10; i++) {
					repeteLoop = true;
					while (repeteLoop) {
						String input = view.leString(i);
						int res = validador.validaNota(input);
						if (res < 0) {
							view.exibeMensagemDeErro(res);
						} else {
							repeteLoop = false;
							switch (i) {
							case 7:
								np1 = Double.parseDouble(input);
								break;
							case 8:
								np2 = Double.parseDouble(input);
								break;
							case 9:
								reposicao = Double.parseDouble(input);
								break;
							case 10:
								exame = Double.parseDouble(input);
								break;
							}
						}
					}
				}
				naoEntrouNaNota = true;
				model.addRendimento(aluno, curso, np1, np2, reposicao, exame);
				if (rendimento == null) {
					view.mostraMessagemInclusaoBemSucessedida(3);
				} else {
					view.mostraMessagemInclusaoBemSucessedida(4);
				}
				aluno = null;
				curso = null;
				break;
			//encerra o programa
			case 8:
				model.comecaEscritaCSV();
				System.exit(0);
				break;
			}

		} while (continua);
	}
}
