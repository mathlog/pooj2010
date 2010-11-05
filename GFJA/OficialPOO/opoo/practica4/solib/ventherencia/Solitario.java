package opoo.practica4.solib.ventherencia;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import opoo.practica4.solib.ventana.VentanaPartida;

public class Solitario {
	public static void main(String[] args) {

		JFrame f = new JFrame("Solitario");
		VentSolitarioHerencia vtab = new VentSolitarioHerencia();

		f.getContentPane().add(vtab.panel, BorderLayout.CENTER);
		VentanaPartida vpa = new VentanaPartida(vtab);
		f.getContentPane().add(vpa, BorderLayout.SOUTH);

		f.setBounds(250, 65, 480, 580);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		f.setVisible(true);

	}

}
