package hijas;

import java.io.IOException;
import java.util.Scanner;

import padre.*;

public class Electronicos extends Producto {
	public static Scanner entrada = new Scanner(System.in);
	
	private int voltaje;
	
	public Electronicos() {
		super();
		this.voltaje = 0;
	}

	public Electronicos(String codigo, String nombre, float precio, int voltaje, int cantidad, char estado, int cantidadIngredientes) {
		super(codigo, nombre, precio, cantidad, estado, cantidadIngredientes);
		this.voltaje = voltaje;
	}

	public int getVoltaje() {
		return voltaje;
	}

	public void setVoltaje(int voltaje) {
		this.voltaje = voltaje;
	}
	
	public void cargarDatos() throws IOException {
		super.cargarDatos();
		System.out.print("Voltaje: "); voltaje = entrada.nextInt();
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Voltaje: "+voltaje);
	}	
}
