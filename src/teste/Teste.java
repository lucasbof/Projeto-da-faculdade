package teste;

import java.util.Locale;

import controller.Controller;

public class Teste {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Controller controller = new Controller();

		controller.inicia();
	}

}
