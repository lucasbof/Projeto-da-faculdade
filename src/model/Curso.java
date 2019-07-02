package model;

public class Curso implements Comparable<Curso> {
	private String nome;
	private Nivel nivel;
	private int ano;

	Curso(String nome, Nivel nivel, int ano) {
		this.nome = nome;
		this.nivel = nivel;
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public int getAno() {
		return ano;
	}

	@Override
	public boolean equals(Object outroObjeto) {

		if (this == outroObjeto)
			return true;

		if (outroObjeto == null || !(outroObjeto instanceof Curso))
			return false;

		Curso outroCurso = (Curso) outroObjeto;

		return (this.nome.equals(outroCurso.nome) && this.nivel == outroCurso.nivel && this.ano == outroCurso.ano);

	}

	@Override
	public int compareTo(Curso outroCurso) {
		if (!(this.ano == outroCurso.getAno())) {
			return Integer.compare(this.ano, outroCurso.ano);
		} else if (!(this.nivel.equals(outroCurso.nivel))) {
			return this.nivel.compareTo(outroCurso.nivel);
		}
		return this.nome.compareTo(outroCurso.nome);
	}

	@Override
	public String toString() {
		String res = "";
		res += "Nome do Curso: " + this.nome;
		res += "\nNível: " + this.nivel;
		res += "\nAno: " + this.ano;

		return res;
	}

}
