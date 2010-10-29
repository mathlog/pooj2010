package opoo.practica3.numeros;

public class Real extends Complejo {

	public Real(double valor) {
		super(valor, 0);
	}

	public double getValor() {
		return getParteReal();
	}

	public String toString() {
		return (String.valueOf(getValor()));
	}

	public Real suma(Real op) {
		return (new Real(getValor() + op.getValor()));
	}

	public Real resta(Real op) {
		return (new Real(getValor() - op.getValor()));
	}

	public Real multiplica(Real op) {
		return (new Real(getValor() * op.getValor()));
	}

	public Real divide(Real op) {
		return (new Real(getValor() / op.getValor()));
	}
}
