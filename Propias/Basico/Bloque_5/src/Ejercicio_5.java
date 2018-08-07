import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Crear y cargar una matriz de n x m, mostrar la suma de cada fila y de cada columna
		
		Scanner entrada = new Scanner(System.in);
		int mat[][], nFil, nCol, suma=0;
		
		//Pedir cuantas filas tendrá la matriz y validar
		nFil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas"));
		while (nFil<=0) {
			nFil = Integer.parseInt(JOptionPane.showInputDialog("Número de filas no válido, reingrese"));
		}
		
		
		//Pedir cuantas columnas tendrá la matriz y validar
		nCol = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas"));
		while (nCol<=0) {
			nCol = Integer.parseInt(JOptionPane.showInputDialog("Número de columnas no válido, reingrese"));
		}
		
		
		//Declarar la matriz con los datos ingresados
		mat = new int[nFil][nCol];
		
		
		//Pedirle al usuario de los datos de la matriz
		System.out.println("Ahora llene la matriz: ");
		for (int i=0; i<nFil; i++) {
			for (int j=0; j<nCol; j++) {
				System.out.print("matriz["+i+"]["+j+"]: ");
				mat[i][j] = entrada.nextInt();
			}//for j
		}//for i
		
		
		//Mostrar la matriz ingresada
		System.out.println("\nEsta es su matriz tal cual la digitó: ");
		for (int i=0; i<nFil; i++) {
			for (int j=0; j<nCol; j++) {
				System.out.print(mat[i][j]+" ");
			}//for j
			System.out.println();
		}//for i
		
	
		//Hora de la magia con las filas e impresión
		System.out.println("\nSumas de las filas: ");
		for (int i=0; i<nFil; i++) {
			for (int j=0; j<nCol; j++) {
				suma += mat[i][j];
				if (j==(nCol-1)) {
					System.out.println("Suma de fila ["+(i+1)+"] es: "+suma);
					suma=0;
				}//if
			}//for i
		}//for j
	
	
		//Hora de la magia con las columnas e impresión
		System.out.println("\nSumas de las columnas: ");
		for (int j=0; j<nCol; j++) {
			for (int i=0; i<nFil; i++) {
				suma += mat[i][j];
				if (i==(nFil-1)) {
					System.out.println("Suma de columna ["+(j+1)+"] es: "+suma);
					suma=0;
				}//if
			}//for i
		}//for j
		entrada.close();
	}//main
}//class
