//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PROYECTO : Practica 4 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.base;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase abstracta que representa una baraja
 * 
 * @author Jos� �ngel Garc�a Fern�ndez
 * @version 1.2 12/11/2010
 */
public abstract class Baraja {

	/**
	 * Variable privada que representa el nombre de la baraja
	 */
	protected String nombreBaraja;

	/**
	 * Array privado de elementos tipo carta que representa las cartas de la
	 * baraja
	 */
	protected Carta[] cartas;

	/**
	 * Variable que repreenta el tipo de baraja
	 */
	protected tipoBaraja tipo;

	/**
	 * Representa los palos de la baraja
	 */
	protected String[] palos;

	/**
	 * Metodo de acceso de la propiedad cartas
	 * 
	 * @return devuelve el array de cartas de la baraja
	 */
	public Carta[] getCartas() {
		return cartas;
	}

	/**
	 * Genera un objeto Baraja en funcion de tipo
	 * 
	 * @param tipo
	 *            el tipo de baraja
	 */
	public Baraja(tipoBaraja tipo) {
		this.tipo = tipo;
		creaPalos();
		creaBaraja();
	}

	/**
	 * Metodo abstracto que crea la baraja
	 */
	protected abstract void creaBaraja();

	/**
	 * Metodo abstracto que crea el string[] de palos
	 */
	protected abstract void creaPalos();

	/**
	 * Metodo toString para mostrar por pantalla
	 * 
	 * @return devuelve la baraja por pantalla
	 */
	public String toString() {
		String baraja = "";
		for (int i = 0; i < cartas.length; i++) {
			baraja += cartas[i] + " ";
		}
		return baraja;
	}

	/**
	 * Metodo que baraja las cartas
	 * 
	 * @param nIter
	 *            parametro que indica cuantas iteraciones se realizaran
	 * 
	 */
	public void barajar(int nIter) {

		Random rand = new Random();
		for (int i = 0; i < nIter; i++) {
			int x = rand.nextInt(40);
			int y = rand.nextInt(40);

			Carta swap = cartas[x];
			cartas[x] = cartas[y];
			cartas[y] = swap;
		}
	}

	/**
	 * Metodo que ordena la baraja
	 */
	public void ordenar() {
		Arrays.sort(cartas);
	}
}
