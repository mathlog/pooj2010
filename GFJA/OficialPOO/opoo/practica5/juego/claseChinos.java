//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Practica 5, Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

import java.util.Random;

/**
 * Clase que recubre a la enumeracion de chinos
 * 
 * @author Jos� �ngel Garc�a Fern�ndez
 * @version 1.2 11/01/2011
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
		return chino + " n�Coins:" + this.getNMonedas();
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

	public Respuesta getEnum(int a) {
		return new claseChinos(this.nMonedas, enumChinos.values()[a]);
	}

	public int length() {
		return enumChinos.values().length;
	}

	@Override
	public Respuesta rand(int nJugadores) {
		Random r = new Random();
		// se comprueba que la maquina saque una jugada valida
		int supuestoCoins = r.nextInt(4) * nJugadores;
		int chinoAux;
		while ((chinoAux = (r.nextInt(4))) > supuestoCoins);
		claseChinos aux = new claseChinos(supuestoCoins,
				enumChinos.values()[chinoAux]);
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