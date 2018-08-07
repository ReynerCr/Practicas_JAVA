import java.util.Scanner;

public class Ejercicio_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1000$ mensuales + 150$ por cada carro + 5% de lo que vale carro.
		
		int numero_carros;
		float valor_carros, sueldo=1000f;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Programa para calcular el salario de vendedor de carros ");
		System.out.println("\nIngrese el numero de carros vendidos");
		numero_carros = entrada.nextInt();
		System.out.println("Ingrese el valor en $ de los carros ");
		valor_carros = entrada.nextFloat();
		sueldo += (150*numero_carros) + (valor_carros * 0.05) * numero_carros;
		
		//vendió 4 carros y cada carro vale 1100$ (comisión de 55$ por carro)
		//4*55=220; 150*4=600; +1000    TODO=220+600+1000=1820$
		
		System.out.print("El sueldo del empleado es de: "+sueldo);
		System.out.println("$");
		entrada.close();
	}

}
