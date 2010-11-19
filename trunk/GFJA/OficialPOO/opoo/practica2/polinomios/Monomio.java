//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Polinomios
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica2.polinomios;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import opoo.excepciones.IncompatibleMonomioException;

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
	 *            a poner
	 * @param grado
	 *            a poner
	 * @param literal
	 *            a poner
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
		// en funcion de si es positivo o negativo definimos 2 formas de mostrar
		DecimalFormat form = new DecimalFormat("+#.#;-#.#");
		// establecemos el punto como separador decimal
		DecimalFormatSymbols dc = form.getDecimalFormatSymbols();
		dc.setDecimalSeparator('.');
		form.setDecimalFormatSymbols(dc);
		// en funcion de grado mostramos el literal y la potencia
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
	 * Comprueba si 2 monomios son compatibles
	 * 
	 * @param otro
	 *            monomio
	 * @return si son compatibles o no
	 */
	public boolean compatible(Monomio otro) {
		if (grado == otro.grado)
			return true;
		else
			return false;
	}

	/**
	 * Suma al monomio this otro
	 * 
	 * @param otro
	 *            monomio
	 * @throws IncompatibleMonomioException
	 *             si no son compatibles
	 */
	public void addSumar(Monomio otro) throws IncompatibleMonomioException {
		if (!compatible(otro))
			throw new IncompatibleMonomioException("(" + this + ") + (" + otro
					+ ")");
		else
			coeficiente += otro.coeficiente;
	}

	/**
	 * Resta al monomio this otro
	 * 
	 * @param otro
	 *            monomio
	 * @throws IncompatibleMonomioException
	 *             si no son compatibles
	 */
	public void addRestar(Monomio otro) throws IncompatibleMonomioException {
		if (!compatible(otro))
			throw new IncompatibleMonomioException("(" + this + ") - (" + otro
					+ ")");
		else
			coeficiente -= otro.coeficiente;
	}

	/**
	 * Multiplica al monomio this otro
	 * 
	 * @param otro
	 *            monomio
	 */
	public void addMult(Monomio otro) {
		coeficiente *= otro.coeficiente;
		grado += otro.grado;
	}

	/**
	 * Multiplica this por un escalar
	 * 
	 * @param escalar
	 *            a multiplicar
	 */
	public void addMultEsc(double escalar) {
		coeficiente *= escalar;
	}

	/**
	 * Suma el monomio this con otro
	 * 
	 * @param otro
	 *            monomio
	 * @return this+monomio
	 * @throws IncompatibleMonomioException
	 *             si no son compatibles
	 */
	public Monomio sumar(Monomio otro) throws IncompatibleMonomioException {
		if (!compatible(otro)) {
			throw new IncompatibleMonomioException("(" + this + ") + (" + otro
					+ ")");
		} else
			return new Monomio(coeficiente + otro.coeficiente, grado, literal);
	}

	/**
	 * Resta el monomio this con otro
	 * 
	 * @param otro
	 *            monomio
	 * @return this-monomio
	 * @throws IncompatibleMonomioException
	 *             si no tienen el mismo grado
	 */
	public Monomio restar(Monomio otro) throws IncompatibleMonomioException {
		if (!compatible(otro)) {
			throw new IncompatibleMonomioException("(" + this + ") - (" + otro
					+ ")");
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
	 * @throws IncompatibleMonomioException
	 *             si no tienen el mismo grado
	 */
	public static Monomio sumar(Monomio a, Monomio b)
			throws IncompatibleMonomioException {
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
	 * @throws IncompatibleMonomioException
	 *             si no tienen el mismo grado
	 */
	public static Monomio restar(Monomio a, Monomio b)
			throws IncompatibleMonomioException {
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
