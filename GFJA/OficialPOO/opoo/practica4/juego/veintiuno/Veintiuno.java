//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.veintiuno;

import opoo.excepciones.NoHayMasCartasException;
import opoo.practica4.juego.base.BarajaFrancesa;
import opoo.practica4.juego.base.Carta;
import opoo.practica4.juego.base.CartaFrancesa;
import opoo.practica4.juego.base.Juego;
import opoo.practica4.juego.base.Jugador;
import opoo.practica4.juego.base.PropsJuegosCartas;

/**
 * Clase que representa el juego del 21
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 12.11.2010
 */
public class Veintiuno extends Juego {

	/**
	 * Constructor que inicializa el juego
	 * 
	 * @param jugadores
	 *            los jugadores de la partida
	 */
	public Veintiuno(Jugador[] jugadores) {
		super("Veintiuno", jugadores, PropsJuegosCartas.PUNTUACION21,
				new BarajaFrancesa(), PropsJuegosCartas.MANO1_21);
	}

	/**
	 * Constructor que inicializa
	 * 
	 * @param jugadores
	 *            los jugadores de la partida
	 * @param bar
	 *            baraja a usar
	 */
	public Veintiuno(Jugador[] jugadores, BarajaFrancesa bar) {
		super("Veintiuno", jugadores, PropsJuegosCartas.PUNTUACION21, bar,
				PropsJuegosCartas.MANO1_21);
	}

	@Override
	public boolean actualizarJugador(Carta carta) {
		CartaFrancesa francesa = (CartaFrancesa) carta;
		Jugador actual = jugadores[jugadorActual];
		if (!actual.isPasado()) {
			if (francesa.esElUno()) {
				float punt = actual.getPuntuacion();
				if ((punt + 11) > limite)
					actual.recibirCarta(carta);
				else
					actual.recibirCarta(new CartaFrancesa(francesa.getPalo(),
							francesa.getNumero(), 11));
				return pierdeJugador(actual);
			} else {
				actual.recibirCarta(carta);
				return pierdeJugador(actual);
			}
		}
		return true;
	}

	@Override
	public Carta[] empezarTurno() throws NoHayMasCartasException {
		Carta[] mano1 = new CartaFrancesa[nCartasPrimeraMano];
		for (int i = 0; i < nCartasPrimeraMano; i++) {
			mano1[i] = sacarCarta();
		}
		mano1[0].flip();
		return mano1;
	}
}
