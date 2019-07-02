package model;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GradeDeAlunos implements Iterable<Aluno> {

	private Set<Aluno> alunos;

	GradeDeAlunos() {
		this.alunos = new TreeSet<>();
	}

	void addAluno(String id, String nome) {
		Aluno aluno = new Aluno(id, nome);
		alunos.add(aluno);
	}

	int getSizeAlunos() {
		return alunos.size();
	}

	Aluno getAlunoEspecifico(String id) {
		for (Aluno a : alunos) {
			if (a.getId().compareTo(id) == 0) {
				return a;
			}
		}
		return null;
	}

	Aluno escolheAlunoEspecifico(int opcao) {
		int i = 0;
		for (Aluno a : alunos) {
			i++;
			if (i == opcao) {
				return a;
			}
		}
		return null;
	}

	@Override
	public Iterator<Aluno> iterator() {
		return alunos.iterator();
	}

	@Override
	public String toString() {
		String res = "";
		for (Aluno a : alunos) {
			res += "\n\n" + a;
		}
		return res;
	}
}
