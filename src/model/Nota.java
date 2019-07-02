package model;

public class Nota {
	private double np1;
	private double np2;
	private double reposicao;
	private double exame;
	private double media;

	Nota(double np1, double np2, double reposicao, double exame) {
		this.np1 = np1;
		this.np2 = np2;
		this.reposicao = reposicao;
		this.exame = exame;
		this.media = calculaMediaInicial();
	}

	public double getNp1() {
		return this.np1;
	}

	public double getNp2() {
		return this.np2;
	}

	public double getReposicao() {
		return this.reposicao;
	}

	public double getExame() {
		return this.exame;
	}

	public double getMedia() {
		return this.media;
	}

	void setMedia(double media) {
		this.media = media;
	}

	double calculaMediaInicial() {
		double np1 = this.np1;
		double np2 = this.np2;
		if (this.reposicao > np1 || this.reposicao > np2) {
			if (np1 < np2) {
				np1 = this.reposicao;
			} else {
				np2 = this.reposicao;
			}
		}
		return (np1 + np2) / 2.0;
	}

	@Override
	public String toString() {
		String res = "";

		res += "Nota da NP1: " + String.format("%.2f", this.np1);
		res += "\nNota da NP2: " + String.format("%.2f", this.np2);
		res += "\nNota da reposição: " + String.format("%.2f", this.reposicao);
		res += "\nNota do exame: " + String.format("%.2f", this.exame);
		res += "\nMédia: " + String.format("%.2f", this.media);

		return res;
	}

}
