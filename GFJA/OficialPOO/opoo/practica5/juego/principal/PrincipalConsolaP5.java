//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego.principal;

import opoo.excepciones.AllRondasCompleteException;
import opoo.practica5.juego.Chinos;
import opoo.practica5.juego.JuegoM;
import opoo.practica5.juego.JugadorM;
import opoo.practica5.juego.PPT;
import opoo.practica5.juego.Respuesta;
import opoo.practica5.juego.enumPPT;
import opoo.utilidades.Teclado;

/**
 * Clase de ejecucion para probar el juego en consola. Solo juega a PPT,
 * ampliable en el futuro
 * 
 * @author José Ángel García Fernández
 * @version 0.25 14/01/2011
 */
public class PrincipalConsolaP5 {

	static private JugadorM[] jugadores = null;
	static private int nJugadores;
	static private JuegoM juego = null;
	static private Respuesta respuesta;
	static private Object[] optionsTiposJuegos = { "Piedra, Papel, Tijera",
			"Chinos", "Pares Nones", "Morra" };

	public static void main(String[] args) {
		int opcion;
		System.out.println("¡¡¡Bienvenido al juego!!!");
		eligeJugadores();
		eligeJuego();
		do {
			System.out.println();
			opcion = menu();
			System.out.println();
			switch (opcion) {
			case 0:
				System.out.println("Gracias por usar el programa");
				break;
			case 1:// Piedra
				respuesta = enumPPT.PIEDRA;
				operacionesJugar();
				break;
			case 2:// Papel
				respuesta = enumPPT.PAPEL;
				operacionesJugar();
				break;
			case 3:// Tijera
				respuesta = enumPPT.TIJERA;
				operacionesJugar();
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		} while (opcion != 0 && !juego.isFinJuego());
	}

	/**
	 * Metodo para elegir juego
	 */
	private static void eligeJuego() {
		int eleccion;
		do {
			System.out.println("Elige el tipo de juego\n1-"
					+ optionsTiposJuegos[0]/*
											 * + "\n2-" + optionsTiposJuegos[1]
											 */);
			System.out.print("Opcion: ");
			eleccion = Teclado.leerInt();
		} while (eleccion != 1 /* && eleccion != 2 */);
		if (eleccion == 1)
			juego = new PPT(jugadores, jugadores.length);
		else
			juego = new Chinos(jugadores, jugadores.length);
	}

	/**
	 * Metodo para configurar los jugadores
	 */
	private static void eligeJugadores() {
		int eleccion;
		do {
			System.out.print("Elige el numero de jugadores [2,6]: ");
			eleccion = Teclado.leerInt();
		} while (eleccion < 2 || eleccion > 6);
		nJugadores = eleccion;
		jugadores = new JugadorM[nJugadores];
		jugadores[0] = new JugadorM("Jugador", true);
		for (int i = 1; i < jugadores.length; i++)
			jugadores[i] = new JugadorM("Maquina" + i, false);
	}

	/**
	 * Metodo para elegir accion
	 * 
	 * @return la accion seleccionnada
	 */
	private static int menu() {
		System.out.println("Elige opcion de jugada:");
		System.out.println("1-Piedra");
		System.out.println("2-Papel");
		System.out.println("3-Tijera");
		System.out.println("0-Salir");
		System.out.print("Opcion: ");
		return Teclado.leerInt();
	}

	/**
	 * Metodo que realiza las operaciones de jugar
	 */
	private static void operacionesJugar() {
		juego.actualizarJugadores(respuesta);
		JugadorM[] ganadores;
		try {
			int before = juego.getNJugadoresActivos();
			ganadores = juego.finalizarRonda();
			if (ganadores.length == 0) {
				escribirRonda(false);
				mostrarEmpateRonda();
			} else if (ganadores.length == before) {
				escribirRonda(false);
				mostrarEmpateRonda();
			} else if (ganadores.length == 1) {
				escribirRonda(true);
				FINhayGanador(ganadores[0]);
				juego.nextRonda();
			} else {
				mostrarGanadoresRonda(ganadores);
				escribirRonda(true);
				juego.nextRonda();
			}
		} catch (AllRondasCompleteException e) {
			FINtotalRondasAlcanzadas(e);
		}
	}

	/**
	 * Escribe los datos de la ronda en los jTA
	 */
	private static void escribirRonda(boolean actual) {
		StringBuilder sb = new StringBuilder("Ronda: " + juego.getNRonda()
				+ "\n");
		for (JugadorM a : juego.getJugadores())
			sb.append(a + "\n");
		System.out.print(sb);
	}

	/**
	 * Muestra ganadores de cada ronda
	 * 
	 * @param ganadores
	 *            los ganadores
	 */
	private static void mostrarGanadoresRonda(JugadorM[] ganadores) {
		StringBuilder strWins = new StringBuilder();
		for (JugadorM a : ganadores)
			strWins.append("\t" + a + "\n");
		System.out.println("¡RONDA " + juego.getNRonda()
				+ " ACABADA!\n Siguen jugando:\n" + strWins);
	}

	/**
	 * Muestra que ha habido un empate
	 */
	private static void mostrarEmpateRonda() {
		System.out.println("¡RONDA " + juego.getNRonda()
				+ " EMPATADA!\n Se repite la ronda " + juego.getNRonda());
	}

	/**
	 * Metodo que finaliza la partida habiendo un ganador
	 * 
	 * @param ganador
	 *            el ganador
	 */
	private static void FINhayGanador(JugadorM ganador) {
		// System.out.println("¡FIN DE JUEGO!\nHa ganado: " + ganador);
		System.out.println("Fin de juego por ganador: " + ganador.getNombre()
				+ "\n");
	}

	/**
	 * Metodo que finaliza la partida porque no quedan mas rondas
	 * 
	 * @param e
	 *            la excepcion de rondas
	 */
	private static void FINtotalRondasAlcanzadas(Exception e) {
		// System.out.println("¡FIN DE JUEGO!\n" + e.getMessage());
		System.out.println("Fin de juego por " + e.getMessage());
	}
}
