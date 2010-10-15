package opoo.juegos.reinas8.estruct;


public class Ereina {
	int[] R = new int[8];
	public boolean buenSitio (int j)
		{
		int i;
			// ¿Es amenaza colocar la reina j en A[j], con las anteriores ?
			for(i = 0; i < j; ++i) {
				{
					if ((R[i]== R[j])||(Math.abs(R[i]-R[j]) == Math.abs(i-j)))
					{
						break;
					}
				}	
			}
			return (i==j);	
	    }
		
		public boolean colocarReinas (int j)
		{
		//	int contador;
			boolean toret = false;
			// Comprobar con todas las columnas
			for (int i = 0; i < 8; ++i)
			{// Colocar la reina j en la columna i
				R[j] = i;
				if (buenSitio(j))
			{	
				// Si j es N+1 he colocado todas las reinas
				if ((j+1)==8){
					toret = true;
					break;
					}
				else {
					// Hacer el siguiente paso recursivamente
					// (colocar la siguiente reina)
					if (colocarReinas(j+1)){
						toret = true;
						break;
						}
				}
			}
			}
		return toret;
		}
		public int posicion(int j){
			return (R[j]);
		}
}
