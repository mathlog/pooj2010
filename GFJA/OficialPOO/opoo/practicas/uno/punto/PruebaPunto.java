package opoo.practicas.uno.punto;

public class PruebaPunto {

	public static void main(String[] args) {
		// PRUEBA CONSTRUCTORES
		// crea un punto en 2D situado en (-2,0)
		Punto p = new Punto(-2, 0);
		// crea un punto en 2D a partir de un modulo y un angulo
		Punto pp = new Punto(0.0, -2.0);
		// crea un punto 2D por defecto (0,0)
		Punto pD = new Punto();
		// PRUEBA DESPLAZAR
		System.out.println("Antes desplazamiento en 2 unidades pc esta en ("
				+ p.x() + "," + p.y() + ")");
		p.desplazar(2, 2);
		System.out.println("Despues de desplazamiento pc esta en (" + p.x()
				+ "," + p.y() + ")\n");
		// PRUEBA ANGULO
		System.out.println("El angulo del punto es " + p.angulo() + "º");
		// PRUEBA MODULO
		System.out.println("El modulo del punto es " + p.modulo() + "\n");
		// PRUEBA rotar
		System.out.println("Antes de rotacion de 180º pc esta en (" + p.x()
				+ "," + p.y() + ")");
		p.rotar(180.0);
		System.out.println("Despues de rotacion pc esta en (" + p.x() + ","
				+ p.y() + ")");
	}
}
