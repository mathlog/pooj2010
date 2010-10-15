package opoo.juegos.reinas8.estruct;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEreinas extends Frame {
    Ereina  Reina = new Ereina();
public static void main(String [ ] args){
	VentanaEreinas v = new VentanaEreinas();
	v.show();
}
public VentanaEreinas() {
	setTitle("Problema de las ocho reinas");
	setSize(600, 500);
	Reina.colocarReinas(0);	

	addWindowListener(new CloseQuit());
}
public void paint(Graphics g) {
	super.paint(g);
	// dibuja el tablero
	for (int i = 0; i <= 8; i++) {
		g.drawLine(50 * i + 10, 40, 50*i + 10, 440);
		g.drawLine(10, 50 * i + 40, 410, 50*i + 40);
	}
	g.drawString("Pulse con para una nueva solución", 20, 470);
	// draw queens
	for (int i= 0; i < 8; ++i) {
			int x = (i) * 50 + 10;
			int y = Reina.posicion(i) * 50 + 40;
			g.drawLine(x+5, y+45, x+45, y+45);
			g.drawLine(x+5, y+45, x+5, y+5);
			g.drawLine(x+45, y+45, x+45, y+5);
			g.drawLine(x+5, y+35, x+45, y+35);
			g.drawLine(x+5, y+5, x+15, y+20);
			g.drawLine(x+15, y+20, x+25, y+5);
			g.drawLine(x+25, y+5, x+35, y+20);
			g.drawLine(x+35, y+20, x+45, y+5);
			g.drawOval(x+20, y+20, 10, 10);
			}		
}      		
				
	private class CloseQuit extends WindowAdapter {
		public void windowClosing (WindowEvent e) {
			System.exit(0);
		}
	}

}
