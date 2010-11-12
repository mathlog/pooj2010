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
 * Clase que extiende de BarajaFrancesa e implementa BarajaMostrable
 * 
 * @author José Ángel García Fernández
 * @version 1.1 12/11/2010
 */
public class BarajaFrancesaMostrable extends BarajaFrancesa implements
		BarajaMostrable {

	/**
	 * El reverso de la baraja
	 */
	private ImageIcon reverso;

	/**
	 * Imagen que representa cuando no halla ninguna carta en la baraja
	 */
	private ImageIcon vacia;

	@Override
	protected void creaBaraja() {
		this.nombreBaraja = "Baraja Francesa Mostrable";
		cartas = new Carta[52];
		Carta carta;
		StringBuilder ruta = new StringBuilder("/opoo/practica4/juego/imgfra/");
		reverso = new ImageIcon(getClass().getResource(
				ruta.toString() + "rev.jpg"));
		vacia = new ImageIcon(getClass().getResource(
				"/opoo/practica4/juego/imgs/vacia.jpg"));
		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 10; i++) {
				ruta.append(i + palos[k] + ".jpg");
				carta = new CartaFrancesaMostrable(palos[k], i, i,
						new ImageIcon(getClass().getResource(ruta.toString())));
				cartas[j] = carta;
				j++;
				ruta.setLength(ruta.length() - 6);
			}
			for (int i = 10; i < 14; i++) {
				ruta.append(i + palos[k] + ".jpg");
				carta = new CartaFrancesaMostrable(palos[k], i, 10,
						new ImageIcon(getClass().getResource(ruta.toString())));
				cartas[j] = carta;
				j++;
				ruta.setLength(ruta.length() - 7);
			}
		}
	}

	@Override
	public ImageIcon getReverso() {
		return reverso;
	}

	@Override
	public void setReverso(ImageIcon img) {
		this.reverso = img;
	}

	@Override
	public ImageIcon getVacia() {
		return vacia;
	}

	@Override
	public void setVacia(ImageIcon img) {
		this.vacia = img;
	}

}
