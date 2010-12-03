//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.excepciones;

/**
 * Clase que representa la excepcion lanzada cuando se completa las rondas en
 * los juegos de la practica5
 * 
 * @author José Ángel García Fernández
 * @version 1.0 03/12/2010
 */
public class AllRondasCompleteException extends Exception {

	/**
	 * Genera un objeto de tipo AllRondasCompleteException
	 * 
	 * @param message
	 *            el mensaje
	 */
	public AllRondasCompleteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
