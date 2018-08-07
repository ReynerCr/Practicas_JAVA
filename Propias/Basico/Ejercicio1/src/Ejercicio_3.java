import java.util.Scanner;

public class Ejercicio_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		float guillermo, luis, juan, sumatotal;
		System.out.println("Ingrese la cantidad de dolares que tiene Guillermo");
		guillermo = entrada.nextFloat();
		luis = guillermo/2;
		juan = (guillermo + luis)/2;
		sumatotal = guillermo + luis + juan;
		//guller=40; luis=20; juan=40+20=60/2=30; 40+20+30=90;
		System.out.print("La cantidad de dinero que tienen entre los 3 es de="+sumatotal);
		System.out.println("$");
		entrada.close();
	}
}
