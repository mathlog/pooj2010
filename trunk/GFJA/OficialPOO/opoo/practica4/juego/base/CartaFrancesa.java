//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.base;

/**
 * Clase que representa una carta francesa
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 06.11.2010
 */
public class CartaFrancesa extends Carta implements Comparable {

	/**
	 * Genera una carta francesa con parametros de palo numero , valor e imagen
	 * 
	 * @param palo
	 *            representa el palo de la carta
	 * @param numero
	 *            representa el numero de la carta
	 * @param valor
	 *            representa el valor de la carta
	 */
	public CartaFrancesa(String palo, int numero, float valor) {
		super(palo, numero, valor);
	}

	/**
	 * Metodo que comprueba el orden de 2 cartas francesas
	 * 
	 * @param o
	 *            a comparar
	 * @return devuelve -1 si this es mayor, 0 si son iguales y 1 si o es mayor
	 */
	public int compareTo(Object o) {

		CartaFrancesa carta = (CartaFrancesa) o;
		String[] palos = { "P", "C", "D", "T" };

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

	public boolean esElUno() {
		return numero == 1;
	}

}
