//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Documentacion de ejercicio 1
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica1.fecha;

import opoo.excepciones.FechaMalFormadaException;

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

	public String miniCompleto() {
		return dia + "\\" + mes + "\\" + year;
	}

	public String estiloIngles() {
		return mesToStr() + " " + dia + ", " + year;
	}

	public String extenso() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", year=" + year + "]";
	}

	@Override
	public String toString() {
		return miniCompleto();
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

	public double diferenciaSegundos(Fecha f2) {
		return diferenciaMinutos(f2) * 60;
	}

	public double diferenciaMinutos(Fecha f2) {
		return diferenciaHoras(f2) * 60;
	}

	public double diferenciaHoras(Fecha f2) {
		return diferenciaDias(f2) * 24;
	}

	public int diferenciaDias(Fecha f2) {
		return diferencia(this, f2)[0];
	}

	public double diferenciaSemanas(Fecha f2) {
		return diferencia(this, f2)[0] / 7;
	}

	public int diferenciaMeses(Fecha f2) {
		return diferencia(this, f2)[1];
	}

	public int diferenciaYears(Fecha f2) {
		return diferencia(this, f2)[2];
	}

	public String diferenciaCompleto(Fecha f2) {
		int[] fecha = diferencia(this, f2);
		return fecha[2] + " años, " + fecha[1] + " meses, " + fecha[0]
				+ " dias";
	}

	public Fecha sumaDias(int nDias) {
		int auxDia, auxMes, auxYear;

		auxDia = dia;
		auxMes = mes;
		auxYear = year;

		while (nDias > 0) {
			nDias--;
			auxDia++;
			if (auxDia == DiasDelMes(auxYear, auxMes) + 1) {
				auxDia = 1;
				auxMes++;
				if (auxMes == 13) {
					auxMes = 1;
					auxYear++;
				}
			}
		}
		try {
			return new Fecha(auxDia, auxMes, auxYear);
		} catch (FechaMalFormadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private int[] diferencia(Fecha a, Fecha b) {

		Fecha anterior, posterior;
		if (a.compareTo(b) < 0) {
			anterior = a;
			posterior = b;
		} else if (a.compareTo(b) > 0) {
			anterior = b;
			posterior = a;
		} else
			return new int[3];

		int auxDiam, auxMesm, auxYearm, mesM, diaM, yearM, diasDelMes;
		int[] dif = { 0, 0, 0 };
		auxDiam = anterior.dia;
		auxMesm = anterior.mes;
		auxYearm = anterior.year;
		yearM = posterior.year;

		while (auxYearm <= yearM) {
			if (auxYearm < yearM) {
				mesM = 12;
				diaM = 31;
			} else {
				mesM = posterior.mes;
				diaM = posterior.dia;
			}
			while (auxMesm <= mesM) {
				diasDelMes = 0;
				if (auxMesm == mesM) {
					diasDelMes = diaM;
				} else {
					diasDelMes = DiasDelMes(auxYearm, auxMesm);
				}
				while (auxDiam <= diasDelMes) {
					dif[0]++;
					auxDiam++;
				}
				auxDiam = 1;
				auxMesm++;
				dif[1]++;
			}
			auxMesm = 1;
			auxYearm++;
			dif[2]++;
		}
		return dif;
	}

	private int DiasDelMes(int year, int mes) {
		int ndias = 0;
		switch (mes) {
		case 1:
			ndias = 31;
			break;
		case 2:
			ndias = EsBisiesto(year) ? 29 : 28;
			break;
		case 3:
			ndias = 31;
			break;
		case 4:
			ndias = 30;
			break;
		case 5:
			ndias = 31;
			break;
		case 6:
			ndias = 30;
			break;
		case 7:
			ndias = 31;
			break;
		case 8:
			ndias = 31;
			break;
		case 9:
			ndias = 30;
			break;
		case 10:
			ndias = 31;
			break;
		case 11:
			ndias = 30;
			break;
		case 12:
			ndias = 31;
			break;
		}
		return ndias;
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

	public int calcul() {
		Integer day = new Integer(dia);
		Integer month = new Integer(mes);
		Integer anyo = new Integer(year);
		int A = 2010;
		int M;
		int[] T = new int[12];
		T[0] = 31;
		T[1] = 28;
		T[2] = 31;
		T[3] = 30;
		T[4] = 31;
		T[5] = 30;
		T[6] = 31;
		T[7] = 31;
		T[8] = 30;
		T[9] = 31;
		T[10] = 30;
		T[11] = 31;
		int N = 0;
		int result = 10;
		if ((anyo - anyo / 4 * 4) != 0 && month == 2 && day == 29)
			result = 10;
		else {

			if (anyo < A) {
				A--;
				M = 12;
				while (anyo < A) {
					if ((anyo - anyo / 4 * 4) == 0) {
						N = N + 52 * 7 + 2;
					} else
						N = N + 52 * 7 + 1;
					A--;
				}
				while (month < M) {
					N = N + T[month - 1];
					M--;
				}
				N = N + T[M - 1] - day + 1;
				if ((A - A / 4 * 4) == 0 && month <= 2)
					N++;
				result = N - N / 7 * 7;
				if (result != 0)
					result = 7 - result;

			}
			A = 2003;
			if (anyo >= A) {
				M = 1;
				while (anyo > A) {
					if ((A - A / 4 * 4) == 0) {
						N = N + 52 * 7 + 2;
					} else
						N = N + 52 * 7 + 1;
					A++;
				}
				while (month > M) {
					N = N + T[M - 1];
					M++;
				}
				N = N + day - 1;
				if ((A - A / 4 * 4) == 0 && M > 2)
					N++;
				result = N - N / 7 * 7;
			}
		}
		return result;
	}

}
