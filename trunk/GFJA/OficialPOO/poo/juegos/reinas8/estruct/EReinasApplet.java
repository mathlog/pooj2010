package poo.juegos.reinas8.estruct;

import java.awt.*;
import java.applet.*;
public class EReinasApplet extends Applet {

    Ereina  Reina = new Ereina();
	 
	public void init() {
		Reina.colocarReinas( 0 );	
		}
	public void paint(Graphics g) {
			// pinta el tablero		
		for (int i = 0; i <= 8; i++) {
			g.drawLine(50 * i + 10, 40, 50*i + 10, 440);
			g.drawLine(10, 50 * i + 40, 410, 50*i + 40);
			}
			// pinta las reinas
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

}
