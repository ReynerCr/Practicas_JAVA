import java.util.Scanner;

public class Ejercicio_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		float[] numeros = new float[5];
		
		for (int i=0; i<5; i++) {
			System.out.print((i+1)+". Digite un numero: ");
			numeros[i] = entrada.nextFloat();
		}
		
		System.out.println("\nLos numeros ingresados son: ");
		for (float i:numeros) {
			System.out.print(i+"   ");
		}
		entrada.close();
	}

}
