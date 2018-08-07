package paquete1;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String  marca, modelo;
		float precio;
		int numeroVehiculos, comparacion=0;
		
		numeroVehiculos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de vehículos que se procesarán"));
		
		Vehiculo coches[] = new Vehiculo[numeroVehiculos]; //Arreglo de objetos
		
		for (int i=0; i<coches.length; i++) {
			System.out.println("\nDigite las características del coche "+(i+1)+": ");
			System.out.print("Ingrese la marca del coche: ");
			marca = entrada.next();
			System.out.print("Ingrese el modelo del coche: ");
			modelo = entrada.next();
			System.out.print("Ingrese el precio del coche: ");
			precio = entrada.nextFloat();
		
			coches[i] = new Vehiculo(marca, modelo, precio);
		}//for i
		
		for (int i=0; i<coches.length; i++) {
			if (coches[comparacion].getPrecio()>coches[i].getPrecio()) {
				comparacion = i;
			}
		}//for i
		
		System.out.println("\nEl coche más barato es: ");
		System.out.println(coches[comparacion].mostrarDatos());
		
		entrada.close();
	}

}
