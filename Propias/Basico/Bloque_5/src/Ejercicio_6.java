import java.util.Scanner;

public class Ejercicio_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Utilizando dos matrices de 5x9 y 9x5, cargar la primera y trasponerla en la segunda
		
		Scanner entrada = new Scanner(System.in);
		int mat1[][], mat2[][];
		
		//Declaro las matrices
		mat1 = new int[5][9];
		mat2 = new int[9][5];
		
		//Llenar la matriz
		System.out.println("Llene la matriz de 5x9");
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				System.out.print("matriz["+i+"]["+j+"]: ");
				mat1[i][j] = entrada.nextInt();
			}//for j
		}//for i
		
		
		//Imprimir la matriz inicial
		System.out.println("\nEsta es su matriz 5x9 tal cual la digitó: ");
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				System.out.print(mat1[i][j]+" ");
			}//for j
			System.out.println();
		}//for i
		
		//Hacer la matriz traspuesta e imprimirla
		System.out.println("\nEsta es la matriz traspuesta de 9x5: ");
		for (int i=0; i<9; i++) {
			for (int j=0; j<5; j++) {
				mat2[i][j] = mat1[j][i];
				System.out.print(mat2[i][j]+" ");
			}
			System.out.println();
		}
		entrada.close();
		
	}//main

}//class
