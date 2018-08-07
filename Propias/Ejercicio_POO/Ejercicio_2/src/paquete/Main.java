package paquete;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		char letra;
		Movimientos tablero = new Movimientos();

		System.out.println("Mover un objeto dentro de un tablero:"
				+ "\nLas teclas posibles son wasd, si ingresa cualquier otra no ocurrirá nada."
				+ "\nIngrese X para salir.");

		tablero.imprimirTablero();
		tablero.imprimirDatos();

		// Ciclo para las repeticiones
		do {
			letra = entrada.next().charAt(0);
			tablero.determinarMov(letra);
			tablero.imprimirTablero();
			tablero.imprimirDatos();
		} while (letra != 'x');

	}

}
