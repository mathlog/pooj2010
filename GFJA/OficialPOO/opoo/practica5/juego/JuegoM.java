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

//cargarte excepcion de 1jugador
//generalizar el calcularGanadores xk es igual x ahora
/**
 * Clase que representa un juego de manos
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 04.12.2010
 */
public abstract class JuegoM {

	/**
	 * Variable que representa el nombre del juego
	 */
	protected String nombre;

	/**
	 * Variable que indica si el juego ha acabado
	 */
	protected boolean finJuego;

	/**
	 * Array que representa los jugadores de la partida
	 */
	protected JugadorM[] jugadores;

	/**
	 * Variable que representa el numero de jugadores de la partida
	 */
	protected int nJugadores;

	/**
	 * Variable que representa al jugador actual
	 */
	protected int jugadorActual;

	/**
	 * Variable que indica el numero de ronda actual
	 */
	protected int nRonda;

	/**
	 * Variable que indica el maximo de rondas
	 */
	protected int nMAXrondas;

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
		empezarPartida();
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

	/**
	 * Metodo que reinicia la partida
	 */
	public void empezarPartida() {
		finJuego = false;
		nRonda = 1;
		nJugadores = jugadores.length;
		resetearJugadores();
	}

	/**
	 * Método que pasa a la siguiente ronda
	 * 
	 * @throws AllRondasCompleteException
	 *             si ya no quedan mas rondas
	 */
	public void nextRonda() throws AllRondasCompleteException {
		nRonda++;
		if (nRonda == nMAXrondas) {
			finJuego = true;
			throw new AllRondasCompleteException("Maximo de rondas alcanzado");
		}
	}

	/**
	 * Metodo abstracto que actualiza los jugadores
	 * 
	 * @param tipoRespuesta
	 *            la respuesta que ha dado el jugador
	 * 
	 */
	public abstract void actualizarJugadores(Respuesta resp);

	/**
	 * Metodo que finaliza la ronda y da los ganadores si los hay
	 * 
	 * @return el ganador o ganadores o null si no hay
	 */
	public abstract JugadorM[] finalizarRonda();

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
	 * Metodo que calcula los resultados de cada ronda
	 */
	protected abstract void calcularResultados();

	/**
	 * Metodo que calcula los ganadores de cada ronda
	 * 
	 * @return los ganadores o null si no hay
	 */
	protected abstract ArrayList<JugadorM> calcularGanadores();

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

	/**
	 * Habilita a los jugadores
	 */
	protected void habilitarJugadores() {
		for (JugadorM a : jugadores)
			a.setDeshabilitado(false);
	}

	/**
	 * Deshabilita a los jugadores
	 */
	protected void deshabilitarJugadores() {
		for (JugadorM a : jugadores)
			a.setDeshabilitado(true);
	}

	/**
	 * Marca los jugadores deshabilitados
	 */
	protected void marcarDeshabilitados() {
		for (JugadorM a : jugadores)
			if (a.isDeshabilitado())
				a.setMarcado(true);
	}

	/**
	 * Marca los jugadores habilitados
	 */
	protected void marcarHabilitados() {
		for (JugadorM a : jugadores)
			if (!a.isDeshabilitado())
				a.setMarcado(true);

	}

	/**
	 * Método que resetea a los jugadores
	 */
	protected void resetearJugadores() {
		for (JugadorM a : jugadores)
			a.resetear();
	}

	/**
	 * Metodo que devuelve el numero de jugadores activos
	 * 
	 * @return el numero de jugadores no eliminados
	 */
	public int getNJugadoresActivos() {
		int activos = 0;
		for (JugadorM a : jugadores)
			if (!a.isMarcado())
				activos++;
		return activos;
	}

	public JugadorM[] getJugadores() {
		return jugadores;
	}

	public JugadorM getJugadorActual() {
		return jugadores[jugadorActual];
	}

	public int getNJugadores() {
		return nJugadores;
	}

	public int getNMAXrondas() {
		return nMAXrondas;
	}

	public int getNRonda() {
		return nRonda;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	public void setJugadores(JugadorM[] jugadores) {
		this.jugadores = jugadores;
	}

}
