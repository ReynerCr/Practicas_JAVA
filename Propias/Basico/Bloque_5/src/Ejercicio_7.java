
public class Ejercicio_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Matris marco "marco" 5x5, todos sus elementos deben ser 0 salvo los bordes que serán 1. Mostrarla
		
		int mat[][] = new int[5][5];
		
		//Llenar la matriz marco e imprimirla a la vez
		System.out.println("La matriz es:\n");
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (i==0 || j==0 || i==4 || j==4) {
					mat[i][j]=1;
				}
				else {
					mat[i][j]=0;
				}
				System.out.print(mat[i][j]+" ");
			}//for i
			System.out.println();
		}//for j
	
	}//main

}//class
