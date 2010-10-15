package opoo.juegos.reinas8.estruct;


public class Eprincipal {
	public static void main (String args[])
	{

	   // En Reinas[i] se almacena la columna donde está i
	   Ereina Reinas  = new Ereina();
	   
	   
	   if ( Reinas.colocarReinas( 0 ) )
	      {
	       	for (int i= 0; i < 8; ++i) {
				System.out.println( " Reina " + (i)
						+ " en la fila " + (i+1)
						+ ", columna " + (Reinas.posicion(i)+1));
			}
		  }
		else System.out.println( "No hay solución\n" );
		}
}
