//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Juego de las Nreinas
// ASIGNATURA : Programacion Orientada a Objetos
//

package ppoo.juegos.nReinas.excepciones;

/** Excepcion que indica que se ha intentado borrar una reina que no existe
 * @author Jos� �ngel Garc�a Fern�ndez
 * @version 1.0 01/10/2010
 */
public class BorradoReinaNoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Genera un objeto de tipo NoHayReinaException
	 * @param message de informacion
	 */
	public BorradoReinaNoExisteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
