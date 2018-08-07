package paquete;

public class Movimientos {
	//Atributos
	int matriz[][] = new int[10][10]; //tablero
	private int pFil = 4; //posición del objeto en filas
	private int pCol = 4; //posición del objeto en columnas
	private String direccion = "no determinada";
	
	//Métodos
		
	//Método para determinar hacia donde se moverá el objeto
	public void determinarMov(char _letra) {
		switch (_letra) {
			case 'w':
				matriz[pFil][pCol] = 0;
				if (pFil > 0)
					pFil--;
				matriz[pFil][pCol] = 1;
				direccion = "arriba";
				break;
			
			case 's':
				matriz[pFil][pCol] = 0;
				if (pFil < 9)
					pFil++;
				matriz[pFil][pCol] = 1;
				direccion = "abajo";
				
				break;
				
			case 'a':
				matriz[pFil][pCol] = 0;
				if (pCol > 0)
					pCol--;
				matriz[pFil][pCol] = 1;
				direccion = "izquierda";
				break;
				
			case 'd':
				matriz[pFil][pCol] = 0;
				if (pCol < 9)
					pCol++;
				matriz[pFil][pCol] = 1;
				direccion = "derecha";
				break;
				
			case 'x':
				direccion = "no hubo direccion";
				break;			
		}//switch
	}//determinarPosicion
	
	//Imprimir la matriz
	public void imprimirTablero() {
		System.out.println();
		matriz[pFil][pCol] = 1;
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
	}//imprimir
	
	//Método para imprimir los datos que se piden
	public void imprimirDatos() {
		System.out.println("La dirección elegida es: "+direccion);
		System.out.println("El objeto se encuentra en las coordenadas: "+(pFil+1)+", "+(pCol+1));
	}
	
	
}