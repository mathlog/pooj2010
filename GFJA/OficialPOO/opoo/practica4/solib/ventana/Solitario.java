package opoo.practica4.solib.ventana;


import javax.swing.*;

import opoo.practica4.soli.modelo.TableroSolitario;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;


public class Solitario {
	
	public static void main(String[] args) {
	
		JFrame f = new JFrame("Solitario");
		TableroSolitario tablero = new TableroSolitario();
		VentanaTablero vtab = new VentanaTablero(tablero);	
		
		f.getContentPane().add(vtab,BorderLayout.CENTER);
		VentanaPartida vpa = new VentanaPartida(tablero);
		f.getContentPane().add(vpa,BorderLayout.SOUTH);
		
		
		f.setBounds(250,65,480,580);
		f.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
		    System.exit(0) ; 
			}
	   });
		f.setVisible(true);
		
	}
}	
