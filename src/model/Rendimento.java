package model;

public abstract class Rendimento implements Comparable<Rendimento> {
	private Aluno aluno;
	private Curso curso;
	private Nota nota;

	Rendimento(Aluno aluno, Curso curso, Nota nota) {
		this.aluno = aluno;
		this.curso = curso;
		this.nota = nota;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public Nota getNota() {
		return nota;
	}

	@Override
	public boolean equals(Object outroObjeto) {

		if (this == outroObjeto)
			return true;

		if (outroObjeto == null || !(outroObjeto instanceof Rendimento))
			return false;

		Rendimento outroRendimento = (Rendimento) outroObjeto;

		return (this.aluno.equals(outroRendimento.getAluno()) && this.curso.equals(outroRendimento.getCurso()));

	}

	@Override
	public int compareTo(Rendimento outroRendimento) {
		if (!(this.aluno.equals(outroRendimento.getAluno()))) {
			return aluno.compareTo(outroRendimento.getAluno());
		}
		return curso.compareTo(outroRendimento.getCurso());
	}

	public abstract boolean defineAprovacao();
}
