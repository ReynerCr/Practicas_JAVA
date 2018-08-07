package paquete1;

import java.util.Scanner;

public class Main {

	public static double mayorArea(Triangulo_Isosceles triangulos[]) {
		double area = triangulos[0].obtenerArea();

		for (int i = 1; i < triangulos.length; i++) {
			if (area < triangulos[i].obtenerArea()) {
				area = triangulos[i].obtenerArea();
			}
		} // for para determinar el triangulo con un area mayor

		return area;

	}// double mayorArea

	public static void main(String[] args) {
		// Programa para trabajar con triangulos isósceles, calcular área y
		// perímetro.

		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		double lado, base;
		int nTriangulos;

		System.out.print("Digite cuantos triángulos isósceles que ingresará al programa: ");
		nTriangulos = entrada.nextInt();

		Triangulo_Isosceles triangulos[] = new Triangulo_Isosceles[nTriangulos];

		for (int i = 0; i < triangulos.length; i++) {
			System.out.println("\nIngrese los valores del triángulo " + (i + 1) + ": ");
			System.out.print("Ingrese medida de la base (cm): ");
			base = entrada.nextDouble();
			System.out.print("Ingrese medidas de los lados (cm): ");
			lado = entrada.nextDouble();

			triangulos[i] = new Triangulo_Isosceles(base, lado);
			System.out.println("\nEl perímetro del triángulo es: " + triangulos[i].obtenerPerimetro());
			System.out.println("El área del triángulo es: " + triangulos[i].obtenerArea());
		} // for para pedir los triangulos

		System.out.println("\nEl área del triángulo de mayor superficie es: " + mayorArea(triangulos));

	}// int main

}// MAIN
