package opoo.practica3.numeros;

public class Complejo {
	public static final int CARTESIANAS = 0;
	public static final int POLARES = 1;
	private double parteReal;
	private double parteImaginaria;

	// CONSTRUCTORES
	public Complejo(double real, double imaginaria) {
		this(real, imaginaria, CARTESIANAS);
	}

	public Complejo(double a, double b, int coordenadas) {
		switch (coordenadas) {
		case POLARES:
			parteReal = a * Math.cos(b);
			parteImaginaria = a * Math.sin(b);
			break;
		default:
			parteReal = a;
			parteImaginaria = b;
		}
	}

	// ACCESORES
	public double getParteReal() {
		return parteReal;
	}

	public double getParteImaginaria() {
		return parteImaginaria;
	}

	public String toString() {
		if (parteImaginaria >= 0) {
			return ("(" + parteReal + " + " + parteImaginaria + "i)");
		} else {
			return ("(" + parteReal + " - " + (-parteImaginaria) + "i)");
		}
	}

	public void inverso() {
		double modulo2 = Math.pow(getModulo(), 2);
		parteReal = parteReal / modulo2;
		parteImaginaria = -parteImaginaria / modulo2;
	}

	public void opuesto() {
		parteReal = -parteReal;
		parteImaginaria = -parteImaginaria;
	}

	public Complejo suma(Complejo op) {
		Complejo resultado = new Complejo(parteReal + op.getParteReal(),
				parteImaginaria + op.getParteImaginaria());
		return resultado;
	}

	public Complejo resta(Complejo op) {
		Complejo resultado = new Complejo(parteReal - op.getParteReal(),
				parteImaginaria - op.getParteImaginaria());
		return resultado;
	}

	public Complejo multiplica(Complejo op) {
		double resReal = parteReal * op.getParteReal() - parteImaginaria
				* op.getParteImaginaria();
		double resImag = parteReal * op.getParteImaginaria() + parteImaginaria
				* op.getParteReal();
		return (new Complejo(resReal, resImag));
	}

	public Complejo divide(Complejo op) {
		Complejo inverso;
		// Necesitamos un objeto auxiliar para no modificar el parámetro
		inverso = new Complejo(op.getParteReal(), op.getParteImaginaria());
		// invertimos el divisor
		inverso.inverso();
		return multiplica(inverso);
	}

	public Complejo calcularConjugado() {
		return new Complejo(parteReal, -parteImaginaria);
	}

	public double getModulo() {
		return Math.sqrt(Math.pow(parteReal, 2) + Math.pow(parteImaginaria, 2));
	}

	public double getFase() {
		double fase = Math.atan(parteImaginaria / parteReal);
		if (parteReal < 0) {
			if (parteImaginaria >= 0) {
				fase = fase + Math.PI;
			} else {
				fase = fase - Math.PI;
			}
		}
		return fase;
	}
}
