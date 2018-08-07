import java.util.Scanner;

import javax.swing.JOptionPane;

public class Insercion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		int arreglo[], nElementos, pos, aux;
		
		//Pedir e numero de elementos
		nElementos = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de elementos del arreglo: "));
		arreglo = new int[nElementos];
		
		//Llenado de arreglo
		System.out.println("\nAhora ingrese los valores que contendrá el arreglo");
		for (int i=0; i<nElementos; i++)  {
			System.out.print((i+1)+". Digite número: ");
			arreglo[i] = entrada.nextInt();
		}
		
		//Ordenamiento por inserción
		for (int i=0; i<nElementos; i++) {
			pos = i;
			aux = arreglo[i];
			
			while ((pos>0) && (arreglo[pos-1]>aux)) {
				arreglo[pos] = arreglo[pos-1];
				pos--;
			}
			
			arreglo[pos] = aux;
		}
		
		System.out.print("\nOrden ascendente: ");
		for (int i:arreglo) {
			System.out.print(i+" - ");
		}
		
		
		System.out.print("\n\nOrden descendente: ");
		for (int i=(nElementos-1); i>=0; i--) {
			System.out.print(arreglo[i]+" - ");
		}
		
		
		
	}

}
