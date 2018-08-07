import java.util.Scanner;

public class Ejercicio_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// leer por teclado 10 elementos de un array y una posicion, eliminar el elemento que se encontraba en esa posicion sin dejar huecos
		//SE PUEDE TRAMPEAR SIMPLEMENTE NO IMPRIMIENDO ESE ELEMENTO (if elemento==0 continue;) c:
		
		Scanner entrada = new Scanner(System.in);
		
		int arreglo[] = new int[10];
		int posicion;
		
		//pedir elementos
		System.out.println("Introduzca 10 enteros.");
		for (int i=0; i<10; i++) {
			System.out.print((i+1)+". Digite un numero: ");
			arreglo[i] = entrada.nextInt();
		}
		
		//imprimir para comprobar
		System.out.println("\nEsta es su tabla inicial: ");
		for (int i:arreglo) {
			System.out.print(i+" ");
		}
		
		//pedir posicion y validar
		do {
			System.out.println("\n\nDigite la posicion (0-9) del elemento que desea eliminar: ");
			posicion = entrada.nextInt();
		} while (posicion<0 || posicion>9);
		
		
		//ESTE ES EL MODO FACIL, NO LO USARE
		/*arreglo[posicion]=0;
		System.out.println("\nEste es su arreglo (modo fácil)"); {
		for (int i=0; i<10; i++) {
			if (arreglo[i]!=0) {
				System.out.print(arreglo[i]+" ");
			}	
		}   */ 
		
		//Hora de la magia: borrar el numero y acomodar los demás
		for (int i=posicion; i<9; i++) {
			arreglo[i]=arreglo[i+1];
		}
		
		//Imprimir ahora sí:
		System.out.println("Tome su impresión del arreglo con el elemento oculto:");
		for (int i=0; i<9; i++) {
			System.out.print(arreglo[i]+" - ");
		}
		entrada.close();
		
	}

}
