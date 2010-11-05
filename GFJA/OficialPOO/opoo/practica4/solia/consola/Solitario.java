package opoo.practica4.solia.consola;



public class Solitario {

		public static void main(String[] args) {
			ConsolaTablero tablero = new ConsolaTablero();	
			boolean flag=true;
			Par origen=null;
			Par destino=null;
			tablero.addVista(tablero);
			while (flag){
			origen= new Par();
			destino=new Par();
			boolean b=tablero.jugada(origen.f,origen.c, destino.f,destino.c);
			if (!b)  System.out.println("jugada no valida ");
			}			
		}


}

