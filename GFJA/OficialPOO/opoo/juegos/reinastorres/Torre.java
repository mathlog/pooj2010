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
 * Clase que extiende de PiezaAjedrez y representa una Torre
 * 
 * @author José Ángel García Fernández
 * @version 1.0 08/10/2010
 */
public class Torre extends PiezaAjedrez {

	/**
	 * Genera un objeto de tipo Torre haciendo uso del contructor de la clase
	 * Padre
	 * 
	 * @param c
	 *            la columna base
	 * @param n
	 *            la pieza vecina
	 * @param enemigas
	 *            el numero de piezas "enemigas"
	 */
	public Torre(int c, PiezaAjedrez n, int enemigas) {
		super(c, n, enemigas);
	}

	@Override
	protected boolean puedeAtacar(PiezaAjedrez otra) {
		if (this == otra)// comprueba que no este comparando la misma pieza
			return false;
		if ((fila == otra.fila) || (columna == otra.columna))
			return true; // misma fila o misma columna
		if (vecina != null)// comprobar vecinas
			return vecina.puedeAtacar(otra);
		return false;
	}

	@Override
	protected void paint(Graphics g) {
		// primero dibuja la vecina vecina
		if (vecina != null)
			vecina.paint(g);
		// despues a ella misna
		// x, y is upper left corner
		int x = (fila - 1) * 50 + 10;
		int y = (columna - 1) * 50 + 40;
		g.drawLine(x + 5, y + 45, x + 45, y + 45);// horizontalinferior
		g.drawLine(x + 5, y + 40, x + 45, y + 40);// horizontalbajo
		g.drawLine(x + 5, y + 45, x + 5, y + 40);// verticalbajoizq
		g.drawLine(x + 45, y + 40, x + 45, y + 45);// verticalbajoder
		g.drawLine(x + 5, y + 40, x + 10, y + 30);// diagonalbajaizq
		g.drawLine(x + 40, y + 30, x + 45, y + 40);// diagonalbajader
		g.drawLine(x + 10, y + 30, x + 10, y + 20);// verticalizqmedia
		g.drawLine(x + 40, y + 30, x + 40, y + 20);// verticaldermedia
		g.drawLine(x + 10, y + 20, x + 40, y + 20);// horizontalmedia
		g.drawLine(x + 10, y + 20, x + 5, y + 10);// diagoizqup
		g.drawLine(x + 40, y + 20, x + 45, y + 10);// diagoderup
		g.drawLine(x + 5, y + 10, x + 5, y + 5);// verticalizqup
		g.drawLine(x + 45, y + 10, x + 45, y + 5);// verticalderup
		g.drawLine(x + 40, y + 5, x + 45, y + 5);// horiderup
		g.drawLine(x + 5, y + 5, x + 10, y + 5);// horiizqup
		g.drawLine(x + 20, y + 5, x + 30, y + 5);// horimedup
		g.drawLine(x + 10, y + 5, x + 10, y + 10);// vert1
		g.drawLine(x + 20, y + 5, x + 20, y + 10);// vert2
		g.drawLine(x + 30, y + 5, x + 30, y + 10);// vert3
		g.drawLine(x + 40, y + 5, x + 40, y + 10);// vert4
		g.drawLine(x + 10, y + 10, x + 20, y + 10);// hori1
		g.drawLine(x + 30, y + 10, x + 40, y + 10);// hori2
	}

}
