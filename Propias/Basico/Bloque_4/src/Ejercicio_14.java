import java.util.Scanner;

public class Ejercicio_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Leer dos series de 10 enteros y verificar si están en en orden creciente (en caso contrario repedir el arreglo).
		 * Fusionar ambas series (tablas) en una tercera serie, y ordenarlos. 
		 */
		
		Scanner entrada = new Scanner(System.in);
		boolean creciente;
		int conteo_serie1=0, conteo_serie2=0;
		int serie1[] = new int[10];
		int serie2[] = new int[10];
		int serie3[] = new int[20];
		
		//Pedir datos de la primera sere
		do {
			System.out.println("\nIngrese la primera serie en orden CRECIENTE");
			creciente=true;
			for (int i=0; i<10; i++) {
				System.out.print((i+1)+". Digite numero: ");
				serie1[i] = entrada.nextInt();
				if (i!=0 && serie1[i]<serie1[i-1]) {
					creciente=false;
					break;
				}
			}
		} while (creciente==false);
		
		//Pedir datos de la segunda serie
		do {
			System.out.println("\nIngrese la segunda serie en orden CRECIENTE");
			creciente=true;
			for (int i=0; i<10; i++) {
				System.out.print((i+1)+". Digite numero: ");
				serie2[i] = entrada.nextInt();
				if (i!=0 && serie2[i]<serie2[i-1]) {
					creciente=false;
					break;
				}
			}
		} while (creciente==false);
		
		
		//Ahora se llenará la tercera tabla con los datos de las dos primeras (o se llena a lo macho y se arregla con burbuja, o se llena con calma)
		//Luego se imprime el dato ya verificado :D
		System.out.println("\n\nEsta es su tabla final:");
		for (int i=0; i<20; i++) {
			if (conteo_serie1 < 10 && serie1[conteo_serie1]<=serie2[conteo_serie2]) {
				serie3[i]=serie1[conteo_serie1];
				conteo_serie1++;
			}
			else {
				serie3[i]=serie2[conteo_serie2];
				conteo_serie2++;
			}
			System.out.print(serie3[i]+" ");
		}
		entrada.close();
	}

}
