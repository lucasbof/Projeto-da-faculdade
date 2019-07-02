package model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HistoricoDeAluno {
	private Map<Aluno, Set<Rendimento>> inscritos;
	private GradeDeAlunos alunos;
	private HistoricoDeRendimentos rendimentos;

	HistoricoDeAluno(GradeDeAlunos alunos, HistoricoDeRendimentos rendimentos) {
		this.inscritos = new TreeMap<>();
		this.alunos = alunos;
		this.rendimentos = rendimentos;
	}

	private void carregaHistoricoDeAluno() {
		for (Aluno a : alunos) {
			Set<Rendimento> rend = new TreeSet<>();
			for (Rendimento r : rendimentos) {
				if (r.getAluno().equals(a)) {
					rend.add(r);
				}
			}
			inscritos.put(a, rend);
		}
	}

	String processaHistoricoDeAluno(Aluno aluno) {
		carregaHistoricoDeAluno();
		String res = "";
		res += "\nDados do Aluno:\n" + aluno;
		if (inscritos.get(aluno).isEmpty()) {
			res += "\n\nO aluno está inscrito em nenhum curso!";
		} else {
			for (Rendimento r : inscritos.get(aluno)) {
				if (r.getAluno().equals(aluno)) {
					boolean aprovacao = r.defineAprovacao();
					res += "\n\nDados do curso inscrito:\n" + r.getCurso();
					res += "\n\nDados das Notas do Aluno relativas ao curso:\n" + r.getNota() + "\n";
					if (aprovacao == true) {
						res += "Situção: " + "Aprovado";
					} else {
						res += "Situação: " + "Reprovado";
					}
				}
			}
		}
		return res;
	}
}
