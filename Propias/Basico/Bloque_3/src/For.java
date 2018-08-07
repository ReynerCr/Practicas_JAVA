import java.util.Scanner;

public class For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		int contador;
		
		System.out.println("Digite la cantidad de terminos");
		contador = entrada.nextInt();
		
		for (int i=1; i<=contador; i++) {
			System.out.println(i);
		}
		entrada.close();
	}

}
