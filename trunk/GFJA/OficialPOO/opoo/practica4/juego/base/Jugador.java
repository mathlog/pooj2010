//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Juego del Siete y medio
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.base;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa a un jugador
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 12.11.2010
 */
public class Jugador {

	/**
	 * Variable que representa la puntuacion del jugador
	 */
	private float puntuacion;

	/**
	 * Arraylist con las cartas del jugador en la mano
	 */
	private ArrayList<Carta> mano;

	/**
	 * Cadena de caracteres que representa el nombre del jugador
	 */
	private String nombre;

	/**
	 * Variable que indica si el jugador se ha plantado
	 */
	private boolean plantado;

	/**
	 * Variable que indica si el jugador se ha pasado
	 */
	private boolean pasado;

	/**
	 * Inicializa un jugador con parametro su nombre
	 * 
	 * @param nombre
	 *            cadena de caracteres que representa el nombre del jugador
	 */
	public Jugador(String nombre) {
		this.nombre = nombre;
		puntuacion = 0;
		mano = new ArrayList<Carta>();
		plantado = false;
		pasado = false;
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
	public ArrayList<Carta> getMano() {
		return mano;
	}

	/**
	 * Metodo para obtener la propiedad plantado
	 * 
	 * @return la propiedad plantado
	 */
	public boolean isPlantado() {
		return plantado;
	}

	/**
	 * Metodo modificador de la propiedad plantado
	 * 
	 * @param plantado
	 *            el plantado a poner
	 */
	public void setPlantado(boolean plantado) {
		this.plantado = plantado;
	}

	/**
	 * Metodo para obtener la propiedad pasado
	 * 
	 * @return la propiedad pasado
	 */
	public boolean isPasado() {
		return pasado;
	}

	/**
	 * Metodo modificador de la propiedad pasado
	 * 
	 * @param pasado
	 *            el pasado a poner
	 */
	public void setPasado(boolean pasado) {
		this.pasado = pasado;
	}

	/**
	 * Metodo toString para mostrar por pantalla
	 * 
	 * @return devuelve un string con las propiedades del Jugador
	 */
	public String toString() {
		return nombre + " -> " + puntuacion + " : " + mano;
	}

	/**
	 * Metodo que permite obtener al jugador una carta
	 * 
	 * @param carta
	 *            que se pide
	 */
	public void recibirCarta(Carta carta) {
		puntuacion += carta.getValor();
		mano.add(carta);
	}

	/**
	 * Metodo que pone boca arriba las cartas de tu mano
	 */
	public void cartasUp() {
		Iterator<Carta> it = mano.iterator();
		Carta c;
		while (it.hasNext()) {
			c = it.next();
			if (!c.isUp())
				c.flip();
		}
	}

	/**
	 * Metodo que obtiene las cartas que estan boca arriba
	 */
	public ArrayList<Carta> getManoUp() {
		Iterator<Carta> it = mano.iterator();
		ArrayList<Carta> aux = new ArrayList<Carta>();
		Carta c;
		while (it.hasNext()) {
			c = it.next();
			if (c.isUp())
				aux.add(c);
		}
		return aux;
	}

	/**
	 * Metodo que resetea al jugador
	 */
	public void resetear() {
		mano.clear();
		puntuacion = 0;
		plantado = false;
		pasado = false;

	}

}
