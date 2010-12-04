package opoo.practica5.juego;

import java.util.Random;

public enum enumPN implements Respuesta {
	PARES, NONES;

	@Override
	public Respuesta getEnum(int a) {
		return values()[a];
	}

	@Override
	public int length() {
		return values().length;
	}

	@Override
	public Respuesta rand() {
		Random r = new Random();
		return getEnum((r.nextInt() % length()));
	}
}
