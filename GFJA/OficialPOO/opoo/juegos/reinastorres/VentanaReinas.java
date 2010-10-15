package opoo.juegos.reinastorres;

//	Eight Reinas puzzle written in Java
//	Written by Tim Budd, January 1996
//	revised for 1.3 event model July 2001
//
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class VentanaReinas extends Frame {
	public static void main(String[] args) {
		VentanaReinas world = new VentanaReinas();
		world.show();
	}

	// Array para el seleccion numero reinas
	private Object[] posibilidades = { "4", "6", "8", "10", "12", "14", "16" };
	private PiezaAjedrez ultimaPieza = null;
	private int nPiezas;

	public VentanaReinas() {
		this.nPiezas = eligeNumeroReinas();
		setTitle("Problema de las nPiezas");
		setSize(nPiezas * 50 + 30, nPiezas * 50 + 80);
		for (int i = 1; i <= nPiezas; i++) {
			ultimaPieza = i % 2 == 0 ? new Reina(i, ultimaPieza, nPiezas)
					: new Torre(i, ultimaPieza, nPiezas);
			ultimaPieza.buscaSolucion();
		}
		addMouseListener(new MouseKeeper());
		addWindowListener(new CloseQuit());
	}

	public void paint(Graphics g) {
		super.paint(g);
		// dibuja el tablero
		for (int i = 0; i <= nPiezas; i++) {
			// tamaño cuadro*nReinas+desplazamiento base
			g.drawLine(50 * i + 10, 40, 50 * i + 10, 50 * nPiezas + 40);
			g.drawLine(10, 50 * i + 40, 50 * nPiezas + 10, 50 * i + 40);
		}
		g.drawString("Pulse encima para una nueva solución", 20,
				50 * nPiezas + 60);
		// draw piezas
		ultimaPieza.paint(g);
	}

	private class CloseQuit extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	private class MouseKeeper extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			ultimaPieza.avanza();
			repaint();
		}
	}

	private int eligeNumeroReinas() {
		// uso JOptionPane para seleccion filtrada de nReinas
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el número de piezas", "Numero de piezas",
				JOptionPane.QUESTION_MESSAGE, null, posibilidades, "8");
		return s != null ? Integer.parseInt(s) : 8;
	}
}
