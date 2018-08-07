package paquete1;
//Programa para calcular el �rea de pol�gonos y luego mostrarlos

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//ARREGLO DINAMICO
	static ArrayList<Poligono> poligonos = new ArrayList<Poligono>();
	static Scanner entrada = new Scanner(System.in);
	 
	
	public static void main(String[] args) {
		
		llenarPoligono();
		mostrarResultados();
		
	}
	
	public static void llenarPoligono() {
		int opcion;
		do {
			System.out.println("Digite que poligono desea: ");
			System.out.println("1. Triangulo.");
			System.out.println("2. Rectangulo");
			System.out.println("3. Salir");
			System.out.print("Opcion: ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
				case 1: llenarTriangulo();
					break;
				case 2: llenarRectangulo();
					break;
				case 3:
					break;
				default: 
					System.out.println("Valor ingresado no valido, reingrese.");
			}
			
			System.out.print("Desea a�adir otro poligono? (si=1, no=2)");
			opcion = entrada.nextInt();
			System.out.println("\n");
		} while(opcion==1);
	}
	
	public static void llenarTriangulo() {
		double lado1, lado2, lado3;
		
		System.out.print("Digite el lado1 del rectangulo: ");
		lado1 = entrada.nextDouble();
		System.out.print("Digite el lado2 del rectangulo: ");
		lado2 = entrada.nextDouble();
		System.out.print("Digite el lado3 del rectangulo: ");
		lado3 = entrada.nextDouble();
		
		//se guarda un objeto dentro del arreglo
		Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
		poligonos.add(triangulo);
	}
	
	public static void llenarRectangulo() {
		double lado1, lado2;
		
		System.out.print("Digite el lado1 del rectangulo: ");
		lado1 = entrada.nextDouble();
		System.out.print("Digite el lado2 del rectangulo: ");
		lado2 = entrada.nextDouble();
		
		Rectangulo rectangulo = new Rectangulo(lado1, lado2);
		poligonos.add(rectangulo);
	}
	
	public static void mostrarResultados() {
		for (Poligono poli: poligonos) {
			System.out.println(poli.toString());
			System.out.println("Area: "+poli.area());
			System.out.println();
		}
	}
	
}//class main
