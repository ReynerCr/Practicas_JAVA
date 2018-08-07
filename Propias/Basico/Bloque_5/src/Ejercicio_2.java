import java.util.Scanner;

public class Ejercicio_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Crear y cargar dos matrices de 3x3, sumarlas y mostrar el resultado
		
		Scanner entrada = new Scanner(System.in);
		int mat1[][], mat2[][], suma[][];
		
		mat1 = new int[3][3];
		mat2 = new int[3][3];
		suma = new int[3][3];
		
		System.out.println("Suma de dos matrices 3x3.\n");
		
		//Pedir los datos de la primera matriz
		System.out.println("Ingrese los valores de la primera matriz: ");
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print("matriz["+i+"]["+j+"]: ");
				mat1[i][j] = entrada.nextInt();
			}
		}
		
		//Pedir los datos de la segunda matriz
		System.out.println("Ingrese los valores de la segunda matriz: ");
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print("matriz["+i+"]["+j+"]: ");
				mat2[i][j] = entrada.nextInt();
			}
		}
		
		//Sumar e imprimier la suma de las matrices
		System.out.println("Esta es la suma de las dos matrices: ");
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				suma[i][j]=mat1[i][j]+mat2[i][j];
				System.out.print(suma[i][j]+" ");
			}
			System.out.println();
		}
		entrada.close();
	}

}
