package opoo.practica5.juego;

import java.util.Random;

public enum enumPPT implements Respuesta {
	PIEDRA, PAPEL, TIJERA;

	public Respuesta getEnum(int a) {
		return values()[a];
	}

	public int length() {
		return values().length;
	}

	@Override
	public Respuesta rand(int nJugadores) {
		Random r = new Random();
		enumPPT aux = (enumPPT) getEnum((r.nextInt(length())));
		return aux;
	}
}
