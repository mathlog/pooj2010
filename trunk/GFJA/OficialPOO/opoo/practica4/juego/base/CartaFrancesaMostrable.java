package opoo.practica4.juego.base;

import javax.swing.ImageIcon;

public class CartaFrancesaMostrable extends CartaFrancesa implements
		CartaMostrable {

	private ImageIcon imagen;

	public CartaFrancesaMostrable(String palo, int numero, float valor,
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
