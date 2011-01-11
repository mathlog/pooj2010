//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

/**
 * Interfaz que representa una respuesta
 * 
 * @author José Ángel García Fernández
 * @version 1.1 06/12/2010
 */
public interface Respuesta {

	/**
	 * Obtiene una respuesta aleatoria
	 * 
	 * @param nJugadores
	 *            el numero de jugadores activo
	 * @return la respuesta
	 */
	public Respuesta rand(int nJugadores);
}
