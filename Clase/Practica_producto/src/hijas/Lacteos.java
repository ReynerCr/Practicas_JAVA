package hijas;

import java.io.IOException;
import java.util.Scanner;

import padre.*;

public class Lacteos extends Producto {
	public static Scanner entrada = new Scanner(System.in);

	String caducidad;
	
	public Lacteos() {
		super();
		caducidad = " ";
	}

	public Lacteos(String codigo, String nombre, float precio, String caducidad, int cantidad, char estado, int cantidadIngredientes) {
		super(codigo, nombre, precio, cantidad, estado, cantidadIngredientes);
		this.caducidad = caducidad;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}
	
	public void cargarDatos() throws IOException {
		super.cargarDatos();
		System.out.print("Caducidad: "); this.caducidad = entrada.next();
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Caducidad: "+caducidad);
	}
	
}
