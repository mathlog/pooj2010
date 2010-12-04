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

/**
 * Clase que representa el juego de los chinos descendiendo de Juego
 * 
 * @author José Ángel García Fernández
 * @version 1.1 04/12/2010
 */
public class Chinos extends JuegoM {

	private int totalMonedas;

	public Chinos(JugadorM[] jugadores, int nMAXrondas) {
		super("Juego de los chinos", jugadores, nMAXrondas);
	}

	@Override
	public JugadorM[] finalizarRonda() {
		ArrayList<JugadorM> ganadores = calcularGanadores();
		if (ganadores.size() == 0) {
			habilitarJugadores();
		} else {
			marcarHabilitados();
		}
		int solo1 = 0;
		for (JugadorM a : jugadores)
			if (!a.isMarcado())
				solo1++;
		if (solo1 == 1) {
			finJuego = true;
			return null;
		} else
			return (JugadorM[]) ganadores
					.toArray(new JugadorM[ganadores.size()]);
	}

	@Override
	public void actualizarJugadores(Respuesta resp) {
		ArrayList<Respuesta> yaDichas = new ArrayList<Respuesta>();
		yaDichas.add(resp);
		Respuesta aux;
		for (JugadorM a : jugadores) {
			if (!a.isMarcado()) {
				if (a.isHumano())
					a.setRespuesta(resp);
				else {
					do {
						aux = resp.rand();
					} while (yaDichas.contains(aux));
					a.setRespuesta(aux);
					yaDichas.add(aux);
				}
			}
		}
	}

	@Override
	protected ArrayList<JugadorM> calcularGanadores() {
		calcularResultados();
		ArrayList<JugadorM> ganadores = new ArrayList<JugadorM>();
		for (JugadorM a : jugadores)
			if ((!a.isDeshabilitado()) && !(a.isMarcado()))
				ganadores.add(a);
		return ganadores;
	}

	@Override
	protected void calcularResultados() {
		totalMonedas = calcularTotalMonedas();
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			claseChinos respA = (claseChinos) a.getRespuesta();
			if (respA.getNMonedas() != totalMonedas) {
				a.setDeshabilitado(true);
			}
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
			if (a.isMarcado())
				continue;
			claseChinos aux = (claseChinos) a.getRespuesta();
			totalMonedas += aux.ordinal();
		}
		return totalMonedas;
	}

	public int getTotalMonedas() {
		return totalMonedas;
	}
}
