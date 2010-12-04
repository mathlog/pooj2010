package opoo.practica5.juego;

import java.util.Random;

public enum enumPPT implements Respuesta {
	PIEDRA, PAPEL, TIJERA;

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
		enumPPT aux = (enumPPT) getEnum((r.nextInt(length())));
		return aux;
	}
}
