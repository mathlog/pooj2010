package poo.juegos.reinastorres;

//	Eight Reinas puzzle written in Java
//	Written by Tim Budd, January 1996
//	revised for 1.3 event model July 2001
//
import java.applet.Applet;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class MuestraReinas extends Applet {
	private PiezaAjedrez ultimaPieza;
	private int nPiezas;

	private Object[] posibilidades = { "4", "6", "8", "10", "12", "14", "16",
			"18", "20", "22", "24", "26" };

	public void init() {
		nPiezas = eligeNumeroPiezas();
		setSize(nPiezas * 50 + 30, nPiezas * 50 + 80);
		int i;
		ultimaPieza = null;
		for (i = 1; i <= nPiezas; i++) {
			ultimaPieza = i % 2 == 0 ? new Reina(i, ultimaPieza, nPiezas)
					: new Torre(i, ultimaPieza, nPiezas);
			ultimaPieza.buscaSolucion();
		}
	}

	public void paint(Graphics g) {
		// pinta el tablero
		for (int i = 0; i <= nPiezas; i++) {
			g.drawLine(50 * i + 10, 40, 50 * i + 10, 50 * nPiezas + 40);
			g.drawLine(10, 50 * i + 40, 50 * nPiezas + 10, 50 * i + 40);
		}
		g.drawString("Pulse encima para una nueva solución", 20,
				50 * nPiezas + 60);
		// pinta las reinas
		ultimaPieza.paint(g);
	}

	public boolean mouseDown(java.awt.Event evt, int x, int y) {
		ultimaPieza.avanza();
		repaint();
		return true;
	}

	private int eligeNumeroPiezas() {
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el número de piezas", "Numero de piezas",
				JOptionPane.QUESTION_MESSAGE, null, posibilidades, "8");
		return s != null ? Integer.parseInt(s) : 8;
	}

}
