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
 * Clase que representa el juego de piedra, papel, tijera, descendiendo de Juego
 * Explicacion: los que ganen juegan entre ellos hasta que quede 1
 * 
 * @author José Ángel García Fernández
 * @version 1.2 05/12/2010
 */
public class PPT extends JuegoM {

	public PPT(JugadorM[] jugadores, int nMAXrondas) {
		super("Juego de Piedra, Papel, Tijera", jugadores, nMAXrondas);
	}

	@Override
	public JugadorM[] finalizarRonda() {
		ArrayList<JugadorM> ganadores = calcularGanadores();

		if (ganadores.size() == 0)
			habilitarJugadores();// no hay ganadores
		else
			marcarDeshabilitados();// marco los que han perdido

		JugadorM[] winners = (JugadorM[]) ganadores
				.toArray(new JugadorM[ganadores.size()]);
		if (ganadores.size() == 1) {
			finJuego = true;// solo 1 ganador se acaba el juego
			return winners;
		} else
			return winners;
	}

	@Override
	public void actualizarJugadores(Respuesta resp) {
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			if (a.isHumano())
				a.setRespuesta(resp);
			else
				a.setRespuesta(resp.rand());

		}
	}

	/*
	 * protected JugadorM[] calcularGanadores() { calcularResultados();
	 * ArrayList<JugadorM> ganadores = new ArrayList<JugadorM>(); for (JugadorM
	 * a : jugadores) if (!a.isDeshabilitado() && !a.isMarcado())
	 * ganadores.add(a); if (ganadores.size() == 0) { habilitarJugadores();
	 * return null; } else { marcarDeshabilitados(); return (JugadorM[])
	 * ganadores .toArray(new JugadorM[ganadores.size()]); } }
	 */

	@Override
	protected void calcularResultados() {
		// evalua cada jugador activo con el resto, deshabilitando los que
		// tengan una mano debil
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			enumPPT respA = (enumPPT) a.getRespuesta();
			for (JugadorM b : jugadores) {
				if (b.isMarcado() || (b == a))
					continue;// si es el mismo
				enumPPT respB = (enumPPT) b.getRespuesta();
				switch (respA) {
				case PIEDRA:
					if (respB == enumPPT.PAPEL)
						a.setDeshabilitado(true);
					else if (respB == enumPPT.TIJERA)
						b.setDeshabilitado(true);
					break;
				case PAPEL:
					if (respB == enumPPT.TIJERA)
						a.setDeshabilitado(true);
					else if (respB == enumPPT.PIEDRA)
						b.setDeshabilitado(true);
					break;
				case TIJERA:
					if (respB == enumPPT.PIEDRA)
						a.setDeshabilitado(true);
					else if (respB == enumPPT.PAPEL)
						b.setDeshabilitado(true);
					break;
				}
			}
		}
	}
}
