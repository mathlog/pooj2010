//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.veintiuno;

import opoo.practica4.juego.base.BarajaFrancesaMostrable;
import opoo.practica4.juego.base.Jugador;

/**
 * Clase que representa el juego del 21 visual
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 06.11.2010
 */
public class VeintiunoVisual extends Veintiuno {

	/**
	 * Constructor que inicializa el Veintinuno viusla
	 * 
	 * @param jugadores
	 *            los jugadores de la partida
	 */
	public VeintiunoVisual(Jugador[] jugadores) {
		super(jugadores, new BarajaFrancesaMostrable());
	}

}
