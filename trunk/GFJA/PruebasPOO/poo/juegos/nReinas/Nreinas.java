//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//

package poo.juegos.nReinas;

enum TipoCas {
	VACIO, REINA, EXP
}

/**
 * Clase que representa el juego de las Nreinas
 * 
 * @author José Ángel García Fernández
 * @version 1.0 01/10/2010
 */
public class Nreinas {

	private enum TipoPos {
		BAJO, DER, UP, IZQ
	};

	/**
	 * Matriz de dimxdim que representa el tablero
	 */
	private Casilla[][] tablero;
	/**
	 * Representa el tamaño del tablero
	 */
	private int dim;

	/**
	 * Representa si hay solucion para el juego
	 */
	private boolean sol;

	/**
	 * Metodo para obtener la propiedad dim
	 * 
	 * @return the dim
	 */
	public int getDim() {
		return dim;
	}

	/**
	 * Metodo para obtener la propiedad sol
	 * 
	 * @return the sol
	 */
	public boolean isSol() {
		return sol;
	}

	/**
	 * Metodo para modificar la propiedad sol
	 * 
	 * @param sol
	 *            the sol to set
	 */
	public void setSol(boolean sol) {
		this.sol = sol;
	}

	/**
	 * Genera un objeto de tipo Nreinas vaciando tablero
	 * 
	 * @param dim
	 *            la dimension del tablero
	 */
	public Nreinas(int dim) {
		this.dim = dim;
		tablero = new Casilla[dim][dim];
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
				tablero[i][j] = new Casilla(TipoCas.VACIO, 0);
	}

	/**
	 * Metodo que comprueba si se puede colocar una reina en la posicion (i,j)
	 * 
	 * @param i
	 *            la fila i
	 * @param j
	 *            la columna j
	 * @return devuelve true si se puede ,false en caso contrario
	 */
	public boolean comprobarReina(int i, int j) {
		return tablero[i][j].getValor() != TipoCas.VACIO ? false : true;
	}

	/**
	 * Metodo para comprobar si una posicion diagonal es valida
	 * 
	 * @param i
	 *            fila i
	 * @param j
	 *            columna j
	 * @param z
	 *            desplazamiento diagonal
	 * @param caso
	 *            PosCaso
	 * @return si la posicion es valida
	 */
	private boolean fuera(int i, int j, int z, TipoPos caso) {
		boolean fuera = false;
		switch (caso) {
		case BAJO:
			if (i + z >= dim)
				fuera = true;
			break;
		case DER:
			if (j + z >= dim)
				fuera = true;
			break;
		case UP:
			if (i - z < 0)
				fuera = true;
			break;
		case IZQ:
			if (j - z < 0)
				fuera = true;
			break;
		}
		return fuera;
	}

	/**
	 * Metodo que añade o elimina una reina del tablero
	 * 
	 * @param i
	 *            la fila i
	 * @param j
	 *            la columna j
	 * @param add
	 *            true añade false elimina
	 */
	public void addReina(int i, int j, boolean add) throws BorradoReinaNoExisteException {
		int z;
		if (add)
			tablero[i][j].setValor(TipoCas.REINA);
		else {
			if (tablero[i][j].getValor() == TipoCas.VACIO)
				throw new BorradoReinaNoExisteException("No hay reina en esa posicion");
			tablero[i][j].setValor(TipoCas.VACIO);
		}
		// rellenar fila
		for (z = 0; z < dim; z++)
			if (z != j)
				tablero[i][z].actualizar(add);
		// rellenar columna
		for (z = 0; z < dim; z++)
			if (z != i)
				tablero[z][j].actualizar(add);
		// rellenar diagonal
		for (z = 1; z < dim; z++) {
			if (!(fuera(i, j, z, TipoPos.BAJO) || fuera(i, j, z, TipoPos.DER)))
				tablero[i + z][j + z].actualizar(add);// bajoder
			if (!(fuera(i, j, z, TipoPos.UP) || fuera(i, j, z, TipoPos.IZQ)))
				tablero[i - z][j - z].actualizar(add);// upizq
			if (!(fuera(i, j, z, TipoPos.BAJO) || fuera(i, j, z, TipoPos.IZQ)))
				tablero[i + z][j - z].actualizar(add);// bajoizq
			if (!(fuera(i, j, z, TipoPos.UP) || fuera(i, j, z, TipoPos.DER)))
				tablero[i - z][j + z].actualizar(add);// upder
		}
	}

	/**
	 * Metodo que soluciona el juego
	 * 
	 * @param i
	 *            posicion de inicio
	 * @throws BorradoReinaNoExisteException cuando se intente borrar una reina que no existe
	 */
	public void solve(int i) throws BorradoReinaNoExisteException {
		int j = 0;
		sol = false;
		do {
			if (comprobarReina(i, j)) {
				addReina(i, j, true);
				if (i < dim - 1) { // encuentra solucion?
					solve(i + 1);
					if (!sol)
						addReina(i, j, false);
				} else
					sol = true; // encuentra la solucion
			}
			j++;
		} while (!sol && j < dim);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("+ ");
		for (int j = 0; j < dim; j++) sb.append(j+" ");
		sb.append("\n");
		for (int i = 0; i < dim; i++) {
			sb.append(i+" ");
			for (int j = 0; j < dim; j++)
				if (tablero[i][j].getValor() == TipoCas.REINA)
					sb.append("R ");
				else if (tablero[i][j].getValor() == TipoCas.EXP)
					sb.append("x ");
				else
					sb.append("- ");
			sb.append("\n");
		}
		return sb.toString();
	}
}
