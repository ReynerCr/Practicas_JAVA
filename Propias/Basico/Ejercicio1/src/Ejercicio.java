import java.util.Scanner;

public class Ejercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		float nota1, nota2, nota3, notafin;
		System.out.println("Digite 3 calificaciones");
		nota1 = entrada.nextFloat();
		nota2 = entrada.nextFloat();
		nota3 = entrada.nextFloat();
		
		notafin = nota1 + nota2 + nota3;
		
		System.out.println("Su calificación es=" +notafin);
		entrada.close();
	}

}
