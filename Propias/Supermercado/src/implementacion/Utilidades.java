package implementacion;

import java.util.Scanner;

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

	
}//class utildades
