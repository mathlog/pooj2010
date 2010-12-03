//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Juego del Siete y medio
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

import java.util.Random;

/**
 * Clase que representa a un jugador
 * 
 * @author José Ángel García Fernández
 * @version 1.0 03/12/2010
 */
public class Jugador {

	/**
	 * Variable que representa la puntuacion del jugador
	 */
	private float puntuacion;

	/**
	 * Variable que representa el tipo de respuesta
	 */
	private tipoRespuesta respuesta;

	/**
	 * Arraylist con las cartas del jugador en la mano
	 */
	// private ArrayList<Carta> mano;

	/**
	 * Cadena de caracteres que representa el nombre del jugador
	 */
	private String nombre;

	/**
	 * Variable que indica si el jugador esta eliminado
	 */
	private boolean eliminado;

	/**
	 * Variable que indica si el jugador es humano
	 */
	private boolean humano;

	/**
	 * Inicializa un jugador con parametro su nombre
	 * 
	 * @param nombre
	 *            cadena de caracteres que representa el nombre del jugador
	 */
	public Jugador(String nombre, boolean humano) {
		this.nombre = nombre;
		this.humano = humano;
		puntuacion = 0;
		// mano = new ArrayList<Carta>();
		eliminado = false;
	}

	/**
	 * Metodo para obtener la propiedad nombre
	 * 
	 * @return la propiedad nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para obtener la propiedad puntuacion
	 * 
	 * @return la propiedad puntuacion
	 */
	public float getPuntuacion() {
		return puntuacion;
	}

	/**
	 * Metodo para obtener la propiedad mano
	 * 
	 * @return la propiedad mano
	 */
	/*
	 * public ArrayList<Carta> getMano() { return mano; }
	 */

	/**
	 * Metodo para obtener la propiedad plantado
	 * 
	 * @return la propiedad plantado
	 */
	public boolean isPlantado() {
		return eliminado;
	}

	/**
	 * Metodo modificador de la propiedad plantado
	 * 
	 * @param plantado
	 *            el plantado a poner
	 */
	public void setPlantado(boolean plantado) {
		this.eliminado = plantado;
	}

	/**
	 * Metodo para obtener la propiedad humano
	 * 
	 * @return si es humano o no
	 */
	public boolean isHumano() {
		return humano;
	}

	/**
	 * Metodo para modificar la propiedad respuesta
	 * 
	 * @param respuesta
	 *            the respuesta to set
	 */
	public void setRespuesta(tipoRespuesta respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Metodo para establecer la respuesta aleatoriamente
	 * 
	 */
	public void setRespuesta() {
		Random r = new Random();
		int length = tipoRespuesta.values().length;
		this.respuesta = tipoRespuesta.values()[(r.nextInt()) % length];
	}

	/**
	 * Metodo para obtener la propiedad respuesta
	 * 
	 * @return the respuesta
	 */
	public tipoRespuesta getRespuesta() {
		return respuesta;
	}

	/**
	 * Metodo toString para mostrar por pantalla
	 * 
	 * @return devuelve un string con las propiedades del Jugador
	 */
	public String toString() {
		return nombre + " -> " + puntuacion;
	}

	/**
	 * Metodo que resetea al jugador
	 */
	public void resetear() {
		puntuacion = 0;
		eliminado = false;
	}

	/**
	 * Metodo para saber si el jugador se planta
	 * 
	 * @param limite
	 *            el limite de puntuacion
	 * @return si se planta o no
	 */
	public boolean sePlanta(float limite) {
		if (puntuacion > limite) {
			eliminado = true;
			return true;
		} else
			return false;
	}

	public void mostrarMano() {
		// TODO Auto-generated method stub

	}

}
