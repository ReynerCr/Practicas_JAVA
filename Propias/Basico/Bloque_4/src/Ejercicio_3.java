import java.util.Scanner;

public class Ejercicio_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner (System.in);
		
		/* int a[];
		 * a = new int[10]
		 */
		
		int j=0;
		int[] A = new int[10];
		int[] B = new int[10];
		int[] C = new int[20];
		
		//Pido arreglo A
		System.out.println("Digite el arreglo A: ");
		for (int i=0; i<10; i++) {
			System.out.print((i+1)+". Digite un numero: ");
			A[i] = entrada.nextInt();
		}
		
		//Pido arreglo B
		System.out.println("Digite el arreglo B: ");
		for (int i=0; i<10; i++) {
			System.out.print((i+1)+". Digite un numero: ");
			B[i] = entrada.nextInt();
		}
		
		//Hora de hacer la magia
		System.out.println("\nSu arreglo magico es: ");
		for (int i=0; i<20; i++) {
			if (i % 2 == 0) {
				C[i] = A[j];
			}
			else {
				C[i] = B[j];
				j++;
			}
			System.out.print(C[i]+" ");
		}
		entrada.close();
	}

}
