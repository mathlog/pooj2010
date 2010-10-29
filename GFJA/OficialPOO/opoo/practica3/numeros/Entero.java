package opoo.practica3.numeros;

public class Entero extends Real {

	// CONSTRUCTOR
	public Entero(long valor) {
		super(valor);
	}

	public long getValorEntero() {
		return (long) getValor();
	}

	public String toString() {
		return (String.valueOf(getValorEntero()));
	}

	// OPERACIONES

	public Entero suma(Entero op) {
		return (new Entero(getValorEntero() + op.getValorEntero()));
	}

	public Entero resta(Entero op) {
		return (new Entero(getValorEntero() - op.getValorEntero()));
	}

	public Entero multiplica(Entero op) {
		return (new Entero(getValorEntero() * op.getValorEntero()));
	}

	public Entero divide(Entero op) {
		return (new Entero(getValorEntero() / op.getValorEntero()));
	}
}
