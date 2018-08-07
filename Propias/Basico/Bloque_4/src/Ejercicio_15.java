import java.util.Scanner;

public class Ejercicio_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		int arreglo[] = new int[10];
		int N, contador_N=0;
		boolean creciente;
		
		System.out.println("Buscar un elemento N en una tabla de 10 enteros");
		
		//Ciclo para ingresar los datos y verificar el orden creciente
		System.out.println("\nIngrese números en orden creciente: ");
		do {
			creciente=true;
			
			for (int i=0; i<10; i++) {
				System.out.print((i+1)+". Digite un número: ");
				arreglo[i] = entrada.nextInt();
				if (i!=0 && arreglo[i]<arreglo[i-1]) {
					creciente=false;
					System.out.println("\nEl arreglo está desordenado, digite nuevamente: ");
					break;
				}
			}
		} while (creciente==false);
		
		//Pedir el número
		System.out.println("\nBien, ahora digite un número que quiera buscar en la tabla: ");
		N = entrada.nextInt();
		
		//Imprimir la tabla para el usuario y a la vez revisar si se encuentra N en la misma.
		System.out.println("\nEsta es su tabla tal cual la digitó: ");
		for (int i=0; i<10; i++) {
			System.out.print(arreglo[i]+" ");
			if (arreglo[i]==N) {
				contador_N++;
			}
		}//for
		
		System.out.println("\n");
		//Condición de que no se encuentra N en la tabla.
		if (contador_N==0) {
			System.out.println(N+" no se encuentra en el arreglo.");
		}//if
		
		//Condición de que se encuentra N tantas veces en la tabla y las posiciones.
		else {
			System.out.println(N+" se encuentra "+contador_N+" vez/veces en el arreglo en las siguientes posiciones: ");
			for (int i=0; i<10; i++) {
				if (arreglo[i]==N) {
					System.out.print(i+" ");
				}
				if (arreglo[i]>N) {
					break;
				}
			}
		}//else
		entrada.close();
	}//main

}//class
