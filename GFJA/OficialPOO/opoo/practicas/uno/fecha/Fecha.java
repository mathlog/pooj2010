//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practicas.uno.fecha;

import opoo.excepciones.FechaMalFormadaException;

/*1.- Diseñar e implementar un programa implemente el tipo abstracto de datos fecha. Una fecha
 * puede construirse correctamente, visualizarse en diferentes formatos, saber cual de dos 
 * fechas es la mayor, calcular el número de días entre dos fechas y dada una fecha definir
 * una nueva fecha pasados un número determinado de días. Además será necesario un programa
 * que pruebe estas funcionalidades.*///sumale 28dias a ver k sale

//primero fecha y lego hacerlcular el dai de la semana
/**
 * Clase que representa una fecha
 * 
 * @author José Ángel García Fernández
 * @version 1.0 15/10/2010
 */
public class Fecha implements Comparable {

	/**
	 * Representa el dia de mes
	 */
	int dia;

	/**
	 * Representa el mes del año
	 */
	int mes;

	/**
	 * Representa el anyo
	 */
	int year;

	public Fecha(int dia, int mes, int anyo) throws FechaMalFormadaException {
		comprobarFecha(dia, mes, anyo);
		this.mes = mes;
		this.dia = dia;
		this.year = anyo;

	}

	public void comprobarFecha(int dia, int mes, int year)
			throws FechaMalFormadaException {
		short flag;
		if ((flag = buenaFecha(dia, mes, year)) != 0) {
			StringBuffer error = new StringBuffer();
			switch (flag) {
			case 1:
				error.append("Dia o Mes erroneo");
				break;
			case 2:
				error.append("Dia no concuerda con mes");
				break;
			case 3:
				error.append("Dia erroneo para febrero en año bisiesto");
				break;
			}
			throw new FechaMalFormadaException(error.toString());
		}

	}

	public String mini() {
		return dia + "\\" + mes + "\\" + yearMini();
	}

	public String miniUSA() {
		return mes + "\\" + dia + "\\" + yearMini();
	}

	public String estiloIngles() {
		return mesToStr() + " " + dia + ", " + year;
	}

	public String extenso() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", year=" + year + "]";
	}

	@Override
	public String toString() {
		return mini();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Fecha))
			return false;
		Fecha otra = (Fecha) o;
		return dia == otra.dia && mes == otra.mes && year == otra.year;
	}

	@Override
	public int compareTo(Object o) {
		Fecha otra = (Fecha) o;
		int val;
		if (year < otra.year)
			val = -1;
		else if (year > otra.year)
			val = 1;
		else {
			if (mes < otra.mes)
				val = -1;
			else if (mes > otra.mes)
				val = 1;
			else {
				if (dia < otra.dia)
					val = -1;
				else if (dia > otra.dia)
					val = 1;
				else
					val = 0;
			}
		}
		return val;
	}

	public int diferenciaDias(Fecha f2) {

		if (compareTo(f2) < 0)
			return diferenciaDias(this, f2);
		else if (compareTo(f2) > 0)
			return diferenciaDias(f2, this);
		else
			return 0;
	}

	private int diferenciaDias(Fecha anterior, Fecha posterior) {
		int difdias=posterior.dia-anterior.dia;
		return difdias;
		
	}

	private short buenaFecha(int dia, int mes, int year) {
		if (dia < 0 || dia > 31 || mes < 0 || mes > 12)
			return 1;
		else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)
			return 2;
		else if (mes == 2 && dia > 28 && !EsBisiesto(year))
			return 3;
		else
			return 0;
	}

	private boolean EsBisiesto(int anno) {
		// devuelve true si el año es múltiplo de 4 y
		// si es multiplo de 100 pero no de 400
		// false en caso contrario
		return (anno % 4 == 0) && !(anno % 100 == 0 && anno % 400 != 0);
	}

	private String yearMini() {
		String yearString = String.valueOf(year);
		int last = yearString.length();
		return yearString.substring(last - 2, last);
	}

	private String mesToStr() {
		StringBuffer mesStr = new StringBuffer();
		switch (mes) {
		case 1:
			mesStr.append("Enero");
			break;
		case 2:
			mesStr.append("Febrero");
			break;
		case 3:
			mesStr.append("Marzo");
			break;
		case 4:
			mesStr.append("Abril");
			break;
		case 5:
			mesStr.append("Mayo");
			break;
		case 6:
			mesStr.append("Junio");
			break;
		case 7:
			mesStr.append("Julio");
			break;
		case 8:
			mesStr.append("Agosto");
			break;
		case 9:
			mesStr.append("Septiembre");
			break;
		case 10:
			mesStr.append("Octubre");
			break;
		case 11:
			mesStr.append("Noviembre");
			break;
		case 12:
			mesStr.append("Diciembre");
			break;
		}
		return mesStr.toString();
	}
	public int calcul(){return 0;}
	/*
	 * int calcul() { Integer dia = new Integer(1// CUAL ES EL INDICE DEL DÍA
	 * 1..31 ); Integer mesth = new Integer(1// NUMERO DEL MES 1..12 ); Integer
	 * year = new Integer(1// AÑO ); int A = 2010; int M; int[] T = new int[12];
	 * T[0] = 31; T[1] = 28; T[2] = 31; T[3] = 30; T[4] = 31; T[5] = 30; T[6] =
	 * 31; T[7] = 31; T[8] = 30; T[9] = 31; T[10] = 30; T[11] = 31; int N = 0;
	 * int result = 10; if ((year - year / 4 * 4) != 0 && mesth == 2 && dia ==
	 * 29) result = 10; else {
	 * 
	 * if (year < A) { A--; M = 12; while (year < A) { if ((year - year / 4 * 4)
	 * == 0) { N = N + 52 * 7 + 2; } else N = N + 52 * 7 + 1; A--; } while
	 * (mesth < M) { N = N + T[mesth - 1]; M--; } N = N + T[M - 1] - dia + 1; if
	 * ((A - A / 4 * 4) == 0 && mesth <= 2) N++; result = N - N / 7 * 7; if
	 * (result != 0) result = 7 - result;
	 * 
	 * } A = 2003; if (year >= A) { M = 1; while (year > A) { if ((A - A / 4 *
	 * 4) == 0) { N = N + 52 * 7 + 2; } else N = N + 52 * 7 + 1; A++; } while
	 * (mesth > M) { N = N + T[M - 1]; M++; } N = N + dia - 1; if ((A - A / 4 *
	 * 4) == 0 && M > 2) N++; result = N - N / 7 * 7; } } return result; }
	 */

}
