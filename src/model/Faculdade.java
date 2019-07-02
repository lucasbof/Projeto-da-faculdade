package model;

public class Faculdade {
	private GradeDeAlunos alunos;
	private GradeDeCursos cursos;
	private HistoricoDeRendimentos rendimentos;
	private HistoricoDeAluno historicoDeAluno;
	private HistoricoDeCurso historicoDeCurso;

	Faculdade() {
		this.alunos = new GradeDeAlunos();
		this.cursos = new GradeDeCursos();
		this.rendimentos = new HistoricoDeRendimentos();
		this.historicoDeAluno = new HistoricoDeAluno(alunos, rendimentos);
		this.historicoDeCurso = new HistoricoDeCurso(cursos, rendimentos);
	}

	public Aluno escolheAlunoEspecifico(int opcao) {
		return alunos.escolheAlunoEspecifico(opcao);
	}

	public Curso escolheCursoEspecifico(int opcao) {
		return cursos.escolheCursoEspecifico(opcao);
	}

	public Aluno getAlunoEspecifico(String id) {
		return alunos.getAlunoEspecifico(id);
	}

	public Curso getCursoEspecifico(String nome, Nivel nivel, int ano) {
		return cursos.getCursoEspecifico(nome, nivel, ano);
	}

	public Rendimento getRendimentoEspecifico(Aluno aluno, Curso curso) {
		return rendimentos.getRendimentoEspecifico(aluno, curso);
	}

	public int getSizeAlunos() {
		return alunos.getSizeAlunos();
	}

	public int getSizeCursos() {
		return cursos.getSizeCursos();
	}

	public String processaHistoricoDeAluno(Aluno aluno) {
		return historicoDeAluno.processaHistoricoDeAluno(aluno);
	}

	public String processaHistoricoDeCurso(Curso curso) {
		return historicoDeCurso.processaHistoricoDeCurso(curso);
	}

	public GradeDeAlunos getAlunos() {
		return alunos;
	}

	public GradeDeCursos getCursos() {
		return cursos;
	}

	public HistoricoDeRendimentos getRendimentos() {
		return rendimentos;
	}

	public void removeRendimento(Aluno aluno, Curso curso) {
		rendimentos.removeRendimento(aluno, curso);
	}

	public void addAluno(String id, String nome) {
		alunos.addAluno(id, nome);
	}

	public void addCurso(String nome, Nivel nivel, int ano) {
		cursos.addCurso(nome, nivel, ano);
	}

	public void addRendimento(Aluno aluno, Curso curso, double np1, double np2, double reposicao, double exame) {
		rendimentos.addRendimento(aluno, curso, np1, np2, reposicao, exame);
	}

}
