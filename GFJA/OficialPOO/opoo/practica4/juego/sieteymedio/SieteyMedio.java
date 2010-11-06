//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.sieteymedio;

import opoo.practica4.juego.base.BarajaSpanish;
import opoo.practica4.juego.base.Juego;
import opoo.practica4.juego.base.Jugador;
import opoo.practica4.juego.base.Limites;

/**
 * Clase que representa el juego del 7.5
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 06.11.2010
 */
public class SieteyMedio extends Juego {

	/**
	 * Constructor que inicializa el Siete y medio
	 * 
	 * @param nJugadores
	 *            los jugadores de la partida
	 */
	public SieteyMedio(Jugador[] jugadores) {
		super("Siete y medio", jugadores, Limites.SIETEYMEDIO,
				new BarajaSpanish());
	}

	/**
	 * Constructor que inicializa el Siete y medio
	 * 
	 * @param nJugadores
	 *            los jugadores de la partida
	 */
	public SieteyMedio(Jugador[] jugadores, BarajaSpanish bar) {
		super("Siete y medio", jugadores, Limites.SIETEYMEDIO, bar);
	}

}
