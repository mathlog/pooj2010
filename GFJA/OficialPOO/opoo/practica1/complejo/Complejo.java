package opoo.practica1.complejo;

import opoo.excepciones.ExcepcionDivideCero;

public class Complejo {
	private double real;
	private double imag;

	public Complejo() {
		real = 0.0;
		imag = 0.0;
	}

	public Complejo(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public Complejo conjugado(Complejo c) {
		return new Complejo(c.real, -c.imag);
	}

	public Complejo opuesto(Complejo c) {
		return new Complejo(-c.real, -c.imag);
	}

	public double modulo() {
		return Math.sqrt(real * real + imag * imag);
	}

	// devuelve el ángulo en grados
	public double argumento() {
		double angulo = Math.atan2(imag, real); // devuelve el ángulo entre -PI
												// y +PI
		if (angulo < 0)
			angulo = 2 * Math.PI + angulo;
		return angulo * 180 / Math.PI;
	}

	// suma de dos números complejos
	public static Complejo suma(Complejo c1, Complejo c2) {
		double x = c1.real + c2.real;
		double y = c1.imag + c2.imag;
		return new Complejo(x, y);
	}

	// suma de dos números complejos
	public Complejo suma(Complejo c2) {
		double x = real + c2.real;
		double y = imag + c2.imag;
		return new Complejo(x, y);
	}

	// producto de dos números complejos
	public static Complejo producto(Complejo c1, Complejo c2) {
		double x = c1.real * c2.real - c1.imag * c2.imag;
		double y = c1.real * c2.imag + c1.imag * c2.real;
		return new Complejo(x, y);
	}

	// producto de un complejo por un número real
	public static Complejo producto(Complejo c, double d) {
		double x = c.real * d;
		double y = c.imag * d;
		return new Complejo(x, y);
	}

	// producto de un número real por un complejo
	public static Complejo producto(double d, Complejo c) {
		double x = c.real * d;
		double y = c.imag * d;
		return new Complejo(x, y);
	}

	// cociente de dos números complejos
	// excepción cuando el complejo denominador es cero
	public static Complejo cociente(Complejo c1, Complejo c2)
			throws ExcepcionDivideCero {
		double aux, x, y;
		if (c2.modulo() == 0.0) {
			throw new ExcepcionDivideCero("Divide entre cero");
		} else {
			aux = c2.real * c2.real + c2.imag * c2.imag;
			x = (c1.real * c2.real + c1.imag * c2.imag) / aux;
			y = (c1.imag * c2.real - c1.real * c2.imag) / aux;
		}
		return new Complejo(x, y);
	}
}