import java.util.Scanner;

public class Ejercicio_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		//Declaro la tabla de 10 enteros
		int[] tabla = new int[10];
		int numero, posicion, auxiliar;
		
		//Pedir 8 elementos
		System.out.println("Tabla de 10 elementos.");
		for (int i=0; i<8; i++) {
			System.out.print((i+1)+". Digite un numero: ");
			tabla[i] = entrada.nextInt();
		}
		tabla[8] = 0;
		tabla[9] = 0;
		
		//Imprimir la tabla por primera vez
		System.out.println("\nEsta es su tabla: ");
		for (int i=0; i<10; i++) {
			System.out.print(tabla[i]+" ");
		}
		do {
			//Pedir un numero y una posicion
			System.out.print("\n\nDigite número que quiera añadir a la tabla (0 para salir): ");
			numero = entrada.nextInt();
			
			if (numero==0) {
				break;
			}
			
			do  {
				System.out.print("Digite la posición donde quiera añadir el número (1-10): ");
				posicion = (entrada.nextInt())-1;
			} while (posicion<0 || posicion>10);
			
			for (int i=posicion; i<10; i++) {
				auxiliar=tabla[i];
				tabla[i]=numero;
				if (i<9) {
					numero=auxiliar;
				}	
			}
			
			//Imprimir la tabla de nuevo
			System.out.println("\n\nEsta es su tabla: ");
			for (int i=0; i<10; i++) {
				System.out.print(tabla[i]+" ");
			}
			numero=1;
		} while (numero!=0);
		System.out.println("\nFin de programa.");
		entrada.close();
	}

}
