import java.util.Scanner;

public class Ejercicio_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//leer 5 elementos que se introducirán de forma creciente, luego pedir un numero N e introducirlo donde va.
		
		Scanner entrada = new Scanner(System.in);
		int arreglo[] = new int[10];
		int numero, posicion = 5;
		boolean creciente = true;
	
		//pedir numeros del arreglo y validarlos
		do {
			System.out.println("\nIngrese 5 numeros de forma CRECIENTE.");
			creciente = true;
			for (int i=0; i<5; i++) {
				System.out.print((i+1)+". Ingrese numero: ");
				arreglo[i] = entrada.nextInt();
				if (i>0 && arreglo[i-1]>arreglo[i]) {
					creciente = false;
					break;
				}
			}//for
		} while (creciente == false);
		
		//pedir numero
		System.out.print("\nBien, ahora ingrese número que se introducirá en la tabla: ");
		numero = entrada.nextInt();
		
		//Ahora la magia, buscar en donde va el numero
		for (int i=0; i<5; i++) {
			if (arreglo[i]>numero) {
				posicion=i;
				break;
			}
		}
		
		//reacomodar el arreglo
		for (int i=8; i>=posicion; i--) {
			arreglo[i+1]=arreglo[i];
		}
		//en la posición donde va el número, colocarlo ahora sí
		arreglo[posicion]=numero;
		
		
		//imprimir arreglo listo
		for (int i=0; i<6; i++) {
			System.out.print(arreglo[i]+" - ");
		}
		entrada.close();
					
	}

}
