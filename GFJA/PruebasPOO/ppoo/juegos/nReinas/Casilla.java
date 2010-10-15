//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Juego de las Nreinas
// ASIGNATURA : Programacion Orientada a Objetos
//

package ppoo.juegos.nReinas;

/**
 * Clase que representa una casilla en el juego Nreinas
 * 
 * @author José Ángel García Fernández
 * @version 1.0 01/10/2010
 */
public class Casilla {

	/**
	 * El valor de la casilla
	 */
	private TipoCas valor;

	/**
	 * El número de veces que se ha sobreescrito la casilla
	 */
	private int repetido;

	/**
	 * Genera un objeto de tipo Casilla
	 * 
	 * @param valor
	 * @param repetido
	 */
	public Casilla(TipoCas valor, int repetido) {
		this.valor = valor;
		this.repetido = repetido;
	}

	/**
	 * Metodo para obtener la propiedad valor
	 * 
	 * @return the valor
	 */
	public TipoCas getValor() {
		return valor;
	}

	/**
	 * Metodo para modificar la propiedad valor
	 * 
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(TipoCas valor) {
		this.valor = valor;
	}

	/**
	 * Metodo para obtener la propiedad repetido
	 * 
	 * @return the repetido
	 */
	public int getRepetido() {
		return repetido;
	}

	/**
	 * Metodo que actualiza las propiedades en funcion del valor de repetido
	 * 
	 * @param mas
	 *            añade o decrementa repetido
	 */
	public void actualizar(boolean mas) {
		if (mas)
			repetido++;
		else {
			if (repetido != 0)
				repetido--;
		}
		if (repetido == 0)
			valor = TipoCas.VACIO;
		else
			valor = TipoCas.EXP;
	}

	public String toString() {
		return String.valueOf(valor);
	}

	/**
	 * Metodo que reinicia las propiedades de la casilla
	 */
	public void reiniciar() {
		repetido = 0;
		valor = TipoCas.VACIO;
	}
}
