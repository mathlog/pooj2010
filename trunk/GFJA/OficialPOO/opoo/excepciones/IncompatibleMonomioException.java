//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Polinomios
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.excepciones;

/**
 * Excepcion que se lanza cuando se intenta unir monomios no compatibles
 * 
 * @author José Ángel García Fernández
 * @version 1.0 23/10/2010
 */
public class IncompatibleMonomioException extends Exception {

	/**
	 * Genera un objeto de tipo IncompatibleMonomioException
	 * 
	 * @param message
	 */
	public IncompatibleMonomioException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
