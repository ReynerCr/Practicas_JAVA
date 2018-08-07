import java.util.Scanner;

public class Do_while1 {

	public static void main(String[] args) {
		//Do while
		
		Scanner entrada = new Scanner(System.in);
		int i=1, contador;
		
		System.out.println("Digite cuantos numeros quiere en pantalla");
		contador = entrada.nextInt();
		
		while (i<=contador) {
			System.out.println(i);
			i+=1;
		}
		entrada.close();
	}

}
