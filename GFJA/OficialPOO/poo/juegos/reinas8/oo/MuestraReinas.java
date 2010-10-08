package poo.juegos.reinas8.oo;

//	Eight Reinas puzzle written in Java
//	Written by Tim Budd, January 1996
//	revised for 1.3 event model July 2001
//
import java.applet.Applet;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class MuestraReinas extends Applet {
	private Reina ultimaReina;
	private int nReinas;

	private Object[] posibilidades = { "4", "6", "8", "10", "12", "14", "16",
			"18", "20", "22", "24", "26" };

	public void init() {
		nReinas = eligeNumeroReinas();
		setSize(nReinas * 50 + 30, nReinas * 50 + 80);
		int i;
		ultimaReina = null;
		for (i = 1; i <= nReinas; i++) {
			ultimaReina = new Reina(i, ultimaReina, nReinas);
			ultimaReina.buscaSolucion();
		}
	}

	public void paint(Graphics g) {
		// pinta el tablero
		for (int i = 0; i <= nReinas; i++) {
			g.drawLine(50 * i + 10, 40, 50 * i + 10, 50 * nReinas + 40);
			g.drawLine(10, 50 * i + 40, 50 * nReinas + 10, 50 * i + 40);
		}
		g.drawString("Pulse encima para una nueva solución", 20, 50 * nReinas + 60);
		// pinta las reinas
		ultimaReina.paint(g);
	}

	public boolean mouseDown(java.awt.Event evt, int x, int y) {
		ultimaReina.avanza();
		repaint();
		return true;
	}

	private int eligeNumeroReinas() {
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el número de reinas", "Numero de reinas",
				JOptionPane.QUESTION_MESSAGE, null, posibilidades, "8");
		return s != null ? Integer.parseInt(s) : 8;
	}

}
