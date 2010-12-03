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
 * @version 1.0 03/12/2010
 */
public interface Respuesta {

	/**
	 * Obtiene la respuesta de la enumeracion
	 * 
	 * @param a
	 *            el indice
	 * @return la respuesta
	 */
	public Respuesta getEnum(int a);

	/**
	 * Obtiene la longitud de la enumeracion
	 * 
	 * @return la longitud de la enumeracion
	 */
	public int length();

	/**
	 * Obtiene una respuesta aleatoria
	 * 
	 * @return la respuesta
	 */
	public Respuesta rand();

}
