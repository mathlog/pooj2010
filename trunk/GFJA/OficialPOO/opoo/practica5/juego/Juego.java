//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

import java.util.Random;
import opoo.excepciones.AllPlayersPlantadosException;

/*
 * El juego como es, te sientas y tu eliges a lo k kieres jugar y el numero de jugadores,
 *  y tu das solo tu eleccion y la makina genera aleatorios pal resto jugadores
 *  tienes piedra,papel,tijera|pares,nones|0,1,2,3|
 */
/**
 * Clase que representa un juego de manos
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 12.11.2010
 */
public abstract class Juego {

	/**
	 * Variable que representa el nombre del juego
	 */
	protected String nombre;

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
	 * Variable que representa al jugador actual
	 */
	protected int jugadorActual;

	/**
	 * Variable que indica el numero de ronda
	 */
	protected int nRonda;
	
	/**
	 * Variable que indica el maximo de rondas
	 */
	protected int nMAXrondas;

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
	 */
	public Juego(String nombre, Jugador[] jugadores, int nMAXrondas) {
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.nMAXrondas=nMAXrondas;
		nJugadores = jugadores.length;
		empezarPartida();
	}

	/***
	 * Metodo abstracto que comienza el turno
	 * 
	 * @return la mano inicial
	 * @throws NoHayMasCartasException
	 *             si no hay mas cartas
	 */
	// public abstract Carta[] empezarTurno() throws NoHayMasCartasException;

	/**
	 * Metodo abstracto que actualiza la mano del jugador
	 * 
	 * @param carta
	 *            a meter en mano
	 * 
	 * @return el estado del jugador (pasado o no)
	 */
	// public abstract boolean actualizarJugador(Carta carta);

	public void mostrarManos(){
		for(int i=0;i<nJugadores;i++){
			jugadores[i].mostrarMano();
		}
	}
	/**
	 * Método que actualiza al siguiente jugador
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
	 * Metodo que reinicia la partida
	 */
	private void empezarPartida() {
		finJuego = false;
		Random rand = new Random();
		jugadorActual = rand.nextInt(nJugadores);
		finJuego = false;
		resetearJugadores();
	}

	/**
	 * Metodo que finaliza la partida y da el ganador
	 * 
	 * @return el ganador o ganadores o null si no hay
	 */
	public Jugador[] finalizarPartida() {
		finJuego = true;
		return comprobarVictoria();
	}

	/**
	 * Metodo que comprueba si el jugador actual ha perdido
	 * 
	 * @param actual
	 *            el jugador actual
	 * @return true o false en funcion de si se ha pasado o no
	 */
	protected boolean comprobarPierdeJugador(Jugador actual) {
		return finJuego;
		/*
		 * if (actual.getPuntuacion() > limite) { actual.setPasado(true); return
		 * actual.sePlanta(limite); } else return actual.sePlanta(limite);
		 */
	}

	/**
	 * Metodo que comprueba quien es el ganador
	 * 
	 * @return el ganador o null si no hay
	 */
	protected Jugador[] comprobarVictoria() {
		return jugadores;
		/*
		 * float max, aux; max = 0; ArrayList<Jugador> ganadores = new
		 * ArrayList<Jugador>(); for (int i = 0; i < nJugadores; i++) { aux =
		 * jugadores[i].getPuntuacion(); if ((aux > max) && (aux <= limite)) {
		 * if (aux == max) { ganadores.add(jugadores[i]); } else {
		 * ganadores.clear(); ganadores.add(jugadores[i]); max =
		 * jugadores[i].getPuntuacion(); } } } return ganadores.size() == 0 ?
		 * null : (Jugador[]) ganadores .toArray(new Jugador[ganadores.size()]);
		 */
	}

	/**
	 * Método que resetea a los jugadores
	 */
	private void resetearJugadores() {
		for (Jugador a : jugadores)
			a.resetear();
	}

	/**
	 * Metodo toString para mostrar
	 * 
	 * @return devuelve un string con las propiedades del juego
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append("\nJugadores:");
		for (int i = 0; i < nJugadores; i++) {
			sb.append("\n");
			sb.append(jugadores[i]);
		}
		return sb.toString();
	}

}
