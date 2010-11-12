//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.principal;

import opoo.excepciones.AllPlayersPlantadosException;
import opoo.excepciones.NoHayMasCartasException;
import opoo.practica4.juego.base.Carta;
import opoo.practica4.juego.base.Juego;
import opoo.practica4.juego.base.Jugador;
import opoo.practica4.juego.sieteymedio.SieteyMedio;
import opoo.practica4.juego.veintiuno.Veintiuno;
import opoo.utilidades.Teclado;

/**
 * Clase de ejecucion para probar el juego
 * 
 * @author José Ángel García Fernández
 * @version 1.0 12/11/2010
 */
public class PrincipalConsola {

	static private Juego juego = null;
	static Jugador[] jugadores = { new Jugador("Jugador"), new Jugador("BANCA") };
	static private boolean primerTurno = true;
	static private boolean down = false;
	static private String log = "";

	public static void main(String[] args) {
		int opcion;
		System.out.println("¡¡¡Bienvenido al juego!!!");
		eligeJuego();
		do {
			down = false;
			System.out.println("Juega: " + juego.getJugadorActual());
			System.out.println("Quedan: " + juego.getNCartasRestantes()
					+ " cartas");
			opcion = menu();
			switch (opcion) {
			case 0:
				System.out.println("Gracias por usar el programa");
				break;
			case 1:
				operacionesSacarCarta();
				break;
			case 2:
				if (primerTurno)
					System.err.println("ERROR:Primer turno, elige opcion 1\n");
				else {
					down = true;
					operacionesSacarCarta();
				}
				break;
			case 3:
				operacionesPlantarse();
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
			System.out
					.println("Elige el tipo de juego\n1-Siete y Medio\n2-Veintiuno");
			eleccion = Teclado.leerInt();
		} while (eleccion != 1 && eleccion != 2);
		if (eleccion == 1)
			juego = new SieteyMedio(jugadores);
		else
			juego = new Veintiuno(jugadores);
	}

	/**
	 * Metodo para elegir accion
	 * 
	 * @return la accion seleccionnada
	 */
	private static int menu() {
		System.out.println("Elige opcion de jugada:");
		System.out.println("1-Sacar Carta");
		System.out.println("2-Sacar Carta down");
		System.out.println("3-Plantarme");
		System.out.println("0-Salir");
		System.out.println("Opcion: ");
		return Teclado.leerInt();
	}

	/**
	 * Metodo base que realiza las operaciones de sacar carta
	 */
	private static void operacionesSacarCarta() {
		try {
			if (primerTurno) {
				primerTurno = false;
				Carta[] mano1 = juego.empezarTurno();
				for (int i = 0; i < mano1.length; i++)
					realizarMano(mano1[i]);
			} else {
				Carta actual = juego.sacarCarta();
				realizarMano(actual);
			}
		} catch (NoHayMasCartasException e1) {
			finalizarPartida(e1.getMessage());
		}
	}

	/**
	 * Metodo que realiza las operaciones de plantarse
	 */
	private static void operacionesPlantarse() {
		primerTurno = true;
		Jugador actual = juego.getJugadorActual();
		actual.setPlantado(true);
		if (!actual.isPasado())
			System.out.println(actual.getNombre() + " se plantó tras "
					+ actual.getMano().size() + " cartas con "
					+ actual.getManoUp() + "\n");
		else
			System.out.println(actual.getNombre() + " se paso tras "
					+ actual.getMano().size() + " cartas con "
					+ actual.getMano() + "\n");
		try {
			juego.nextJugador();
			actual = juego.getJugadorActual();
		} catch (AllPlayersPlantadosException e1) {
			finalizarPartida(e1.getMessage());
		}
	}

	/**
	 * Metodo que opera con la carta actual de la jugada
	 * 
	 * @param carta
	 *            la carta actual
	 */
	private static void realizarMano(Carta carta) {
		System.out.println("Carta sacada: " + carta + "\n");
		Jugador jug = juego.getJugadorActual();
		if (down) {
			carta.flip();
			jug.cartasUp();
		}
		boolean pasado = juego.actualizarJugador(carta);
		log = log + jug + " sacó " + carta + "\n";
		if (pasado)
			operacionesPlantarse();

	}

	/**
	 * Metodo que finaliza la partida mostrando informacion
	 * 
	 * @param info
	 *            motivo de fin
	 */
	private static void finalizarPartida(String info) {
		Jugador[] ganadores = juego.finalizarPartida();
		if (ganadores == null) {
			System.out.println("No ha ganado nadie!\n" + info
					+ "\n¡Revisa el log para comprobar los resultados!\n");
		} else {
			StringBuilder strWins = new StringBuilder();
			for (int i = 0; i < ganadores.length; i++)
				strWins.append(ganadores[i] + "\n");
			System.out
					.println(ganadores.length > 1 ? "Han empatado: "
							: "Ha ganado: "
									+ strWins
									+ "\n"
									+ info
									+ "\n¡Revisa el log para comprobar los resultados!\n");
		}
		System.out.println("LOG:\n" + log);
	}
}
