import java.util.Scanner;

public class Ejercicio_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Cargar una matriz de 3x3, trasponerla y mostrarla
		Scanner entrada = new Scanner(System.in);
		int matriz[][] = new int[3][3];
		int aux;
		
		System.out.println("Mostrar una matriz traspuesta");
		
		//Pedir la matriz 3x3
		System.out.println("Ingrese su matriz 3x3");
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print("matriz["+i+"]["+j+"]: ");
				matriz[i][j] = entrada.nextInt();
			}//for i
		}//for j
		
		//Mostrar la matriz ingresada
		System.out.println("\nEsta es su matriz tal cual la digitó: ");
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(matriz[i][j]+" ");
			}//for i
			System.out.println();
		}//for j	
		
		//Trasponer la matriz
		for (int i=0; i<3; i++) {
			for (int j=0; j<i; j++) {
				aux = matriz[j][i];
				matriz[j][i] = matriz[i][j];
				matriz[i][j] = aux;
			}//for j
		}//for i
		
		//Mostrar la matriz traspuesta
		System.out.println("\nEsta es su matriz traspuesta: ");
		for  (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		entrada.close();
	}

}
