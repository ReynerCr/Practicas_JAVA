import java.util.Scanner;

public class Ejercicio_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		float numeros[] = new float[5];
		
		System.out.println("Ingrese 5 numeros");
		
		for (int i=0; i<5; i++) {
			numeros[i] = entrada.nextFloat();
		}
		System.out.println("\nEstos son los numeros ingresados en orden inverso al introducido:");
		
		for (int i = 4; i>=0; i--) {
			System.out.println(numeros[i]);
		}
		entrada.close();
	}

}
