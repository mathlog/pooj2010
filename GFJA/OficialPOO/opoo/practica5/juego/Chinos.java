//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego;

import java.util.ArrayList;

import opoo.excepciones.PlayerGanadorException;

/**
 * Clase que representa el juego de los chinos descendiendo de Juego
 * 
 * @author José Ángel García Fernández
 * @version 1.0 03/12/2010
 */
public class Chinos extends JuegoM {

	private int totalMonedas;

	public int getTotalMonedas() {
		return totalMonedas;
	}

	public Chinos(JugadorM[] jugadores, int nMAXrondas) {
		super("Juego de los chinos", jugadores, nMAXrondas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizarJugadores(Respuesta resp) {
		ArrayList<Respuesta> yaDichas = new ArrayList<Respuesta>();
		yaDichas.add(resp);
		Respuesta aux;
		for (JugadorM a : jugadores) {
			do {
				aux = resp.rand();
			} while (yaDichas.contains(aux));
			if (a.isHumano())
				a.setRespuesta(resp);
			else
				a.setRespuesta(aux);
		}
	}

	@Override
	public JugadorM[] finalizarRonda() {
		JugadorM[] ganadores = calcularGanadores();
		if (ganadores == null)
			return null;
		else {
			return ganadores;
		}
	}

	protected JugadorM[] calcularGanadores() {
		calcularResultados();
		ArrayList<JugadorM> ganadores = new ArrayList<JugadorM>();
		for (JugadorM a : jugadores)
			if (a.isDeshabilitado())
				ganadores.add(a);
		if (ganadores.size() == 0) {
			habilitarJugadores();
			return null;
		} else {
			marcarDeshabilitados();
			return (JugadorM[]) ganadores
					.toArray(new JugadorM[ganadores.size()]);
		}
	}

	/**
	 * Metodo para calcular el total de monedas
	 * 
	 * @return el total de monedas
	 */
	private int calcularTotalMonedas() {
		int totalMonedas = 0;
		for (JugadorM a : jugadores) {
			tipoChinos aux = (tipoChinos) a.getRespuesta();
			totalMonedas += aux.getNMonedas();
		}
		return totalMonedas;
	}

	@Override
	protected void calcularResultados() {
		totalMonedas = calcularTotalMonedas();
		for (JugadorM a : jugadores) {
			tipoChinos respA = (tipoChinos) a.getRespuesta();
			if (respA.getNMonedas() == totalMonedas) {
				a.setDeshabilitado(true);
				break;
			}
		}
	}

}
