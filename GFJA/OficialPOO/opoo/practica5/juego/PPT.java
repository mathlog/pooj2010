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
import java.util.Random;

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
			else {
				switch ((tipoPPT) resp.rand()) {
				case PIEDRA:
					a.setRespuesta(tipoPPT.PIEDRA);
					break;
				case PAPEL:
					a.setRespuesta(tipoPPT.PAPEL);
					break;
				case TIJERA:
					a.setRespuesta(tipoPPT.TIJERA);
					break;
				}
			}
		}
	}

	@Override
	protected void calcularResultados() {
		for (JugadorM a : jugadores) {
			if (a.isDeshabilitado() || a.isEliminado())
				continue;
			tipoPPT respA = (tipoPPT) a.getRespuesta();
			for (JugadorM b : jugadores) {
				if (b.isDeshabilitado() || b.isEliminado())
					continue;
				tipoPPT respB = (tipoPPT) a.getRespuesta();
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
