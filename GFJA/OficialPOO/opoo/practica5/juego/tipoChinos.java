package opoo.practica5.juego;

import java.util.Random;

public enum tipoChinos implements Respuesta {
	CERO, UNA, DOS, TRES;

	private int nMonedas;

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
		tipoChinos aux = (tipoChinos) getEnum((r.nextInt(length())));
		aux.nMonedas = r.nextInt(13);
		return aux;
	}

	public void setNMonedas(int nMonedas) {
		this.nMonedas = nMonedas;
	}

	public int getNMonedas() {
		return nMonedas;
	}

	/*public boolean equals(Object o) {
		if (!(o instanceof Respuesta))
			return false;
		tipoChinos otro = (tipoChinos) o;
		if (nMonedas == otro.nMonedas)
			return true;
		else
			return false;
	}*/
}