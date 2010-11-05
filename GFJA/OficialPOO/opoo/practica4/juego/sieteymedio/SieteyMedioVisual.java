//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.sieteymedio;

import opoo.practica4.juego.base.BarajaSpanishMostrable;
import opoo.practica4.juego.base.Juego;
import opoo.practica4.juego.base.Jugador;
import opoo.practica4.juego.base.Limites;

/**
 * Clase que representa el juego del 7.5 visual
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 24.09.2010
 */
public class SieteyMedioVisual extends Juego {

	/**
	 * Constructor que inicializa el Siete y medio visual
	 * 
	 * @param nombre
	 *            el nombre del juego
	 * @param nJugadores
	 *            los jugadores de la partida
	 */
	public SieteyMedioVisual(Jugador[] jugadores) {
		super("Siete y medio Visual", jugadores, Limites.SIETEYMEDIO,
				new BarajaSpanishMostrable());
	}
}
