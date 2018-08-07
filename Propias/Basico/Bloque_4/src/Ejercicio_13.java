import java.util.Scanner;

public class Ejercicio_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Leer 10 enteros en una tabla. Separar los elementos pares de la tabla e insertarlos en otra tabla; lo mismo con los impares (3 tablas).
		
		Scanner entrada = new Scanner(System.in);
		int pos_par=0, pos_impar=0;
		int arreglo[] = new int[10];
		
		
		//Explicar programa
		System.out.println("Tabla de 10 elementos, separa los pares de los impares.");
		System.out.println("Ingrese 10 elementos: ");
		
		//Pedir numeros, llenar la primera tabla y saber de que tamaño se harán las otras dos tablas
		for (int i=0; i<10; i++) {
			System.out.print((i+1)+". Digite numero: ");
			arreglo[i] = entrada.nextInt();
			if (arreglo[i] % 2 == 0) {
				pos_par++;
			}
			else {
				pos_impar++;
			}
		}
		
		//Mostrar la tabla ingresada
		System.out.println("\nEsta es su tabla tal cual la ingresó: ");
		for (int i:arreglo) {
			System.out.print(i+" ");
		}
		
		//Inicializar las tablas sabiendo cuantos elementos exactos pares e impares hay en la primera tabla
		int pares[] = new int[pos_par];
		int impares[] = new int[pos_impar];
		
		//Inicializar a cero para que no se sobrepase
		pos_par=0;
		pos_impar=0;
		
		//Hora de hacer la magia
		for (int i=0; i<10; i++) {
			if (arreglo[i]%2==0) {
				pares[pos_par] = arreglo[i];
				pos_par++;
			}
			else {
				impares[pos_impar] = arreglo[i];
				pos_impar++;
			}
		}
		
		//Mostrar la tabla de los pares o indicar que no hubo pares
		if (pos_par==0) {
			System.out.println("\n\nNo hubo pares, no hay tabla que mostrar c:");
		}
		else {
			System.out.println("\n\nEsta es la tabla de los pares: ");
			for (int i:pares) {
				System.out.print(i+" ");
			}
		}
		
		
		//Mostrar la tabla de los impares o indicar que no hubo impares
		if (pos_impar==0) {
			System.out.println("\n\nNo hubo impares, no hay tabla que mostrar c:");
		}
		else {
			System.out.println("\n\nEsta es la tabla de los impares: ");
			for (int i:impares) {
				System.out.print(i+" ");
			}
		}
		entrada.close();
		
	}

}
