//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.sieteymedio;

import opoo.excepciones.NoHayMasCartasException;
import opoo.practica4.juego.base.BarajaSpanish;
import opoo.practica4.juego.base.Carta;
import opoo.practica4.juego.base.CartaSpanish;
import opoo.practica4.juego.base.Juego;
import opoo.practica4.juego.base.Jugador;
import opoo.practica4.juego.base.PropsJuegosCartas;

/**
 * Clase que representa el juego del 7.5
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 12.11.2010
 */
public class SieteyMedio extends Juego {

	/**
	 * Constructor que inicializa el Siete y medio
	 * 
	 * @param nJugadores
	 *            los jugadores de la partida
	 */
	public SieteyMedio(Jugador[] jugadores) {
		super("Siete y medio", jugadores, PropsJuegosCartas.PUNTUACION7Y5,
				new BarajaSpanish(), PropsJuegosCartas.MANO1_7Y5);
	}

	/**
	 * Constructor que inicializa el Siete y medio
	 * 
	 * @param nJugadores
	 *            los jugadores de la partida
	 */
	public SieteyMedio(Jugador[] jugadores, BarajaSpanish bar) {
		super("Siete y medio", jugadores, PropsJuegosCartas.PUNTUACION7Y5, bar,
				PropsJuegosCartas.MANO1_7Y5);
	}

	@Override
	public boolean actualizarJugador(Carta carta) {
		Jugador actual = jugadores[jugadorActual];
		if (!actual.isPasado()) {
			actual.recibirCarta(carta);
			return pasado(actual);
		}
		return true;
	}

	@Override
	public Carta[] empezarTurno() throws NoHayMasCartasException {
		Carta[] mano1 = new CartaSpanish[nCartasPrimeraMano];
		mano1[0] = sacarCarta();
		mano1[0].flip();
		return mano1;
	}

}
