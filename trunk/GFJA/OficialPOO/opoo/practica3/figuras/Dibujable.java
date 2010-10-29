package opoo.practica3.figuras;

// fichero Dibujable.java
import java.awt.Graphics;

public interface Dibujable {

	public void setPosicion(double x, double y);

	public void dibujar(Graphics dw);
}
