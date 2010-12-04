//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5, Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

/**
 * Clase que representa a un jugador
 * 
 * @author José Ángel García Fernández
 * @version 1.0 03/12/2010
 */
public class JugadorM {

	/**
	 * Variable que representa la puntuacion del jugador
	 */
	private float puntuacion;

	/**
	 * Variable que representa el tipo de respuesta
	 */
	private Respuesta respuesta;

	/**
	 * Arraylist con las cartas del jugador en la mano
	 */
	// private ArrayList<Carta> mano;
	/**
	 * Cadena de caracteres que representa el nombre del jugador
	 */
	private String nombre;

	/**
	 * Variable que indica si el jugador esta marcado
	 */
	private boolean marcado;

	/**
	 * Variable que indica si el jugador esta deshabilitado
	 */
	private boolean deshabilitado;

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
	public JugadorM(String nombre, boolean humano) {
		this.nombre = nombre;
		this.humano = humano;
		puntuacion = 0;
		marcado = false;
		deshabilitado = false;
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
		return marcado;
	}

	/**
	 * Metodo modificador de la propiedad plantado
	 * 
	 * @param plantado
	 *            el plantado a poner
	 */
	public void setPlantado(boolean plantado) {
		this.marcado = plantado;
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
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Metodo para obtener la propiedad respuesta
	 * 
	 * @return the respuesta
	 */
	public Respuesta getRespuesta() {
		return respuesta;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	public boolean isDeshabilitado() {
		return deshabilitado;
	}

	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	/**
	 * Metodo toString para mostrar
	 * 
	 * @return devuelve un string con las propiedades del JugadorM
	 */
	public String toString() {
		if (marcado)
			if (humano)
				return nombre + "->reinicia";
			else
				return nombre + "->" + respuesta + ": ELIMINADO";
		else
			return nombre + "->" + respuesta;
	}

	/**
	 * Metodo que resetea al jugador
	 */
	public void resetear() {
		puntuacion = 0;
		marcado = false;
		deshabilitado = false;
	}

	public void mostrarMano() {
		// TODO Auto-generated method stub
	}

}
