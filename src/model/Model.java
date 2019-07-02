package model;

import model.dao.Dao;

public class Model {

	private Faculdade faculdade;
	private Dao dao;

	public Model() {
		this.faculdade = new Faculdade();
		this.dao = new Dao(faculdade);
	}

	public void comecaLeituraCSV() {
		dao.comecaLeituraCSV();
	}

	public void comecaEscritaCSV() {
		dao.comecaEscritaCSV();
	}

	public Aluno getAlunoEspecifico(String id) {
		return faculdade.getAlunoEspecifico(id);
	}

	public Curso getCursoEspecifico(String nome, Nivel nivel, int ano) {
		return faculdade.getCursoEspecifico(nome, nivel, ano);
	}

	public Rendimento getRendimentoEspecifico(Aluno aluno, Curso curso) {
		return faculdade.getRendimentoEspecifico(aluno, curso);
	}

	public Aluno escolheAlunoEspecifico(int opcao) {
		return faculdade.escolheAlunoEspecifico(opcao);
	}

	public Curso escolheCursoEspecifico(int opcao) {
		return faculdade.escolheCursoEspecifico(opcao);
	}

	public int getSizeAlunos() {
		return faculdade.getSizeAlunos();
	}

	public int getSizeCursos() {
		return faculdade.getSizeCursos();
	}

	public String processaRelatorioDeAluno(Aluno aluno) {
		return faculdade.processaHistoricoDeAluno(aluno);
	}

	public String processaRelatorioDeCurso(Curso curso) {
		return faculdade.processaHistoricoDeCurso(curso);
	}

	public GradeDeAlunos getAlunos() {
		return faculdade.getAlunos();
	}

	public GradeDeCursos getCursos() {
		return faculdade.getCursos();
	}

	public void removeRendimento(Aluno aluno, Curso curso) {
		faculdade.removeRendimento(aluno, curso);
	}

	public void addAluno(String id, String nome) {
		faculdade.addAluno(id, nome);
	}

	public void addCurso(String nome, Nivel nivel, int ano) {
		faculdade.addCurso(nome, nivel, ano);
	}

	public void addRendimento(Aluno aluno, Curso curso, double np1, double np2, double reposicao, double exame) {
		faculdade.addRendimento(aluno, curso, np1, np2, reposicao, exame);
	}
}
