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
 * Clase que representa una carta espanyola con una imagen representativa
 * extendiendo de CartaSpanish e implementando CartaMostrable
 * 
 * @author José Ángel García Fernández
 * @version 1.2 12/11/2010
 */
public class CartaSpanishMostrable extends CartaSpanish implements
		CartaMostrable {

	/**
	 * La imagen de la carta
	 */
	private ImageIcon imagen;

	/**
	 * Genera una CartaSpanishMostrable con parametros de palo numero , valor e
	 * imagen
	 * 
	 * @param palo
	 *            representa el palo de la carta
	 * @param numero
	 *            representa el numero de la carta
	 * @param valor
	 *            representa el valor de la carta
	 * @param imagen
	 *            representa la imagen de la carta
	 */
	public CartaSpanishMostrable(String palo, int numero, float valor,
			ImageIcon imagen) {
		super(palo, numero, valor);
		this.imagen = imagen;
	}

	/**
	 * Metodo que comprueba si 2 cartas mostrables son iguales
	 * 
	 * @param o
	 *            a comparar
	 * @return devuelve false si no son iguales y true si son iguales
	 */
	public boolean equals(Object o) {
		if (super.equals(o) && (this.imagen == imagen))
			return true;
		return false;
	}

	@Override
	public ImageIcon getImgCarta() {
		if (up)
			return imagen;
		else
			return null;
	}

	@Override
	public void setImgCarta(ImageIcon img) {
		this.imagen = img;
	}
}
