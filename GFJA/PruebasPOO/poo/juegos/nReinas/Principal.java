//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Juego de las Nreinas
// ASIGNATURA : Programacion Orientada a Objetos
//
package poo.juegos.nReinas;

import poo.juegos.nReinas.visual.VentanaNreinas;

/**
 * Clase principal para la realizacion del juego de las Nreinas
 * 
 * @author José Ángel García Fernández
 * @version 1.0 01/10/2010
 */
public class Principal {

	public static void main(String args[]) {
		VentanaNreinas juego = new VentanaNreinas();
		juego.setLocationRelativeTo(null);
		juego.setDefaultCloseOperation(VentanaNreinas.EXIT_ON_CLOSE);
		juego.setVisible(true);
	}
}
