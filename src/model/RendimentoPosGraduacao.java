package model;

public class RendimentoPosGraduacao extends Rendimento {

	RendimentoPosGraduacao(Aluno aluno, Curso curso, Nota nota) {
		super(aluno, curso, nota);
	}

	@Override
	public boolean defineAprovacao() {

		double mediaInicial = getNota().getMedia();

		if (mediaInicial >= 5.0) {
			return true;
		} else {
			double mediaFinal = (mediaInicial + getNota().getExame()) / 2.0;
			if (mediaFinal >= 5.0) {
				getNota().setMedia(mediaFinal);
				return true;
			} else {
				getNota().setMedia(mediaFinal);
				return false;
			}
		}
	}
}
