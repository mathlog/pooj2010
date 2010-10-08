//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//
package poo.juegos.reinastorres;

//	Written by Tim Budd, January 1996
//	revised for 1.3 event model July 2001
//
import java.awt.Graphics;

/**
 * Clase que extiende de PiezaAjedrez y representa una Reina
 * 
 * @author José Ángel García Fernández
 * @version 1.0 08/10/2010
 */
public class Reina extends PiezaAjedrez {

	/**
	 * Genera un objeto de tipo Reina haciendo uso del contructor de la clase
	 * Padre
	 * 
	 * @param c
	 *            la columna base
	 * @param n
	 *            la pieza vecina
	 * @param enemigas
	 *            el numero de piezas "enemigas"
	 */
	public Reina(int c, PiezaAjedrez n, int enemigas) {
		super(c, n, enemigas);
	}

	protected boolean puedeAtacar(PiezaAjedrez otra) {
		if (this == otra)// comprueba que no este comparando la misma pieza
			return false;
		int columnaDiferencia = otra.columna - columna;
		if ((fila == otra.fila) || (fila + columnaDiferencia == otra.fila)
				|| (fila - columnaDiferencia == otra.fila))
			return true;// misma fila diagonal sup e inf
		if (vecina != null)// comprobar vecinas
			return vecina.puedeAtacar(otra);
		return false;
	}

	protected void paint(Graphics g) {
		// primero dibuja la vecina vecina
		if (vecina != null)
			vecina.paint(g);
		// despues a ella misna
		// x, y is upper left corner
		int x = (fila - 1) * 50 + 10;
		int y = (columna - 1) * 50 + 40;
		g.drawLine(x + 5, y + 45, x + 45, y + 45);
		g.drawLine(x + 5, y + 45, x + 5, y + 5);
		g.drawLine(x + 45, y + 45, x + 45, y + 5);
		g.drawLine(x + 5, y + 35, x + 45, y + 35);
		g.drawLine(x + 5, y + 5, x + 15, y + 20);
		g.drawLine(x + 15, y + 20, x + 25, y + 5);
		g.drawLine(x + 25, y + 5, x + 35, y + 20);
		g.drawLine(x + 35, y + 20, x + 45, y + 5);
		g.drawOval(x + 20, y + 20, 10, 10);
	}
}
