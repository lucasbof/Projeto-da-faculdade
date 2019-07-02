package model.dao;

import model.Faculdade;

public class Dao {
	private LeEEscreveCSVAluno aluno;
	private LeEEscreveCSVCurso curso;
	private LeEEscreveCSVNotas notas;
	
	public Dao(Faculdade faculdade){
		this.aluno = new LeEEscreveCSVAluno(faculdade);
		this.curso = new LeEEscreveCSVCurso(faculdade);
		this.notas = new LeEEscreveCSVNotas(faculdade);
	}
	
	public void comecaLeituraCSV() {
		aluno.leCSVAluno();
		curso.leCSVCursos();
		notas.leCSVNotas();
	}
	
	public void comecaEscritaCSV() {
		aluno.escreveCSVAluno();
		curso.escreveCSVCurso();
		notas.escreveCSVNotas();
	}
	
	
}
