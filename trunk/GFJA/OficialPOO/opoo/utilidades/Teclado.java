package opoo.utilidades;

/*  Paquete de utilidades
 */

import java.io.*;

/**
 * La clase <em>Teclado</em> permite la lectura de datos desde la entrada
 * estandar. Es decir trata de hacer transparente la lectura de los tipos mas
 * comunes de datos desde la entrada estandar (p.e. sin tener que tener en
 * cuenta excepciones ya que son capturadas dentro de la propia clase, y sin
 * tener que introducir las clases de entrada/salida -streams-).
 * 
 * @version 2.0
 * 
 */
public class Teclado {

	/** variable de clase asignada a la entrada estandar del sistema */
	public static BufferedReader entrada = new BufferedReader(
			new InputStreamReader(System.in));

	/**
	 * lee una cadena desde la entrada estandar
	 * 
	 * @return cadena de tipo String
	 * @exception excepciones
	 *                No lanza ningun tipo de excepcion de entrada/salida
	 * @throws excepciones
	 *             No produce ninguna excepcion (comentario java 1.2)
	 */
	public static String leerString() {
		String cadena = "";
		try {
			cadena = new String(entrada.readLine());
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
		return cadena;
	}

	/**
	 * lee un numero entero desde la entrada estandar
	 * 
	 * @return numero entero de tipo int
	 * @exception excepciones
	 *                No lanza ningun tipo de excepcion de entrada/salida
	 */
	public static int leerInt() {
		int entero = 0;
		boolean error = false;
		do {
			try {
				error = false;
				entero = Integer.valueOf(entrada.readLine()).intValue();
			} catch (NumberFormatException e1) {
				error = true;
				System.out
						.println("Error en el formato del numero, intentelo de nuevo.");
			} catch (IOException e) {
				System.out.println("Error de E/S");
			}
		} while (error);
		return entero;
	}

	/**
	 * lee un numero real (float) desde la entrada estandar
	 * 
	 * @return numero real de tipo float
	 * @exception excepciones
	 *                No lanza ningun tipo de excepcion de entrada/salida
	 */
	public static float leerFloat() {
		float real = 0;
		boolean error = false;
		do {
			try {
				error = false;
				real = Float.valueOf(entrada.readLine()).floatValue();
			} catch (NumberFormatException e1) {
				error = true;
				System.out
						.println("Error en el formato del numero, intentelo de nuevo.");
			} catch (IOException e) {
				System.out.println("Error de E/S");
			}
		} while (error);
		return real;
	}

	/**
	 * lee un numero real (double) desde la entrada estandar
	 * 
	 * @return numero real de tipo double
	 * @exception excepciones
	 *                No lanza ningun tipo de excepcion de entrada/salida
	 */
	public static double leerDouble() {
		double real = 0.0;
		boolean error = false;
		do {
			try {
				error = false;
				real = Double.valueOf(entrada.readLine()).doubleValue();
			} catch (NumberFormatException e1) {
				error = true;
				System.out
						.println("Error en el formato del numero, intentelo de nuevo.");
			} catch (IOException e) {
				System.out.println("Error de E/S");
			}
		} while (error);

		return real;
	}

	/**
	 * lee un caracter desde la entrada estandar. Vease el metodo
	 * {@link #leerString() leerString}
	 * 
	 * @return caracter de tipo char
	 * @exception excepciones
	 *                No lanza ningun tipo de excepcion de entrada/salida
	 * @see #leerString()
	 */
	public static char leerChar() {
		char car = 't';
		String cadena = "";
		try {
			do {
				cadena = new String(entrada.readLine());
				if (cadena.length() > 0)
					car = cadena.charAt(0);
				else
					System.out
							.println("Error: cadena vacia hay que introducir un caracter");
			} while (cadena.length() == 0);
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
		return car;
	}

}
