package implementacion;

import java.util.Scanner;
import padres.Producto;

public class Utilidades {
	
	public static Scanner entrada = new Scanner(System.in);
	
	//pausar la ejecucion en la consola
	public static void pausa() {
		entrada.nextLine();
		entrada.nextLine();
	}//pausa
	
	//limpiar pantalla
	public static void limpiar() {
		for (int i=0; i<40; i++) { System.out.println(); }
	}//limpiar
	
	//obtener la posicion de un producto
	public static int getPosicionProductos(Producto[] prods) {
		int i=0;
		while (prods[i]!=null && i<prods.length)
			i++;
		if (i==prods.length)
			i=-1;
		return i;
	}//getPosicionProductos

	
}//class utildades
