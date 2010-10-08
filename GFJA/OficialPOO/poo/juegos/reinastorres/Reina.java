package poo.juegos.reinastorres;

//	Eight Reinas puzzle written in Java
//	Written by Tim Budd, January 1996
//	revised for 1.3 event model July 2001
//
import java.awt.Graphics;

public class Reina extends PiezaAjedrez {
	// datos

	// constructor
	Reina(int c, Reina n, int enemigas) {
		super(c, n, enemigas);
	}

	//la ultima reina encola las 7 peudeAtacar a todas las demas
	protected boolean puedeAtacar(int testfila, int testcolumna) {
		int columnaDiferencia = testcolumna - columna; // columnas de diferencia
		if ((fila == testfila) || // misma fila
				(fila + columnaDiferencia == testfila) || // diagonal por abajo
				(fila - columnaDiferencia == testfila))// diagonal por arriba
			return true;
		if (vecina != null)// this no puede atacar a test pero y su vecina?
			return vecina.puedeAtacar(testfila, testcolumna);
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
