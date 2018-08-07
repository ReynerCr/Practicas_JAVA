package paquete1;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int numeroAtleta, cantidadAtletas, tiempo, indiceMTiempo = 0;
		String nombre;

		cantidadAtletas = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de atletas que hay"));

		Atleta corredores[] = new Atleta[cantidadAtletas];
		for (int i = 0; i < corredores.length; i++) {
			System.out.println("Ingrese los datos del atleta " + (i + 1) + ":");
			System.out.print("Numero del corredor: ");
			numeroAtleta = entrada.nextInt();
			System.out.print("Nombre del corredor: ");
			nombre = entrada.next();
			System.out.print("Tiempo de carrera (segundos): ");
			tiempo = entrada.nextInt();
			System.out.println();
			corredores[i] = new Atleta(numeroAtleta, tiempo, nombre);
		} // for para los objetos de atleta

		for (int i = 0; i < corredores.length; i++) {
			if (corredores[indiceMTiempo].getTiempo() > corredores[i].getTiempo()) {
				indiceMTiempo = i;
			}
		} // for para determinar el tiempo menor y por tanto, el ganador

		System.out.println("Datos del ganador:\n" + corredores[indiceMTiempo].mostrarDato());

		entrada.close();
	}

}
