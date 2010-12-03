//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Polinomios
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica2.polinomios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import opoo.excepciones.IncompatibleMonomioException;

/**
 * Clase que representa un Polinomio
 * 
 * @author José Ángel García Fernández
 * @version 1.0 22/10/2010
 */
public class Polinomio {

	// se guardara como orden de menor a mayor
	private List<Monomio> terminos;

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
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<Monomio> it = terminos.iterator(); it.hasNext();)
			sb.append(it.next());
		return sb.toString();
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
	 * Elimina un monomio del polinomio
	 * 
	 * @param otro
	 *            el monomio a eliminar
	 * @return true si se ha borrado false si no existe
	 */
	public boolean removeMonomio(Monomio otro) {
		return terminos.remove(otro);
	}

	/**
	 * Cambia la variable del polinomio
	 * 
	 * @param variable
	 *            a poner
	 */
	public void cambiarVariable(char variable) {
		ListIterator<Monomio> it = terminos.listIterator();
		while (it.hasNext()) {
			it.next().setLiteral(variable);
		}
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
					break;// ya ha encontrado comun me salgo
				} catch (IncompatibleMonomioException e) {
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
					break;// ya ha encontrao comun me salgo
				} catch (IncompatibleMonomioException e) {
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
		terms.clear();// limpio terms, metere los validos
		Iterator<Monomio> it = auxTerms.iterator();
		ListIterator<Monomio> it2 = auxTerms.listIterator();
		Monomio aux, aux2, comunes;
		// itero comparando cada valor con todos los demas
		// cada vez que junte un comun lo elimina
		while (it.hasNext()) {
			aux = it.next();
			comunes = new Monomio(aux);// guardara los valores comunes
			while (it2.hasNext()) {
				aux2 = it2.next();
				if ((aux != aux2)) {// si no es él mismo
					try {
						comunes.addSumar(aux2);
						it2.remove();// delete ya estudiado
					} catch (IncompatibleMonomioException e) {
						continue;// continua iterando
					}
				}
			}
			terms.add(comunes);
			auxTerms.remove(aux);// del ya estudiado
			// reseteo iteradores
			it = auxTerms.iterator();
			it2 = auxTerms.listIterator();
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
}
