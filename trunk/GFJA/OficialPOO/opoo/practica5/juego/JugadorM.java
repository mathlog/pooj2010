//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5, Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

/**
 * Clase que representa a un jugador de un juego de manos
 * 
 * @author José Ángel García Fernández
 * @version 1.2 05/12/2010
 */
public class JugadorM {

	/**
	 * Cadena de caracteres que representa el nombre del jugador
	 */
	private String nombre;

	/**
	 * Variable que representa el tipo de respuesta
	 */
	private Respuesta respuesta;

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
		marcado = false;
		deshabilitado = false;
	}

	/**
	 * Metodo que resetea al jugador
	 */
	public void resetear() {
		marcado = false;
		deshabilitado = false;
	}

	/**
	 * Metodo toString para mostrar
	 * 
	 * @return devuelve un string con las propiedades del JugadorM
	 */
	public String toString() {
		if (marcado)
			if (humano)
				return nombre + "->" + respuesta
						+ " | reinicia para jugar otra partida";
			else
				return nombre + "->" + respuesta + " | OUTJUEGO";
		else
			return nombre + "->" + respuesta;
	}

	public String getNombre() {
		return nombre;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public boolean isDeshabilitado() {
		return deshabilitado;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public boolean isHumano() {
		return humano;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

}
