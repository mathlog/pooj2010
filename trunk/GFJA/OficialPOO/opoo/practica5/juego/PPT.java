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
 * 
 * @author José Ángel García Fernández
 * @version 1.0 03/12/2010
 */
public class PPT extends JuegoM {

	public PPT(JugadorM[] jugadores, int nMAXrondas) {
		super("Juego de Piedra, Papel, Tijera", jugadores, nMAXrondas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizarJugadores(Respuesta resp) {
		for (JugadorM a : jugadores) {
			if (a.isHumano())
				a.setRespuesta(resp);
			else
				a.setRespuesta(resp.rand());
		}
	}

	@Override
	protected JugadorM[] calcularGanadores() {
		calcularResultados();
		ArrayList<JugadorM> ganadores = new ArrayList<JugadorM>();
		for (JugadorM a : jugadores)
			if (!a.isDeshabilitado() && !a.isMarcado())
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

	@Override
	public JugadorM[] finalizarRonda() {
		JugadorM[] ganadores = calcularGanadores();
		if (ganadores == null)
			return null;
		else if (ganadores.length == 1) {
			finJuego = true;
			return ganadores;
		} else
			return ganadores;
	}

	@Override
	protected void calcularResultados() {
		for (JugadorM a : jugadores) {
			if (a.isMarcado())
				continue;
			tipoPPT respA = (tipoPPT) a.getRespuesta();
			for (JugadorM b : jugadores) {
				if (b.isMarcado() || (b == a))
					continue;
				tipoPPT respB = (tipoPPT) b.getRespuesta();
				switch (respA) {
				case PIEDRA:
					if (respB == tipoPPT.PAPEL)
						a.setDeshabilitado(true);
					else if (respB == tipoPPT.TIJERA)
						b.setDeshabilitado(true);
					break;
				case PAPEL:
					if (respB == tipoPPT.TIJERA)
						a.setDeshabilitado(true);
					else if (respB == tipoPPT.PIEDRA)
						b.setDeshabilitado(true);
					break;
				case TIJERA:
					if (respB == tipoPPT.PIEDRA)
						a.setDeshabilitado(true);
					else if (respB == tipoPPT.PAPEL)
						b.setDeshabilitado(true);
					break;
				}
			}
		}
	}
}
