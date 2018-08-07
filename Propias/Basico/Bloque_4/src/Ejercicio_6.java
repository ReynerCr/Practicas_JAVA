import java.util.Scanner;

public class Ejercicio_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		int a[], b[], c[], j=0;	
		
		a = new int[12];
		b = new int[12];
		c = new int[24];
		
		//Arreglo A
		System.out.println("Digite el arreglo A: ");
		for (int i=0; i<12; i++) {
			System.out.print((i+1)+". ");
			a[i] = entrada.nextInt();
		}
		
		//Arreglo B
		System.out.println("Digite el arreglo B: ");
		for (int i=0; i<12; i++) {
			System.out.print((i+1)+". ");
			b[i] = entrada.nextInt();
		}
		
		//Arreglo C (la magia)
		for (int i=0; i<12; i=i+3) {
				c[j] = a[i];
				j++;
				c[j] = a[i+1];
				j++;
				c[j] = a[i+2];
				j++;
			
				c[j] = b[i];
				j++;
				c[j] = b[i+1];
				j++;
				c[j] = b[i+2];
				j++;
		}
		
		//Impresion de arreglo C
		System.out.println("\nEste es su arreglo C:");
		for (int i=0; i<24; i++) {
			System.out.print(c[i]+" ");
		}
		entrada.close();
	}

}
