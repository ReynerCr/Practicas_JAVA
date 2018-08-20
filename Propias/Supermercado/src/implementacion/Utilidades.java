package implementacion;

import java.util.Scanner;

import hijas.Carnes;
import hijas.Enlatados;
import hijas.LacteosLiquidos;
import hijas.LacteosSolidos;
import hijas.Viveres;
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
	
	//clonar productos porque al igualar solo igualo el apuntador
	public static void setProd(Producto prod[], Producto prod2, int i) {
		if (prod2!=null) {
			if (prod2 instanceof Carnes)
				prod[i] = new Carnes();
				
			else if (prod2 instanceof Enlatados)
				prod[i] = new Enlatados();
			
			else if (prod2 instanceof LacteosLiquidos)
				prod[i] = new LacteosLiquidos();
				
			else if (prod2 instanceof LacteosSolidos)
				prod[i] = new LacteosSolidos();
			
			else if (prod2 instanceof Viveres)
				prod[i] = new Viveres();
		
		
			prod[i].setCodigo(prod2.getCodigo());
			prod[i].setDescripcion(prod2.getDescripcion());
			prod[i].setCantidadEnExistencia(prod2.getCantidadEnExistencia());
			prod[i].setCosto(prod2.getCosto());
			prod[i].setVenta(prod2.getVenta());
		}//if
		else {
			prod[i] = prod2;
		}
	}//setProd

	
}//class utildades
