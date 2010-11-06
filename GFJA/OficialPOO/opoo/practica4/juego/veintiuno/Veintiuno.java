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
import opoo.practica4.juego.base.Carta;
import opoo.practica4.juego.base.CartaFrancesa;
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
	 * Constructor que inicializa el juego
	 * 
	 * @param Jugadores
	 *            los jugadores de la partida
	 */
	public Veintiuno(Jugador[] jugadores) {
		super("Veintiuno", jugadores, Limites.VEINTIUNO, new BarajaFrancesa());
	}

	/**
	 * Constructor que inicializa
	 * 
	 * @param Jugadores
	 *            los jugadores de la partida
	 * @param bar
	 *            baraja a usar
	 */
	public Veintiuno(Jugador[] jugadores, BarajaFrancesa bar) {
		super("Veintiuno", jugadores, Limites.VEINTIUNO, bar);
	}

	/**
	 * Metodo que actualiza la mano del jugador
	 * 
	 * @param carta
	 *            a meter en mano
	 */
	@Override
	public void actualizarJugador(Carta carta) {
		CartaFrancesa francesa = (CartaFrancesa) carta;
		if (!jugadores[jugadorActual].isPlantado()) {
			if (francesa.esElUno()) {
				float puntu = jugadores[jugadorActual].getPuntuacion();
				if ((puntu + 11) > limite)
					jugadores[jugadorActual].recibirCarta(carta);
				else
					jugadores[jugadorActual].recibirCarta(new Carta(francesa
							.getPalo(), francesa.getNumero(), 11));
			} else
				jugadores[jugadorActual].recibirCarta(carta);
		}
	}
}
