//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//
//IDEA GUI
//2 TEXT FIELD FILA COLUMNA boton añadir o eliminar, 
//sitio pa label aviso de no se pue borrar o hecho correctamente
// el acerca de e info pss
// zona de texto grande, odne poner el tablero de Nreinas
//o hacer alguna cosa rara con paint y tal pss
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
