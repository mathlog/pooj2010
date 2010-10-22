package opoo.practica2.polinomios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
		while (it.hasNext())
			while (it2.hasNext())
				termMult.add(it.next().mult(it2.next()));
		rejuntarComunes(termMult);
		return new Polinomio(termMult);
	}

	private void rejuntarComunes(ArrayList<Monomio> termMult) {

	}

	public Polinomio multEsc(double escalar) {
		Iterator<Monomio> it = terminos.iterator();
		ArrayList<Monomio> termEsc = new ArrayList<Monomio>();
		while (it.hasNext())
			termEsc.add(it.next().multEsc(escalar));
		return new Polinomio(termEsc);
	}
}
