//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.base;

import java.util.Random;

import opoo.excepciones.AllPlayersPlantadosException;
import opoo.excepciones.NoHayMasCartasException;

//instrucciones
//creas 7ymedio con baraja española y 21 con baraja francesa heredan de juego DONE
//Inicial UNA ARRIBA OTRA ABAJO 11 												DONE
//Inicial UNA ABAJO 7															DONE
//o te pasas se caba jeugo o te plantas o sigues jugada							DONE
//pides carta y sale boca abajo, si pides otra pues pedirla boca abajo y poner resto boca arriba
/**
 * Clase que representa un juego de cartas
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 12.11.2010
 */
public abstract class Juego {

	/**
	 * Variable que representa el nombre del juego
	 */
	private String nombre;

	/**
	 * Array que representa los jugadores de la partida
	 */
	protected Jugador[] jugadores;

	/**
	 * Variable que representa el numero de jugadores de la partida
	 */
	protected int nJugadores;

	/**
	 * Variable que indica si el juego ha acabado
	 */
	protected boolean finJuego;

	/**
	 * Objeto de tipo Baraja que se usara para el juego
	 */
	protected Baraja baraja;

	/**
	 * Variable que representa el numero de cartas restantes
	 */
	protected int nCartasRestantes;

	/**
	 * Variable que representa al jugador actual
	 */
	protected int jugadorActual;

	/**
	 * Variable que representa el limite de puntuacion del juego
	 */
	protected static float limite;

	/**
	 * Variable que representa el numero de cartas para la primera mano
	 */
	protected static int nCartasPrimeraMano;

	/**
	 * Metodo para obtener la propiedad jugadores
	 * 
	 * @return la propiedad jugadores
	 */
	public Jugador[] getJugadores() {
		return jugadores;
	}

	/**
	 * Metodo para obtener la propiedad nJugadores
	 * 
	 * @return la propiedad nJugadores
	 */
	public int getNJugadores() {
		return nJugadores;
	}

	/**
	 * Metodo para obtener la propiedad finJuego
	 * 
	 * @return la propiedad finJuego
	 */
	public boolean isFinJuego() {
		return finJuego;
	}

	/**
	 * Metodo para obtener la propiedad baraja
	 * 
	 * @return la propiedad baraja
	 */
	public Baraja getBaraja() {
		return baraja;
	}

	/**
	 * Metodo para obtener la propiedad nCartasRestantes
	 * 
	 * @return la propiedad nCartasRestantes
	 */
	public int getNCartasRestantes() {
		return nCartasRestantes;
	}

	/**
	 * Metodo para obtener la propiedad limite
	 * 
	 * @return la propiedad limite
	 */
	public float getLimite() {
		return limite;
	}

	/**
	 * Metodo para obtener el jugador de la propiedad jugadorActual
	 * 
	 * @return la propiedad jugadorActual
	 */
	public Jugador getJugadorActual() {
		return jugadores[jugadorActual];
	}

	/**
	 * Constructor para inicializar el juego
	 * 
	 * @param nombre
	 *            el nombre del juego
	 * @param jugadores
	 *            los jugadores de la partida
	 * @param lim
	 *            el limite de puntos de la partida
	 * @param bar
	 *            la baraja con la que se juega
	 */
	public Juego(String nombre, Jugador[] jugadores, float lim, Baraja bar,
			int nCFirstMano) {
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.baraja = bar;
		Juego.limite = lim;
		Juego.nCartasPrimeraMano = nCFirstMano;
		nJugadores = jugadores.length;
		empezarPartida();
	}

	/***
	 * Metodo que comienza el turno
	 * 
	 * @return la mano inicial
	 * @throws NoHayMasCartasException
	 *             si no hay mas cartas
	 */
	public abstract Carta[] empezarTurno() throws NoHayMasCartasException;

	/**
	 * Metodo que actualiza la mano del jugador
	 * 
	 * @param carta
	 *            a meter en mano
	 * 
	 * @return el estado del jugador (pasado o no)
	 */
	public abstract boolean actualizarJugador(Carta carta);

	/**
	 * Metodo que actualiza al siguiente jugador
	 * 
	 * @throws AllPlayersPlantadosException
	 *             si ya no quedan mas jugadores
	 */
	public void nextJugador() throws AllPlayersPlantadosException {
		jugadorActual++;
		jugadorActual = jugadorActual % nJugadores;
		if (jugadores[jugadorActual].isPlantado())
			throw new AllPlayersPlantadosException(
					"Todos los jugadores se han plantado/pasado");

	}

	/**
	 * Metodo que saca una carta de la baraja
	 * 
	 * @return devuelve la carta sacada
	 * @throws NoHayMasCartasException
	 *             en caso de que no halla mas cartas
	 */
	public Carta sacarCarta() throws NoHayMasCartasException {
		if (nCartasRestantes != 0) {
			return baraja.getCartas()[--nCartasRestantes];
		} else
			throw new NoHayMasCartasException("No hay mas cartas en la baraja");
	}

	/**
	 * Metodo que reinicia la partida
	 */
	public void empezarPartida() {
		finJuego = false;
		Random rand = new Random();
		jugadorActual = rand.nextInt(nJugadores);
		nCartasRestantes = baraja.getCartas().length;
		finJuego = false;
		baraja.barajar(100);
		resetearJugadores();
	}

	/**
	 * Metodo que finaliza la partida y da el ganador
	 * 
	 * @return el ganador o null si no hay
	 */
	public Jugador finalizarPartida() {
		finJuego = true;
		return comprobarVictoria();
	}

	/**
	 * Metodo que establece si el jugador actual se ha pasado
	 * 
	 * @param actual
	 *            el jugador actual
	 * @return true o false en funcion de si se ha pasado o no
	 */
	protected boolean pasado(Jugador actual) {
		if (actual.getPuntuacion() > limite) {
			actual.setPasado(true);
			return true;
		} else
			return false;
	}

	/**
	 * Método que resetea a los jugadores
	 */
	private void resetearJugadores() {
		for (Jugador a : jugadores)
			a.resetear();
	}

	/**
	 * Metodo que comprueba quien es el ganador
	 * 
	 * @return el ganador o null si no hay
	 */
	private Jugador comprobarVictoria() {
		float max, aux;
		max = 0;
		Jugador ganador = null;
		for (int i = 0; i < nJugadores; i++) {
			aux = jugadores[i].getPuntuacion();
			if ((aux > max) && (aux <= limite)) {
				max = jugadores[i].getPuntuacion();
				ganador = jugadores[i];
			}
		}
		return ganador;
	}

	/**
	 * Metodo toString para mostrar por pantalla
	 * 
	 * @return devuelve un string con las propiedades del juego
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append("Limite de: " + limite + " puntos");
		sb.append("\nJugadores:");
		for (int i = 0; i < nJugadores; i++) {
			sb.append("\n");
			sb.append(jugadores[i]);
		}
		return sb.toString();
	}

}
