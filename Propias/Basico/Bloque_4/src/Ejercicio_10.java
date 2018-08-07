import java.util.Scanner;

public class Ejercicio_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		//int[] tabla = new int[10];
		int posiciones, ultimo;
		int tabla[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		/*//pido valores
		System.out.println("Ingrese valores de su arreglo: ");
		for (int i=0; i<10; i++) {
			System.out.print((i+1)+". Digite un numero: ");
			tabla[i] = entrada.nextInt();
		}*/
		
		System.out.println("Este es su arreglo tal cual lo ingresó: ");
		for (int i:tabla) {
			System.out.print(i+" ");
		}
		
		do {
			System.out.print("\n\nIngrese la cantidad de posiciones que se desplazarán los elementos del arreglo: ");
			posiciones = (entrada.nextInt())-1;
		} while (posiciones<0);		
		
		//La magia
		for (int j=0; j<=posiciones; j++) {
			ultimo=tabla[9];
			for (int i=8; i>=0; i--) {
				tabla[i+1]=tabla[i];
			}
			tabla[0]=ultimo;
		}
		
		//Impresión final del arreglo
		System.out.println("\n\nEste es su arreglo modificado: ");
		for (int i:tabla) {
			System.out.print(i+" ");
		}
		entrada.close();
		
	}

}
