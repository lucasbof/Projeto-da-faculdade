package model;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HistoricoDeRendimentos implements Iterable<Rendimento> {

	private Set<Rendimento> rendimentos;

	HistoricoDeRendimentos() {
		this.rendimentos = new TreeSet<>();
	}

	void addRendimento(Aluno aluno, Curso curso, double np1, double np2, double reposicao, double exame) {
		Nota notas = new Nota(np1, np2, reposicao, exame);
		if (curso.getNivel() == Nivel.GRADUACAO) {
			rendimentos.add(new RendimentoGraduacao(aluno, curso, notas));
		} else {
			rendimentos.add(new RendimentoPosGraduacao(aluno, curso, notas));
		}
	}

	Rendimento getRendimentoEspecifico(Aluno aluno, Curso curso) {
		for (Rendimento r : rendimentos) {
			if ((aluno.equals(r.getAluno()) && (curso.equals(r.getCurso())))) {
				return r;
			}
		}
		return null;
	}

	void removeRendimento(Aluno aluno, Curso curso) {
		for (Rendimento r : rendimentos) {
			if ((aluno.equals(r.getAluno()) && (curso.equals(r.getCurso())))) {
				rendimentos.remove(r);
				break;
			}
		}
	}

	@Override
	public Iterator<Rendimento> iterator() {
		return rendimentos.iterator();
	}

}
