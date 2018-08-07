import java.util.Scanner;

import javax.swing.JOptionPane;

public class Matrices1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int nCol, nFil, matriz[][];
		
		nFil = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas: "));
		nCol = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de columnas: "));
		
		matriz = new int[nFil][nCol];
		
		System.out.println("Digite la matriz: ");
		for (int i=0; i<nFil; i++) {
			for (int j=0; j<nCol; j++) {
				System.out.print("matriz["+i+"]["+j+"]: ");
				matriz[i][j] = entrada.nextInt();
			}
		}
		
		System.out.println("\nEsta es su matriz:  \n");
		for (int i=0; i<nFil; i++) {
			for (int j=0; j<nCol; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
		entrada.close();
	}

}
