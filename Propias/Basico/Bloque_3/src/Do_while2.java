import java.util.Scanner;

public class Do_while2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		int i=1, contador;
		System.out.println("Digite cuantas veces quiere que se repita");
		contador = entrada.nextInt();
		
		do {
			System.out.println(i);
			i++;
		} while (i<=contador);
		entrada.close();
	}

}
