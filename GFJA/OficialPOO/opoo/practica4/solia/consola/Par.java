package opoo.practica4.solia.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Par {
	public int f=0;
	int c=0;
	public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	public Par() {
		String cad,c1,c2;
		boolean error = false;
		do {
			try {
				error = false;
				cad=entrada.readLine();
				cad= cad +" ";
				c1=cad.substring(0,1);
				c2=cad.substring(2,3);
				f= Integer.valueOf(c1).intValue();
				c=Integer.valueOf(c2).intValue();
	
			}
			catch (NumberFormatException e1) {
				error = true;
				System.out.println("Error en el formato del numero, intentelo de nuevo.");
			}
			catch (IOException e) {
				System.out.println("Error de E/S");
			}
		} while (error);
	}
}
