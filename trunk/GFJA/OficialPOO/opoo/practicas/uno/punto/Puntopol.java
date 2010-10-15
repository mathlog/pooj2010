package opoo.practicas.uno.punto;

class Puntopol {
	private double angulo = 0;
	private double modulo = 0;

	public Puntopol(double angulo, double modulo) {
		this.angulo = angulo;
		this.modulo = modulo;
	}

	public Puntopol() {
		angulo = 0;
		modulo = 0;
	}

	public void rotar(double rotacion) {
		angulo += rotacion;

	}

	public double x() {
		return modulo * Math.cos(angulo);
	}

	public double y() {
		return modulo * Math.sin(angulo);
	}

	public double angulo() {
		return angulo;
	}

	public double modulo() {
		return modulo;
	}

}
