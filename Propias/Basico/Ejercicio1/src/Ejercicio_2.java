import java.util.Scanner;

public class Ejercicio_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner entrada = new Scanner(System.in);
		/*Hacer un programa que calcule e imprima el salario semanal de un empleado a partir
		de sus horas semanales trabajadas y de su salario por hora*/
		int horas_trabajadas, salario_hora, salario_semanal;
		
		System.out.println("Programa para calcularel salario semanal\n");
		System.out.print("Digite las horas semanales trabajadas y a continuación su salario por hora: ");
		
		horas_trabajadas = entrada.nextInt();
		salario_hora = entrada.nextInt();
		
		salario_semanal = horas_trabajadas * salario_hora;
		
		System.out.print("\nEl sueldo de esta semana es de: "+salario_semanal);
		System.out.println("$");
		entrada.close();
	} //FIN

}
