package opoo.practicas.uno.fecha;

import opoo.excepciones.FechaMalFormadaException;

public class Principal {

	public static void main(String[] args) {
		Fecha f, f2;
		try {
			f = new Fecha(15, 2, 2005);
			f2 = new Fecha(20, 2, 2005);
			System.out.println(f.extenso());
			System.out.println(f.mini());
			System.out.println(f.miniUSA());
			System.out.println(f.estiloIngles());
			if (f.compareTo(f2) < 0)
				System.out.println(f + " es antes que " + f2);
			else
				System.out.println(f + " es despues que " + f2);
		} catch (FechaMalFormadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
