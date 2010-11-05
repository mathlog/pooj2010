package opoo.practica4.solia.consola;

import opoo.practica4.soli.modelo.TableroSolitario;
import opoo.practica4.soli.modelo.VistaSolitario;

public class ConsolaTablero extends TableroSolitario implements VistaSolitario {

	public ConsolaTablero() {
		super();
		cambio();
	}

	public void cambio() {
		for (int i = 0; i < 7; i++) {
			System.out.print(String.valueOf(i));
			System.out.print("   ");
			for (int j = 0; j < 7; j++) {
				if (tablero[i][j] == -1)
					System.out.print(" ");
				if (tablero[i][j] == 0)
					System.out.print(".");
				if (tablero[i][j] == 1)
					System.out.print("0");
			}
			System.out.println(" ");
		}
		System.out.print("    ");
		for (int i = 0; i < 7; i++)
			System.out.print(String.valueOf(i));
		System.out.println("    ");
	}

}
