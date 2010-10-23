//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica X, Documentacion de ejercicio Y
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.excepciones;

/**
 * Excepcion que se lanza cuando se intenta sumar monomios de distinto grado
 * 
 * @author José Ángel García Fernández
 * @version 1.0 23/10/2010
 */
public class DistintoGradoException extends Exception {

	/**
	 * Genera un objeto de tipo DistintoGradoException
	 * 
	 * @param message
	 */
	public DistintoGradoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
