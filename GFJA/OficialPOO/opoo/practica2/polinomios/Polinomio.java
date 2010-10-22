package opoo.practica2.polinomios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clase que representa un monomio
 * 
 * @author José Ángel García Fernández
 * @version 1.0 22/10/2010
 */
public class Polinomio {

	private int gradoMax;

	// se guardara como a1+a2x+a3x^2
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
	@SuppressWarnings("unchecked")
	public Polinomio(List<Monomio> terminos) {
		Collections.sort(terminos);
		this.terminos = terminos;
		gradoMax = terminos.get(terminos.size() - 1).getGrado();
	}

	/**
	 * Genera un objeto de tipo Polinomio a partir de un array de coeficientes
	 * 
	 * @param coeficientes
	 *            los coeficientes del polinomio
	 */
	public Polinomio(Double[] coeficientes) {
		terminos = new ArrayList<Monomio>(coeficientes.length);
		for (int i = 0; i < coeficientes.length; i++)
			terminos.add(new Monomio(coeficientes[i], i, 'x'));
		// gradoMax usando libreria
		gradoMax = coeficientes.length - 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Iterator<Monomio> it = terminos.iterator(); it.hasNext();)
			sb.append(it.next());
		return sb.toString();
	}

	// private Polinomio unir(Polinomio otro){
	// return new Polinomio(new ArrayList<Monomio>(otro.terminos));
	// }
	public Polinomio sumar(Polinomio otro) {
		ArrayList<Monomio> termSumas = new ArrayList<Monomio>();
		Iterator<Monomio> it = terminos.iterator();
		Iterator<Monomio> it2 = otro.terminos.iterator();
		while (it.hasNext()) {
			Monomio monomio = it.next().sumar(it2.next());

		}
		return otro;
	}

	public Polinomio restar(Polinomio otro) {

		return otro;
	}

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
		rejuntarComunes(termMult);
		return new Polinomio(termMult);
	}

	@SuppressWarnings("unchecked")
	private void rejuntarComunes(ArrayList<Monomio> terms) {

		ArrayList<Monomio> auxTerms = (ArrayList<Monomio>) terms.clone();
		ArrayList<Integer> grados = new ArrayList<Integer>();
		terms.clear();
		int gradoAux;
		double coefiAux;
		Iterator<Monomio> it;
		Monomio aux, aux2;
		it = auxTerms.iterator();
		aux = it.next();
		while (true) {
			gradoAux = aux.getGrado();
			if (!grados.contains(gradoAux)) {
				grados.add(gradoAux);
				coefiAux = aux.getCoeficiente();
				while (it.hasNext()) {
					aux2 = it.next();
					if (aux2.getGrado() == gradoAux)
						coefiAux += aux2.getCoeficiente();
				}
				it = auxTerms.iterator();
				terms.add(new Monomio(coefiAux, gradoAux, aux.getLiteral()));
			} else {
				try {
					aux = it.next();
					while (grados.contains(aux.getGrado())) {
						aux = it.next();
					}
				} catch (NoSuchElementException e) {
					break;
				}
			}
		}
	}

	public Polinomio multEsc(double escalar) {
		Iterator<Monomio> it = terminos.iterator();
		ArrayList<Monomio> termEsc = new ArrayList<Monomio>();
		while (it.hasNext())
			termEsc.add(it.next().multEsc(escalar));
		return new Polinomio(termEsc);
	}
}
