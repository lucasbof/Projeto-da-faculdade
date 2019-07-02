package model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HistoricoDeCurso {

	private Map<Curso, Set<Rendimento>> inscritos;
	private GradeDeCursos cursos;
	private HistoricoDeRendimentos rendimentos;

	HistoricoDeCurso(GradeDeCursos cursos, HistoricoDeRendimentos rendimentos) {
		this.inscritos = new TreeMap<>();
		this.cursos = cursos;
		this.rendimentos = rendimentos;
	}

	private void carregaInscritosPorCurso() {
		for (Curso c : cursos) {
			Set<Rendimento> rend = new TreeSet<>();
			for (Rendimento r : rendimentos) {
				if (r.getCurso().equals(c)) {
					rend.add(r);
				}
			}
			inscritos.put(c, rend);
		}
	}

	String processaHistoricoDeCurso(Curso curso) {
		carregaInscritosPorCurso();
		String res = "";
		res += "\nDados do Curso:\n" + curso;
		if (inscritos.get(curso).isEmpty()) {
			res += "\n\nO Curso está com nenhum estudante matriculado!";
		} else {
			for (Rendimento r : inscritos.get(curso)) {
				boolean aprovacao = r.defineAprovacao();
				res += "\n\nDados do aluno inscrito:\n" + r.getAluno();
				res += "\n\nDados das Notas do Aluno relativas ao curso:\n" + r.getNota() + "\n";
				if (aprovacao == true) {
					res += "Situção: " + "Aprovado";
				} else {
					res += "Situação: " + "Reprovado";
				}
			}
		}
		return res;
	}

}
