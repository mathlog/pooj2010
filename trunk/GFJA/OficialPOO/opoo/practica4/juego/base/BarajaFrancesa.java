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
 * Clase que representa una baraja francesa
 * 
 * @author José Ángel García Fernández
 * @version 1.0 05/11/2010
 */
public class BarajaFrancesa extends Baraja {

	public BarajaFrancesa(){
		super(tipoBaraja.FRANCESA);
	}
	protected void creaBaraja() {
		this.nombreBaraja = "Baraja Francesa";
		cartas = new Carta[40];
		Carta carta;
		StringBuilder ruta = new StringBuilder("/opoo/practica4/juego/imgfra/");
		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 8; i++) {
				ruta.append(i + palos[k] + ".jpg");
				carta = new CartaFrancesa(palos[k], i, i);
				cartas[j] = carta;
				j++;
				ruta.setLength(ruta.length() - 6);
			}
			for (int i = 10; i < 13; i++) {
				ruta.append(i + palos[k] + ".jpg");
				carta = new CartaFrancesa(palos[k], i, 10);
				cartas[j] = carta;
				j++;
				ruta.setLength(ruta.length() - 7);
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
