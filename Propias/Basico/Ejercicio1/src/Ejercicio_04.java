import java.util.Scanner;

public class Ejercicio_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		double a, b, c;
		double resolv, x, x1, x2;
		
		System.out.println("Ingrese el valor de a, b y c");
		a = entrada.nextDouble();
		b = entrada.nextDouble();
		c = entrada.nextDouble();
		
		x = (b * -1);
		resolv = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
		x1 = (x + resolv)/2 * a;
		x2 = (x - resolv)/2 * a;
		
		System.out.println("Sus dos valores son:");
		System.out.print("x1="+x1);
		System.out.println("\tx2="+x2);
		entrada.close();
	}
}
