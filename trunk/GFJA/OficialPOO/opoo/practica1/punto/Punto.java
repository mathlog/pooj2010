package opoo.practica1.punto;

class Punto {
	private int x = 0;
	private int y = 0;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punto(double angulo, double modulo) {
		this.x = (int) (modulo * Math.cos(angulo));
		this.y = (int) (modulo * Math.sin(angulo));
	}

	public Punto() {
		x = 0;
		y = 0;
	}

	public void desplazar(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public double angulo() {
		return Math.atan2(x, y);
	}

	public double modulo() {
		return Math.sqrt(x * x + y * y);
	}

	public void rotar(double rotacion) {
		this.x = (int) (modulo() * Math.cos(this.angulo() + rotacion));

	}

}
