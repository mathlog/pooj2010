//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.veintiuno;

import opoo.practica4.juego.base.BarajaFrancesa;
import opoo.practica4.juego.base.Juego;
import opoo.practica4.juego.base.Jugador;
import opoo.practica4.juego.base.Limites;

/**
 * Clase que representa el juego del 21
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 24.09.2010
 */
public class Veintiuno extends Juego {

	/**
	 * Constructor que inicializa el Siete y medio
	 * 
	 * @param Jugadores
	 *            los jugadores de la partida
	 */
	public Veintiuno(Jugador[] jugadores) {
		super("Veintiuno", jugadores, Limites.VEINTIUNO, new BarajaFrancesa());
	}
}
