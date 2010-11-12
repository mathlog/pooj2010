//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.base;

/** Clase abstracta que representa una carta
 * @author José Ángel García Fernández
 * @version 1.0 12/11/2010
 */
public abstract class Carta {
	/**
	 * Variable privada que representa el palo de la carta
	 */
	protected String palo;
	/**
	 * Variable privada que representa el numero de la carta
	 */
	protected int numero;
	/**
	 * Variable privada que representa el valor de la carta
	 */
	protected float valor;

	/**
	 * Variable privada que indica si la carta esta a la vista o no
	 */
	protected boolean up;

	/**
	 * Genera una carta con parametros de palo numero , valor e imagen
	 * 
	 * @param palo
	 *            representa el palo de la carta
	 * @param numero
	 *            representa el numero de la carta
	 * @param valor
	 *            representa el valor de la carta
	 */
	public Carta(String palo, int numero, float valor) {
		this.palo = palo;
		this.numero = numero;
		this.valor = valor;
		up = true;
	}

	/**
	 * Metodo de acceso de la propiedad palo
	 * 
	 * @return devuelve el palo de la carta
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * Metodo de acceso de la propiedad numero
	 * 
	 * @return devuelve el numero de la carta
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Metodo de acceso de la propiedad valor
	 * 
	 * @return devuelve el valor de la carta
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * Metodo para obtener la propiedad up
	 * 
	 * @return the up
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * Metodo que comprueba si 2 cartas son iguales
	 * 
	 * @param o
	 *            a comparar
	 * @return devuelve false si no son iguales y true si son iguales
	 */
	public boolean equals(Object o) {

		if (!(o instanceof Carta))
			return false;

		Carta carta = (Carta) o;
		if ((this.numero == carta.numero) && (this.palo == carta.palo)
				&& (this.valor == valor)) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo toString para mostrar
	 * 
	 * @return devuelve la carta mostrando el palo y el numero
	 */
	public String toString() {
		if (up)
			return palo + numero;
		else
			return "(" + palo + numero + ")";
	}

	/**
	 * Da la vuelta a una carta
	 */
	public void flip() {
		up = (up ? false : true);
	}
}
