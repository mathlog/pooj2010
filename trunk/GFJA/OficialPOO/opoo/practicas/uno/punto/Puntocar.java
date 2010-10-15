package opoo.practicas.uno.punto;

class Puntocar {
	private int x = 0;
	private int y = 0;

	public Puntocar(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Puntocar() {
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

}
