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
 * Clase que representa una baraja francesa que extiende de Baraja
 * 
 * @author José Ángel García Fernández
 * @version 1.2 12/11/2010
 */
public class BarajaFrancesa extends Baraja {

	public BarajaFrancesa() {
		super(tipoBaraja.FRANCESA);
	}

	@Override
	protected void creaBaraja() {
		this.nombreBaraja = "Baraja Francesa";
		cartas = new Carta[52];
		Carta carta;
		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 14; i++) {
				carta = new CartaFrancesa(palos[k], i, i);
				cartas[j] = carta;
				j++;
			}
		}
	}

	@Override
	protected void creaPalos() {
		palos = new String[4];
		palos[0] = "P";
		palos[1] = "C";
		palos[2] = "D";
		palos[3] = "T";
	}
}
