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
import java.util.List;

/**
 * Clase para usar Polinomio
 * 
 * @author José Ángel García Fernández
 * @version 1.0 22/10/2010
 */
public class PruebaPolinomios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Double[] coefisLinear = { -1.0, 2.0 };
		Polinomio p1 = new Polinomio(coefisLinear);
		System.out.println("Polinomio creado con array de doubles:");
		System.out.println(p1);

		List<Monomio> coefisVariao = new ArrayList<Monomio>();
		coefisVariao.add(new Monomio(1.0, 2, 'x'));
		coefisVariao.add(new Monomio(3.0, 0, 'x'));
		coefisVariao.add(new Monomio(2.5, 4, 'x'));
		Polinomio p2 = new Polinomio(coefisVariao);
		System.out.println("Polinomio creado con List de Monomios:");
		System.out.println(p2);

		System.out.println("Multiplicacion escalar:");
		System.out.print("(" + p1 + ")*(2) = ");
		Polinomio pEsc = p1.multEsc(2);
		System.out.println(pEsc);

		System.out.println("Multiplicacion:");
		System.out.print("(" + pEsc + ")*(" + p1 + ") = ");
		System.out.println(pEsc.mult(p1));

		System.out.println("Suma:");
		System.out.print("(" + p1 + ")+(" + p1 + ") = ");
		System.out.println(p1.sumar(p1));

		System.out.println("Resta:");
		System.out.print("(" + pEsc + ")-(" + p1 + ") = ");
		System.out.println(pEsc.restar(p1));

		System.out.println("Resta distinto tamaño:");
		pEsc.addMonomio(new Monomio(1.0, 3, 'x'));
		System.out.print("(" + pEsc + ")-(" + p1 + ") = ");
		System.out.println(pEsc.restar(p1));

		System.out.println("Multiplicacion distinto tamaño:");
		System.out.print("(" + pEsc + ")*(" + p1 + ") = ");
		System.out.println(pEsc.mult(p1));

		System.out.println("Multiplicacion static:");
		System.out.print("(" + pEsc + ")*(" + p1 + ") = ");
		System.out.println(Polinomio.mult(pEsc, p1));
	}

}
