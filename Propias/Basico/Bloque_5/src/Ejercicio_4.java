
public class Ejercicio_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Crear una matriz de 7x7 y rellenarla de modo que los elementos de la diagonal principal sean 1 y el resto 0
		
		int mat[][] = new int[7][7];
		
		System.out.println("Matriz de 7x7 con 1 en la diagonal principal y 0 en el resto:");
		
		//Rellenar e imprimir la matriz
		for (int i=0; i<7; i++) {
			for (int j=0; j<7; j++) {
				mat[i][j] = 0;
				if (i==j) {
					mat[i][j]=1;
				}
				System.out.print(mat[i][j]+" ");
			}//for j
			System.out.println();
		}//for i
		
	}

}
