package opoo.practicas.uno.fecha;

import opoo.excepciones.FechaMalFormadaException;

public class Principal {

	public static void main(String[] args) {
		Fecha f, f2;
		try {
			f = new Fecha(16, 12, 1990);
			f2 = new Fecha(20, 2, 2005);
			System.out.println(f.extenso());
			System.out.println(f.mini());
			System.out.println(f.miniUSA());
			System.out.println(f.estiloIngles());
			if (f.compareTo(f2) < 0)
				System.out.println(f + " es antes que " + f2);
			else
				System.out.println(f + " es despues que " + f2);
			System.out.println("Diferencias tiempo entre " + f + " y " + f2
					+ ":");
			
			System.out.println("Años: " + f.diferenciaYears(f2));
			System.out.println("Meses: " + f.diferenciaMeses(f2));
			System.out.println("Semanas: " + f.diferenciaSemanas(f2));
			System.out.println("Dias: " + f.diferenciaDias(f2));
			System.out.println("Horas: " + f.diferenciaHoras(f2));
			System.out.println("Minutos: " + f.diferenciaMinutos(f2));
			System.out.println("Segundos: " + f.diferenciaSegundos(f2));
			System.out.println("Completo: " + f.diferenciaCompleto(f2));
			
			System.out.println(f+" +20 dias: " + f.sumaDias(20));
		} catch (FechaMalFormadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
