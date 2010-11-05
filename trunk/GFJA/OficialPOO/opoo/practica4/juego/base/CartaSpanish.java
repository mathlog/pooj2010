//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Juego del Siete y medio
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.base;


/**
 * Clase que representa una carta e implementa la interfaz Comparable
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 24.09.2010
 */
public class CartaSpanish extends Carta implements Comparable {

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
	public CartaSpanish(String palo, int numero, float valor) {
		super(palo, numero, valor);
	}

	/**
	 * Metodo que comprueba el orden de 2 cartas españolas
	 * 
	 * @param o
	 *            a comparar
	 * @return devuelve -1 si this es mayor, 0 si son iguales y 1 si o es mayor
	 */
	public int compareTo(Object o) {

		CartaSpanish carta = (CartaSpanish) o;
		String[] palos = { "O", "C", "E", "B" };

		if (this.equals(carta)) {
			return 0;
		}
		int posThis = 0;
		for (int i = 0; i < palos.length; i++) {
			if (this.palo.equals(palos[i]))
				posThis = i;
		}
		int posCarta = 0;
		for (int i = 0; i < palos.length; i++) {
			if (carta.palo.equals(palos[i]))
				posCarta = i;
		}
		if (posThis < posCarta) {
			return -1;
		} else if (posThis > posCarta) {
			return 1;
		} else {
			if (this.numero < carta.numero) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
