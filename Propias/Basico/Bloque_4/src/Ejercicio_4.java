import java.util.Scanner;

public class Ejercicio_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// leer 10 numeros enteros y mostrarlos el primero y ultimo y así.
		Scanner entrada = new Scanner(System.in);
		int[] numeros = new int[10];
		int j=9;
		
		for (int i=0; i<10; i++) {
			System.out.print(i+1+". Ingrese numero: ");
			numeros[i] = entrada.nextInt();
		}
		System.out.println("\nLos numeros impresos en orden riko son los siguientes:");
		for (int i=0; i<5; i++) {
			System.out.println(numeros[i]);
			System.out.println(numeros[j]);			
			j--;
		}
		entrada.close();
	}

}
