//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//
//IDEA GUI
//2 TEXT FIELD FILA COLUMNA boton añadir o eliminar, 
//sitio pa label aviso de no se pue borrar o hecho correctamente
// el acerca de e info pss
// zona de texto grande, odne poner el tablero de Nreinas
//o hacer alguna cosa rara con paint y tal pss
package poo.juegos.nReinas;

/**
 * Clase principal para la realizacion del juego de las Nreinas
 * 
 * @author José Ángel García Fernández
 * @version 1.0 01/10/2010
 */
public class Principal {

	public static void main(String args[]) {
		Nreinas juego = new Nreinas(Teclado.leerInt());
		System.out.println(juego);
		try {
			juego.solve(0);
		} catch (BorradoReinaNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		System.out.println(juego);
		/*
		 * if (juego.comprobarReina(0, 0)) juego.addReina(0, 0);
		 * System.out.println(juego); if (juego.comprobarReina(2, 1))
		 * juego.addReina(2, 1); System.out.println(juego); juego.removeReina(0,
		 * 0); System.out.println(juego);
		 */
	}
}
