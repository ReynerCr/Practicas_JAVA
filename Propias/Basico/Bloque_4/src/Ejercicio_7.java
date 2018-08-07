import java.util.Scanner;

public class Ejercicio_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// leer por teclado una serie de 10 numeros enteros e indicar si estan ordenados de alguna forma o desordenados
		
		Scanner entrada = new Scanner(System.in);
		int numero[] = new int[10];
		boolean mayor_menor=false,  menor_mayor=false;   // desorden=false;
		//pedir numeros
		System.out.println("Ingrese 10 numeros");
		for (int i=0; i<10; i++) {
			System.out.print((i+1)+". Ingrese numero: ");
			numero[i] = entrada.nextInt();
		}
		
		//Verificar orden
		for (int i=0; i<9; i++) {
			if (numero[i]>numero[i+1]) {
				mayor_menor=true;
			}
			else if (numero[i]<numero[i+1]) {
				menor_mayor=true;
			}
		}
		
		if (mayor_menor==true && menor_mayor==true) {
			System.out.println("Están desordenados");
		}
		else if (mayor_menor==true && menor_mayor==false) {
			System.out.println("Están ordenados de mayor a menor");
		}
		else if (mayor_menor==false && menor_mayor==true) {
			System.out.println("Están ordenados de menor a mayor");
		}
		else if (mayor_menor==false && menor_mayor==false) {
			System.out.println("Son iguales");
		}
		entrada.close();
	}

}
