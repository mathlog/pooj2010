package poo.juegos.reinastorres;

import java.awt.Graphics;

public class Torre extends PiezaAjedrez {

	Torre(int c, PiezaAjedrez n, int enemigas) {
		super(c, n, enemigas);
	}

	@Override
	protected boolean puedeAtacar(int testfila, int testcolumna) {
		if ((fila == testfila) ||(columna == testcolumna)) // misma fila
			return true;
		if (vecina != null)// this no puede atacar a test pero y su vecina?
			return vecina.puedeAtacar(testfila, testcolumna);
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
		g.drawLine(x + 5, y + 45, x + 45, y + 45);
		g.drawLine(x + 5, y + 45, x + 5, y + 5);
		g.drawLine(x + 45, y + 45, x + 45, y + 5);
		g.drawLine(x + 5, y + 35, x + 45, y + 35);
		//g.drawLine(x + 5, y + 5, x + 15, y + 20);
		//g.drawLine(x + 15, y + 20, x + 25, y + 5);
		//g.drawLine(x + 25, y + 5, x + 35, y + 20);
		//g.drawLine(x + 35, y + 20, x + 45, y + 5);
	}

}
