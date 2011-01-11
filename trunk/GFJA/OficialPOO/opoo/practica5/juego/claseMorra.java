//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

import java.util.Random;

/**
 * Clase para la respuesta de clase morra
 * 
 * @author José Ángel García Fernández
 * @version 1.0 06/12/2010
 */
public class claseMorra implements Respuesta {

	private int tusDedos;

	private int totalDedos;

	public claseMorra(int tusDedos, int totalDedos) {
		this.tusDedos = tusDedos;
		this.totalDedos = totalDedos;
	}

	@Override
	public String toString() {
		// return "tusDedos:" + tusDedos + " totalDedos:" + totalDedos;
		return "Sacados: " + tusDedos + " Supuestos: " + totalDedos;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof claseMorra))
			return false;
		claseMorra cM = (claseMorra) o;
		if (cM.totalDedos == this.totalDedos)
			return true;
		else
			return false;
	}

	@Override
	public Respuesta rand(int nJugadores) {
		Random r = new Random();
		//se comprueba que la maquina saque una jugada valida
		int propios=r.nextInt(5) + 1;
		int total;
		while((total=((r.nextInt(5) + 1)*nJugadores))<propios);
		claseMorra aux = new claseMorra(propios, total);
		return aux;
	}

	public int getTusDedos() {
		return tusDedos;
	}

	public int getTotalDedos() {
		return totalDedos;
	}
}