package controller;

import controller.exceptions.CasasDecimaisException;
import controller.exceptions.StringVaziaException;

public class Validador {
	int validaOpcaoEscolha(String opcao, int tamanho) {
		int opcaoTeste = 0;
		try {
			if (opcao.trim().isEmpty()) {
				throw new StringVaziaException();
			}
			opcaoTeste = Integer.parseInt(opcao);

			if (!(opcaoTeste >= 1 && opcaoTeste <= tamanho)) {
				throw new NumberFormatException();
			}
		} catch (StringVaziaException e) {
			return -1;
		} catch (NumberFormatException e) {
			return -2;
		}

		return opcaoTeste;
	}

	int validaString(String string) {
		try {
			if (string.trim().isEmpty()) {
				throw new StringVaziaException();
			}
		} catch (StringVaziaException e) {
			return -1;
		}
		return 0;
	}

	int validaAnoCurso(String input) {
		int ano = 0;
		try {
			if (input.trim().isEmpty()) {
				throw new StringVaziaException();
			}
			ano = Integer.parseInt(input);

			if (ano < 0) {
				throw new NumberFormatException();
			}
		} catch (StringVaziaException e) {
			return -1;
		} catch (NumberFormatException e) {
			return -4;
		}
		return ano;
	}

	int validaNota(String input) {
		double valor = 0.0;
		try {
			if (input.trim().isEmpty()) {
				throw new StringVaziaException();
			}
			valor = Double.parseDouble(input);

			String[] divisor = Double.toString(valor).split("\\.");
			int decimais = divisor[1].length();

			if (!((valor >= 0.00) && (valor <= 10.00))) {
				throw new NumberFormatException();
			} else if (decimais > 2) {
				throw new CasasDecimaisException();
			}
		} catch (StringVaziaException e) {
			return -1;
		} catch (NumberFormatException e) {
			return -5;
		} catch (CasasDecimaisException e) {
			return -6;
		}
		return 0;
	}

}
