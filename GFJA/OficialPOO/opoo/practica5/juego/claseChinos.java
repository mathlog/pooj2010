package opoo.practica5.juego;

import java.util.Random;

public class claseChinos implements Respuesta {

	private int nMonedas;

	private enumChinos chino;

	public claseChinos(enumChinos tce) {
		this(0, tce);
	}

	public claseChinos(int nMonedas, enumChinos tce) {
		this.nMonedas = nMonedas;
		chino = tce;
	}

	@Override
	public String toString() {
		return chino + " nºCoins:" + this.getNMonedas();
	}

	public boolean equals(Object o) {
		if (!(o instanceof claseChinos))
			return false;
		claseChinos cc = (claseChinos) o;
		if (cc.nMonedas == this.nMonedas)
			return true;
		else
			return false;
	}

	/**
	 * Devuelve el numero de la enumeracion
	 * 
	 * @return el numero de orden de la enumeracion
	 */
	public int ordinal() {
		return chino.ordinal();
	}

	@Override
	public Respuesta getEnum(int a) {
		return new claseChinos(this.nMonedas, enumChinos.values()[a]);
	}

	@Override
	public int length() {
		return enumChinos.values().length;
	}

	@Override
	public Respuesta rand() {
		Random r = new Random();
		claseChinos aux = new claseChinos(r.nextInt(13), enumChinos.values()[r
				.nextInt(length())]);
		return aux;
	}

	public int getNMonedas() {
		return nMonedas;
	}

	public void setNMonedas(int nMonedas) {
		this.nMonedas = nMonedas;
	}
}