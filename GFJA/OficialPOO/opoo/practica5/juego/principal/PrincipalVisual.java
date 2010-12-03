//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego.principal;

import opoo.practica5.juego.visual.VentanaJuegos;


/**
 * Clase de ejecucion para VentanaJuegos
 * 
 * @author José Ángel García Fernández
 * @version 1.0 03/12/2010
 */
public class PrincipalVisual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		VentanaJuegos ventana = new VentanaJuegos();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
