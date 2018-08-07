import java.util.Scanner;

import javax.swing.JOptionPane;

public class Burbuja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		int arreglo[], nElementos, aux;
		
		//Pido la cantidad de valores que contendrá el arreglo y luego declaro el arreglo con su tamaño
		nElementos = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de elementos que va a contener el arreglo"));
		arreglo = new int[nElementos];
		
		//Pido elementos del arreglo
		for (int i=0; i<nElementos; i++) {
			System.out.print((i+1)+". Digite un numero: ");
			arreglo[i] = entrada.nextInt();
		}
		
		//Método de burbuja
		for (int i=0; i<(nElementos-1); i++) {
			for (int j=0; j<(nElementos-1); j++) {
				if (arreglo[j]>arreglo[j+1]) {
					aux = arreglo[j];
					arreglo[j] = arreglo[j+1];
					arreglo[j+1] = aux;
				}
			}
		}
		
		//Mostrar el arreglo ordenado de forma creciente
		System.out.println("Arreglo ordenado en forma creciente");
		for (int i:arreglo) {
			System.out.print(i+" - ");
		}
		System.out.println("\nArreglo ordenado en forma decreciente");
		//Arreglo ordenado en forma decreciente
		for (int i=nElementos-1; i>=0; i--) {
			System.out.print(arreglo[i]+" - ");
		}
		entrada.close();
		
	}

}
