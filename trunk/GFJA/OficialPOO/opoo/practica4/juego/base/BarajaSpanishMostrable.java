package opoo.practica4.juego.base;

import javax.swing.ImageIcon;

public class BarajaSpanishMostrable extends BarajaSpanish implements
		BarajaMostrable {

	private ImageIcon reverso;
	private ImageIcon vacia;

	@Override
	protected void creaBaraja() {
		this.nombreBaraja = "Baraja Española";
		cartas = new Carta[40];
		Carta carta;
		StringBuilder ruta = new StringBuilder("/opoo/practica4/juego/imgspa/");
		reverso = new ImageIcon(getClass().getResource(
				ruta.toString() + "rev.jpg"));
		vacia = new ImageIcon(getClass().getResource(
				"/opoo/practica4/juego/imgs/vacia.jpg"));
		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 8; i++) {
				ruta.append(i + palos[k] + ".jpg");
				carta = new CartaSpanishMostrable(palos[k], i, i,
						new ImageIcon(getClass().getResource(ruta.toString())));
				cartas[j] = carta;
				j++;
				ruta.setLength(ruta.length() - 6);
			}
			for (int i = 10; i < 13; i++) {
				ruta.append(i + palos[k] + ".jpg");
				carta = new CartaSpanishMostrable(palos[k], i, 0.5f,
						new ImageIcon(getClass().getResource(ruta.toString())));
				cartas[j] = carta;
				j++;
				ruta.setLength(ruta.length() - 7);
			}
		}
	}

	@Override
	public ImageIcon getReverso() {
		// TODO Auto-generated method stub
		return reverso;
	}

	@Override
	public void setReverso(ImageIcon img) {
		this.reverso = img;
	}

	@Override
	public ImageIcon getVacia() {
		// TODO Auto-generated method stub
		return vacia;
	}

	@Override
	public void setVacia(ImageIcon img) {
		this.vacia = img;

	}
}
