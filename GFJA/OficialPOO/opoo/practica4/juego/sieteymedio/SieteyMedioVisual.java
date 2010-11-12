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
import opoo.practica4.juego.base.Jugador;

/**
 * Clase que representa el juego del 7.5 visual
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 06.11.2010
 */
public class SieteyMedioVisual extends SieteyMedio {

	/**
	 * Constructor que inicializa el Siete y medio visual
	 * 
	 * @param jugadores
	 *            los jugadores de la partida
	 */
	public SieteyMedioVisual(Jugador[] jugadores) {
		super(jugadores, new BarajaSpanishMostrable());
	}
}
