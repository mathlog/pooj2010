package opoo.practica5.juego;

import java.util.Random;

public enum tipoPPT implements Respuesta {
	PIEDRA, PAPEL, TIJERA;

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
		tipoPPT aux=(tipoPPT) getEnum((r.nextInt(length())));
		return aux;
	}
}
