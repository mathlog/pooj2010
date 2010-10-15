//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.juegos.reinastorres;

import java.awt.Graphics;

/**
 * Clase abtracta que representa una pieza de ajedrez
 * 
 * @author José Ángel García Fernández
 * @version 1.0 08/10/2010
 */
public abstract class PiezaAjedrez {

	/**
	 * Propiedad que indica en que fila se encuentra la pieza
	 */
	protected int fila;
	/**
	 * Propiedad que indica en que columna se encuentra la pieza
	 */
	protected int columna;
	/**
	 * Propiedad que indica el numero de piezas enemigas
	 */
	protected int enemigas;
	/**
	 * Propiedad que indica la pieza vecina
	 */
	protected PiezaAjedrez vecina;

	/**
	 * Genera un objeto de tipo PiezaAjedrez
	 * 
	 * @param c
	 *            la columna base
	 * @param n
	 *            la pieza vecina
	 * @param enemigas
	 *            el numero de piezas "enemigas"
	 */
	public PiezaAjedrez(int c, PiezaAjedrez n, int enemigas) {
		fila = 1;
		columna = c;
		vecina = n;
		this.enemigas = enemigas;
	}

	/**
	 * Metodo que busca solucion para la colocacion de la pieza
	 * 
	 * @return true si se ha podido colocar, false en caso contrario
	 */
	public boolean buscaSolucion() {
		while (vecina != null
				&& (vecina.puedeAtacar(this) || puedeAtacar(vecina)))
			if (!avanza())
				return false;
		return true;
	}

	/**
	 * Metodo que hace avanzar la pieza
	 * 
	 * @return true si se ha podido avanzar false en caso contrario
	 */
	public boolean avanza() {
		if (fila < enemigas) {
			fila++; // miro siguiente fila
			return buscaSolucion();
		}
		if (vecina != null) {// miro mover vecinas
			if (!vecina.avanza())
				return false;
			if (!vecina.buscaSolucion())
				return false;
		} else
			return false;
		fila = 1;
		return buscaSolucion();
	}

	/**
	 * Metodo abstracto que comprueba si una pieza puede atacar a otra
	 * 
	 * @param testfila
	 *            la fila a comprobar
	 * @param testcolumna
	 *            la columna a comprobar
	 * @return devuelve si puede o no atacar
	 */
	protected abstract boolean puedeAtacar(PiezaAjedrez otra);

	/**
	 * Metodo abstracto para pintar la pieza
	 * 
	 * @param g
	 */
	protected abstract void paint(Graphics g);
}
