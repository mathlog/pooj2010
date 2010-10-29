package opoo.practica2.polinomios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import opoo.excepciones.DistintoGradoException;

/**
 * Clase que representa un monomio
 * 
 * @author José Ángel García Fernández
 * @version 1.0 22/10/2010
 */
public class Polinomio {

	private int gradoMax;

	// se guardara como orden de menor a mayor
	private List<Monomio> terminos;

	/**
	 * Metodo para obtener la propiedad gradoMax
	 * 
	 * @return the gradoMax
	 */
	public int getGradoMax() {
		return gradoMax;
	}

	/**
	 * Metodo para obtener la propiedad terminos
	 * 
	 * @return the terminos
	 */
	public List<Monomio> getTerminos() {
		return terminos;
	}

	/**
	 * Genera un objeto de tipo Polinomio a partir de un list de monomios
	 * 
	 * @param terminos
	 *            cada uno de los monomios
	 */
	public Polinomio(List<Monomio> terminos) {
		Collections.sort(terminos);
		this.terminos = terminos;
		gradoMax = terminos.get(terminos.size() - 1).getGrado();
	}

	/**
	 * Genera un objeto de tipo Polinomio a partir de un array de coeficientes
	 * completo
	 * 
	 * @param coeficientes
	 *            los coeficientes del polinomio
	 */
	public Polinomio(Double[] coeficientes) {
		terminos = new ArrayList<Monomio>(coeficientes.length);
		for (int i = 0; i < coeficientes.length; i++)
			terminos.add(new Monomio(coeficientes[i], i, 'x'));
		gradoMax = coeficientes.length - 1;
	}

	/**
	 * Añade un monomio al polinomio
	 * 
	 * @param otro
	 *            el nuevo monomio
	 */
	public void addMonomio(Monomio otro) {
		terminos.add(otro);
		Collections.sort(terminos);
	}

	/**
	 * Suma el polinomio this con otro
	 * 
	 * @param otro
	 *            polinomio
	 * @return this+otro
	 */
	public Polinomio sumar(Polinomio otro) {
		ArrayList<Monomio> termSumas = new ArrayList<Monomio>();
		Iterator<Monomio> it = terminos.iterator();
		Iterator<Monomio> it2 = otro.terminos.iterator();
		while (it.hasNext()) {
			Monomio aux = it.next();
			while (it2.hasNext())
				try {
					termSumas.add(aux.sumar(it2.next()));
					break;// ya ha encontrao comun me voy
				} catch (DistintoGradoException e) {
					if (!it2.hasNext())// si no hay comunes lo mete direc
						termSumas.add(aux);
				}
			it2 = otro.terminos.iterator();
		}
		return new Polinomio(termSumas);
	}

	/**
	 * Resta el polinomio this con otro
	 * 
	 * @param otro
	 *            polinomio
	 * @return this-otro
	 */
	public Polinomio restar(Polinomio otro) {

		ArrayList<Monomio> termRestas = new ArrayList<Monomio>();
		Iterator<Monomio> it = terminos.iterator();
		Iterator<Monomio> it2 = otro.terminos.iterator();
		while (it.hasNext()) {
			Monomio aux = it.next();
			while (it2.hasNext())
				try {
					termRestas.add(aux.restar(it2.next()));
					break;// ya ha encontrao comun me voy
				} catch (DistintoGradoException e) {
					if (!it2.hasNext())// si no hay comunes lo mete direc
						termRestas.add(aux);
				}
			it2 = otro.terminos.iterator();
		}
		return new Polinomio(termRestas);
	}

	/**
	 * Multiplica el polinomio this con otro
	 * 
	 * @param otro
	 *            polinomio
	 * @return this*otro
	 */
	public Polinomio mult(Polinomio otro) {
		ArrayList<Monomio> termMult = new ArrayList<Monomio>();
		Iterator<Monomio> it = terminos.iterator();
		Iterator<Monomio> it2 = otro.terminos.iterator();
		while (it.hasNext()) {
			Monomio aux = it.next();
			while (it2.hasNext())
				termMult.add(aux.mult(it2.next()));
			it2 = otro.terminos.iterator();
		}
		juntarComunes(termMult);
		return new Polinomio(termMult);
	}

	/**
	 * Dado una lista de monomios junta los comunes
	 * 
	 * @param terms
	 *            la lista de monomios a juntar
	 */
	@SuppressWarnings("unchecked")
	private void juntarComunes(ArrayList<Monomio> terms) {

		ArrayList<Monomio> auxTerms = (ArrayList<Monomio>) terms.clone();
		ArrayList<Integer> grados = new ArrayList<Integer>();
		terms.clear();// limpio terms, metere los buenos
		int gradoAux;
		double coefiAux;
		Iterator<Monomio> it;
		Monomio aux, aux2;
		it = auxTerms.iterator();
		aux = it.next();
		while (true) {// siempre itera hasta que lanza excepcion
			gradoAux = aux.getGrado();
			if (!grados.contains(gradoAux)) {// si no ha sido estudiado ya
				grados.add(gradoAux);// marco grado
				coefiAux = aux.getCoeficiente();
				while (it.hasNext()) {
					aux2 = it.next();
					if (aux2.getGrado() == gradoAux)// añado coeficientes
						coefiAux += aux2.getCoeficiente();
				}
				it = auxTerms.iterator();// añado monomio
				terms.add(new Monomio(coefiAux, gradoAux, aux.getLiteral()));
			} else {// si lo ha sido busco uno que no
				try {
					aux = it.next();
					while (grados.contains(aux.getGrado())) {
						aux = it.next();
					}
				} catch (NoSuchElementException e) {// ya han sido estudiados
													// todos
					break;
				}
			}
		}
	}

	/**
	 * Multiplica this por un escalar
	 * 
	 * @param escalar
	 *            a multiplicar
	 * @return this*escalar
	 */
	public Polinomio multEsc(double escalar) {
		Iterator<Monomio> it = terminos.iterator();
		ArrayList<Monomio> termEsc = new ArrayList<Monomio>();
		while (it.hasNext())
			termEsc.add(it.next().multEsc(escalar));
		return new Polinomio(termEsc);
	}

	/**
	 * Suma dos Polinomios
	 * 
	 * @param a
	 *            el primer Polinomio
	 * @param b
	 *            el segundo Polinomio
	 * @return a+b
	 */
	public static Polinomio sumar(Polinomio a, Polinomio b) {
		return a.sumar(b);
	}

	/**
	 * Resta dos Polinomios
	 * 
	 * @param a
	 *            el primer Polinomio
	 * @param b
	 *            el segundo Polinomio
	 * @return a-b
	 */
	public static Polinomio restar(Polinomio a, Polinomio b) {
		return a.restar(b);
	}

	/**
	 * Multiplica dos Polinomios
	 * 
	 * @param a
	 *            el primer Polinomio
	 * @param b
	 *            el segundo Polinomio
	 * @return a*b
	 */
	public static Polinomio mult(Polinomio a, Polinomio b) {
		return a.mult(b);
	}

	/**
	 * Multiplica un Polinomio por un escalar
	 * 
	 * @param a
	 *            el Polinomio
	 * @param escalar
	 *            a multiplicar
	 * @return a*escalar
	 */
	public static Polinomio multEsc(Polinomio a, double escalar) {
		return a.multEsc(escalar);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Iterator<Monomio> it = terminos.iterator(); it.hasNext();)
			sb.append(it.next());
		return sb.toString();
	}
}
