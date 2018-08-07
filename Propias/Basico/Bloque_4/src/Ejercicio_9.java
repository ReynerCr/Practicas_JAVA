import java.util.Scanner;

public class Ejercicio_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		int arreglo[] = new int[10];
		int ultimo;
		
		//pedir numeros
		System.out.println("Digite los elementos del arreglo: ");
		for (int i=0; i<10; i++) {
			System.out.print((i+1)+". Digite un numero: ");
			arreglo[i] = entrada.nextInt();
		}
		
		//imprimo para comprobar que se ingresaron bien los datos
		System.out.println("Esta es su tabla tal cual la digitó: ");
		for (int i=0; i<10; i++) {
			System.out.print(arreglo[i]+" ");
		}
		
		//hora de la magia
		ultimo=arreglo[9];
		for (int i=8; i>=0; i--) {
			arreglo[i+1]=arreglo[i];
		}
		arreglo[0]=ultimo;
		
		//impresion
		System.out.println("\n\nEsta es su tabla ya modificada:");
		for (int i=0; i<10; i++) {
			System.out.print(arreglo[i]+" ");
		}
		entrada.close();
		
	}

}
