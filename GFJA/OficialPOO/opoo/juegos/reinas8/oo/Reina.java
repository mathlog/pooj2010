package opoo.juegos.reinas8.oo;

//	Eight Reinas puzzle written in Java
//	Written by Tim Budd, January 1996
//	revised for 1.3 event model July 2001
//
import java.awt.Graphics;

public class Reina {
	// datos
	private int fila;
	private int columna;
	private Reina vecina;
	private int enemigas;

	// constructor
	Reina(int c, Reina n, int enemigas) {
		fila = 1;
		columna = c;
		vecina = n;
		this.enemigas = enemigas;
	}

	public boolean buscaSolucion() {
		while (vecina != null && vecina.puedeAtacar(fila, columna))
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
			return false; // no hay vecina
		fila = 1; // he podio mover resto empiezo de nuevo a comprobar fila
		return buscaSolucion();
	}

	private boolean puedeAtacar(int testfila, int testcolumna) {
		int columnaDiferencia = testcolumna - columna; // columnas de diferencia
		if ((fila == testfila) || // misma fila
				(fila + columnaDiferencia == testfila) || // diagonal por abajo
				(fila - columnaDiferencia == testfila))// diagonal por arriba
			return true;
		if (vecina != null)// this no puede atacar a test pero y su vecina?
			return vecina.puedeAtacar(testfila, testcolumna);
		return false;
	}

	public void paint(Graphics g) {
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
