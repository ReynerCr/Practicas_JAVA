import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crear y cargar una matriz de N x M y decir si es simétrica o no
		
		Scanner entrada = new Scanner(System.in);
		int matriz[][], nFil, nCol;
		boolean simetria=false;
		
		//Pido filas y verifico el valor
		nFil = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas que tendrá la matriz"));
		while (nFil<0) {
			nFil = Integer.parseInt(JOptionPane.showInputDialog("No es un valor correcto, reingrese las filas"));
		}
		
		//Pido columnas y verifico el valor
		nCol = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas que tendrá la matriz"));
		while (nCol<0) {
			Integer.parseInt(JOptionPane.showInputDialog("No es un valor correcto, reingrese las columnas"));
		}
		
		//Declaro la matriz
		matriz = new int[nFil][nCol];
		
		//Pido datos de la matriz
		System.out.println("Ahora digite su matriz: ");
		for (int i=0; i<nFil; i++) {
			for (int j=0; j<nCol; j++) {
				System.out.print("matriz["+i+"]["+j+"]: ");
				matriz[i][j] = entrada.nextInt();
			}//for j
		}//for i
		
		//Imprimo la matriz
		System.out.println("\nEsta es su matriz tal cual la digitó: ");
		for (int i=0; i<nFil; i++) { 
			for (int j=0; j<nCol; j++) {
				if (matriz[i][j]>=1000 || matriz[i][j]<=-1000) {
					System.out.print(matriz[i][j]+" ");
				}
				else if (matriz[i][j]>=100 || matriz[i][j]<=-100) {
					System.out.print(matriz[i][j]+"  ");
				}
				else if (matriz[i][j]>=10 || matriz[i][j]<=-10) {
					System.out.print(matriz[i][j]+"   ");
				}
				else if (matriz[i][j]>=10 || matriz[i][j]<=-10) {
					System.out.print(matriz[i][j]+"    ");
				}
				else {
					System.out.print(matriz[i][j]+"     ");
				}
			}
			System.out.println();
		}
		
		//Imprimo a matriz trasversa
		System.out.println("\n Esta es su matriz trasversa: ");
		for (int j=0; j<nCol; j++) { 
			for (int i=0; i<nFil; i++) {
				if (matriz[i][j]>=1000 || matriz[i][j]<=-1000) {
					System.out.print(matriz[i][j]+" ");
				}
				else if (matriz[i][j]>=100 || matriz[i][j]<=-100) {
					System.out.print(matriz[i][j]+"  ");
				}
				else if (matriz[i][j]>=10 || matriz[i][j]<=-10) {
					System.out.print(matriz[i][j]+"   ");
				}
				else if (matriz[i][j]>=10 || matriz[i][j]<=-10) {
					System.out.print(matriz[i][j]+"    ");
				}
				else {
					System.out.print(matriz[i][j]+"     ");
				}
			}
			System.out.println();
		}
		//Cuando se cumple que filas=columnas se verifica si la matriz es simétrica o no
		if (nFil == nCol) {
			for (int i=0; i<nFil; i++) {
				for (int j=0; j<nCol; j++) {
					simetria=true;
					if (matriz[i][j] != matriz[j][i]) {
						simetria=false;
						break;
					}
				}//for j
			}//for i
		}//else
		
		//Imprimir si la matriz es simétrica o no
		if (simetria==true) {
			JOptionPane.showMessageDialog(null, "La matriz es simetrica.");
		}
		else {
			JOptionPane.showMessageDialog(null, "La matriz no es simetrica.");
		}
		entrada.close();
	}//main

}//class
