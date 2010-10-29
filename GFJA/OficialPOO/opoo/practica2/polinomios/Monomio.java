//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica2.polinomios;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import opoo.excepciones.DistintoGradoException;

/**
 * Clase que representa un monomio
 * 
 * @author José Ángel García Fernández
 * @version 1.0 22/10/2010
 */
public class Monomio implements Comparable<Monomio> {

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

	/**
	 * Genera un objeto de tipo Monomio por defecto
	 */
	public Monomio() {
		this(1.0, 0, 'x');
	}

	/**
	 * Genera un objeto de tipo Monomio a partir de otro
	 * 
	 * @param otro
	 *            monomio
	 */
	public Monomio(Monomio otro) {
		this(otro.coeficiente, otro.grado, otro.literal);
	}

	@Override
	public String toString() {
		if (coeficiente == 0)
			return "";

		DecimalFormat form = new DecimalFormat("+#.#;-#.#");
		DecimalFormatSymbols dc = form.getDecimalFormatSymbols();
		dc.setDecimalSeparator('.');
		form.setDecimalFormatSymbols(dc);
		return form.format(coeficiente) + (grado != 0 ? literal : "")
				+ (grado > 1 ? "^" + grado : "");
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
	public int compareTo(Monomio o) {
		if (equals(o))
			return 0;
		Monomio otro = (Monomio) o;
		if (grado < otro.grado)
			return -1;
		else
			return 1;
	}

	/**
	 * Suma el monomio this con otro
	 * 
	 * @param otro
	 *            monomio
	 * @return this+monomio
	 * @throws DistintoGradoException
	 *             si no tienen el mismo grado
	 */
	public Monomio sumar(Monomio otro) throws DistintoGradoException {
		if (grado != otro.grado) {
			throw new DistintoGradoException("(" + this + ") + (" + otro + ")");
		} else
			return new Monomio(coeficiente + otro.coeficiente, grado, literal);
	}

	/**
	 * Resta el monomio this con otro
	 * 
	 * @param otro
	 *            monomio
	 * @return this-monomio
	 * @throws DistintoGradoException
	 *             si no tienen el mismo grado
	 */
	public Monomio restar(Monomio otro) throws DistintoGradoException {
		if (grado != otro.grado) {
			throw new DistintoGradoException("(" + this + ") - (" + otro + ")");
		} else
			return new Monomio(coeficiente - otro.coeficiente, grado, literal);
	}

	/**
	 * Multiplica el monomio this con otro
	 * 
	 * @param otro
	 *            monomio
	 * @return this*monomio
	 */
	public Monomio mult(Monomio otro) {
		return new Monomio(coeficiente * otro.coeficiente, grado + otro.grado,
				literal);
	}

	/**
	 * Multiplica this por un escalar
	 * 
	 * @param escalar
	 *            a multiplicar
	 * @return this*escalar
	 */
	public Monomio multEsc(double escalar) {
		return new Monomio(coeficiente * escalar, grado, literal);
	}

	/**
	 * Suma dos monomios
	 * 
	 * @param a
	 *            el primer monomio
	 * @param b
	 *            el segundo monomio
	 * @return a+b
	 * @throws DistintoGradoException
	 *             si no tienen el mismo grado
	 */
	public static Monomio sumar(Monomio a, Monomio b)
			throws DistintoGradoException {
		return a.sumar(b);
	}

	/**
	 * Resta dos monomios
	 * 
	 * @param a
	 *            el primer monomio
	 * @param b
	 *            el segundo monomio
	 * @return a-b
	 * @throws DistintoGradoException
	 *             si no tienen el mismo grado
	 */
	public static Monomio restar(Monomio a, Monomio b)
			throws DistintoGradoException {
		return a.restar(b);
	}

	/**
	 * Multiplica dos monomios
	 * 
	 * @param a
	 *            el primer monomio
	 * @param b
	 *            el segundo monomio
	 * @return a*b
	 */
	public static Monomio mult(Monomio a, Monomio b) {
		return a.mult(b);
	}

	/**
	 * Multiplica un monomio por un escalar
	 * 
	 * @param a
	 *            el monomio
	 * @param escalar
	 *            a multiplicar
	 * @return a*escalar
	 */
	public static Monomio multEsc(Monomio a, double escalar) {
		return a.multEsc(escalar);
	}
}
