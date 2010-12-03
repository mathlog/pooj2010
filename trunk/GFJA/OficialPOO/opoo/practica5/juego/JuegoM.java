//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

import java.util.ArrayList;

import opoo.excepciones.AllRondasCompleteException;
import opoo.excepciones.PlayerGanadorException;


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
public abstract class JuegoM {

	/**
	 * Variable que representa el nombre del juego
	 */
	protected String nombre;

	/**
	 * Array que representa los jugadores de la partida
	 */
	protected JugadorM[] jugadores;

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
	public JugadorM[] getJugadores() {
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
	public JugadorM getJugadorActual() {
		return jugadores[jugadorActual];
	}

	public int getNRonda() {
		return nRonda;
	}

	public int getNMAXrondas() {
		return nMAXrondas;
	}

	/**
	 * Constructor para inicializar el juego
	 * 
	 * @param nombre
	 *            el nombre del juego
	 * @param jugadores
	 *            los jugadores de la partida
	 */
	public JuegoM(String nombre, JugadorM[] jugadores, int nMAXrondas) {
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.nMAXrondas = nMAXrondas;
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
	 * Metodo abstracto que actualiza los jugadores
	 * 
	 * @param tipoRespuesta
	 *            la respuesta que ha dado el jugador
	 * 
	 */
	public abstract void actualizarJugadores(Respuesta resp);

	/**
	 * Metodo que calcula los resultados de cada ronda
	 */
	protected abstract void calcularResultados();

	public void mostrarManos() {
		for (int i = 0; i < nJugadores; i++) {
			jugadores[i].mostrarMano();
		}
	}

	/**
	 * Método que pasa a la siguiente ronda
	 * 
	 * @throws AllRondasCompleteException
	 *             si ya no quedan mas rondas
	 */
	public void nextRonda() throws AllRondasCompleteException {
		nRonda++;
		if (nRonda == nMAXrondas)
			throw new AllRondasCompleteException("Maximo de rondas alcanzado");

	}

	/**
	 * Metodo que reinicia la partida
	 */
	public void empezarPartida() {
		finJuego = false;
		nRonda = 0;
		resetearJugadores();
	}

	/**
	 * Metodo que finaliza la partida y da el ganador
	 * 
	 * @return el ganador o ganadores o null si no hay
	 * @throws AllRondasCompleteException
	 *             si se han acabado las rondas
	 * @throws PlayerGanadorException
	 */
	public JugadorM[] finalizarRonda() throws AllRondasCompleteException,
			PlayerGanadorException {
		nextRonda();
		JugadorM[] ganadores = calcularGanadores();
		if (ganadores.length == 1) {
			finJuego = true;
			throw new PlayerGanadorException("Hay ganador", ganadores[0]);
		} else
			return ganadores;
	}

	/**
	 * Metodo que comprueba si el jugador actual ha perdido
	 * 
	 * @param actual
	 *            el jugador actual
	 * @return true o false en funcion de si se ha pasado o no
	 */
	protected boolean comprobarPierdeJugador(JugadorM actual) {
		return finJuego;
		/*
		 * if (actual.getPuntuacion() > limite) { actual.setPasado(true); return
		 * actual.sePlanta(limite); } else return actual.sePlanta(limite);
		 */
	}

	/*
	 * float max, aux; max = 0; ArrayList<JugadorM> ganadores = new
	 * ArrayList<JugadorM>(); for (int i = 0; i < nJugadores; i++) { aux =
	 * jugadores[i].getPuntuacion(); if ((aux > max) && (aux <= limite)) { if
	 * (aux == max) { ganadores.add(jugadores[i]); } else { ganadores.clear();
	 * ganadores.add(jugadores[i]); max = jugadores[i].getPuntuacion(); } } }
	 * return ganadores.size() == 0 ? null : (JugadorM[]) ganadores .toArray(new
	 * JugadorM[ganadores.size()]);
	 */

	/**
	 * Método que resetea a los jugadores
	 */
	protected void resetearJugadores() {
		for (JugadorM a : jugadores)
			a.resetear();
	}

	/**
	 * Habilita a los jugadores
	 */
	private void habilitarJugadores() {
		for (JugadorM a : jugadores)
			a.setDeshabilitado(false);
	}

	/**
	 * Elimina los jugadores deshabilitados
	 */
	private void eliminarDeshabilitados() {
		for (JugadorM a : jugadores)
			if (a.isDeshabilitado())
				a.setEliminado(true);
	}

	/**
	 * Metodo que calcula los ganadores de cada ronda
	 * 
	 * @return los ganadores o null si no hay
	 */
	private JugadorM[] calcularGanadores() {

		calcularResultados();
		ArrayList<JugadorM> ganadores = new ArrayList<JugadorM>();
		for (JugadorM a : jugadores)
			if (!a.isDeshabilitado())
				ganadores.add(a);
		if (ganadores.size() == 0) {
			habilitarJugadores();
			return null;
		} else {
			eliminarDeshabilitados();
			return (JugadorM[]) ganadores.toArray(new JugadorM[ganadores.size()]);
		}
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
