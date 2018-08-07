import java.util.Scanner;

public class Ejercicio_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float horas_totales, semanas, dias, horas;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese el numero total de horas: ");
		horas_totales = entrada.nextFloat();
		
		semanas = (horas_totales/24)/7; //ya da resultado; 1000/24 y entre 7=5.95; 5;
		dias = (((semanas*100) % 100) * 7)/100; //6.65
		horas = Math.round((((dias * 100) % 100) / 100) * 24);
		semanas = (int) semanas;
		dias = (int) dias;
		System.out.println("Semanas: "+semanas);
		System.out.println("Dias: "+dias);
		System.out.println("Horas: "+horas);
		entrada.close();	
	}

}
