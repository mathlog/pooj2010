//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica2.polinomios;

import opoo.practica1.fecha.Fecha;

/**
 * Clase que representa un monomio
 * 
 * @author José Ángel García Fernández
 * @version 1.0 22/10/2010
 */
public class Monomio implements Comparable {

	private double coeficiente;

	private int grado;

	private char literal;

	/**
	 * Metodo para obtener la propiedad literal
	 * 
	 * @return the literal
	 */
	public char getLiteral() {
		return literal;
	}

	/**
	 * Metodo para modificar la propiedad literal
	 * 
	 * @param literal
	 *            the literal to set
	 */
	public void setLiteral(char literal) {
		this.literal = literal;
	}

	/**
	 * Metodo para obtener la propiedad coeficiente
	 * 
	 * @return the coeficiente
	 */
	public double getCoeficiente() {
		return coeficiente;
	}

	/**
	 * Metodo para obtener la propiedad grado
	 * 
	 * @return the grado
	 */
	public int getGrado() {
		return grado;
	}

	/**
	 * Genera un objeto de tipo Monomio
	 * 
	 * @param coeficiente
	 * @param grado
	 * @param literal
	 */
	public Monomio(double coeficiente, int grado, char literal) {
		this.coeficiente = coeficiente;
		this.grado = grado;
		this.literal = literal;
	}

	@Override
	public String toString() {
		return String.format("%+.1f", coeficiente)
				+ (grado != 0 ? literal : "") + (grado > 1 ? "^" + grado : "");
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Monomio))
			return false;
		Monomio otro = (Monomio) o;
		return grado == otro.grado && coeficiente == otro.coeficiente
				&& literal == otro.literal;
	}

	@Override
	public int compareTo(Object o) {
		if (equals(o))
			return 0;
		Monomio otro = (Monomio) o;
		if (grado < otro.grado)
			return -1;
		else
			return 1;
	}

	public Monomio sumar(Monomio otro) {
		if (grado != otro.grado) {
			// excepcion
			return null;
		} else
			return new Monomio(coeficiente + otro.coeficiente, grado, literal);
	}

	public Monomio restar(Monomio otro) {
		if (grado != otro.grado) {
			// excepcion
			return null;
		} else
			return new Monomio(coeficiente - otro.coeficiente, grado, literal);
	}

	public Monomio mult(Monomio otro) {
		return new Monomio(coeficiente * otro.coeficiente, grado + otro.grado,
				literal);
	}

	public Monomio multEsc(double escalar) {
		return new Monomio(coeficiente * escalar, grado, literal);
	}

	public static Monomio sumar(Monomio a, Monomio b) {
		if (a.grado != b.grado) {
			// excepcion
			return null;
		} else
			return new Monomio(a.coeficiente + b.coeficiente, a.grado,
					a.literal);
	}

	public static Monomio restar(Monomio a, Monomio b) {
		if (a.grado != b.grado) {
			// excepcion
			return null;
		} else
			return new Monomio(a.coeficiente - b.coeficiente, a.grado,
					a.literal);
	}

	public static Monomio mult(Monomio a, Monomio b) {
		return new Monomio(a.coeficiente * b.coeficiente, a.grado + b.grado,
				a.literal);
	}

	public static Monomio multEsc(Monomio a, double escalar) {
		return new Monomio(a.coeficiente * escalar, a.grado, a.literal);
	}
}
