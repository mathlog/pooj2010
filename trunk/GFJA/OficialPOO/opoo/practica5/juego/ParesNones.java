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
 * Clase que representa el juego de pares nones para varios jugadores extiende
 * de Juego. Explicacion: si hay varios jugadores, los que ganen sa salen el
 * resto sigue jugando
 * 
 * @author José Ángel García Fernández
 * @version 1.0 05/12/2010
 */
public class ParesNones extends JuegoM {

	private enumPN pn;

	private int totalDedos;

	public ParesNones(JugadorM[] jugadores, int nMAXrondas) {
		super("Juego de Pares-Nones", jugadores, nMAXrondas);
	}

	@Override
	public void actualizarJugadores(Respuesta resp) {
		// para que al menos una de las respuesta sea distinta a la de los demas
		boolean alm1 = false;
		ArrayList<Respuesta> yaDichas = new ArrayList<Respuesta>();
		Respuesta aux;
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			if (a.isHumano()) {
				a.setRespuesta(resp);
				yaDichas.add(resp);
			} else {
				do {
					aux = resp.rand();
				} while ((yaDichas.contains(aux)) && (!alm1));
				a.setRespuesta(aux);
				// debe haber alguna respuesta ya dicha
				if (yaDichas.size() > 0)
					alm1 = true;
				yaDichas.add(aux);
			}
		}
	}

	@Override
	public JugadorM[] finalizarRonda() {
		ArrayList<JugadorM> ganadores = calcularGanadores();
		marcarHabilitados();// los que han ganado fuera
		habilitarJugadores();// permito al resto seguir jugando
		return (JugadorM[]) ganadores.toArray(new JugadorM[ganadores.size()]);
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
		pn = calcularPARNONES();
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			clasePN respA = (clasePN) a.getRespuesta();
			if (respA.getPn() != pn) {
				a.setDeshabilitado(true);
			}
		}
	}

	private enumPN calcularPARNONES() {
		totalDedos = 0;
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			clasePN aux = (clasePN) a.getRespuesta();
			totalDedos += aux.getNDedos();
		}
		return (totalDedos % 2) == 0 ? enumPN.PARES : enumPN.NONES;
	}

	public enumPN getPn() {
		return pn;
	}

	public int getTotalDedos() {
		return totalDedos;
	}
	// Sistema chungo
	/*
	 * if (ganadores.size() == 1) { marcarHabilitados(); habilitarJugadores();
	 * }else { marcarDeshabilitados(); }
	 */

	// Sistem chungo+aun
	/*
	 * if (ganadores.size() == 0) { habilitarJugadores(); }elseif
	 * (ganadores.size() == 1) { marcarHabilitados(); habilitarJugadores(); } /
	 * else if (ganadores.size() == getNJugadoresActivos()) {
	 * habilitarJugadores(); } else if ((jugadores.length - ganadores.size()) ==
	 * 1)
	 */
}
