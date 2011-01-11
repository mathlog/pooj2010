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
 * Clase que representa el juego de la morra para varios jugadores extiende de
 * Juego. Explicacion: muestran una mano y deben acertar cual es el nTotal de
 * dedos.
 * 
 * @author José Ángel García Fernández
 * @version 1.0 05/12/2010
 */
public class Morra extends JuegoM {

	private int totalDedosReal;

	public Morra(JugadorM[] jugadores, int nMAXrondas) {
		super("Juego de la Morra", jugadores, nMAXrondas);
	}

	@Override
	public void actualizarJugadores(Respuesta resp) {
		// comprueba que la respuesta no haya sido dicha ya
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
					aux = resp.rand(getNJugadoresActivos());
				} while (yaDichas.contains(aux));
				a.setRespuesta(aux);
				yaDichas.add(aux);
			}
		}
	}

	@Override
	public JugadorM[] finalizarRonda() {
		ArrayList<JugadorM> ganadores = calcularGanadores();
		if (ganadores.size() == 0)
			habilitarJugadores();
		else
			marcarHabilitados();
		return (JugadorM[]) ganadores.toArray(new JugadorM[ganadores.size()]);
	}

	@Override
	protected void calcularResultados() {
		calcularTotalDedos();
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			claseMorra respA = (claseMorra) a.getRespuesta();
			if (respA.getTotalDedos() != totalDedosReal) {
				a.setDeshabilitado(true);
			}
		}
	}

	/**
	 * Metodo para calcular el total de dedos
	 * 
	 */
	private void calcularTotalDedos() {
		totalDedosReal = 0;
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			claseMorra aux = (claseMorra) a.getRespuesta();
			totalDedosReal += aux.getTusDedos();
		}
	}

	public int getTotalDedos() {
		return totalDedosReal;
	}
}
