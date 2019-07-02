package model;

public class Aluno implements Comparable<Aluno> {
	private String id;
	private String nome;

	Aluno(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public boolean equals(Object outroObjeto) {

		if (this == outroObjeto)
			return true;

		if (outroObjeto == null || !(outroObjeto instanceof Aluno))
			return false;

		Aluno outroAluno = (Aluno) outroObjeto;

		return (this.id.equals(outroAluno.id));

	}

	@Override
	public int compareTo(Aluno outroAluno) {
		return this.id.compareTo(outroAluno.id);
	}

	@Override
	public String toString() {
		String res = "";

		res += "ID: " + this.id;
		res += "\nNome: " + this.nome;
		return res;
	}

}
