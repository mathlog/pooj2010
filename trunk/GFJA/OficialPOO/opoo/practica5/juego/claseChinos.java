//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

import java.util.Random;

/**
 * Clase que recubre a la enumeracion de chinos
 * 
 * @author José Ángel García Fernández
 * @version 1.1 05/12/2010
 */
public class claseChinos implements Respuesta {

	private int nMonedas;

	private enumChinos chino;

	public claseChinos(int nMonedas, enumChinos tce) {
		this.nMonedas = nMonedas;
		chino = tce;
	}

	public claseChinos(enumChinos tce) {
		this(0, tce);
	}

	@Override
	public String toString() {
		return chino + " nºCoins:" + this.getNMonedas();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof claseChinos))
			return false;
		claseChinos cc = (claseChinos) o;
		if (cc.nMonedas == this.nMonedas)
			return true;
		else
			return false;
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

	public int ordinal() {
		return chino.ordinal();
	}

	public int getNMonedas() {
		return nMonedas;
	}

	public void setNMonedas(int nMonedas) {
		this.nMonedas = nMonedas;
	}
}