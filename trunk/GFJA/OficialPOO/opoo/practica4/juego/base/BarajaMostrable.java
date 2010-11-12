//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.base;

import javax.swing.ImageIcon;

/**
 * Interfaz de una BarajaMostrable
 * 
 * @author José Ángel García Fernández
 * @version 1.0 12/11/2010
 */
public interface BarajaMostrable {

	/**
	 * Metodo que obtiene el reverso de la Baraja
	 * 
	 * @return la imagen de reverso de la Baraja
	 */
	ImageIcon getReverso();

	/**
	 * Metodo que modifica el reverso de la Baraja
	 * 
	 * @param img
	 *            la imagen de reverso
	 */
	void setReverso(ImageIcon img);

	/**
	 * Metodo que obtiene la imagen de vacio de la Baraja
	 * 
	 * @return la imagen de vacio de la Baraja
	 */
	ImageIcon getVacia();

	/**
	 * Metodo que modifica la imagen de vacio de la Baraja
	 * 
	 * @param img
	 *            la imagen de vacio de la Baraja a poner
	 */
	void setVacia(ImageIcon img);

}
