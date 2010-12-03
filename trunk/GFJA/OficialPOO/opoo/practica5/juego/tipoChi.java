package opoo.practica5.juego;

import java.util.Random;

public enum tipoChi implements Respuesta {
	CERO, UNA, DOS, TRES;

	@Override
	public Respuesta getEnum(int a) {
		return values()[a];
	}

	@Override
	public int length() {
		return values().length;
	}

	public Respuesta rand() {
		Random r = new Random();
		return getEnum((r.nextInt() % length()));
	}
}