import java.util.Scanner;

import javax.swing.JOptionPane;

public class Busqueda_secuencial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Búsqueda secuencial a mi manera (no con while, como está explicado en el video)
		
		Scanner entrada = new Scanner(System.in);
		int dato, arreglo[], nElementos;
		boolean existente = false;
		
		//Valores que contendrá el arreglo y verificación de este valor
		nElementos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos valores tendrá el arreglo?"));
		while (nElementos <=0) {
			nElementos = Integer.parseInt(JOptionPane.showInputDialog("Imposible crear un arreglo de ese número de elementos, reingrese"));
		}
		
		arreglo = new int[nElementos];

		//Llenado de arreglo
		System.out.println("Ahora llene el arreglo");
		for (int i=0; i<nElementos; i++) {
			System.out.print((i+1)+". Digite número: ");
			arreglo[i] = entrada.nextInt();
		}
		
		//Pedir el número que se buscará
		dato = Integer.parseInt(JOptionPane.showInputDialog("Ahora digite el elemento que desee buscar en el arreglo"));
		
		//Buscar el número e imprimir la posición
		System.out.println();
		for (int i=0; i<nElementos; i++) {
			if (arreglo[i] == dato) {
				existente = true;
				System.out.println("Encontrado en la posición: "+i);
			}
		}
		
		//Condición de número no encontrado
		if (existente == false) {
			System.out.println("\nNo se encontró el valor en el arreglo.");
		}
		
		//Finalmente, impresión del arreglo para comprobar que funcionó correctamente
		System.out.println("\nEste es su arreglo tal cual lo digitó");
		for (int i:arreglo) {
			System.out.print(i+" - ");
		}
		entrada.close();
		
	}

}
