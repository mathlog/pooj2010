package opoo.practica4.solib.ventana;


import java.awt.*;
import javax.swing.*;

import opoo.practica4.soli.modelo.TableroSolitario;
import opoo.practica4.soli.modelo.VistaSolitario;

import java.awt.event.*;

public class VentanaPartida extends JPanel implements VistaSolitario {
	
	private TableroSolitario tableroSol;
	private JLabel fichasQuedan;
	private JButton nuevaPartida;
	
	public VentanaPartida(TableroSolitario plateauSolitaire) {
		super(new BorderLayout());
		add(new JLabel("-----------------------------------------------------------------------------",SwingConstants.CENTER),BorderLayout.NORTH);
		this.tableroSol = plateauSolitaire;
		fichasQuedan = new JLabel("Quedan "+tableroSol.getnumFichaQuedan()+" fichas");
		fichasQuedan.setHorizontalAlignment(SwingConstants.CENTER);
		add(fichasQuedan,BorderLayout.CENTER);
		nuevaPartida = new JButton("Partida en curso. Reiniciar ?");
		nuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableroSol.reinicio();
			}
		});
		add(nuevaPartida,BorderLayout.SOUTH);
		tableroSol.addVista(this);
	}
	
	public void cambio() {
		fichasQuedan.setText("Quedan "+tableroSol.getnumFichaQuedan()+" fichas");
		if (tableroSol.testPerder()) {
		 nuevaPartida.setText("Se puede seguir moviendo. Reiniciar ?");
		 JOptionPane.showMessageDialog(null,"No hay mas posibilidades.\nHas perdido.","Solitario",JOptionPane.INFORMATION_MESSAGE);
		} 
		else nuevaPartida.setText((tableroSol.getnumFichaQuedan() == 1)?"Partida ganada. Reiniciar ?":"Partida en curso. reiniciar ?");
		
		if (tableroSol.getnumFichaQuedan() == 1) 
		 JOptionPane.showMessageDialog(null,"Felicidades./nHas ganado.","Solitario",JOptionPane.INFORMATION_MESSAGE);
	}
	
}