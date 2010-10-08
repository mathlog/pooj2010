package poo.juegos.reinas8.oo;

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

	//Array para el seleccion numero reinas
	private Object[] posibilidades = { "4", "6", "8", "10", "12", "14", "16"};
	private Reina ultimaReina = null;
	private int nReinas;

	public VentanaReinas() {
		this.nReinas = eligeNumeroReinas();
		setTitle("Problema de las ocho reinas");
		setSize(nReinas * 50 + 30, nReinas * 50 + 80);
		for (int i = 1; i <= nReinas; i++) {
			ultimaReina = new Reina(i, ultimaReina, nReinas);
			ultimaReina.buscaSolucion();
		}
		addMouseListener(new MouseKeeper());
		addWindowListener(new CloseQuit());
	}

	public void paint(Graphics g) {
		super.paint(g);
		// dibuja el tablero
		for (int i = 0; i <= nReinas; i++) {
			// tamaño cuadro*nReinas+desplazamiento base
			g.drawLine(50 * i + 10, 40, 50 * i + 10, 50 * nReinas + 40);
			g.drawLine(10, 50 * i + 40, 50 * nReinas + 10, 50 * i + 40);
		}
		g.drawString("Pulse encima para una nueva solución", 20,
				50 * nReinas + 60);
		// draw queens
		ultimaReina.paint(g);
	}

	private class CloseQuit extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	private class MouseKeeper extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			ultimaReina.avanza();
			repaint();
		}
	}

	private int eligeNumeroReinas() {
		// uso JOptionPane para seleccion filtrada de nReinas
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el número de reinas", "Numero de reinas",
				JOptionPane.QUESTION_MESSAGE, null, posibilidades, "8");
		return s != null ? Integer.parseInt(s) : 8;
	}
}
