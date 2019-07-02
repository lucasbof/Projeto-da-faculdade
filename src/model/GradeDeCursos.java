package model;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GradeDeCursos implements Iterable<Curso> {

	private Set<Curso> cursos;

	GradeDeCursos() {
		this.cursos = new TreeSet<>();
	}

	void addCurso(String nome, Nivel nivel, int ano) {
		Curso curso = new Curso(nome, nivel, ano);
		cursos.add(curso);
	}

	int getSizeCursos() {
		return cursos.size();
	}

	Curso getCursoEspecifico(String nome, Nivel nivel, int ano) {
		Curso curso = new Curso(nome, nivel, ano);
		for (Curso c : cursos) {
			if (c.equals(curso)) {
				return c;
			}
		}
		return null;
	}

	Curso escolheCursoEspecifico(int opcao) {
		int i = 0;
		for (Curso c : cursos) {
			i++;
			if (i == opcao) {
				return c;
			}
		}
		return null;
	}

	@Override
	public Iterator<Curso> iterator() {
		return cursos.iterator();
	}

	@Override
	public String toString() {
		String res = "";
		for (Curso c : cursos) {
			res += "\n\n" + c;
		}
		return res;
	}

}
