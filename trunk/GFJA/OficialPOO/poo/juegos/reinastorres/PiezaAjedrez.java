//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica X, Documentacion de ejercicio Y
// ASIGNATURA : Programacion Orientada a Objetos
//
package poo.juegos.reinastorres;

import java.awt.Graphics;

/**
 * Clase
 * 
 * @author José Ángel García Fernández
 * @version 1.0 08/10/2010
 */
public abstract class PiezaAjedrez {

	protected int fila;
	protected int columna;
	protected int enemigas;
	protected PiezaAjedrez vecina;

	// constructor
	PiezaAjedrez(int c, PiezaAjedrez n, int enemigas) {
		fila = 1;
		columna = c;
		vecina = n;
		this.enemigas = enemigas;
	}

	public boolean buscaSolucion() {//manda su pos a todas anteriores
		while (vecina != null && vecina.puedeAtacar(fila, columna))//para recur si null
			if (!avanza())// en fila columna no puedo, avanzo hacia otra pos
				return false; // el avance no ha sido fructifero
		return true;
	}

	public boolean avanza() {
		if (fila < enemigas) { // no ha llegado ultima fila
			fila++; // miro siguiente fila
			return buscaSolucion();
		}
		// this col no puedo, check filas y tmp pruebo a mover otras reinas
		if (vecina != null) {
			if (!vecina.avanza()) // si no avanza vecina no avanzo yo
				return false;
			if (!vecina.buscaSolucion())// vecina avanza,check si todo queda ben
				return false;
		} else
			return false; // no hay vecina es la primera
		fila = 1; // he podio mover resto empiezo de nuevo a comprobar fila
		return buscaSolucion();
	}

	protected abstract boolean puedeAtacar(int testfila, int testcolumna);

	protected abstract void paint(Graphics g);
}
