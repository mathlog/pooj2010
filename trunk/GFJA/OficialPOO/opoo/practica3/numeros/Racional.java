package opoo.practica3.numeros;

public class Racional extends Real {

	private long numerador;
	private long denominador;

	// CONSTRUCTOR
	public Racional(long num, long den) {
		super((double) num / den);
		numerador = num;
		denominador = den;
	}

	public String toString() {
		return (numerador + "/" + denominador);
	}

	// ACCESORES

	public long getNumerador() {
		return numerador;
	}

	public long getDenominador() {
		return denominador;
	}

	// OPERACIONES

	/**
	 * Devuelve el resultado de sumar este número y el que se pasa como
	 * parámetro. No modifica ninguno de los objetos (ni este número ni el
	 * parámetro)
	 */
	public Racional suma(Racional op) {
		long num = numerador * op.getDenominador() + denominador
				* op.getNumerador();
		long den = denominador * op.getDenominador();
		return (new Racional(num, den));
	}

	/**
	 * Devuelve el resultado de restar a este número el que se pasa como
	 * parámetro. No modifica ninguno de los objetos (ni este número ni el
	 * parámetro)
	 */
	public Racional resta(Racional op) {
		long num = numerador * op.getDenominador() - denominador
				* op.getNumerador();
		long den = denominador * op.getDenominador();
		return (new Racional(num, den));
	}

	/**
	 * Devuelve el resultado de multiplicar este número y el que se pasa como
	 * parámetro. No modifica ninguno de los objetos (ni este número ni el
	 * parámetro)
	 */
	public Racional multiplica(Racional op) {
		return (new Racional(numerador * op.getNumerador(), denominador
				* op.getDenominador()));
	}

	/**
	 * Devuelve el resultado de dividir este número por el que se pasa como
	 * parámetro. No modifica ninguno de los objetos (ni este número ni el
	 * parámetro)
	 */
	public Racional divide(Racional op) {
		return (new Racional(numerador * op.getDenominador(), denominador
				* op.getNumerador()));
	}

}
